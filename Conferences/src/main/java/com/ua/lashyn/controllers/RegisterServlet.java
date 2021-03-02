package com.ua.lashyn.controllers;

import com.ua.lashyn.db.DAO.UserDAO;
import com.ua.lashyn.db.entity.User;
import org.apache.log4j.Logger;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(RegisterServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doPost method has been started.");
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
        if (userDAO.getIdByEmail(user.getEmail()) != 0)
            log.info("user with id=" + userDAO.getIdByEmail(user.getEmail()) + " signed in.");
        log.info("doPost method was finished.");
        getServletContext().getRequestDispatcher("/mainPage").forward(request, response);
    }
}
