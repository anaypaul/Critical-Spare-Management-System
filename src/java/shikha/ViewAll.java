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
public class ViewAll extends HttpServlet {

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
            }else{out.println("<DOCTYPE html>");
                            out.println("<html>"
                                    + "<head><title>ViewAll</title>");
                              
                            out.println("<style>"
                    + "html, body, div, span, applet, object, iframe,\n" +
"h1, h2, h3, h4, h5, h6, p, blockquote, pre,\n" +
"a, abbr, acronym, address, big, cite, code,\n" +
"del, dfn, em, font, img, ins, kbd, q, s, samp,\n" +
"small, strike, strong, sub, sup, tt, var,\n" +
"b, u, i, center,\n" +
"dl, dt, dd, ol, ul, li,\n" +
"fieldset, form, label, legend,\n" +
"caption, tbody, tfoot, thead{\n" +
"	margin: 0;\n" +
"	padding: 0;\n" +
"	border: 1;\n" +
"	outline: 0;\n" +
"	font-size: 100%;\n" +
"	vertical-align: baseline;\n" +
"	background: transparent;\n" +
"}\n" +
"body {\n" +
"	background: #DCDDDF;\n" +
"	color: #000;\n" +
"	font: 14px Arial;\n" +
"	margin: 0 auto;\n" +
"	padding: 0;\n" +
"	position: relative;\n" +
"}\n" +
"h1{ font-size:35px;}\n" +
"h2{ font-size:26px;}\n" +
"h3{ font-size:18px;}\n" +
"h4{ font-size:16px;}\n" +
"h5{ font-size:14px;}\n" +
"h6{ font-size:12px;}\n" +
"h1,h2,h3,h4,h5,h6{ color:#563D64;}\n" +
"small{ font-size:10px;}\n" +
"b, strong{ font-weight:bold;}\n" +
"a{ text-decoration: none; }\n" +
"a:hover{ text-decoration: underline; }\n" +
".left { float:left; }\n" +
".right { float:right; }\n" +
".alignleft { float: left; margin-right: 15px; }\n" +
".alignright { float: right; margin-left: 15px; }\n" +
".clearfix:after,\n" +
"form:after {\n" +
"	content: \".\";\n" +
"	display: block;\n" +
"	height: 0;\n" +
"	clear: both;\n" +
"	visibility: hidden;\n" +
"}\n" +
".container { margin: 25px auto; position: relative; width: 900px; }\n" +
"#content {\n" +
"	background: #f9f9f9;\n" +
"	background: -moz-linear-gradient(top,  rgba(248,248,248,1) 0%, rgba(249,249,249,1) 100%);\n" +
"	background: -webkit-linear-gradient(top,  rgba(248,248,248,1) 0%,rgba(249,249,249,1) 100%);\n" +
"	background: -o-linear-gradient(top,  rgba(248,248,248,1) 0%,rgba(249,249,249,1) 100%);\n" +
"	background: -ms-linear-gradient(top,  rgba(248,248,248,1) 0%,rgba(249,249,249,1) 100%);\n" +
"	background: linear-gradient(top,  rgba(248,248,248,1) 0%,rgba(249,249,249,1) 100%);\n" +
"	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f8f8f8', endColorstr='#f9f9f9',GradientType=0 );\n" +
"	-webkit-box-shadow: 0 1px 0 #fff inset;\n" +
"	-moz-box-shadow: 0 1px 0 #fff inset;\n" +
"	-ms-box-shadow: 0 1px 0 #fff inset;\n" +
"	-o-box-shadow: 0 1px 0 #fff inset;\n" +
"	box-shadow: 0 1px 0 #fff inset;\n" +
"	border: 1px solid #c4c6ca;\n" +
"	margin: 0 auto;\n" +
"	padding: 25px 0 0;\n" +
"	position: relative;\n" +
"	text-align: center;\n" +
"	text-shadow: 0 1px 0 #fff;\n" +
"	width: 400px;\n" +
"}\n" +
"#content h1 {\n" +
"	color: #7E7E7E;\n" +
"	font: bold 25px Helvetica, Arial, sans-serif;\n" +
"	letter-spacing: -0.05em;\n" +
"	line-height: 20px;\n" +
"	margin: 10px 0 30px;\n" +
"}\n" +
"#content h1:before,\n" +
"#content h1:after {\n" +
"	content: \"\";\n" +
"	height: 1px;\n" +
"	position: absolute;\n" +
"	top: 10px;\n" +
"	width: 27%;\n" +
"}\n" +
"#content h1:after {\n" +
"	background: rgb(126,126,126);\n" +
"	background: -moz-linear-gradient(left,  rgba(126,126,126,1) 0%, rgba(255,255,255,1) 100%);\n" +
"	background: -webkit-linear-gradient(left,  rgba(126,126,126,1) 0%,rgba(255,255,255,1) 100%);\n" +
"	background: -o-linear-gradient(left,  rgba(126,126,126,1) 0%,rgba(255,255,255,1) 100%);\n" +
"	background: -ms-linear-gradient(left,  rgba(126,126,126,1) 0%,rgba(255,255,255,1) 100%);\n" +
"	background: linear-gradient(left,  rgba(126,126,126,1) 0%,rgba(255,255,255,1) 100%);\n" +
"    right: 0;\n" +
"}\n" +
"#content h1:before {\n" +
"	background: rgb(126,126,126);\n" +
"	background: -moz-linear-gradient(right,  rgba(126,126,126,1) 0%, rgba(255,255,255,1) 100%);\n" +
"	background: -webkit-linear-gradient(right,  rgba(126,126,126,1) 0%,rgba(255,255,255,1) 100%);\n" +
"	background: -o-linear-gradient(right,  rgba(126,126,126,1) 0%,rgba(255,255,255,1) 100%);\n" +
"	background: -ms-linear-gradient(right,  rgba(126,126,126,1) 0%,rgba(255,255,255,1) 100%);\n" +
"	background: linear-gradient(right,  rgba(126,126,126,1) 0%,rgba(255,255,255,1) 100%);\n" +
"    left: 0;\n" +
"}\n" +
"#content:after,\n" +
"#content:before {\n" +
"	background: #f9f9f9;\n" +
"	background: -moz-linear-gradient(top,  rgba(248,248,248,1) 0%, rgba(249,249,249,1) 100%);\n" +
"	background: -webkit-linear-gradient(top,  rgba(248,248,248,1) 0%,rgba(249,249,249,1) 100%);\n" +
"	background: -o-linear-gradient(top,  rgba(248,248,248,1) 0%,rgba(249,249,249,1) 100%);\n" +
"	background: -ms-linear-gradient(top,  rgba(248,248,248,1) 0%,rgba(249,249,249,1) 100%);\n" +
"	background: linear-gradient(top,  rgba(248,248,248,1) 0%,rgba(249,249,249,1) 100%);\n" +
"	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f8f8f8', endColorstr='#f9f9f9',GradientType=0 );\n" +
"	border: 1px solid #c4c6ca;\n" +
"	content: \"\";\n" +
"	display: block;\n" +
"	height: 100%;\n" +
"	left: -1px;\n" +
"	position: absolute;\n" +
"	width: 100%;\n" +
"}\n" +
"#content:after {\n" +
"	-webkit-transform: rotate(2deg);\n" +
"	-moz-transform: rotate(2deg);\n" +
"	-ms-transform: rotate(2deg);\n" +
"	-o-transform: rotate(2deg);\n" +
"	transform: rotate(2deg);\n" +
"	top: 0;\n" +
"	z-index: -1;\n" +
"}\n" +
"#content:before {\n" +
"	-webkit-transform: rotate(-3deg);\n" +
"	-moz-transform: rotate(-3deg);\n" +
"	-ms-transform: rotate(-3deg);\n" +
"	-o-transform: rotate(-3deg);\n" +
"	transform: rotate(-3deg);\n" +
"	top: 0;\n" +
"	z-index: -2;\n" +
"}\n" +
"#content form { margin: 0 20px; position: relative }\n" +
"#content form input[type=\"text\"],\n" +
"#content form input[type=\"password\"] {\n" +
"	-webkit-border-radius: 3px;\n" +
"	-moz-border-radius: 3px;\n" +
"	-ms-border-radius: 3px;\n" +
"	-o-border-radius: 3px;\n" +
"	border-radius: 3px;\n" +
"	-webkit-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;\n" +
"	-moz-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;\n" +
"	-ms-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;\n" +
"	-o-box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;\n" +
"	box-shadow: 0 1px 0 #fff, 0 -2px 5px rgba(0,0,0,0.08) inset;\n" +
"	-webkit-transition: all 0.5s ease;\n" +
"	-moz-transition: all 0.5s ease;\n" +
"	-ms-transition: all 0.5s ease;\n" +
"	-o-transition: all 0.5s ease;\n" +
"	transition: all 0.5s ease;\n" +
"	background: #eae7e7 url(http://cssdeck.com/uploads/media/items/8/8bcLQqF.png) no-repeat;\n" +
"	border: 1px solid #c8c8c8;\n" +
"	color: #777;\n" +
"	font: 13px Helvetica, Arial, sans-serif;\n" +
"	margin: 0 0 10px;\n" +
"	padding: 15px 10px 15px 40px;\n" +
"	width: 80%;\n" +
"}\n" +
"#content form input[type=\"text\"]:focus,\n" +
"#content form input[type=\"password\"]:focus {\n" +
"	-webkit-box-shadow: 0 0 2px #ed1c24 inset;\n" +
"	-moz-box-shadow: 0 0 2px #ed1c24 inset;\n" +
"	-ms-box-shadow: 0 0 2px #ed1c24 inset;\n" +
"	-o-box-shadow: 0 0 2px #ed1c24 inset;\n" +
"	box-shadow: 0 0 2px #ed1c24 inset;\n" +
"	background-color: #fff;\n" +
"	border: 1px solid #ed1c24;\n" +
"	outline: none;\n" +
"}\n" +
"#username { background-position: 10px 10px !important }\n" +
"#password { background-position: 10px -53px !important }\n" +
"#content form input[type=\"submit\"] {\n" +
"	background: rgb(254,231,154);\n" +
"	background: -moz-linear-gradient(top,  rgba(254,231,154,1) 0%, rgba(254,193,81,1) 100%);\n" +
"	background: -webkit-linear-gradient(top,  rgba(254,231,154,1) 0%,rgba(254,193,81,1) 100%);\n" +
"	background: -o-linear-gradient(top,  rgba(254,231,154,1) 0%,rgba(254,193,81,1) 100%);\n" +
"	background: -ms-linear-gradient(top,  rgba(254,231,154,1) 0%,rgba(254,193,81,1) 100%);\n" +
"	background: linear-gradient(top,  rgba(254,231,154,1) 0%,rgba(254,193,81,1) 100%);\n" +
"	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#fee79a', endColorstr='#fec151',GradientType=0 );\n" +
"	-webkit-border-radius: 30px;\n" +
"	-moz-border-radius: 30px;\n" +
"	-ms-border-radius: 30px;\n" +
"	-o-border-radius: 30px;\n" +
"	border-radius: 30px;\n" +
"	-webkit-box-shadow: 0 1px 0 rgba(255,255,255,0.8) inset;\n" +
"	-moz-box-shadow: 0 1px 0 rgba(255,255,255,0.8) inset;\n" +
"	-ms-box-shadow: 0 1px 0 rgba(255,255,255,0.8) inset;\n" +
"	-o-box-shadow: 0 1px 0 rgba(255,255,255,0.8) inset;\n" +
"	box-shadow: 0 1px 0 rgba(255,255,255,0.8) inset;\n" +
"	border: 1px solid #D69E31;\n" +
"	color: #85592e;\n" +
"	cursor: pointer;\n" +
"	float: left;\n" +
"	font: bold 15px Helvetica, Arial, sans-serif;\n" +
"	height: 35px;\n" +
"	margin: 20px 0 35px 15px;\n" +
"	position: relative;\n" +
"	text-shadow: 0 1px 0 rgba(255,255,255,0.5);\n" +
"	width: 120px;\n" +
"}\n" +
"#content form input[type=\"submit\"]:hover {\n" +
"	background: rgb(254,193,81);\n" +
"	background: -moz-linear-gradient(top,  rgba(254,193,81,1) 0%, rgba(254,231,154,1) 100%);\n" +
"	background: -webkit-linear-gradient(top,  rgba(254,193,81,1) 0%,rgba(254,231,154,1) 100%);\n" +
"	background: -o-linear-gradient(top,  rgba(254,193,81,1) 0%,rgba(254,231,154,1) 100%);\n" +
"	background: -ms-linear-gradient(top,  rgba(254,193,81,1) 0%,rgba(254,231,154,1) 100%);\n" +
"	background: linear-gradient(top,  rgba(254,193,81,1) 0%,rgba(254,231,154,1) 100%);\n" +
"	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#fec151', endColorstr='#fee79a',GradientType=0 );\n" +
"}\n" +
"#content form div a {\n" +
"	color: #004a80;\n" +
"    float: right;\n" +
"    font-size: 20px;\n" +
"    margin: 30px 15px 0 0;\n" +
"    text-decoration: underline;\n" +
"}\n" +
".button {\n" +
"	background: rgb(247,249,250);\n" +
"	background: -moz-linear-gradient(top,  rgba(247,249,250,1) 0%, rgba(240,240,240,1) 100%);\n" +
"	background: -webkit-linear-gradient(top,  rgba(247,249,250,1) 0%,rgba(240,240,240,1) 100%);\n" +
"	background: -o-linear-gradient(top,  rgba(247,249,250,1) 0%,rgba(240,240,240,1) 100%);\n" +
"	background: -ms-linear-gradient(top,  rgba(247,249,250,1) 0%,rgba(240,240,240,1) 100%);\n" +
"	background: linear-gradient(top,  rgba(247,249,250,1) 0%,rgba(240,240,240,1) 100%);\n" +
"	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f7f9fa', endColorstr='#f0f0f0',GradientType=0 );\n" +
"	-webkit-box-shadow: 0 1px 2px rgba(0,0,0,0.1) inset;\n" +
"	-moz-box-shadow: 0 1px 2px rgba(0,0,0,0.1) inset;\n" +
"	-ms-box-shadow: 0 1px 2px rgba(0,0,0,0.1) inset;\n" +
"	-o-box-shadow: 0 1px 2px rgba(0,0,0,0.1) inset;\n" +
"	box-shadow: 0 1px 2px rgba(0,0,0,0.1) inset;\n" +
"	-webkit-border-radius: 0 0 5px 5px;\n" +
"	-moz-border-radius: 0 0 5px 5px;\n" +
"	-o-border-radius: 0 0 5px 5px;\n" +
"	-ms-border-radius: 0 0 5px 5px;\n" +
"	border-radius: 0 0 5px 5px;\n" +
"	border-top: 1px solid #CFD5D9;\n" +
"	padding: 15px 0;\n" +
"}\n" +
".button a {\n" +
"	background: url(http://cssdeck.com/uploads/media/items/8/8bcLQqF.png) 0 -112px no-repeat;\n" +
"	color: #7E7E7E;\n" +
"	font-size: 17px;\n" +
"	padding: 2px 0 2px 40px;\n" +
"	text-decoration: none;\n" +
"	-webkit-transition: all 0.3s ease;\n" +
"	-moz-transition: all 0.3s ease;\n" +
"	-ms-transition: all 0.3s ease;\n" +
"	-o-transition: all 0.3s ease;\n" +
"	transition: all 0.3s ease;\n" +
"}\n" +
".button a:hover {\n" +
"	background-position: 0 -135px;\n" +
"	color: #00aeef;\n" +
"}"


                            
                            
  
                    + "</style>");
                            
                            out.println("</head>");
                            out.println("<body>");
                Connection con=Service.getConnection();
                String u_name=(String)hs.getAttribute("uname");
                PreparedStatement pst_check=con.prepareStatement("select utype from login_sms where username=(?)");
                pst_check.setString(1,u_name);
                ResultSet rs_check=pst_check.executeQuery();
                if(rs_check.next()){
                    //this part will be for the user view
                    if(rs_check.getString(1).equals("user")){
                            
                            //provide here the other links for the user module
                            out.print("<br><br>"
                                    + "<center><a href=\"userHome\"><h4>HOME</a>&nbsp;&nbsp;<font color='red'>||</font>&nbsp;&nbsp;"
                                        + "<a href=\"EditPassword\">ACCOUNT SETTINGS</a>&nbsp;&nbsp;<font color='red'>||</font>&nbsp;&nbsp;"
                                        + "<a href=\"User_IssueProducts\">ISSUE PRODUCTS</a>&nbsp;&nbsp;<font color='red'>||</font>&nbsp;&nbsp;"
                                        + "<a href=\"ViewAll\">VIEW ALL</a>&nbsp;&nbsp;<font color='red'>||</font>&nbsp;&nbsp;"
                                        + "<a href=\"Logout\">LOGOUT</a></h4></center>"
                                    + "<br><br><br>");
                            
                            
                           
                            
                            
                            
                                        
                                                    out.println("</body>");
                                                    out.println("</html>");
                            
                            
                
                
                
                
                
                
                
                
                
                    }
                    else{
                
                                                    out.println("<!DOCTYPE html>");
                                                    out.println("<html>");
                                                    out.println("<head>");
                                                    out.println("<title>Servlet ViewAll</title>");            
                                                    out.println("</head>");
                                                    out.println("<body>");
                                                   // out.println("<h1>Servlet ViewAll at " + request.getContextPath() + "</h1>");


                                                    
                                                   out.println("<br><br>");
            out.print("<center><a href=\"adminHome\"><h4>HOME</a>&nbsp;<font color='RED'>||</font>&nbsp;"
                    + "<a href=\"EditPassword\">ACCOUNT SETTINGS</a>&nbsp;<font color='RED'>||</font>&nbsp;"
                    + "<a href=\"UserManager\">USER MANAGER</a>&nbsp;<font color='RED'>||</font>&nbsp;"
                            + "<a href=\"AddItem\">ADD ITEM</a>&nbsp;<font color='RED'>||</font>&nbsp;"
                            + "<a href=\"EditData\">EDIT DATA</a>&nbsp;<font color='RED'>||</font>&nbsp;"
                            + "<a href=\"SearchItem\">SEARCH</a>&nbsp;<font color='RED'>||</font>&nbsp;"
                            + "<a href=\"ViewAll\">VIEW ALL</a>&nbsp;<font color='RED'>||</font>&nbsp;"
                            + "<a href=\"PlaceOrder\">PLACE ORDER</a>&nbsp;<font color='RED'>||</font>&nbsp;"
                            + "<a href=\"Bills\">BILL</a>&nbsp;<font color='RED'>||</font>&nbsp;"
                            + "<a href=\"MonthlyReport\">MONTHLY REPORT</a>&nbsp;<font color='RED'>||</font>&nbsp;"
                            + "<a href=\"CheckStatusSelect\">CHECK STATUS</a>&nbsp;<font color='RED'>||</font>&nbsp;"
                            + "<a href=\"Logout\">LOGOUT</a></h4></center>"
                    + "<br><br><br>");
                    }  
                                                    out.println("<table border='1' cellspacing='1'>"
                                                                + "<tr>"
                                                                + "<th>Umc</th>"
                                                                + "<th>Description</th>"
                                                                + "<th>Plant</th>"
                                                                + "<th>Category</th>"
                                                                + "<th>Criticality</th>"
                                                                + "<th>Material Class</th>"
                                                                + "<th>Recommended Quantity</th>"//6
                                                            //change made here 
                                                                + "<th>Local Store Quantity</th>"//14
                                                            //change made here 
                                                                + "<th>Main Store Quantity</th>"//15
                                                                + "<th>Available Quantity</th>"
                                                                + "<th>UOM</th>"
                                                                + "<th>Location</th>"
                                                                + "<th>Unit Price</th>"
                                                                + "<th>Total Price</th>"
                                                                + "<th>Normal/Insurance</th>"
                                                                + "<th>Flag Colour</th>"
                                                                + "</tr>");
                                PreparedStatement pst=con.prepareStatement("select * from products_sms order by category");
                                 ResultSet rs=pst.executeQuery();
                                                    while(rs.next()){
                                                        out.println("<tr>"
                                                                + "<td>"+rs.getString(1)+"</td>"
                                                                + "<td>"+rs.getString(2)+"</td>"
                                                                + "<td>"+rs.getString(3)+"</td>"
                                                                + "<td>"+rs.getString(4)+"</td>");
                                                                //String plant=rs.getString(3);
                                                                out.println("<td>"+rs.getString(5)+"</td>"
                                                                + "<td>"+rs.getString(6)+"</td>");

                                                                //if(plant.equals("37")){
                                                                                                                                //}else if(plant.equals("73")){
                                                                //    out.println("<td>Not available</td>");
                                                                //}

                                                                out.println( "<td>"+rs.getString(7)+"</td>"
                                                                + "<td>"+rs.getString(8)+"</td>"
                                                                + "<td>"+rs.getString(9)+"</td>"
                                                                + "<td>"+rs.getString(10)+"</td>"
                                                                + "<td>"+rs.getString(11)+"</td>"
                                                                + "<td>"+rs.getString(12)+"</td>"
                                                                + "<td>"+rs.getString(13)+"</td>"
                                                                + "<td>"+rs.getString(14)+"</td>"
                                                                + "<td>"+rs.getString(15)+"</td>");
                                                                String fl=rs.getString(16);
                                                                int m=Integer.parseInt(fl);
                                                                if(m==0){
                                                                    out.println("<td bgcolor=\"#FFFF33\">"+rs.getString(16)+"</td>");
                                                                }
                                                                else if(m<=-1){
                                                                    out.println("<td bgcolor=\"#FF0000\">"+rs.getString(16)+"</td>");
                                                                }
                                                                else{
                                                                    out.println("<td bgcolor=\"green\">"+rs.getString(16)+"</td>");
                                                                }
                                                                out.println("</tr>");
                                                        }
                                                    out.println("</table>");
                                                    out.println("</body>");
                                                    out.println("</html>");
                    
                }
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
