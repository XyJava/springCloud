package com.eureka.servicezuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 1.filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
 *      pre：路由之前
 *      routing：路由之时
 *      post： 路由之后
 *      error：发送错误调用
 * 2.filterOrder：过滤的顺序
 * 3.shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
 * 4.run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
 */
@Component
public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String url = request.getRequestURI();
        String  method = request.getMethod();
        System.out.print("Url===>"+url+"#########Meth===>"+method+"\n");
        Object param = request.getParameter("token");
        if (param == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is null");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  null;
        }
        return null;
    }
}
