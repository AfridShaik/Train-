
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class regi extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
    
        
        String Uname=request.getParameter("Uname");
        String upass=request.getParameter("pass");
        String Mbno=request.getParameter("Mbno");
        
        
         try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/train","root","root");
         Statement st=con.createStatement();
         String query="insert into customer values('"+Uname+"','"+upass+"','"+Mbno+"')";
         
        st.executeUpdate(query);
        response.sendRedirect("\\index.html");
         
      
        st.close();
        con.close();
         }
         catch(Exception e)
         {
             out.println("error"+e);
         }
        
        
    }

}
