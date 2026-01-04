package com.university;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StudentServlet extends HttpServlet {

    String url = "jdbc:mysql://localhost:3306/university";
    String user = "root";
    String pass = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.html");
            return;
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/university",
    "root",
    "");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM student");
            ResultSet rs = ps.executeQuery();

            out.println("<h2>Student Records</h2>");
            while (rs.next()) {
                out.println(rs.getInt("id") + " "
                        + rs.getString("name") + " "
                        + rs.getString("department") + "<br>");
            }
            request.setAttribute("message", "Student added successfully");

            request.setAttribute("message", "Student added successfully");

            RequestDispatcher rd =
                    request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);

            con.close();
        } catch (Exception e) {
            out.println(e);
        }
    }
}
