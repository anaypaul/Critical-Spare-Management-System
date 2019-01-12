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
public class User_IssueFormLog extends HttpServlet {

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
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>User_IssueFormLog</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Servlet User_IssueFormLog at " + request.getContextPath() + "</h1>");
                    String nm=(String)hs.getAttribute("uname");
                    String umc=request.getParameter("umc");
                    String description=request.getParameter("name");
                    System.out.println("desc="+description);
                    String issue_qty=request.getParameter("issue_qty");
                    String issue_date=request.getParameter("issue_date");
                    String purpose=request.getParameter("purpose");
                    System.out.println("uname="+nm);
                    
                    //get the local store , available qty and the flag colour to update it after issue process qty from products-sms
                    Connection con=Service.getConnection();
                    PreparedStatement pst_fetch=con.prepareStatement("select l_store_qty,flag_colour,qty,unit_price from products_sms where umc=(?)");
                    pst_fetch.setString(1,umc);
                    String l_store_qty=null;
                    String flag_colour=null;
                    String available_qty=null;
                    String total_price=null;
                    String unit_price=null;
                    String total_price_report=null;
                    ResultSet rs_fetch=pst_fetch.executeQuery();
                    if(rs_fetch.next()){
                        l_store_qty=rs_fetch.getString(1);
                        flag_colour=rs_fetch.getString(2);
                        available_qty=rs_fetch.getString(3);
                        unit_price=rs_fetch.getString(4);
                    }
                    //conversion
                    int l_store_qtyint = Integer.parseInt(l_store_qty);
                    int flag_colourint = Integer.parseInt(flag_colour);
                    int available_qtyint =Integer.parseInt(available_qty);
                    int issue_qtyint = Integer.parseInt(issue_qty);
                    double unit_pricedouble=Double.parseDouble(unit_price);
                   
                    
                    //calculation 
                    l_store_qtyint = l_store_qtyint - issue_qtyint;
                    available_qtyint = available_qtyint - issue_qtyint;
                    flag_colourint = flag_colourint - issue_qtyint;
                    double total_pricedouble=(l_store_qtyint)*(unit_pricedouble);
                    double total_price_reportdouble=(issue_qtyint)*(unit_pricedouble);
                    //back to string
                    l_store_qty=""+l_store_qtyint;
                    available_qty=""+available_qtyint;
                    flag_colour=""+flag_colourint;
                    total_price=""+total_pricedouble;
                    total_price_report=""+total_price_reportdouble;
                    
                    
                    
                    
                    
                    
                    
                        String st2=issue_date;
                        String year2=st2.split("\\-")[0];
                        String month2=st2.split("\\-")[1];
                        String date2=st2.split("\\-")[2];
                        int mon2=Integer.parseInt(month2);
                        switch(mon2){
                                case 1:
                                        month2="jan";
                                        break;
                                case 2:
                                        month2="feb";
                                        break;
                                case 3:
                                        month2="mar";
                                        break;
                                case 4:
                                        month2="apr";
                                        break;
                                case 5:
                                        month2="may";
                                        break;
                                case 6:
                                        month2="jun";
                                        break;
                                case 7:
                                        month2="jul";
                                        break;
                                case 8:
                                        month2="aug";
                                        break;
                                case 9:
                                        month2="sep";
                                        break;
                                case 10:
                                        month2="oct";
                                        break;
                                case 11:
                                        month2="nov";
                                        break;
                                case 12:
                                        month2="dec";
                                        break;
                        }
                    String new_issue_date=date2+"-"+month2+"-"+year2;
                    PreparedStatement pst_update=con.prepareStatement("update products_sms set l_store_qty=(?), flag_colour=(?),qty=(?),total_price=(?) where umc=(?)");
                    pst_update.setString(1,l_store_qty);
                    pst_update.setString(2,flag_colour);
                    pst_update.setString(3,available_qty);
                    pst_update.setString(4, total_price);
                    pst_update.setString(5,umc);
                    int a=pst_update.executeUpdate();
                    if(a<0){
                        System.out.println("issue process failed");
                        request.setAttribute("msg","Issue Process Failed.Try again");
                        RequestDispatcher rd = request.getRequestDispatcher("User_SearchItemLog");
                        rd.forward(request, response);
                    }
                    else{
                        System.out.println("Product Issued Successfully");
                        request.setAttribute("msg","Products Issued . Thank you ");
                        RequestDispatcher rd = request.getRequestDispatcher("User_SearchItemLog");
                        rd.forward(request, response);
                    }
                    
                    PreparedStatement pst=con.prepareStatement("insert into monthly_report_issue_sms values(?,?,?,?,?,?,?,?)");
                    pst.setString(1, umc);
                    pst.setString(2, description);
                    pst.setString(3, issue_qty);
                    pst.setString(4,new_issue_date);
                    pst.setString(5,unit_price);
                    pst.setString(6,total_price_report);
                    pst.setString(7, purpose);
                    pst.setString(8, nm);
                    a=pst.executeUpdate();
                    if(a<0){
                        System.out.println("a="+a);
                    }else{
                        System.out.println("a="+a);
                    }
                    out.println("</body>");
                    out.println("</html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(User_IssueFormLog.class.getName()).log(Level.SEVERE, null, ex);
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
