

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


@WebServlet("/RegServlet3")
public class RegServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Profound","root","Pratiksha@123");
			PreparedStatement ps=con.prepareStatement("select * from Userreg where uid=?");
			ps.setString(1,request.getParameter("t1"));
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				out.println("<h1>user with this id is already exists</h1>");
			}
			else
			{
				PreparedStatement ps1=con.prepareStatement("insert into Userreg values(?,?,?,?,?)");
				ps1.setString(1,request.getParameter("t1"));
				ps1.setString(2,request.getParameter("t2"));
				ps1.setString(3,request.getParameter("t3"));
				ps1.setString(4,request.getParameter("t4"));
				ps1.setString(5,request.getParameter("t5"));
				ps1.executeUpdate();
				out.println("<h2>Account Opened Successfully</h2>");
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
