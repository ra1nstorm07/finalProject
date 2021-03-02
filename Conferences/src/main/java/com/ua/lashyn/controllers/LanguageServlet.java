package com.ua.lashyn.controllers;

import org.apache.log4j.Logger;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LanguageServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(LanguageServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doPost method has been started.");
        request.setCharacterEncoding("cp1251");
        response.setContentType("text/html; windows-1251");
        HttpSession session = request.getSession();
        session.setAttribute("language", request.getParameter("language"));
        log.info("language was changed to " + request.getParameter("language") + ".");
        log.info("doPost method was finished.");
        response.sendRedirect(request.getHeader("Referer"));
    }
}
