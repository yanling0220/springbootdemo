package com.aceyan.framework.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yanling
 * @time 2018-01-24-10:22
 */
@WebServlet(urlPatterns = "/myServlet/*",description = "Servlet 说明")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = -4331845878244289893L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.err.println("===============service=================");
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>HelloWorld</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>这是：MyServlet</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
