package com.ex.web;

import com.ex.domain.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by August Duet on 8/23/2017.
 */
@WebServlet("/json")
public class JsonServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person august = new Person();
        august.setName("August Duet");
        august.setAge(34);

        String out = new Gson().toJson(august);
        resp.getWriter().write(out);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();

        Person p = (Person) new Gson().fromJson(reader, Person.class);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(p.getName() != null && p.getAge() != null){
            resp.setStatus(200);
            resp.getWriter().write("Person save successfully");
        }else{
            resp.sendError(400, "Invalid person sent in request");
        }
    }
}
