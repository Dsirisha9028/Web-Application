import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Duggasani Sirisha
 */
@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

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
            out.println("<title>Servlet login1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login1 at " + request.getContextPath() + "</h1>");
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
   

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        try{
            Connection conn=DbConnection.dbConnection();
           // Statement pst=conn.createStatement();
            
            PreparedStatement st;
            st = conn.prepareStatement("insert into student values(?, ?, ?, ?, ?, ?, ?)");
           st.setString(1,request.getParameter("Name"));
           st.setString(2,request.getParameter("pwd"));
           st.setString(3,request.getParameter("email"));
           st.setString(4,request.getParameter("phone.no"));
           st.setString(5,request.getParameter("Roll.No"));
           st.setString(6,request.getParameter("Branch"));
           st.setString(7,request.getParameter("Ragging details"));
           st.execute();
           
           st.close();
            conn.close();
            out.println("script type=\"text/javascript\">");
            out.println("alert('You have successfully lodged your complaint');");
            out.println("location='login.html';");
            out.println("</script>");
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}