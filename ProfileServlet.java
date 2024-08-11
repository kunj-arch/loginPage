package kbsEnterprises;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("link.html").include(request, response);
		
		Cookie ck[] = request.getCookies();
		if(ck!=null) {
			String name = ck[0].getValue();
			
			if(!name.equals("")||name!=null){
				out.print("<b>WELCOME TO PROFILE</b>");
				out.print("<br>welcome,"+name);
			}
		}else {
			out.print("please login first");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}

}
