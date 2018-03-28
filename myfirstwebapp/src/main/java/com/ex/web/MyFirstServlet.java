package com.ex.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by August Duet on 8/23/2017.
 */
public class MyFirstServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Calling Service");
        System.out.println("Jerry has the value of " + getServletConfig().getInitParameter("Jerry"));
        System.out.println("Kramer has the value of " + getServletContext().getInitParameter("Kramer"));
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("Destroying the servlet");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Initializing the servlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("Jerry has the value of " + getServletConfig().getInitParameter("Jerry"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
