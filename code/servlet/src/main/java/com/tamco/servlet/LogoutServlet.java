package com.tamco.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();

            out.println("<html><body>");
            out.println("<h1>Goodbye" + "!</h1>");
            out.println("</body></html>");

        } else {
            out.println("<html><body>");
            out.println("<h1>Cannot logout. You have not logged in" + "!</h1>");
            out.println("</body></html>");
        }
    }
}
