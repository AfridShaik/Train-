

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class login extends HttpServlet {
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html");
       PrintWriter out=response.getWriter();
        String Uname=request.getParameter("Uname");
        String upass=request.getParameter("pass");
        HttpSession session=request.getSession();
      session.setAttribute("Uname",Uname);
       try
       {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/train","root","root");
            Statement st=con.createStatement();
            String query="select * from customer where Uname='"+Uname+"' and upass='"+upass+"'";
           ResultSet rs=st.executeQuery(query);
        if(rs.next()!=true)
        {
            
           out.println("Invalid user");
        }
        else
             response.sendRedirect("\\place.html");
         
      
        st.close();
        con.close();
       }
       catch(Exception e)
       {
           out.println("error"+e);
       }
        
    }



}
