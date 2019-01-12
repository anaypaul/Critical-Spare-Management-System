/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shikha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class AddCart_Service extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>AddCart_Service</title>");  
            Connection con=Service.getConnection();
            String shopping_cart_no=request.getParameter("shopping_cart_no");
            String description=request.getParameter("description");
           // String order_date=request.getParameter("order_date");
            String order_qty=request.getParameter("order_qty");
            String unit_price=request.getParameter("unit_price");
            double total_pricedouble=Integer.parseInt(order_qty)*Double.parseDouble(unit_price);
            String total_price=""+total_pricedouble;
            
            PreparedStatement pst_insert=con.prepareStatement("insert into cart_service values(?,?,?,?,?)");
            pst_insert.setString(1,shopping_cart_no);
            pst_insert.setString(2,description);
            pst_insert.setString(3,order_qty);
            pst_insert.setString(4,"");
            pst_insert.setString(5,unit_price);
            
            int a=pst_insert.executeUpdate();
           
            if(a<0){
                request.setAttribute("msg","not added to cart");
                RequestDispatcher rd = request.getRequestDispatcher("ServiceOrder");
                rd.forward(request, response);
            }else{
                request.setAttribute("msg","Added to cart");
                RequestDispatcher rd = request.getRequestDispatcher("ServiceOrder");
                rd.forward(request, response);
            }
            /* TODO output your page here. You may use following sample code. */
            
            out.println("</body>");
            out.println("</html>");
            }
            
        }catch (SQLException ex) {
                Logger.getLogger(AddCart_Service.class.getName()).log(Level.SEVERE, null, ex);
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
