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
public class AddBillLog extends HttpServlet {

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
                
                    String description = request.getParameter("description");
                    String received_on = request.getParameter("received_on");
                    String bill_ref_no = request.getParameter("bill_ref_no");
                    String work_order_no = request.getParameter("work_order_no");
                    String mo_no = request.getParameter("mo_no");
                    String sc_for_do = request.getParameter("sc_for_do");
                    String dop =request.getParameter("do");
                    String conf_for_ses = request.getParameter("conf_for_ses");
                    String ses = request.getParameter("ses");
                    String total_value_wot = request.getParameter("total_value_wot");
                    String total_value_wt = request.getParameter("total_value_wt");
                    //String total_value_bal = request.getParameter("total_value_bal");
                    String comments = request.getParameter("comments");
                    
                    String st1=received_on;
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
                        String new_received_on=date+"-"+month+"-"+year;
                    
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>AddBillLog</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>AddBillLog at " + request.getContextPath() + "</h1>");
                    Connection con = Service.getConnection();
                    PreparedStatement pst=con.prepareStatement("insert into bills values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1,description);
                    pst.setString(2,new_received_on);
                    pst.setString(3,bill_ref_no);
                    pst.setString(4, work_order_no);
                    pst.setString(5,mo_no);
                    pst.setString(6,sc_for_do);
                    pst.setString(7,dop);
                    pst.setString(8,conf_for_ses);
                    pst.setString(9,ses);
                    pst.setString(10,total_value_wot);
                    pst.setString(11,total_value_wt);
                    pst.setString(12,"0");
                    pst.setString(13,comments);
                    int a= pst.executeUpdate();
                    if(a<0){
                        System.out.println("a="+a);
                        request.setAttribute("msg","not done");
                RequestDispatcher rd = request.getRequestDispatcher("AddBill");
                rd.forward(request, response);
                    }else{
                        System.out.println("a="+a);
                        request.setAttribute("msg","Bill added ");
                RequestDispatcher rd = request.getRequestDispatcher("AddBill");
                rd.forward(request, response);
                    }
                    
                    out.println("</body>");
                    out.println("</html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddBillLog.class.getName()).log(Level.SEVERE, null, ex);
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
