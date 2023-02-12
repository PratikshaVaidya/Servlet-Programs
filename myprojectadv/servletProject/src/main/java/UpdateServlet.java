

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Profound","root","Pratiksha@123");
			PreparedStatement ps=con.prepareStatement("update userreg set pwd=? where uid=? and pwd=?");
			ps.setString(1, request.getParameter("t3"));
			ps.setString(2, request.getParameter("t1"));
			ps.setString(3, request.getParameter("t2"));
			ps.executeUpdate();
			out.println("<h1>password updated successfully</h1>");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		out.close();
	}

}
