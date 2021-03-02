package com.ua.lashyn.controllers;

import com.ua.lashyn.db.DAO.*;
import com.ua.lashyn.db.entity.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(AdminServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doPost method has been started.");
        request.setCharacterEncoding("cp1251");
        response.setContentType("text/html; windows-1251");
        ConferenceDAO conferenceDAO = new ConferenceDAO();
        UserDAO userDAO = new UserDAO();
        CommonTopicDAO commonTopicDAO = new CommonTopicDAO();
        TopicDAO topicDAO = new TopicDAO();
        SpeakerDAO speakerDAO = new SpeakerDAO();
        UserConferenceDAO userConferenceDAO = new UserConferenceDAO();
        long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("id", id);
        String objectType = request.getParameter("objectType");
        String objectName = request.getParameter("objectName");
        long objectValue1 = 0;
        long objectValue2 = 0;
        if(request.getParameter("objectValue1") != null) {
            objectValue1 = Long.parseLong(request.getParameter("objectValue1"));
            objectValue2 = Long.parseLong(request.getParameter("objectValue2"));
        }
        long user_id;
        long topic_id;
        long conference_id;
        long commonTopic_id;
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String selectedObject = request.getParameter("selectedObject");
        String date = request.getParameter("date");
        String location = request.getParameter("location");
        boolean admin_privilegies = Boolean.parseBoolean(request.getParameter("admin_privilegies"));
        if(objectType != null) {
            switch (objectType) {
                case "user":
                    user_id = userDAO.getIdByEmail(objectName);
                    User user = new User();
                    user.setId(user_id);
                    user.setSurname(surname);
                    user.setName(name);
                    user.setAddress(address);
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setAdmin_privilegies(admin_privilegies);
                    userDAO.adminUpdateUser(user);
                    log.info("information of user with id=" + user.getId() + " was updated.");
                    break;
                case "conference":
                    long common_topic_id = Long.parseLong(request.getParameter("common_topic_id"));
                    conference_id = conferenceDAO.getConferenceIdByName(objectName);
                    Conference conference = new Conference();
                    conference.setId(conference_id);
                    conference.setName(name);
                    conference.setDate(date);
                    conference.setCommon_topic_id(common_topic_id);
                    conference.setLocation(location);
                    conferenceDAO.adminUpdateConference(conference);
                    log.info("information of conference with id=" + conference.getId() + " was updated.");
                    break;
                case "commonTopic":
                    commonTopic_id = commonTopicDAO.getCommonTopicIdByName(objectName);
                    CommonTopic commonTopic = new CommonTopic();
                    commonTopic.setId(commonTopic_id);
                    commonTopic.setName(name);
                    commonTopicDAO.adminUpdateCommonTopic(commonTopic);
                    log.info("information of commonTopic with id=" + commonTopic.getId() + " was updated.");
                    break;
                case "topic":
                    topic_id = topicDAO.getTopicIdByName(objectName);
                    commonTopic_id = Long.parseLong(request.getParameter("common_topic_id"));
                    Topic topic = new Topic();
                    topic.setId(topic_id);
                    topic.setName(name);
                    topic.setCommon_topic_id(commonTopic_id);
                    topicDAO.adminUpdateTopic(topic);
                    log.info("information of topic with id=" + topic.getId() + " was updated.");
                    break;
                case "speaker":
                    user_id = Long.parseLong(request.getParameter("user_id"));
                    topic_id = Long.parseLong(request.getParameter("topic_id"));
                    long speaker_id = speakerDAO.getSpeakerIdByUserAndTopicId(objectValue1, objectValue2);
                    Speaker speaker = new Speaker();
                    speaker.setId(speaker_id);
                    speaker.setUser_id(user_id);
                    speaker.setTopic_id(topic_id);
                    speakerDAO.adminUpdateSpeaker(speaker);
                    log.info("information of speaker with id=" + speaker.getId() + " was updated.");
                    break;
                case "user_conference":
                    user_id = Long.parseLong(request.getParameter("user_id"));
                    conference_id = Long.parseLong(request.getParameter("conference_id"));
                    boolean isArrived = Boolean.parseBoolean(request.getParameter("isArrived"));
                    long user_conference_id = userConferenceDAO.getUserConferenceId(objectValue1, objectValue2);
                    UserConference userConference = new UserConference();
                    userConference.setId(user_conference_id);
                    userConference.setUser_id(user_id);
                    userConference.setConference_id(conference_id);
                    userConference.setArrived(isArrived);
                    userConferenceDAO.adminUpdateUserConference(userConference);
                    log.info("information of user-conference with id=" + userConference.getId() + " was updated.");
                    break;
                case "delete":
                    long objectId = Long.parseLong(request.getParameter("objectId"));
                    switch (selectedObject) {
                        case "user":
                            userDAO.deleteUser(objectId);
                            break;
                        case "conference":
                            conferenceDAO.deleteConference(objectId);
                            break;
                        case "commonTopic":
                            commonTopicDAO.deleteCommonTopic(objectId);
                            break;
                        case "topic":
                            topicDAO.deleteTopic(objectId);
                            break;
                        case "speaker":
                            if(request.getParameter("topic_id") != null) {
                                topic_id = Long.parseLong(request.getParameter("topic_id"));
                                speakerDAO.deleteSpeaker(objectId, conferenceDAO.getConferenceByTopicId(topic_id).getId(), topic_id);
                            }
                            break;
                        default:
                            userConferenceDAO.deleteUserConference(objectId);
                            break;
                    }
                    log.info(selectedObject + " with id=" + objectId + " was deleted.");
                    break;
                default:
                    switch (selectedObject) {
                        case "user":
                            user = new User();
                            user.setSurname(surname);
                            user.setName(name);
                            user.setAddress(address);
                            user.setEmail(email);
                            user.setPassword(password);
                            user.setAdmin_privilegies(admin_privilegies);
                            userDAO.addUser(user);
                            log.info("user with id=" + userDAO.getIdByEmail(user.getEmail()) + " was added.");
                            break;
                        case "conference":
                            common_topic_id = Long.parseLong(request.getParameter("common_topic_id"));
                            conference = new Conference();
                            conference.setName(name);
                            conference.setDate(date);
                            conference.setCommon_topic_id(common_topic_id);
                            conference.setLocation(location);
                            conferenceDAO.addConference(conference);
                            log.info("conference with id=" + conferenceDAO.getConferenceIdByName(conference.getName()) + " was added.");
                            break;
                        case "commonTopic":
                            commonTopic = new CommonTopic();
                            commonTopic.setName(name);
                            commonTopicDAO.addCommonTopic(commonTopic);
                            log.info("commonTopic with id=" + commonTopicDAO.getCommonTopicIdByName(commonTopic.getName()) + " was added.");
                            break;
                        case "topic":
                            common_topic_id = Long.parseLong(request.getParameter("common_topic_id"));
                            topic = new Topic();
                            topic.setName(name);
                            topic.setCommon_topic_id(common_topic_id);
                            topicDAO.addTopic(topic);
                            log.info("topic with id=" + topicDAO.getTopicIdByName(name) + " was added.");
                            break;
                        case "speaker":
                            user_id = Long.parseLong(request.getParameter("user_id"));
                            topic_id = Long.parseLong(request.getParameter("topic_id"));
                            speaker = new Speaker();
                            speaker.setUser_id(user_id);
                            speaker.setTopic_id(topic_id);
                            speakerDAO.addSpeaker(speaker);
                            log.info("speaker with id=" + speakerDAO.getSpeakerIdByUserAndTopicId(user_id, topic_id) + " was added.");
                            break;
                        default:
                            userConference = new UserConference();
                            user_id = Long.parseLong(request.getParameter("user_id"));
                            conference_id = Long.parseLong(request.getParameter("conference_id"));
                            isArrived = Boolean.parseBoolean(request.getParameter("isArrived"));
                            userConference.setUser_id(user_id);
                            userConference.setConference_id(conference_id);
                            userConference.setArrived(isArrived);
                            userConferenceDAO.addUserConference(userConference);
                            log.info("userConference with id=" + userConferenceDAO.getUserConferenceId(user_id, conference_id) + " was added.");
                            break;
                    }
                    break;
            }
        }
        ArrayList<UserConference> usersConferences = userConferenceDAO.showUserConferenceList();
        ArrayList<Conference> conferences = conferenceDAO.showConferencesList();
        ArrayList<User> users = userDAO.showUsersList();
        ArrayList<CommonTopic> commonTopics = commonTopicDAO.showCommonTopicList();
        ArrayList<Topic> topics = topicDAO.showTopicList();
        ArrayList<Speaker> speakers = speakerDAO.showSpeakerList();
        request.setAttribute("userConferenceList", usersConferences);
        request.setAttribute("commonTopicList", commonTopics);
        request.setAttribute("confList", conferences);
        request.setAttribute("usersList", users);
        request.setAttribute("topicList", topics);
        request.setAttribute("speakerList", speakers);
        log.info("doPost method was finished.");
        getServletContext().getRequestDispatcher("/AdminPage.jsp").forward(request, response);
    }
}
