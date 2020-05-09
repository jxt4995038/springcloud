package com.example.product.conf;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2019-12-16 15:31
 */
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器执行");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}