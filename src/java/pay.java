

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class pay extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String Uname =request.getParameter("uname");
         HttpSession session=request.getSession();
        String Ufrom=(String)session.getAttribute("Ufrom");     
        String Uto=(String)session.getAttribute("Uto");
        String Udate=(String)session.getAttribute("Udate");
        
         try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/train","root","root");
        Statement st=con.createStatement();
        String query="insert into confirm values('"+Uname+"','"+Ufrom+"','"+Uto+"','"+Udate+"')";
         
        st.executeUpdate(query);
        response.sendRedirect("\\thank.html");
         
      
        st.close();
        con.close();
         }
         catch(Exception e)
         {
             out.println("error"+e);
         }
        
    }

    
}
