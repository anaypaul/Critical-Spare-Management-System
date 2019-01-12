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

/**
 *
 * @author SCHOOL
 */
public class RegistrationLog extends HttpServlet {

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
            String nm=request.getParameter("uname");
            String ps=request.getParameter("pass");
            String name=request.getParameter("name");
            String con_pass=request.getParameter("con_pass");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>RegistrationLog</title>");            
            out.println("</head>");
            out.println("<body>");
           if(con_pass.equals(ps)){
                    Connection con=Service.getConnection();
                    PreparedStatement pst=con.prepareStatement("insert into login_sms values(?,?,'user')");
                    pst.setString(1,nm);
                    pst.setString(2, ps);

                    int a=pst.executeUpdate();
                    PreparedStatement pst1=con.prepareStatement("insert into rq_sms values(?,'rejected',?)");
                    pst1.setString(1,nm);
                    pst1.setString(2,name);
                    int b=pst1.executeUpdate();
                    System.out.println("a="+a);
                    if(a>0 && b>0){
                        out.println("record insert succesfully");
                        request.setAttribute("msg","Thank You for registering");
                        RequestDispatcher rd = request.getRequestDispatcher("loginpage");
                        rd.forward(request, response);
                    }
                    else{
                        request.setAttribute("msg","Registration Failed.Please try again");
                        RequestDispatcher rd = request.getRequestDispatcher("Register");
                        rd.forward(request, response);
                    }
           }
           else{
                    request.setAttribute("msg","The password did not match. Please Re-enter.");
                    RequestDispatcher rd = request.getRequestDispatcher("Register");
                    rd.forward(request, response);
           }
            out.println("<h1>Servlet RegistrationLog at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            request.setAttribute("msg","Registration Failed. Username Already Exists");
            RequestDispatcher rd = request.getRequestDispatcher("loginpage");
            rd.forward(request, response);
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
