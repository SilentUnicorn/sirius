package springmvc;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author zhangjingsi
 * @date 2018/9/13下午6:20
 * 用于存储上下文 request response
 */
public class WebContext {

    public static ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<>();
    public static ThreadLocal<HttpServletResponse> responseHplder = new ThreadLocal<>();

    public HttpServletRequest getRequest(){
        return requestHolder.get();
    }

    public HttpSession getSession(){
        return requestHolder.get().getSession();
    }

    public ServletContext getServletContext(){
        return requestHolder.get().getSession().getServletContext();
    }

    public HttpServletResponse getResponse(){
        return responseHplder.get();
    }
}
