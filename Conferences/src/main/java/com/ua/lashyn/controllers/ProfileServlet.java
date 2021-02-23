package com.ua.lashyn.controllers;

import com.ua.lashyn.db.DAO.ConferenceDAO;
import com.ua.lashyn.db.DAO.UserDAO;
import com.ua.lashyn.db.entity.Conference;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("cp1251");
        response.setContentType("text/html; windows-1251");
        long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("id", id);
        ConferenceDAO conf = new ConferenceDAO();
        request.setAttribute("user", new UserDAO().getUserById(id));
        ArrayList<Conference> conferences = conf.getConferencesByUserId(id);
        request.setAttribute("confList", conferences);
        getServletContext().getRequestDispatcher("/ProfilePage.jsp").forward(request, response);
    }

}