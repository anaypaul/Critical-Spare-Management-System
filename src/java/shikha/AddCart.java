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
public class AddCart extends HttpServlet {

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
            out.println("<title>AddCart</title>");  
            Connection con=Service.getConnection();
            String umc=request.getParameter("umc");
            String plant=request.getParameter("plant");
                System.out.println("plant="+plant);
                
            PreparedStatement pst_fetch=con.prepareStatement("select umc,name,plant,category,criticality,material_class,unit_price from products_sms where umc=(?)");
            pst_fetch.setString(1, umc);
            ResultSet rs_fetch=pst_fetch.executeQuery();
            String description=null;
            
            String category=null;
            String criticality=null;
            String material_class=null;
            String unit_price=null;
            while(rs_fetch.next()){
                description=rs_fetch.getString(2);
                plant=rs_fetch.getString(3);
                category=rs_fetch.getString(4);
                
                criticality=rs_fetch.getString(5);
                material_class=rs_fetch.getString(6);
                unit_price=rs_fetch.getString(7);
            }
            
            
            PreparedStatement pst_insert=con.prepareStatement("insert into cart values(?,?,?,?,?,?,?,?,?,?)");
            pst_insert.setString(1,"");
            pst_insert.setString(2,umc);
            pst_insert.setString(3,description);
            pst_insert.setString(4,category);
            pst_insert.setString(5,criticality);
            pst_insert.setString(6,material_class);
            pst_insert.setString(7,"");
            pst_insert.setString(8,"");
            pst_insert.setString(9,unit_price);
            pst_insert.setString(10, plant);
           
            
            int a=pst_insert.executeUpdate();
            if(plant.equals("73")){
            if(a<0){
                request.setAttribute("msg","not added to cart");
                RequestDispatcher rd = request.getRequestDispatcher("PlaceOrderLog73");
                rd.forward(request, response);
            }else{
                request.setAttribute("msg","Added to cart");
                RequestDispatcher rd = request.getRequestDispatcher("PlaceOrderLog73");
                rd.forward(request, response);
            }
            }
            else{
                    if(a<0){
                request.setAttribute("msg","not added to cart");
                RequestDispatcher rd = request.getRequestDispatcher("PlaceOrderLog37");
                rd.forward(request, response);
            }else{
                request.setAttribute("msg","Added to cart");
                RequestDispatcher rd = request.getRequestDispatcher("PlaceOrderLog37");
                rd.forward(request, response);
            }
            }
            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCart at " + request.getContextPath() + "</h1>");
            
            out.println("</body>");
            out.println("</html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddCart.class.getName()).log(Level.SEVERE, null, ex);
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
