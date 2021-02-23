package com.ua.lashyn.controllers;

import com.ua.lashyn.db.DAO.CommonTopicDAO;
import com.ua.lashyn.db.DAO.ConferenceDAO;
import com.ua.lashyn.db.DAO.UserDAO;
import com.ua.lashyn.db.entity.CommonTopic;
import com.ua.lashyn.db.entity.Conference;
import com.ua.lashyn.db.entity.User;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("cp1251");
        response.setContentType("text/html; windows-1251");
        ConferenceDAO conferenceDAO = new ConferenceDAO();
        UserDAO userDAO = new UserDAO();
        CommonTopicDAO commonTopicDAO = new CommonTopicDAO();
        long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("id", id);
        ArrayList<Conference> conferences = conferenceDAO.showConferencesList();
        ArrayList<User> users = userDAO.showUsersList();
        ArrayList<CommonTopic> commonTopics = commonTopicDAO.showCommonTopicList();
        request.setAttribute("commonTopicList", commonTopics);
        request.setAttribute("confList", conferences);
        request.setAttribute("usersList", users);
        /*String param = "";
        if (request.getParameter("elementType") != null) {
            param = request.getParameter("elementType");
        }
        long elementId = 0;
        if(request.getParameter("elementId") != null)
            elementId = Long.parseLong(request.getParameter("elementId"));
        if(param.equals("user")) {
            request.setAttribute("formUser", userDAO.getUserById(elementId));
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            boolean admin_privilegies = Boolean.parseBoolean(request.getParameter("admin_privilegies"));
            User user = new User();
            user.setId(elementId);
            user.setName(name);
            user.setSurname(surname);
            user.setAddress(address);
            user.setEmail(email);
            user.setPassword(password);
            user.setAdmin_privilegies(admin_privilegies);
            request.setAttribute("user", userDAO.adminUpdateUser(user));
        }
        else if(param.equals("conference")) {
            String name = request.getParameter("name");
            long common_topic_id = Long.parseLong(request.getParameter("common_topic_id"));
            Date date = Date.valueOf(request.getParameter("date"));
            String location = request.getParameter("location");
            Conference conf = new Conference();
        }*/
        getServletContext().getRequestDispatcher("/AdminPage.jsp").forward(request, response);
    }
}
