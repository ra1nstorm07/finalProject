package com.ua.lashyn.controllers;

import com.ua.lashyn.db.DAO.UserDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("cp1251");
        response.setContentType("text/html; windows-1251");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO userDAO = UserDAO.getInstance();

        if(userDAO.logInValidate(email, password)){
            request.setAttribute("id", userDAO.getIdByEmail(email));
            RequestDispatcher rd = request.getRequestDispatcher("showConferences");
            rd.forward(request,response);
        }
        else{
            out.print("Wrong email or password, try again.");
            RequestDispatcher rd = request.getRequestDispatcher("/LogInPage.jsp");
            rd.forward(request,response);
        }
        out.close();
    }
}
