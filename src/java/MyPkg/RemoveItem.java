/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyPkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SCHOOL
 */
public class RemoveItem extends HttpServlet {

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
            out.println("<title>RemoveItem</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RemoveItem at " + request.getContextPath() + "</h1>");
            out.print("<center><a href=\"adminHome\"><h4>HOME</a>&nbsp;&nbsp;&nbsp;"
                    + "<a href=\"EditPassword\">ACCOUNT SETTINGS</a>&nbsp;&nbsp;&nbsp;"
                    + "<a href=\"UserManager\">USER MANAGER</a>&nbsp;&nbsp;&nbsp;"
                            + "<a href=\"AddItem\">ADD ITEM</a>&nbsp;&nbsp;&nbsp;"
                            + "<a href=\"EditData\">EDIT DATA</a>&nbsp;&nbsp;&nbsp;"
                            + "<a href=\"SearchItem\">SEARCH ITEM</a>&nbsp;&nbsp;&nbsp;"
                            + "<a href=\"ViewAll\">VIEW ALL</a>&nbsp;&nbsp;&nbsp;"
                            + "<a href=\"PlaceOrder\">PLACE ORDER</a>&nbsp;&nbsp;&nbsp;"
                            + "<a href=\"Bills\">BILLS</a>&nbsp;&nbsp;&nbsp;"
                            + "<a href=\"MonthlyReport\">MONTHLY REPORT</a>&nbsp;&nbsp;&nbsp;"
                            + "<a href=\"CheckStatusSelect\">CHECK STATUS</a>&nbsp;&nbsp;&nbsp;"
                            + "<a href=\"Logout\">LOGOUT</a></h4></center>"
                    + "<br><br><br>");
            Connection con=Service.getConnection();
                    
                    PreparedStatement pst=con.prepareStatement("select * from products_sms");
                    ResultSet rs=pst.executeQuery();
                    out.println("<form action=\"RemoveItemLog\" method=\"post\">"
                            + "<table border='1'>"
                                + "<tr>"
                                + "<td>Umc</td>"
                                + "<td>Description</td>"
                                + "<td>Plant</td>"
                                + "<td>Category</td>"
                                + "<td>Criticality</td>"
                                + "<td>Recommended Quantity</td>"
                                + "<td>Available Quantity</td>"
                                + "<td>UOM</td>"
                                + "<td>Location</td>"
                                + "<td>Unit Price</td>"
                                + "<td>Total Price</td>"
                                + "<td>Normal/Insurance</td>"
                                + "<td>Flag Colour</td>"
                                + "</tr>");
                    while(rs.next()){
                        out.println("<tr>"
                                + "<td><a href=\"RemoveItemLog?umc="+rs.getString(1)+"\">"+rs.getString(1)+"</a></td>"
                                + "<td>"+rs.getString(2)+"</td>"
                                + "<td>"+rs.getString(3)+"</td>"
                                + "<td>"+rs.getString(4)+"</td>"
                                + "<td>"+rs.getString(5)+"</td>"
                                + "<td>"+rs.getString(6)+"</td>"
                                + "<td>"+rs.getString(7)+"</td>"
                                + "<td>"+rs.getString(8)+"</td>"
                                + "<td>"+rs.getString(9)+"</td>"
                                + "<td>"+rs.getString(10)+"</td>"
                                + "<td>"+rs.getString(11)+"</td>"
                                + "<td>"+rs.getString(12)+"</td>");
                                String fl=rs.getString(13);
                                int m=Integer.parseInt(fl);
                                if(m==0){
                                    out.println("<td bgcolor=\"#FFFF33\">"+rs.getString(13)+"</td>");
                                }
                                else if(m<=-1){
                                    out.println("<td bgcolor=\"red\">"+rs.getString(13)+"</td>");
                                }
                                else{
                                    out.println("<td bgcolor=\"green\">"+rs.getString(13)+"</td>");
                                }
                                
                                
                                
                    }

            out.println("</table></form></body>");
            out.println("</html>");
            }
        } catch (Exception ex) {
            out.println(ex);
        }  finally {
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
