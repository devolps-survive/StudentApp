package com.university;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String course = request.getParameter("course");

        // Store name in session
        HttpSession session = request.getSession();
        session.setAttribute("studentName", name);

        // Set attributes for forwarding
        request.setAttribute("id", id);
        request.setAttribute("course", course);

        RequestDispatcher rd =
                request.getRequestDispatcher("ConfirmationServlet");
        rd.forward(request, response);
    }
}
