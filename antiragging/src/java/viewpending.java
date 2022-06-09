import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Duggasani Sirisha
 */
@WebServlet(urlPatterns = {"/viewpending"})
public class viewpending extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet view_pending</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet view_pending at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
         response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        try{
            Connection conn=DbConnection.dbConnection();
           // Statement pst=conn.createStatement();
            
            Statement stmt = conn.createStatement();  
             ResultSet rs = stmt.executeQuery("select * from student"); 
             out.println("script type=\"text/javascript\">");
             out.println("<html><body>"); 
             out.println("<table border=1 width=50% height=50%>");  
             out.println("<tr><th>Name</th><th>Rollno</th><th>email</th><th>phone no</th><th>Branch</th><th>text</th><th>Status</th><tr>"); 
             while (rs.next()) 
             {  
                 String n = rs.getString("sname");  
                 String nr = rs.getString("rno");
                 String ne = rs.getString("email");
                 String np = rs.getString("phno");
                 String nb = rs.getString("branch");
                 String nt = rs.getString("ragdetails");
                 String ns = rs.getString("statuus"); 
                 out.println("<tr><td>" + n + "</td><td>" + nr + "</td><td>" + ne + "</td><td>" + np + "</td><td>" + nb + "</td><td>" + nt + "</td><td>" + ns + "</td></tr>");   
             }  
             
             out.println("</table>");  
             
             out.println("</html></body>");
             out.println("location='View_pendingrequest.html';");
            out.println("</script>");
             
             conn.close();
        
    }
        catch(Exception e){
             e.printStackTrace();
        }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    // </editor-fold>
    }

}