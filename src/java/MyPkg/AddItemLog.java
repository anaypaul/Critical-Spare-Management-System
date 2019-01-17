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
public class AddItemLog extends HttpServlet {

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
                String umc=request.getParameter("umc");
                String description=request.getParameter("desc");
                String plant=request.getParameter("plant");
                String category=request.getParameter("category");
                String criticality=request.getParameter("critical");
                String material_class=request.getParameter("material_class");
                String recommended_qty=request.getParameter("r_qty");
                String l_store_qty=request.getParameter("l_store_qty");
                String m_store_qty=request.getParameter("m_store_qty");
                //String available_qty=request.getParameter("a_qty");
                String uom=request.getParameter("uom");
                String location=request.getParameter("location");
                String unit_price=request.getParameter("u_price");
                String type=request.getParameter("type");
                
                
                //operation 
                int l_qty=Integer.parseInt(l_store_qty);
                int m_qty=Integer.parseInt(m_store_qty);
                int total=l_qty+m_qty;
                String available_qty=""+total;
                int x=(Integer.valueOf(l_store_qty)).intValue();
                int y=(Integer.valueOf(recommended_qty)).intValue();
                int f=x-y;
                String flag_colour=""+f;
                //out.println("flag="+flag_colour);
                float m=(Float.valueOf(unit_price)).floatValue();
                float r=m*x;
                String total_price=""+r;
                //out.println("total_price="+total_price);
                
                
                //out.println("<br>"+umc+"<br>"+description+"<br>"+plant+"<br>"+category+"<br>"+criticality+"<br>"+recommended_qty+"<br>"+available_qty+"<br>"+uom+"<br>"+location+"<br>"+unit_price+"<br>"+type);
                
                

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>AddItemLog</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet AddItemLog at " + request.getContextPath() + "</h1>");
               Connection con=Service.getConnection();
                
                String sql="insert into products_sms values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                
                PreparedStatement pst=con.prepareStatement(sql);
                
                pst.setString(1,umc);
                pst.setString(2,""+description);
                pst.setString(3,plant);
                pst.setString(4,category);
                pst.setString(5,criticality);
                pst.setString(6,material_class);
                pst.setString(7,recommended_qty);
                pst.setString(8,l_store_qty);
                pst.setString(9,m_store_qty);
                pst.setString(10,available_qty);
                pst.setString(11,""+uom);
                pst.setString(12,""+location);
                pst.setString(13,""+unit_price);
                pst.setString(14,total_price);
                pst.setString(15,type);
                pst.setString(16,flag_colour);
               
                
                int num=pst.executeUpdate();
                
                out.println("<h1>num=</h1>"+num);
                if(num<0){
                    System.out.println("not inserted.enter again");
                    request.setAttribute("msg","Item not added. please enter again");
                    RequestDispatcher rd = request.getRequestDispatcher("AddItem");
                    rd.forward(request, response);
                }
                else{
                    System.out.println("record insert succesfully");
                    request.setAttribute("msg","Item added Succesfully");
                    RequestDispatcher rd = request.getRequestDispatcher("AddItem");
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
