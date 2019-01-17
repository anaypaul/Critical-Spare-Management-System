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
public class SeeStatusPRPOLog extends HttpServlet {

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
                    
                    String shopping_cart_no=request.getParameter("shopping_cart_no");
                    String order_date=request.getParameter("order_date");
                    String pr_no=request.getParameter("pr_no");
                    String pr_date=request.getParameter("pr_date");
                    String po_no=request.getParameter("po_no");
                    String po_date=request.getParameter("po_date");
                    String exp_delivery_date=request.getParameter("exp_delivery_date");
                    out.println("Shopping Cart No="+shopping_cart_no+"pr no="+pr_no+"pr_date="+pr_date+"po_date="+po_date+"exp_delivery_date="+exp_delivery_date);
                    Connection con = Service.getConnection();
                              
                     if(pr_date!="" && po_date=="" && exp_delivery_date==""){  
                        String st1=pr_date;
                        String year=st1.split("\\-")[0];
                        String month=st1.split("\\-")[1];
                        String date=st1.split("\\-")[2];
                        int mon=Integer.parseInt(month);
                        switch(mon){
                                case 1:
                                        month="jan";
                                        break;
                                case 2:
                                        month="feb";
                                        break;
                                case 3:
                                        month="mar";
                                        break;
                                case 4:
                                        month="apr";
                                        break;
                                case 5:
                                        month="may";
                                        break;
                                case 6:
                                        month="jun";
                                        break;
                                case 7:
                                        month="jul";
                                        break;
                                case 8:
                                        month="aug";
                                        break;
                                case 9:
                                        month="sep";
                                        break;
                                case 10:
                                        month="oct";
                                        break;
                                case 11:
                                        month="nov";
                                        break;
                                case 12:
                                        month="dec";
                                        break;
                        }
                        String new_pr_date=date+"-"+month+"-"+year;
                        out.println("new_pr_date="+new_pr_date);
                        
                        
                        PreparedStatement pst_update=con.prepareStatement("update order_prpo set pr_no=(?),pr_date=(?),po_no=(?),po_date=(?),exp_delivery_date=(?) where shopping_cart_no=(?)");
                    pst_update.setString(1,""+pr_no);
                    pst_update.setString(2,""+new_pr_date);
                    pst_update.setString(3,""+po_no);
                    pst_update.setString(4,"");
                    pst_update.setString(5,"");
                    pst_update.setString(6,shopping_cart_no);
                    int a=pst_update.executeUpdate();
                    
                    if(a<0){
                        System.out.println("a="+a);
                        request.setAttribute("msg","ORDER_PRPO NOT Updated ");
                        RequestDispatcher rd = request.getRequestDispatcher("SeeStatusPRPO");
                        rd.forward(request, response);
                    }else{
                        System.out.println("a="+a);
                        request.setAttribute("msg","ORDER_PRPO Updated");
                        RequestDispatcher rd = request.getRequestDispatcher("SeeStatusPRPO");
                        rd.forward(request, response);
                    }
           }     
                        
                        
                        
                        
                        
                      else if(pr_date!="" && po_date!="" && exp_delivery_date!=""){
                           String st1=pr_date;
                        String year=st1.split("\\-")[0];
                        String month=st1.split("\\-")[1];
                        String date=st1.split("\\-")[2];
                        int mon=Integer.parseInt(month);
                        switch(mon){
                                case 1:
                                        month="jan";
                                        break;
                                case 2:
                                        month="feb";
                                        break;
                                case 3:
                                        month="mar";
                                        break;
                                case 4:
                                        month="apr";
                                        break;
                                case 5:
                                        month="may";
                                        break;
                                case 6:
                                        month="jun";
                                        break;
                                case 7:
                                        month="jul";
                                        break;
                                case 8:
                                        month="aug";
                                        break;
                                case 9:
                                        month="sep";
                                        break;
                                case 10:
                                        month="oct";
                                        break;
                                case 11:
                                        month="nov";
                                        break;
                                case 12:
                                        month="dec";
                                        break;
                        }
                        String new_pr_date=date+"-"+month+"-"+year;
                        out.println("new_pr_date="+new_pr_date);
                        
                        
                        st1=po_date;
                        year=st1.split("\\-")[0];
                        month=st1.split("\\-")[1];
                        date=st1.split("\\-")[2];
                        mon=Integer.parseInt(month);
                        switch(mon){
                                case 1:
                                        month="jan";
                                        break;
                                case 2:
                                        month="feb";
                                        break;
                                case 3:
                                        month="mar";
                                        break;
                                case 4:
                                        month="apr";
                                        break;
                                case 5:
                                        month="may";
                                        break;
                                case 6:
                                        month="jun";
                                        break;
                                case 7:
                                        month="jul";
                                        break;
                                case 8:
                                        month="aug";
                                        break;
                                case 9:
                                        month="sep";
                                        break;
                                case 10:
                                        month="oct";
                                        break;
                                case 11:
                                        month="nov";
                                        break;
                                case 12:
                                        month="dec";
                                        break;
                        }
                        String new_po_date=date+"-"+month+"-"+year;
                        out.println("new_po_date="+new_pr_date);
                       
                       
                        st1=exp_delivery_date;
                        year=st1.split("\\-")[0];
                        month=st1.split("\\-")[1];
                        date=st1.split("\\-")[2];
                        mon=Integer.parseInt(month);
                        switch(mon){
                                case 1:
                                        month="jan";
                                        break;
                                case 2:
                                        month="feb";
                                        break;
                                case 3:
                                        month="mar";
                                        break;
                                case 4:
                                        month="apr";
                                        break;
                                case 5:
                                        month="may";
                                        break;
                                case 6:
                                        month="jun";
                                        break;
                                case 7:
                                        month="jul";
                                        break;
                                case 8:
                                        month="aug";
                                        break;
                                case 9:
                                        month="sep";
                                        break;
                                case 10:
                                        month="oct";
                                        break;
                                case 11:
                                        month="nov";
                                        break;
                                case 12:
                                        month="dec";
                                        break;
                        }
                        String new_exp_delivery_date=date+"-"+month+"-"+year;
                        out.println("new_exp_delivery_date="+new_exp_delivery_date);
                       
                       
                     
                     
                    
                    PreparedStatement pst_update=con.prepareStatement("update order_prpo set pr_no=(?),pr_date=(?),po_no=(?),po_date=(?),exp_delivery_date=(?) where shopping_cart_no=(?)");
                    pst_update.setString(1,""+pr_no);
                    pst_update.setString(2,""+new_pr_date);
                    pst_update.setString(3,""+po_no);
                    pst_update.setString(4,""+new_po_date);
                    pst_update.setString(5,""+new_exp_delivery_date);
                    pst_update.setString(6,shopping_cart_no);
                    int a=pst_update.executeUpdate();
                    
                    if(a<0){
                        System.out.println("a="+a);
                        request.setAttribute("msg","ORDER_PRPO NOT Updated ");
                        RequestDispatcher rd = request.getRequestDispatcher("SeeStatusPRPO");
                        rd.forward(request, response);
                    }else{
                        System.out.println("a="+a);
                        request.setAttribute("msg","ORDER_PRPO Updated");
                        RequestDispatcher rd = request.getRequestDispatcher("SeeStatusPRPO");
                        rd.forward(request, response);
                    }
         }
                    
                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>SeeStatusPRPOLog</title>");
                            out.println("</head>");
                            out.println("<body>");
                            out.println("<h1>Servlet SeeStatusPRPOLog at " + request.getContextPath() + "</h1>");
                            out.println("</body>");
                            out.println("</html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeeStatusPRPOLog.class.getName()).log(Level.SEVERE, null, ex);
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
