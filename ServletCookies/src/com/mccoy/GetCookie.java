package com.mccoy;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GetCookie extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Cookie[] cks = request.getCookies();
        out.println("Welcome "+cks[0].getValue());
    }
}