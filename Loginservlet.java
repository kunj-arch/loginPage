package kbsEnterprises;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Loginservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out =  response.getWriter();

request.getRequestDispatcher("link.html").include(request, response);
String name = request.getParameter("name");
String password = request.getParameter("password");
	

	if(password.equals("admin123")) {
	out.println("you are successfully logged in!");
	out.println("HTML CHEAT CODES");
	out.print("<br>Thanks ,"+name);
	
	
	Cookie ck = new Cookie("name",name);
	response.addCookie(ck);
	
	
} else {
out.print("sorry, username or password eror!");
request.getRequestDispatcher("login.html").include(request, response);
}
	
	}

}
