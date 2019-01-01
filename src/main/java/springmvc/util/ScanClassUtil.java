package springmvc.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;

/**
 * @author zhangjingsi
 * @date 2018/9/14上午10:08
 */
public class ScanClassUtil {

    public static Set<Class<?>> getClasses(String pack){
        Set<Class<?>> classes = new LinkedHashSet<>();
        String packageDir = pack.replace('.', '/');
        /**定义枚举集合循环处理目录下的class*/
        Enumeration<URL> dirs = null;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Objects.nonNull(dirs)){
            while (dirs.hasMoreElements()){
                URL url = dirs.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)){
                    /**此处不考虑jar包的情况，只解析java文件中的注解*/
                    System.err.print("扫描文件");
                    String filePath = "";
                    try {
                        filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                        ScanClassUtil.findAnnotationClass(pack, filePath, true, classes);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return classes;
    }

    public static void findAnnotationClass(String packageName, String packagePath, final boolean recursive, Set<Class<?>> classes){
        File dir = new File(packagePath);
        if (!dir.exists() || !dir.isDirectory()){
            System.out.println("包名异常");
            return;
        }
        /**获取包下所有文件+目录,过滤出其中的.class文件和子目录*/
        File[] files = dir.listFiles(file -> (recursive && file.isDirectory()) || (file.getName().endsWith(".class")));
        Arrays.asList(files).forEach(file -> {
            if (file.isDirectory()){
                /**如果是目录递归扫描添加*/
                ScanClassUtil.findAnnotationClass(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes);
            }else{
                /**如果是class文件 去掉后缀名，只保留类名*/
                String className = file.getName().substring(0, file.getName().length() -6);
                try {
                    classes.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + "." + className));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
