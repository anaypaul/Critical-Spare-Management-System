/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shikha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class UpdateItem_Log extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
           else{
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>UpdateItem_Log</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateItem_Log at " + request.getContextPath() + "</h1>");
            String actual_umc=request.getParameter("actual_umc");
            String umc=request.getParameter("umc");
            String description=request.getParameter("desc");
            String plant=request.getParameter("plant");
            String category=request.getParameter("category");
            String critical=request.getParameter("critical");
            String material_class=request.getParameter("material_class");
            String r_qty=request.getParameter("r_qty");
            String l_store_qty=request.getParameter("l_store_qty");
            String m_store_qty=request.getParameter("m_store_qty");
            //String qty=request.getParameter("a_qty");
            String uom=request.getParameter("uom");
            String location=request.getParameter("location");
            String u_price=request.getParameter("u_price");
            
            String total_price;
            String type=request.getParameter("type");
            String flag_colour;
            
           System.out.println(category);
            
            //operation
                int l_qty=Integer.parseInt(l_store_qty);
                int m_qty=Integer.parseInt(m_store_qty);
                int t=l_qty+m_qty;
                String qty=""+t;
                int x=(Integer.valueOf(l_store_qty)).intValue();
                int y=(Integer.valueOf(r_qty)).intValue();
                int f=x-y;
                flag_colour=""+f;
                
                //out.println("flag="+flag_colour);
                float m=(Float.valueOf(u_price)).floatValue();
                float r=m*x;
                total_price=""+r;
                
                
            //connection    
            Connection con=Service.getConnection();
            
            String sql="update products_sms SET umc=(?),name=(?),plant=(?),category=(?),criticality=(?),material_class=(?),r_qty=(?),qty=(?),uom=(?),location=(?),unit_price=(?),total_price=(?),nrml_insu=(?),flag_colour=(?),l_store_qty=(?),m_store_qty=(?) where umc=(?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, umc);
            pst.setString(2, description);
            pst.setString(3, plant);
            pst.setString(4,category);
            pst.setString(5, critical);
            pst.setString(6, material_class);
            pst.setString(7, r_qty);
            pst.setString(8, qty);
            pst.setString(9, uom);
            pst.setString(10, location);
            pst.setString(11, u_price);
            pst.setString(12, total_price);
            pst.setString(13, type);
            pst.setString(14, flag_colour);
            pst.setString(15, l_store_qty);
            //if(plant.equals("37")){
            pst.setString(16,m_store_qty);
            //}else{
            //    pst.setString(15,"99999");
            //}
            pst.setString(17, actual_umc);
           
            int a=pst.executeUpdate();
            
            
            if(a<0){
                //System.out.println("ERROR ERROR ERROR a="+a);
                request.setAttribute("msg","Updation failed.");
                RequestDispatcher rd= request.getRequestDispatcher("EditData");
                rd.forward(request, response);
            }
            else if(a>0){
                System.out.println("a="+a);
                request.setAttribute("msg","Item Updated Successfully");
                RequestDispatcher rd= request.getRequestDispatcher("EditData");
                rd.forward(request, response);
            }
            
            out.println("</body>");
            out.println("</html>");
           }
        } catch (Exception ex) {
            out.println(ex);
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
