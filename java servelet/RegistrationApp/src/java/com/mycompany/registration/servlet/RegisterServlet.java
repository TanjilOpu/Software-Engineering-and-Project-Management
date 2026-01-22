package com.mycompany.registration.servlet;

import com.mycompany.registration.util.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/RegisterServlet") // This MUST match the form action
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String mail = request.getParameter("email");
        String ph = request.getParameter("phone");

        try (Connection con = DBUtil.getConnection()) {
            String sql = "INSERT INTO users (username, password, email, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, mail);
            ps.setString(4, ph);

            int result = ps.executeUpdate();
            if (result > 0) {
                response.sendRedirect("success.jsp");
            } else {
                response.getWriter().println("Registration Failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}