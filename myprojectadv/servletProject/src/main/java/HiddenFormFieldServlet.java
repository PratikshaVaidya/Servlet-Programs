

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HiddenFormFieldServlet")
public class HiddenFormFieldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String s1=request.getParameter("t1");
	
		
		out.println("<form method='post' action='HiddenFormFieldServlet2'>");
		out.println("<input type='hidden' name='h1' value='"+s1+"'>");

		out.println("<input type='submit' value='submit'>");
		out.println("</form>");
		out.close();
	}

}
