package ru.csc.java.networking.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

//@WebServlet(urlPatterns = "/*")
public class DemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet()");

        response.setHeader("Content-Type", "text/html");

        HttpSession session = request.getSession();
        Object attr = session.getAttribute("attr");
        if (attr == null) {
            attr = LocalDateTime.now();
            session.setAttribute("attr", attr);
        }

        response.getOutputStream().println(
                "<h1>Hello world!</h1>"
                + "<p>" + attr + "</p>");
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
