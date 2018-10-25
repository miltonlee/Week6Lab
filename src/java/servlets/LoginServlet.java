/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import models.UserService;

/**
 *
 * @author 659159
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (request.getParameter("logout") != null) {
            request.setAttribute("message", "Log out Successfully");
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        if (session.getAttribute("username") != null) {
            response.sendRedirect("home");
            return;
        }

        Cookie[] cookies = request.getCookies();
        String cookieName = "username";
        String cookieValue = "";
        for (Cookie cookie : cookies) {
            if (cookieName.equals(cookie.getName())) {
                cookieValue = cookie.getValue();
                request.setAttribute("username", cookieValue);
           

            }
        }

        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("") && password.equals("")) {
            request.setAttribute("message", "invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        UserService userservice = new UserService();
        User user = userservice.login(username, password);
        if (userservice.login(username, password) != null) {

            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUser());
            if ((request.getParameter("rem") != null) ) {

                Cookie c = new Cookie("username", username);
                c.setMaxAge(60 * 60 * 24 * 365 * 2);   // set age to 2 years
                c.setPath("/");                // allow access by entire app

                response.addCookie(c);
            }
            response.sendRedirect("home");

        } else {
            request.setAttribute("message", "Invalid");
            request.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        }

    }

}
