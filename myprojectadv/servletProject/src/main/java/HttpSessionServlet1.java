

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/HttpSessionServlet1")
public class HttpSessionServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session=request.getSession();
		String s1=request.getParameter("t1");
		String s2=request.getParameter("t2");
		
		session.setAttribute("uid", s1);
		session.setAttribute("pwd", s2);
		out.println("<h1>value stored in session</h1>");
		out.println("<a href='HttpSessionServlet2'>next page</a>");
		out.close();
		
	}

}
