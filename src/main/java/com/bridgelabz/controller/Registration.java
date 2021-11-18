package com.bridgelabz.controller;

import com.bridgelabz.UserDTO.UserDTO;
import com.bridgelabz.services.FacilityImp;
import com.bridgelabz.services.Ifacility;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Ifacility obj = new FacilityImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        UserDTO user = new UserDTO();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setUserName(request.getParameter("userName"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));
        user.setPassword(request.getParameter("password"));
        obj.dtomodelMapping(user);
        response.sendRedirect("success.jsp");
    }

}
