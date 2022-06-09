import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Duggasani Sirisha
 */
@WebServlet(urlPatterns = {"/register"})
public class register extends HttpServlet {

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
            out.println("<title>Servlet register</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet register at " + request.getContextPath() + "</h1>");
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
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        int flag=0;
        String user=request.getParameter("uname");
        String pwd=request.getParameter("pwd");
        if(user.isEmpty() || pwd.isEmpty()){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('You must fill both the fields');");
            out.println("location='home.html';");
            out.println("</script>");
        }
        if(user.equals("admin") && pwd.equals("admin")){
            response.sendRedirect("http://localhost:8284/antiragging/homeadmin.html");
        }
        else{
            try
			{
				Connection conn = DbConnection.dbConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("select rno, pwd from student");
				while(rs.next())
				{
					if(user.equals(rs.getString("rno")) && pwd.equals(rs.getString("pwd")))
					{
						/*HttpSession hs = request.getSession();
						hs.setAttribute("uID", user);
						hs.setAttribute("name", rs.getString(1));*/
						response.sendRedirect("http://localhost:8284/Antiragging/checkStatus.jsp");
					}
				}
				st.close();
				conn.close();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('UserID or password incorrect');");
				out.println("location='home.html';");
				out.println("</script>");
                }
            catch(Exception e)
			{
				e.printStackTrace();
			}
        /*else{
            try{
                
            }
        }*/
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
  

}
}
