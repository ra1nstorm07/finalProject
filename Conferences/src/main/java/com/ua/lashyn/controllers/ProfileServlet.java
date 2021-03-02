package com.ua.lashyn.controllers;

import com.ua.lashyn.db.DAO.ConferenceDAO;
import com.ua.lashyn.db.DAO.UserDAO;
import com.ua.lashyn.db.entity.Conference;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(ProfileServlet.class);

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
        ConferenceDAO conf = new ConferenceDAO();
        request.setAttribute("user", new UserDAO().getUserById(id));
        ArrayList<Conference> conferences = conf.getConferencesByUserId(id);
        request.setAttribute("confList", conferences);
        log.info("doPost method was finished.");
        getServletContext().getRequestDispatcher("/ProfilePage.jsp").forward(request, response);
    }

}