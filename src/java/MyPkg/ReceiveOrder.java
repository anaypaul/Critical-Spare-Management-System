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
public class ReceiveOrder extends HttpServlet {

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
                Connection con=Service.getConnection();
                    String received_qty=request.getParameter("received_qty");
                    String umc=request.getParameter("umc");
                    String received_date=request.getParameter("received_date");
                    String order_qty=request.getParameter("order_qty");
                    String shopping_cart_no=request.getParameter("shopping_cart_no");
                    String order_date=request.getParameter("order_date");
                    String description=request.getParameter("description");
                    String reservation_no=request.getParameter("reservation_no");
                    String plant=request.getParameter("plant"); 
                    out.println("received_qty="+received_qty+"umc="+umc+"received_date="+received_date+"order_qty="+order_qty+"shopping_cart_no="+shopping_cart_no);
                   
                   // conversion for date
                    
                    String st1=order_date;
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
                        String new_order_date=date+"-"+month+"-"+year;

                        String st2=received_date;
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
                String new_received_date=date2+"-"+month2+"-"+year2;    
                out.println("new order date:"+new_order_date);
                out.println("new received date:"+new_received_date);
                        
                        
                        
                        
                 if(Integer.parseInt(order_qty)!=Integer.parseInt(received_qty)){
                    //fetch the info from products_sms
                    
                    PreparedStatement pst_pro_sms=con.prepareStatement("select l_store_qty,qty,unit_price,total_price,flag_colour,m_store_qty from products_sms where umc=(?)");
                    pst_pro_sms.setString(1,umc);
                    ResultSet rs_pro_sms=pst_pro_sms.executeQuery();
                    String l_store_qty=null;
                    String qty=null;
                    String unit_price=null;
                    String total_price=null;
                    String flag_colour=null;
                    String m_store_qty=null;
                    while(rs_pro_sms.next()){
                        
                        l_store_qty=rs_pro_sms.getString(1);
                        qty=rs_pro_sms.getString(2);
                        unit_price=rs_pro_sms.getString(3);
                        total_price=rs_pro_sms.getString(4);
                        flag_colour=rs_pro_sms.getString(5);
                        m_store_qty=rs_pro_sms.getString(6);
                    }
                    //conversion.....
                    int l_store_qtyint=Integer.parseInt(l_store_qty);
                    int m_store_qtyint=Integer.parseInt(m_store_qty);
                    int qtyint=Integer.parseInt(qty);
                    double unit_priceint=Double.parseDouble(unit_price);
                    double total_priceint=Double.parseDouble(total_price);
                    
                    int flag_colourint=Integer.parseInt(flag_colour);
                    int received_qtyint=Integer.parseInt(received_qty);
                    int order_qtyint =Integer.parseInt(order_qty);
                    m_store_qtyint -=received_qtyint;
                    l_store_qtyint += received_qtyint;
                    total_priceint = l_store_qtyint*unit_priceint;
                    flag_colourint +=received_qtyint;
                    double total_pricereportint=unit_priceint*received_qtyint;
                    order_qtyint -= received_qtyint;
                    //qtyint += received_qtyint;
                    double total_priceorderint=unit_priceint*order_qtyint;
                    //conversion back 
                    order_qty=""+order_qtyint;
                    l_store_qty=""+l_store_qtyint;
                    qty=""+qtyint;
                    total_price=""+total_priceint;
                    flag_colour=""+flag_colourint;
                    m_store_qty=""+m_store_qty;
                    String total_priceorder=""+total_priceorderint;
                    String total_pricereport=""+total_pricereportint;
                    
                    //after calculation update the order table and the products_sms table
                    PreparedStatement pst_update_order=con.prepareStatement("update order73 set order_qty=(?),receive_date=(?),total_price=(?) where umc=(?) and shopping_cart_no=(?)");
                    pst_update_order.setString(1,order_qty);
                    pst_update_order.setString(2,new_received_date);
                    pst_update_order.setString(3,total_priceorder);
                    pst_update_order.setString(4,umc);
                    pst_update_order.setString(5,shopping_cart_no);
                    int a=pst_update_order.executeUpdate();
                    
                    
                    
                   /* PreparedStatement pst_update_report=con.prepareStatement("update monthly_report_rev_sms set receive_date=(?), received_qty=(?) where umc=(?) and shopping_cart_no=(?)");
                    pst_update_report.setString(1,new_received_date);
                    pst_update_report.setString(2,received_qty);
                     pst_update_report.setString(3,umc);
                      pst_update_report.setString(4,shopping_cart_no);
                    int c=pst_update_report.executeUpdate(); */
                    
                    
                    PreparedStatement pst_update_product=con.prepareStatement("update products_sms set l_store_qty=(?),total_price=(?),flag_colour=(?), m_store_qty=(?) where umc=(?)");
                    pst_update_product.setString(1, l_store_qty);
                    //pst_update_product.setString(2, qty);
                    pst_update_product.setString(2, total_price);
                    pst_update_product.setString(3, flag_colour);
                    pst_update_product.setString(4, m_store_qty);
                    pst_update_product.setString(5, umc);
                    
                    int b=pst_update_product.executeUpdate(); 
                    
                    PreparedStatement pst_update_report=con.prepareStatement("insert into monthly_report_rev_sms values(?,?,?,?,?,?,?,?,?,?,?)");
                    pst_update_report.setString(1, shopping_cart_no);
                    pst_update_report.setString(2, new_order_date);
                    pst_update_report.setString(3,umc);
                    pst_update_report.setString(4,description);
                    pst_update_report.setString(5, order_qty);
                    pst_update_report.setString(6, unit_price);
                    pst_update_report.setString(7, total_pricereport);
                    pst_update_report.setString(8, reservation_no);
                    pst_update_report.setString(9, plant);
                    pst_update_report.setString(10, new_received_date);
                    pst_update_report.setString(11, received_qty);
                    int c=pst_update_report.executeUpdate();
                    
                    
                    
                     if(a>0 && b>0 && c>0){
                //System.out.println("ERROR ERROR ERROR a="+a);
                request.setAttribute("msg","Order Status Update");
                RequestDispatcher rd= request.getRequestDispatcher("SeeStatus");
                rd.forward(request, response);
            }
            else {
                System.out.println("a="+a);
                request.setAttribute("msg","Item not Updated");
                RequestDispatcher rd= request.getRequestDispatcher("SeeStatus");
                rd.forward(request, response);
            }
                     
        }
                    else{
                        
                     PreparedStatement pst_pro_sms=con.prepareStatement("select l_store_qty,qty,unit_price,total_price,flag_colour,m_store_qty from products_sms where umc=(?)");
                    pst_pro_sms.setString(1,umc);
                    ResultSet rs_pro_sms=pst_pro_sms.executeQuery();
                    String l_store_qty=null;
                    String qty=null;
                    String unit_price=null;
                    String total_price=null;
                    String flag_colour=null;
                    String m_store_qty=null;
                    while(rs_pro_sms.next()){
                        
                        l_store_qty=rs_pro_sms.getString(1);
                        qty=rs_pro_sms.getString(2);
                        unit_price=rs_pro_sms.getString(3);
                        total_price=rs_pro_sms.getString(4);
                        flag_colour=rs_pro_sms.getString(5);
                        m_store_qty=rs_pro_sms.getString(6);
                    }
                    //conversion.....
                    int l_store_qtyint=Integer.parseInt(l_store_qty);
                    int qtyint=Integer.parseInt(qty);
                    double unit_priceint=Double.parseDouble(unit_price);
                    double total_priceint=Double.parseDouble(total_price);
                    
                    int flag_colourint=Integer.parseInt(flag_colour);
                    int received_qtyint=Integer.parseInt(received_qty);
                    int order_qtyint =Integer.parseInt(order_qty);
                    int m_store_qtyint=Integer.parseInt(m_store_qty);
                    l_store_qtyint += received_qtyint;
                    total_priceint = l_store_qtyint*unit_priceint;
                    flag_colourint +=received_qtyint;
                    double total_pricereportint=unit_priceint*received_qtyint;
                    order_qtyint -= received_qtyint;
                    m_store_qtyint -= received_qtyint;
                    double total_priceorderint=unit_priceint*order_qtyint;
                    //conversion back 
                    order_qty=""+order_qtyint;
                    l_store_qty=""+l_store_qtyint;
                    qty=""+qtyint;
                    total_price=""+total_priceint;
                    flag_colour=""+flag_colourint;
                    String total_priceorder=""+total_priceorderint;
                    String total_pricereport=""+total_pricereportint;
                    m_store_qty=""+m_store_qtyint;
                    //after calculation update the order table and the products_sms table
                    PreparedStatement pst_update_order=con.prepareStatement("delete from order73 where umc=(?) and shopping_cart_no=(?)");
                    
                    pst_update_order.setString(1,umc);
                    pst_update_order.setString(2,shopping_cart_no);
                    int a=pst_update_order.executeUpdate();
                    
                    
                    
                   /* PreparedStatement pst_update_report=con.prepareStatement("update monthly_report_rev_sms set receive_date=(?), received_qty=(?) where umc=(?) and shopping_cart_no=(?)");
                    pst_update_report.setString(1,new_received_date);
                    pst_update_report.setString(2,received_qty);
                     pst_update_report.setString(3,umc);
                      pst_update_report.setString(4,shopping_cart_no);
                    int c=pst_update_report.executeUpdate(); */
                    
                    
                    PreparedStatement pst_update_product=con.prepareStatement("update products_sms set l_store_qty=(?),m_store_qty=(?),total_price=(?),flag_colour=(?) where umc=(?)");
                    pst_update_product.setString(1, l_store_qty);
                    pst_update_product.setString(2, m_store_qty);
                    pst_update_product.setString(3, total_price);
                    pst_update_product.setString(4, flag_colour);
                    pst_update_product.setString(5, umc);
                    int b=pst_update_product.executeUpdate(); 
                    
                    PreparedStatement pst_update_report=con.prepareStatement("insert into monthly_report_rev_sms values(?,?,?,?,?,?,?,?,?,?,?)");
                    pst_update_report.setString(1, shopping_cart_no);
                    pst_update_report.setString(2, new_order_date);
                    pst_update_report.setString(3,umc);
                    pst_update_report.setString(4,description);
                    pst_update_report.setString(5, order_qty);
                    pst_update_report.setString(6, unit_price);
                    pst_update_report.setString(7, total_pricereport);
                    pst_update_report.setString(8, reservation_no);
                    pst_update_report.setString(9, plant);
                    pst_update_report.setString(10, new_received_date);
                    pst_update_report.setString(11, received_qty);
                    int c=pst_update_report.executeUpdate();
                    
                    
                    
                     if(a>0 && b>0 && c>0){
                //System.out.println("ERROR ERROR ERROR a="+a);
                request.setAttribute("msg","Order Status Update");
                RequestDispatcher rd= request.getRequestDispatcher("SeeStatus");
                rd.forward(request, response);
            }
            else {
                System.out.println("a="+a);
                request.setAttribute("msg","Item not Updated");
                RequestDispatcher rd= request.getRequestDispatcher("SeeStatus");
                rd.forward(request, response);
            }
                     
                     
                     
                     
                     
                        
                        
                        
                       /* PreparedStatement pst_delete=con.prepareStatement("delete from order73 where umc=(?) and shopping_cart_no=(?)");
                        pst_delete.setString(1, umc);
                        pst_delete.setString(2,shopping_cart_no);
                        int e=pst_delete.executeUpdate();
                         if(e>0 ){
                            //System.out.println("ERROR ERROR ERROR a="+a);
                            request.setAttribute("msg","Order Status Update");
                            RequestDispatcher rd= request.getRequestDispatcher("SeeStatus");
                            rd.forward(request, response);
                        }
                        else {
                             System.out.println("a="+a);
                             request.setAttribute("msg","Item not Updated");
                             RequestDispatcher rd= request.getRequestDispatcher("SeeStatus");
                            rd.forward(request, response);
            }*/
                        
                    }
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>ReceiveOrder</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Servlet ReceiveOrder at " + request.getContextPath() + "</h1>");
                    out.println("</body>");
                    out.println("</html>");
                     if(request.getAttribute("msg")!=null){
                out.println("<center><font color=\"red\">"+request.getAttribute("msg")+"</font></center>");
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReceiveOrder.class.getName()).log(Level.SEVERE, null, ex);
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
