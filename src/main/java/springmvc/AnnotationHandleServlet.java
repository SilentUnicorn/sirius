package springmvc;

import org.springframework.util.StringUtils;
import springmvc.annotation.Controller;
import springmvc.util.BeanUtil;
import springmvc.util.ScanClassUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zhangjingsi
 * @date 2018/9/13下午6:09
 * 注解处理器，用于处理自定义的@Controller和@RequestMapping
 */
public class AnnotationHandleServlet extends HttpServlet {

    private String pareRequestURI(HttpServletRequest request){
        /**对rul进行处理， 获取能映射到Controller的路径*/
        String path = request.getContextPath() + "/";
        String requestUri = request.getRequestURI();
        String midUrl = requestUri.replaceFirst(path, "");
        String lastUrl = midUrl.substring(0, midUrl.lastIndexOf("."));
        return lastUrl;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        this.excute(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        this.excute(request, response);
    }

    public void excute(HttpServletRequest request, HttpServletResponse response){
        /**将上下文存储起来*/
        WebContext.requestHolder.set(request);
        WebContext.responseHplder.set(response);
        /**解析url*/
        String lastUrl = this.pareRequestURI(request);
        /**获取路径对应的class*/
        Class clazz = RequestMapping.getClass(lastUrl);
        /**生成对应对象*/
        Object obj = BeanUtil.instanceClass(clazz);
        /**获取所有方法用于匹配要调用的方法*/
        Method[] methods = clazz.getDeclaredMethods();
        AtomicReference<Method> method = null;
        /**循环匹配要调用的方法*/
        Arrays.asList(methods).forEach(m -> {
            /**有@RequestMapping注解的方法*/
            if (m.isAnnotationPresent(springmvc.annotation.RequestMapping.class)){
                String annoPath = m.getAnnotation(springmvc.annotation.RequestMapping.class).value();
                if (!StringUtils.isEmpty(annoPath) && lastUrl.equals(annoPath)){
                    method.set(m);
                }
            }
        });
        /**执行对应的方法*/
        if (Objects.nonNull(method)){
            try {
                Object returnObj = method.get().invoke(obj);
                request.setAttribute("data", returnObj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("开始初始化...");
        /**获取需要扫描的package*/
        String basePackage = config.getInitParameter("basePackage");
        if (basePackage.indexOf(",") > 0){
            String[] packages = basePackage.split(",");
            Arrays.asList(packages).forEach(p -> {
                this.initRequestMapping(p);
            });
        }else{
            this.initRequestMapping(basePackage);
        }
        System.out.println("初始化结束");
    }

    private void initRequestMapping(String pachageName){
        Set<Class<?>> classes = ScanClassUtil.getClasses(pachageName);
        classes.forEach(clazz -> {
            if (clazz.isAnnotationPresent(Controller.class)){
                /**获取class的所有方法*/
                Method[] methods = clazz.getDeclaredMethods();
                /**匹配需要执行的方法*/
                Arrays.asList(methods).forEach(method -> {
                    String annoPath = method.getAnnotation(springmvc.annotation.RequestMapping.class).value();
                    if (!StringUtils.isEmpty(annoPath)){
                        if (RequestMapping.getRequestMap().containsKey(annoPath)){
                            throw new RuntimeException("RequestMapping 不可添加重复映射地址。");
                        }else{
                            RequestMapping.put(annoPath, clazz);
                        }
                    }
                });
            }
        });
    }

}
