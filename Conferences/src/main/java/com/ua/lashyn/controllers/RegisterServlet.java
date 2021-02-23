package com.ua.lashyn.controllers;

import com.ua.lashyn.db.DAO.UserDAO;
import com.ua.lashyn.db.entity.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/RegistrationPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("cp1251");
        response.setContentType("text/html; windows-1251");
        String name = request.getParameter("Name");
        String surname = request.getParameter("Surname");
        String address = request.getParameter("Address");
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");
        boolean admin_privilegies = false;
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setAddress(address);
        user.setEmail(email);
        user.setPassword(password);
        user.setAdmin_privilegies(admin_privilegies);
        UserDAO userDAO = UserDAO.getInstance();
        userDAO.registration(user);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
