package com.bridgelabz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.DB.DBConnectionImp;
import com.bridgelabz.DB.IDBConnection;
import com.bridgelabz.model.User;


//@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IDBConnection obj = new DBConnectionImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        try {
            if (obj.login(user)) {
                try {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("currentSessionUser", email);
                    response.sendRedirect("Welcome.jsp");
                } catch (IOException e) {

                    e.printStackTrace();
                }
            } else {
                try {
                    response.sendRedirect("Login.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
