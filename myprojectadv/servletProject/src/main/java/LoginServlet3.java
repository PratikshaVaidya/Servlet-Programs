

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


@WebServlet("/LoginServlet3")
public class LoginServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String s1=request.getParameter("t1");
		String s2=request.getParameter("t2");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/profound","root","Pratiksha@123");
			PreparedStatement ps=con.prepareStatement("select * from userreg where uid=? and pwd=?");
			ps.setString(1,s1);
			ps.setString(2,s2);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				out.println("<form method='post' action='UpdateServlet'>");
				out.println("User id:<input type='text' name='t1' value='"+s1+"'><br>");
				out.println("old Password:<input type='password' name='t2' value='"+s2+"'><br>");
				out.println("new Password:<input type='password' name='t3'><br>");
				out.println("<input type='submit' value='update'>");
				out.println("</form>");
			}
			else
			{
				out.println("<h2>Login Filed....</h2>");
				rs.close();
				con.close();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		out.close();
	}

}
