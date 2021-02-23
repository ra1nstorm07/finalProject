package com.ua.lashyn.controllers;

import com.ua.lashyn.db.DAO.ConferenceDAO;
import com.ua.lashyn.db.entity.Conference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConferencesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("cp1251");
        response.setContentType("text/html; windows-1251");
        ConferenceDAO conf = new ConferenceDAO();
        ArrayList<Conference> conferences = conf.showConferencesList();
        request.setAttribute("confList", conferences);
        getServletContext().getRequestDispatcher("/EventsPage.jsp").forward(request, response);
    }
}

