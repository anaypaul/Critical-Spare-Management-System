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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SCHOOL
 */
public class UpdateCartPRPO extends HttpServlet {

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
                
                
                
                out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>UpdateCartPRPO</title>");  
            
             
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
           // out.println("<h1>Servlet UpdateCart at " + request.getContextPath() + "</h1>");
            /* TODO output your page here. You may use following sample code. */
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
               String shopping_cart_no=request.getParameter("shopping_cart_no");
               
               String order_date=request.getParameter("order_date");
               System.out.println("order date prpo="+order_date);
               //out.println("shopping_cart_no="+shopping_cart_no+"orderdate="+order_date);
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
                        //out.println("new_order_date="+new_order_date);
               Connection con=Service.getConnection();
               PreparedStatement pst_fetch=con.prepareStatement("select * from cart_prpo");
               ResultSet rs_fetch=pst_fetch.executeQuery();
               int a=0,b=0,c=0;
               while(rs_fetch.next())
               {
                   double total_price_double=Double.parseDouble(rs_fetch.getString(9))*Integer.parseInt(rs_fetch.getString(7));
                   String total_price=""+total_price_double;
               PreparedStatement pst_update=con.prepareStatement("insert into order_prpo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
               //PreparedStatement pst_into_monthly_report=con.prepareStatement("insert into monthly_report_rev_sms values(?,?,?,?,?,?,?,?,?,?,?)");
               pst_update.setString(1,shopping_cart_no);
              // pst_into_monthly_report.setString(1, shopping_cart_no);
               pst_update.setString(2,"");
               pst_update.setString(3,new_order_date);
              // pst_into_monthly_report.setString(2, new_order_date);
               //pst_into_monthly_report.setString(3, rs_fetch.getString(2));
               pst_update.setString(4,"");
               pst_update.setString(5,"");
               pst_update.setString(6, rs_fetch.getString(2));
               //pst_into_monthly_report.setString(4, rs_fetch.getString(3)); 
               pst_update.setString(7, rs_fetch.getString(3));
               //pst_into_monthly_report.setString(5, rs_fetch.getString(7));
               pst_update.setString(8, rs_fetch.getString(7));
               //pst_into_monthly_report.setString(6, rs_fetch.getString(9));
               pst_update.setString(9,rs_fetch.getString(9));
               pst_update.setString(10, total_price);
               //pst_into_monthly_report.setString(7, total_price);
               
               //pst_into_monthly_report.setString(8, reservation_no);
               pst_update.setString(11, rs_fetch.getString(10));
               //pst_into_monthly_report.setString(9, rs_fetch.getString(10));
               pst_update.setString(12,"");
               pst_update.setString(13,"");
               pst_update.setString(14,"");
               //pst_into_monthly_report.setString(10,"");
                //pst_into_monthly_report.setString(11,"0");
               String umc=rs_fetch.getString(2);
               
               PreparedStatement pst_update_cart=con.prepareStatement("update cart_prpo set cart_no=(?),order_date=(?) where umc=(?)");
               pst_update_cart.setString(1,shopping_cart_no);
               pst_update_cart.setString(2, new_order_date);
               pst_update_cart.setString(3,umc);
               b=pst_update.executeUpdate();
              // c=pst_into_monthly_report.executeUpdate();
               a=pst_update_cart.executeUpdate();
               
                System.out.println("mad=1");
               }
               if(a<0 && b<0){
                request.setAttribute("msg","order unsuccesful");
                //RequestDispatcher rd = request.getRequestDispatcher("PlaceOrderLog73");
                //rd.forward(request, response);
                System.out.println("mad=2");
            }else if(a>0 && b>0){
                request.setAttribute("msg","Order Placed");
               // RequestDispatcher rd = request.getRequestDispatcher("PlaceOrderLog73");
               // rd.forward(request, response);
                System.out.println("mad=3");
            }
             
                double total_price_cart=0;
               
            //out.println("Shopping_Cart_No.="+shopping_cart_no);
            PreparedStatement pst_display=con.prepareStatement("select * from cart_prpo where cart_no=(?)");
               pst_display.setString(1,shopping_cart_no);
               ResultSet rs_display=pst_display.executeQuery();
                
               out.println("<center>");
                      
                       out.println("<br><br><b>Shopping Cart No : <input type=\"text\" name=\"shopping_cart_no\" value="+shopping_cart_no+" readonly></b>"
                       + "<br><br><b>Order Date : <input type=\"text\" name=\"order_date\" value="+new_order_date+" readonly></b>");
                        out.println("<table border='1' cellspacing='1'>"
                                                                + "<tr>"
                                                                 
                                                                + "<th>Umc</th>"
                                                                + "<th>Description</th>"
                                                                + "<th>Plant</th>"
                                                                +"<th>Order Quantity</th>"
                                                                + "<th>Unit Price</th>"
                                                                + "<th>Total Price</th>"
                                                                + "</tr>");
                    
                       while(rs_display.next()){
                           double total_price=Double.parseDouble(rs_display.getString(7))*Integer.parseInt(rs_display.getString(9));
                      
                        System.out.println("mad=5");
                                                        out.println("<tr>"
                                                              
                                                                + "<td>"+rs_display.getString(2)+"</td>"
                                                                + "<td>"+rs_display.getString(3)+"</td>"
                                                                + "<td>"+rs_display.getString(10)+"</td>"
                                                                + "<td>"+rs_display.getString(7)+"</td>"
                                                                + "<td>"+rs_display.getString(9)+"</td>"
                                                                +"<td>"+total_price+"</td>"
                                                                + "</tr>");
                                                           total_price_cart=total_price_cart+total_price;
                    }                 
                                                    out.println("</table>");
                                                            
                                                            out.println("<br><br><b>Total Cart Value : <input type=\"text\" name=\"total_price\" value="+total_price_cart+" readonly></b>");
                                                             out.println("</center>");
               
                 PreparedStatement pst_delete=con.prepareStatement("delete cart_prpo");
                 int del=pst_delete.executeUpdate();
                 if(del<0){
                     
                     System.out.println("NOT delete from the cart");
                 }else{
                     System.out.println("deleted from the cart");
                 }
                 
                 
            out.println("</body>");
            out.println("</html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateCart.class.getName()).log(Level.SEVERE, null, ex);
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
