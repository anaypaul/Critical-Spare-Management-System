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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SCHOOL
 */
public class UpdateItem extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
           else{
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>UpdateItem</title>");  
            
            out.println("<style>"
                    + "html, body, div, span, applet, object, iframe,\n" +
"h1, h2, h3, h4, h5, h6, p, blockquote, pre,\n" +
"a, abbr, acronym, address, big, cite, code,\n" +
"del, dfn, em, font, img, ins, kbd, q, s, samp,\n" +
"small, strike, strong, sub, sup, tt, var,\n" +
"b, u, i, center,\n" +
"dl, dt, dd, ol, ul, li,\n" +
"fieldset, form, label, legend,\n" +
"caption, tbody, tfoot, thead, th{\n" +
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
           // out.println("<h1>Servlet UpdateItem at " + request.getContextPath() + "</h1>");
            Connection con=Service.getConnection();
            String umc=request.getParameter("umc");
            
            
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
                    out.println("<center><h3>Re-enter the Details of the Item:-</h3></center>");
                    String sql="select * from products_sms where umc=(?)";
                    PreparedStatement pst=con.prepareStatement(sql);
                    pst.setString(1,umc);
                    ResultSet rs=pst.executeQuery();
                    while(rs.next()){
                    
                    out.println( "<center><table>"
                            + "<form action=\"UpdateItem_Log\" method=\"post\">"
                            + "<tr>"
                            + "<th>UMC</th><td>:</td><td><input type=\"text\" name=\"umc\" value="+rs.getString(1)+"></td>"
                            + "</tr>");
                    //String actual_umc=rs.getString(1);
                    out.println("<input type=\"hidden\" name=\"actual_umc\" value="+rs.getString(1)+">");
                            out.println( "<tr>"
                            + "<th>Desciption</th><td>:</td><td><input type=\"text\" name=\"desc\" value='"+rs.getString(2)+"'></td>"
                            + "</tr>"
                            + "<tr>"
                            + "<th>Plant</th><td>:</td><td>"
                            + "<select name=\"plant\" id=\"plant\" value="+rs.getString(3)+">"
                            +"<option value="+rs.getString(3)+" selected>"+rs.getString(3)+"</option>"
                            + "<option value=\"37\">37</option>"
                            + "<option value=\"73\">73</option>"
                            + "<option value=\"26\">26</option>"
                            + "<option value=\"27\">27</option>"
                            + "</select>"
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<th>Category</th><td>:</td><td>");
                                    
                                   
                            out.println("<select name=\"category\" id=\"category\" value="+rs.getString(4)+">"
                            + "<option value='"+rs.getString(4)+"' selected>"+rs.getString(4)+"</option>"
                            + "<option value=\"PB & LED\">PB & LED</option>"
                            + "<option value=\"MCB & MCCB\">MCB & MCCB</option>"
                            + "<option value=\"Cable & Wiring Acc.\">Cable & Wiring Acc.</option>"
                            + "<option value=\"Field Device\">Field Device</option>"
                            + "<option value=\"Fuse\">Fuse</option>"
                            + "<option value=\"Networking\">Networking</option>"
                            + "<option value=\"Drive & Spare\">Drive & Spare</option>"
                            + "<option value=\"SMPS\">SMPS</option>"
                            + "<option value=\"Electronic Hardware\">Electronic Hardware</option>"
                            + "<option value=\"Lighting\">Lighting</option>"
                            + "<option value=\"Roll Shop\">Roll Shop</option>"
                            + "<option value=\"Relay & Contactor\">Relay & Contactor</option>"
                            + "<option value=\"Tools\">Tools</option>"
                            + "<option value=\"PLC & HMI\">PLC & HMI</option>"
                            + "<option value=\"Crane\">Crane</option>"
                            + "<option value=\"Carbon_Brush\">Carbon_Brush</option>"
                            + "<option value=\"Furnance\">Furnance</option>"
                            + "<option value=\"Instrumentation\">Instrumentation</option>"
                            + "<option value=\"Breaker & ACC\">Breaker & ACC</option>"
                            + "<option value=\"Miscellaneous\">Miscellaneous</option>"
                            + "</select>"
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<th>Criticality</th><td>:</td><td>"
                            + "<select name=\"critical\" id=\"critical\" value="+rs.getString(5)+">"
                                    + "<option value="+rs.getString(5)+" selected>"+rs.getString(5)+"</option>"
                            + "<option value=\"Low\">Low</option>"
                            + "<option value=\"Medium\">Medium</option>"
                            + "<option value=\"High\">High</option>"
                            + "</select>"

                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<th>Material Class</th><td>:</td><td>"
                            + "<select name=\"material_class\" id=\"material_class\" value="+rs.getString(6)+">"
                                    + "<option value="+rs.getString(6)+" selected>"+rs.getString(6)+"</option>"
                            + "<option value=\"A\">A</option>"
                            + "<option value=\"B\">B</option>"
                            + "<option value=\"C\">C</option>"
                            + "<option value=\"D\">D</option>"
                            + "</select>"

                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<th>Recommended Quantity</th><td>:</td><td><input type=\"text\" name=\"r_qty\" value="+rs.getString(7)+"></td>"
                            + "</tr>"
                            + "<tr>"
                                    
                            + "<th>Local Store Quantity</th><td>:</td><td><input type=\"text\" name=\"l_store_qty\" value="+rs.getString(8)+"></td>"
                            + "</tr>"
                            + "<tr>");
                                    
                            //if(rs.getString(3).equals("37")){        
                            out.println("<th>Main Store Quantity</th><td>:</td><td><input type=\"text\" name=\"m_store_qty\" value="+rs.getString(9)+"></td>"
                            + "</tr>"
                            + "<tr>");
                            //}
                           //else if(rs.getString(3).equals("73")){
                           // out.println("<td>Main Store Quantity</td><td>:</td><td><input type=\"hidden\" name=\"m_store_qty\" >"+rs.getString(15)+"</td>"
                            //+ "</tr>"
                            //+ "<tr>");
                            //}
                                    
                            out.println("<th>UOM</th><td>:</td><td><input type=\"text\" name=\"uom\" value="+rs.getString(11)+"></td>"
                            + "</tr>"
                            + "<tr>"
                            + "<th>Location</th><td>:</td><td><input type=\"text\" name=\"location\" value='"+rs.getString(12)+"'></td>"
                            + "</tr>"
                            + "<tr>"
                            + "<th>Unit Price</th><td>:</td><td><input type=\"text\" name=\"u_price\" value="+rs.getString(13)+"></td>"
                            + "</tr>"
                            + "<tr>"
                            + "<th>Type Of Product</th><td>:</td><td>"
                            + "<select  name=\"type\" id=\"type\" value="+rs.getString(15)+">"
                                    + "<option value="+rs.getString(15)+" selected>"+rs.getString(15)+"</option>"
                            + "<option value=\"Normal\">Normal</option>"
                            + "<option value=\"Insurance\">Insurance</option>"
                            + "</select>"
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td colspan=\"3\" align=\"center\"><input type=\"submit\" value=\"Update Item\"></td>"
                            + "</tr>"
                            + "</table>"
                            + "</form>"
                                    + "</center>");
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
