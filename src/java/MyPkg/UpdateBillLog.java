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
public class UpdateBillLog extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession hs=request.getSession(false);
            if(hs==null){
                response.sendRedirect("loginpage");
            }else{
                    String bill_ref_no=request.getParameter("bill_ref_no");
                    String total_value_wt = request.getParameter("total_value_wt");
                    Connection con= Service.getConnection();
                    
                    PreparedStatement pst=con.prepareStatement("update bills set total_value_bal=(?) where bill_ref_no=(?)");
                    pst.setString(1, total_value_wt);
                    pst.setString(2, bill_ref_no);
                    
                    int a = pst.executeUpdate();
                    if(a<0){
                        System.out.println("a="+a);
                        request.setAttribute("msg","update not done");
                RequestDispatcher rd = request.getRequestDispatcher("UpdateBill");
                rd.forward(request, response);
                    }else{
                        System.out.println("a="+a);
                        request.setAttribute("msg","bill updated");
                RequestDispatcher rd = request.getRequestDispatcher("UpdateBill");
                rd.forward(request, response);
                    }
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>UpdateBillLog</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Servlet UpdateBillLog at " + request.getContextPath() + "</h1>");
                    out.println("</body>");
                    out.println("</html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateBillLog.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
