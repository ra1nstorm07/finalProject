package com.ua.lashyn.controllers;

import com.ua.lashyn.db.DAO.UserDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

public class LogInServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(LogInServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doPost method has been started.");
        request.setCharacterEncoding("cp1251");
        response.setContentType("text/html; windows-1251");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserDAO userDAO = UserDAO.getInstance();
        if(userDAO.logInValidate(email, password)){
            log.info("user with id=" + userDAO.getIdByEmail(email) + " logged in.");
            request.setAttribute("id", userDAO.getIdByEmail(email));
            RequestDispatcher rd = request.getRequestDispatcher("/showConferences");
            rd.forward(request,response);
        }
        log.info("doPost method was finished.");
    }
}
