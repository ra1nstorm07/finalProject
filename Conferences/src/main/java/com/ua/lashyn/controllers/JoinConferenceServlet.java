package com.ua.lashyn.controllers;

import com.ua.lashyn.db.DAO.ConferenceDAO;
import com.ua.lashyn.db.DAO.TopicDAO;
import com.ua.lashyn.db.DAO.UserDAO;
import org.apache.log4j.Logger;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinConferenceServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(JoinConferenceServlet.class);

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
        long conference_id = Long.parseLong(request.getParameter("conference_id"));
        String userType = request.getParameter("userType");
        String topic = request.getParameter("topic");
        UserDAO userDAO = new UserDAO();
        TopicDAO topicDAO = new TopicDAO();
        ConferenceDAO conferenceDAO = new ConferenceDAO();
        if(userType.equals("user"))
            userDAO.joinConferenceAsUser(id, conference_id);
        else {
            topicDAO.createTopic(topic, conferenceDAO.getConferenceById(conference_id).getCommon_topic_id());
            userDAO.joinConferenceAsSpeaker(id, conference_id, topicDAO.getTopicIdByName(topic));
        }
        log.info("user with id=" + id + " joined conference with id=" + conference_id + " as " + userType + ".");
        log.info("doPost method was finished.");
        getServletContext().getRequestDispatcher("/showConferences").forward(request, response);
    }
}