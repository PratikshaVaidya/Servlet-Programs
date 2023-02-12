

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RequestDisServlet1")
public class RequestDisServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String s1=request.getParameter("t1");
		String s2=request.getParameter("t2");
		
		if(s1.equals("User1") && s2.equals("User1"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("RequestDisServlet2");
			rd.forward(request,response);
		}
		else
		{
			out.println("<h1>Login Filed....</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("RequestDisLogin.html");
			rd.include(request,response);
		}
		
	}

}
