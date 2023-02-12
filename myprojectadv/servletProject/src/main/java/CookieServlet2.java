

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/CookieServlet2")
public class CookieServlet2 extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		Cookie c[]=request.getCookies();
		for(int i=0;i<c.length;i++)
		{
			out.println("<h1>"+c[i].getName()+" "+c[i].getValue()+"</h1>");
		}
		out.close();
		
	}

}
