/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyPkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SCHOOL
 */
public class Remove_From_Cart_Service extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            HttpSession hs=request.getSession(false);
            if(hs==null){
                    response.sendRedirect("loginpage");
            }
            else{
            /* TODO output your page here. You may use following sample code. */
                String description=request.getParameter("description");
                Connection con=Service.getConnection();
                PreparedStatement pst_delete=con.prepareStatement("delete from cart_service where name=(?)");
                pst_delete.setString(1,description);
                int a=pst_delete.executeUpdate();
                if(a>0){
                out.println("Item deleted");
                request.setAttribute("msg","Item Removed");
                RequestDispatcher rd = request.getRequestDispatcher("AddCart1_Service");
                rd.forward(request, response);
            }
            else{
                request.setAttribute("msg","Not Removed");
                RequestDispatcher rd = request.getRequestDispatcher("AddCart1_Service");
                rd.forward(request, response);
            }
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Remove_From_Cart_Service</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Remove_From_Cart_Service at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
        } 
        }
       catch (SQLException ex) {
            Logger.getLogger(Remove_From_Cart_Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    finally {
            out.close();
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
        processRequest(request, response);
    }

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
        processRequest(request, response);
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

