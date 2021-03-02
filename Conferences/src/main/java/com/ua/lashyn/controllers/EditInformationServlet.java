package com.ua.lashyn.controllers;

import com.ua.lashyn.db.DAO.UserDAO;
import com.ua.lashyn.db.entity.User;
import org.apache.log4j.Logger;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditInformationServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(EditInformationServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doPost method has been started.");
        request.setCharacterEncoding("cp1251");
        response.setContentType("text/html; windows-1251");
        long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("id", id);
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setSurname(surname);
        user.setAddress(address);
        user.setPassword(password);
        UserDAO userDAO = new UserDAO();
        request.setAttribute("user", userDAO.updateUser(user));
        log.info("information of user with id=" + user.getId() + " was updated by user.");
        RequestDispatcher rd = request.getRequestDispatcher("profile");
        log.info("doPost method was finished.");
        rd.forward(request,response);
    }
}
