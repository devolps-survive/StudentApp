package com.university;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        if (user.equals("admin") && pass.equals("admin")) {
            HttpSession session = request.getSession();
            session.setAttribute("user", "admin");
            response.sendRedirect("StudentServlet");
        } else {
            response.sendRedirect("login.html");
        }
    }
