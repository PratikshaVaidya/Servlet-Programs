

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/LoginServlet2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String s1=request.getParameter("t1");
		String s2=request.getParameter("t2");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Profound","root","Pratiksha@123");
			PreparedStatement ps=con.prepareStatement("select * from user where uid=? and pwd=?");
			ps.setString(1,s1);
			ps.setString(2,s2);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				out.println("<h1>welcome</h1>");
			}
			else
			{
				out.println("<h2>Login Filed....</h2>");
				rs.close();
				con.close();
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		out.close();
	}

}
