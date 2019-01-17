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
public class ReceiveOrderService extends HttpServlet {

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
            }else{
                Connection con=Service.getConnection();
                String shopping_cart_no=request.getParameter("shopping_cart_no");
                String order_qty=request.getParameter("order_qty");
                String received_date=request.getParameter("received_date");
                String description=request.getParameter("description");
                //System.out.println("<h1>received date</h1>"+received_date);
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
                       // System.out.println("new received Date="+new_received_date);
                
                

                                                    
                                                    
                                                    //fetch details from order_prpo to insert into monthly report
                                                    PreparedStatement pst_order_fetch=con.prepareStatement("select * from order_service where shopping_cart_no=(?) and name=(?)");
                                                    
                                                    pst_order_fetch.setString(1,shopping_cart_no);
                                                    pst_order_fetch.setString(2,description);
                                                    ResultSet rs_order_fetch=pst_order_fetch.executeQuery();
                                                    String pr_nox=null;
                                                    String order_datex=null;
                                                    String po_nox=null;
                                                    String exp_delivery_datex=null;
                                                    String total_pricex=null;
                                                   // String plantx=null;
                                                    String pr_datex=null;
                                                    String po_datex=null;
                                                    String namex=null;
                                                    String unit_price=null;
                                                    while(rs_order_fetch.next()){
                                                        System.out.println("success!!!!!");
                                                        namex=rs_order_fetch.getString(6);
                                                        pr_nox=rs_order_fetch.getString(2);
                                                        order_datex=rs_order_fetch.getString(3);
                                                        po_nox=rs_order_fetch.getString(4);
                                                        exp_delivery_datex=rs_order_fetch.getString(5);
                                                        total_pricex=rs_order_fetch.getString(9);
                                                        unit_price=rs_order_fetch.getString(8);
                                                        pr_datex=rs_order_fetch.getString(11);
                                                        po_datex=rs_order_fetch.getString(12);
                                                    }
                                                    System.out.println("received_date="+received_date);
                         st2=received_date;
                        year2=st2.split("\\-")[0];
                        month2=st2.split("\\-")[1];
                        date2=st2.split("\\-")[2];
                        mon2=Integer.parseInt(month2);
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
                new_received_date=date2+"-"+month2+"-"+year2;               
                     System.out.println("new_received_date="+new_received_date);                               
                                                    
                         System.out.println("po_datex="+po_datex);                           
                        st2=po_datex;
                        String half=st2.split("\\ ")[0];
               
                        year2=half.split("\\-")[0];
                        month2=half.split("\\-")[1];
                        date2=half.split("\\-")[2];
                        mon2=Integer.parseInt(month2);
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
                String new_po_datex=date2+"-"+month2+"-"+year2;    
               
                                                    System.out.println("new_po_datex"+new_po_datex);
                                                    
                                                    System.out.println("pr_datex="+pr_datex);
                         st2=pr_datex;
                         half=st2.split("\\ ")[0];
               
                        year2=half.split("\\-")[0];
                        month2=half.split("\\-")[1];
                        date2=half.split("\\-")[2];
                        mon2=Integer.parseInt(month2);
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
                String new_pr_datex=date2+"-"+month2+"-"+year2;
                                                    System.out.println("new_pr_datex="+new_pr_datex);
                                                    System.out.println("order_datex="+order_datex);
                                                   st2=order_datex;
                                                        order_datex=st2.split("\\ ")[0];
                                                        year2=order_datex.split("\\-")[0];
                                                        month2=order_datex.split("\\-")[1];
                                                        date2=order_datex.split("\\-")[2];
                                                        mon2=Integer.parseInt(month2);
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
                                                String new_order_datex=date2+"-"+month2+"-"+year2;
                                                System.out.println("new_order_datex="+new_order_datex);
                                                System.out.println("exp_delivery_datex="+exp_delivery_datex);
                        st2=exp_delivery_datex;
                        half=st2.split("\\ ")[0];
               
                        year2=half.split("\\-")[0];
                        month2=half.split("\\-")[1];
                        date2=half.split("\\-")[2];
                        mon2=Integer.parseInt(month2);
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
                String new_exp_delivery_datex=date2+"-"+month2+"-"+year2;    
               System.out.println("new_exp_delivery_datex="+new_exp_delivery_datex);
               
               
               
               
               
               
                                
                                                    
                                                    
                                                    
                                                    PreparedStatement pst_monthly=con.prepareStatement("insert into monthly_report_service_sms values(?,?,?,?,?,?,?,?,?,?,?,?)");
                                                    pst_monthly.setString(1,shopping_cart_no);
                                                    pst_monthly.setString(2,pr_nox);
                                                    pst_monthly.setString(3,new_order_datex);
                                                    pst_monthly.setString(4,po_nox);
                                                    pst_monthly.setString(5,new_exp_delivery_datex);
                                                    //pst_monthly.setString(6,umc);
                                                    pst_monthly.setString(6,namex);
                                                    pst_monthly.setString(7,order_qty);
                                                    pst_monthly.setString(8,unit_price);
                                                    pst_monthly.setString(9,total_pricex);
                                                    //pst_monthly.setString(11,plantx);
                                                    pst_monthly.setString(10,new_received_date);
                                                    pst_monthly.setString(11,new_pr_datex);
                                                    pst_monthly.setString(12,new_po_datex);
                                                    //pst_monthly.setString(15,received_qty);
                                                    int p=pst_monthly.executeUpdate();
                                                    if(p>0){
                                                    //System.out.println("ERROR ERROR ERROR a="+a);
                                                        request.setAttribute("msg","Order Status Update");
                                                        RequestDispatcher rd= request.getRequestDispatcher("SeeStatusService");
                                                        rd.forward(request, response);
                                                        }
                                                        else {
                                                            System.out.println("p="+p);
                                                            request.setAttribute("msg","Item not Updated");
                                                            RequestDispatcher rd= request.getRequestDispatcher("SeeStatusService");
                                                            rd.forward(request, response);
                                                        }
                                                    PreparedStatement pst_delete_order=con.prepareStatement("delete from order_service where name=(?) and shopping_cart_no=(?)");
                                                    
                                                    pst_delete_order.setString(1, description);
                                                    pst_delete_order.setString(2, shopping_cart_no);
                                                    int b=pst_delete_order.executeUpdate();
                                                    if(b>0){
                                                 //System.out.println("ERROR ERROR ERROR a="+a);
                                                    request.setAttribute("msg","Order Status Update");
                                                    RequestDispatcher rd= request.getRequestDispatcher("SeeStatusService");
                                                    rd.forward(request, response);
                                                    }
                                                    else {
                                                        System.out.println("b="+b);
                                                        request.setAttribute("msg","Item not Updated");
                                                        RequestDispatcher rd= request.getRequestDispatcher("SeeStatusService");
                                                        rd.forward(request, response);
                                                    }
                                                  
            
               
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>ReceiveOrderService</title>");            
                out.println("</head>");
                out.println("<body>");
                             
                out.println("</body>");
                out.println("</html>");
                    
                    
        }
        }
        catch (SQLException ex) {
            Logger.getLogger(ReceiveOrderPRPO.class.getName()).log(Level.SEVERE, null, ex);
        }                  finally {
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
