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
public class EditPasswordLog extends HttpServlet {

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
            out.println("<title>EditPasswordLog</title>");            
            out.println("</head>");
            out.println("<body>");
           // out.println("<h1>Servlet EditPasswordLog at " + request.getContextPath() + "</h1>");
            
            
            
            
            String password_old=request.getParameter("password_old");
            String password_new=request.getParameter("password_new");
            String password_re_new=request.getParameter("password_re_new");
            String nm=(String)hs.getAttribute("uname");
            //out.println("password_old="+password_old);
            //out.println("password_new="+password_new);
           // out.println("password_re_new="+password_re_new);
           // out.println("nm="+nm);
            if(password_old.equals("") || password_new.equals("")){
                System.out.println("Field Empty");
                request.setAttribute("msg","All Fields are mandatory");
                RequestDispatcher rd = request.getRequestDispatcher("EditPassword");
                rd.forward(request, response);
            }
            else{
                        Connection con=Service.getConnection();
                        PreparedStatement pst_fetch=con.prepareStatement("select password from login_sms where username=(?)");
                        pst_fetch.setString(1, nm);
                        ResultSet rs_fetch=pst_fetch.executeQuery();
                        if(rs_fetch.next()){
                                   if(rs_fetch.getString(1).equals(password_old)){
                                          //out.println("current password="+password_old);
                                           if(password_new.equals(password_re_new)){
                                                   PreparedStatement pst_update=con.prepareStatement("update login_sms set password=(?) where username=(?)");
                                                   pst_update.setString(1, password_new);
                                                   pst_update.setString(2,nm);
                                                   int a=pst_update.executeUpdate();
                                                   if(a>0){
                                                           System.out.println("Password Changed");
                                                           request.setAttribute("msg","Password Changed Successfully");
                                                           RequestDispatcher rd = request.getRequestDispatcher("EditPassword");
                                                           rd.forward(request, response);
                                                   }
                                                   else{
                                                           System.out.println("Password not changed");
                                                           request.setAttribute("msg","Password Updation Failed. Please try again");
                                                           RequestDispatcher rd = request.getRequestDispatcher("EditPassword");
                                                           rd.forward(request, response);
                                                   }
                                           }
                                           else{
                                                   System.out.println("New Password Mismatch");
                                                   request.setAttribute("msg","The new password entry did not match. Please re-enter");
                                                   RequestDispatcher rd = request.getRequestDispatcher("EditPassword");
                                                   rd.forward(request, response);

                                           }
                                   }

                                   else{

                                           System.out.println("Wrong Password");
                                           request.setAttribute("msg","The current password you entered was wrong");
                                           RequestDispatcher rd = request.getRequestDispatcher("EditPassword");
                                           rd.forward(request, response);
                                   }
                        }
            } 
            out.println("</body>");
            out.println("</html>");
        }
        }
        catch (SQLException ex) {
            Logger.getLogger(EditPasswordLog.class.getName()).log(Level.SEVERE, null, ex);
        }        finally {
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
