package com.university;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class ConfirmationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletContext context = getServletContext();
        String university = context.getInitParameter("universityName");

        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("studentName");

        String id = (String) request.getAttribute("id");
        String course = (String) request.getAttribute("course");

        out.println("<h2>" + university + "</h2>");
        out.println("<p>Student ID: " + id + "</p>");
        out.println("<p>Student Name: " + name + "</p>");
        out.println("<p>Course Code: " + course + "</p>");
        out.println("<h3>Registration Successful!</h3>");
    }
}
