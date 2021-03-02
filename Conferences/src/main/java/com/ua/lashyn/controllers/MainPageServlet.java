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

public class MainPageServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(MainPageServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doPost method has been started.");
        request.setCharacterEncoding("cp1251");
        response.setContentType("text/html; windows-1251");
        ConferenceDAO conf = new ConferenceDAO();
        ArrayList<Conference> conferences = conf.showConferencesList();
        request.setAttribute("confList", conferences);
        log.info("doPost method was finished.");
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

}