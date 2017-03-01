package com.mccoy;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GettingCookies
 */
@WebServlet("/GettingCookies")
public class GettingCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		CookieManager cookieManager = new CookieManager();
		cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
		CookieHandler.setDefault(cookieManager);
		 PrintWriter out = response.getWriter();
		
		//creates url for the given string 
		URL url = null;
		try {								
			url = new URL("https://www.google.co.in/");
			
			//open's a connection with the url specified and returns URLConnection object
			URLConnection  urlConnection = url.openConnection(); 
			// get's the contents from this url specifies
			urlConnection.getContent(); 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		} catch (IOException e) {
			e.printStackTrace();
		}			
		
		//returns the cookie store(bunch of cookies)
		CookieStore cookieStore = cookieManager.getCookieStore();
		
		//getting cookies which returns in the form of List of type HttpCookie
		List<HttpCookie> listOfcookies = cookieStore.getCookies();
		
		for(HttpCookie httpCookie: listOfcookies){
			
			out.println("Cookie Name : "+httpCookie.getName()+" Cookie Value : "+httpCookie.getValue());
		}
	}

}
