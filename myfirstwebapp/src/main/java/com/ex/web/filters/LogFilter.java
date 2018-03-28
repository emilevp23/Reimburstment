package com.ex.web.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by August Duet on 8/24/2017.
 */
public class LogFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        System.out.println("Request coming from " + req.getRemoteAddr());
        System.out.println("Request for " + req.getRequestURL());
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Response done");
    }

    public void destroy() {

    }
}
