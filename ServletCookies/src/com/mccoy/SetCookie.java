package com.mccoy;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SetCookie extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        if(pass.equals("mohan"))
        {
            Cookie ck = new Cookie("username",name);
            response.addCookie(ck);
            response.sendRedirect("GetCookie");
        }
        else
        {
        	request.getRequestDispatcher("/Session.html").include(request,response);
        	out.println("Login is unsucessfull");
        	
        }
    }
}