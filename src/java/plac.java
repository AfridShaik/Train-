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


public class plac extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String Ufrom =request.getParameter("From");
        String Uto=request.getParameter("To");
        String Udate=request.getParameter("Date");
        HttpSession session=request.getSession();
        String Uname=(String)session.getAttribute("Uname");
      
      session.setAttribute("Ufrom",Ufrom);
       session.setAttribute("Uto",Uto);
       session.setAttribute("Udate",Udate);
      
      
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/train","root","root");
             Statement st=con.createStatement();
            String query="insert into place values('"+Uname+"','"+Ufrom+"','"+Uto+"','"+Udate+"')";
            
         
        st.executeUpdate(query);
        if(Ufrom.equals("Guntur") && Uto.equals("Vijayawada"))
         {
             response.sendRedirect("\\GV.html");
         }
        else if(Ufrom.equals("Guntur") && Uto.equals("Tenali"))
         {
             
         response.sendRedirect("\\GT.html");
         }
        else if(Ufrom.equals("Guntur") && Uto.equals("Hyderabad"))
         {
             
         response.sendRedirect("\\GH.html");
         }else if(Ufrom.equals("Vijayawada") && Uto.equals("Tenali"))
         {
             
         response.sendRedirect("\\VT.html");
         }else if(Ufrom.equals("Vijayawada") && Uto.equals("Guntur"))
         {
             
         response.sendRedirect("\\VG.html");
         }else if(Ufrom.equals("Vijayawada") && Uto.equals("Hyderabad"))
         {
             
         response.sendRedirect("\\VH.html");
         }else if(Ufrom.equals("Tenali") && Uto.equals("Guntur"))
         {
             
         response.sendRedirect("\\TG.html");
         }else if(Ufrom.equals("Tenali") && Uto.equals("Vijayawada"))
         {
             
         response.sendRedirect("\\TV.html");
         }else if(Ufrom.equals("Tenali") && Uto.equals("Hyderabad"))
         {
             
         response.sendRedirect("\\TH.html");
         }
        
           
        }
        catch(Exception e)
        {
        out.println("error"+e);
        
        }
    }
}
