package com.ua.lashyn.controllers;

import com.ua.lashyn.db.DAO.ConferenceDAO;
import com.ua.lashyn.db.entity.Conference;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConferencesServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(ConferencesServlet.class);

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
        String sortMethod = request.getParameter("option");
        ArrayList<Conference> conferences;
        if(sortMethod == null) {
            conferences = conf.showConferencesList();
            log.error("sortMethod == null");
        }
        else if(sortMethod.equals("dateDesc"))
            conferences = conf.showConferencesListOrderedByDateDesc();
        else if(sortMethod.equals("date"))
            conferences = conf.showConferencesListOrderedByDate();
        else if(sortMethod.equals("topicsDesc"))
            conferences = conf.showConferencesListOrderedByTopicsNumberDesc();
        else if(sortMethod.equals("topics"))
            conferences = conf.showConferencesListOrderedByTopicsNumber();
        else if(sortMethod.equals("usersDesc"))
            conferences = conf.showConferencesListOrderedByUsersNumberDesc();
        else
            conferences = conf.showConferencesListOrderedByUsersNumber();
        List<Integer> pageList = new ArrayList<>();

        if (conferences.size() % 9 == 0) {
            for (int i = 0; i < conferences.size() / 9; i++) {
                pageList.add(i + 1);
            }
        } else {
            for (int i = 0; i < conferences.size() / 9 + 1; i++) {
                pageList.add(i + 1);
            }
        }

        int counter = 0;
        int index = 0;

        while (true) {
            if (request.getParameter("page") == null || request.getParameter("page").equals("1")) {
                break;
            } else if (request.getParameter("page").equals("2")) {
                if (counter == 9) {
                    break;
                }
                conferences.remove(index);
            } else if (request.getParameter("page").equals("3")) {
                if (counter == 18) {
                    break;
                }
                conferences.remove(index);
            }
            counter++;
        }

        if(request.getParameter("page") != null)
            request.setAttribute("currentPage", request.getParameter("page"));
        else
            request.setAttribute("currentPage", 1);
        request.setAttribute("pageList", pageList);
        request.setAttribute("confList", conferences);
        log.info("doPost method was finished.");
        getServletContext().getRequestDispatcher("/EventsPage.jsp").forward(request, response);
    }
}

