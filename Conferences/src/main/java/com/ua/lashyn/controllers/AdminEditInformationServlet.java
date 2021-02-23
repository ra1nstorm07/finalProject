package com.ua.lashyn.controllers;

import com.ua.lashyn.db.DAO.CommonTopicDAO;
import com.ua.lashyn.db.DAO.ConferenceDAO;
import com.ua.lashyn.db.DAO.UserDAO;
import com.ua.lashyn.db.entity.User;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminEditInformationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        ConferenceDAO conferenceDAO = new ConferenceDAO();
        CommonTopicDAO commonTopicDAO = new CommonTopicDAO();
        long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("id", id);
        long elementId = Long.parseLong(request.getParameter("elementId"));
        String elementType = request.getParameter("elementType");
        if(elementType.equals("user"))
            request.setAttribute("formUser", userDAO.getUserById(elementId));
        else if (elementType.equals("conference"))
            request.setAttribute("formConf", conferenceDAO.getConferenceById(elementId));
        else
            request.setAttribute("formTopic", commonTopicDAO.getCommonTopicById(elementId));
        RequestDispatcher rd = request.getRequestDispatcher("admin");
        rd.forward(request,response);
    }
}
