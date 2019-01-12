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
public class LoginAuth extends HttpServlet {

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
            String ps=request.getParameter("upass");
            
            Connection con=Service.getConnection();
            
            PreparedStatement pst =con.prepareStatement("select * from login_sms where username=? and password=?");
            pst.setString(1,nm);
            pst.setString(2,ps);
            
            ResultSet rs=pst.executeQuery();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LoginAuth</title>");            
            out.println("</head>");
            out.println("<body background=\"images\\tata.png\" >");
            out.println("<h1>Servlet LoginAuth at " + request.getContextPath() + "</h1>");
            
            if(rs.next()){
                if(rs.getString(3).equalsIgnoreCase("admin")){
                        HttpSession hs=request.getSession(true);
                        hs.setAttribute("uname",nm);
                        hs.setAttribute("upass",ps);
                        response.sendRedirect("adminHome");
                }
                else{
                    HttpSession hs=request.getSession(true);
                    hs.setAttribute("uname",nm);
                    hs.setAttribute("upass",ps);
                    response.sendRedirect("userHome");
                }
            }
            else{
                
                request.setAttribute("msg","Invalid username or password");
                RequestDispatcher rd = request.getRequestDispatcher("loginpage");
                rd.forward(request, response);
            }
            out.println("</body>");
            out.println("</html>");
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

