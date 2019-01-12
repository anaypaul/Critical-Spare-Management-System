/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shikha;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SCHOOL
 */
public class Service extends HttpServlet {
    private static Connection con;
    static{
        try{
           Class.forName("oracle.jdbc.OracleDriver");
           con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","anay");
    }catch(Exception ex){
        System.out.println("Connection error:"+ex.getMessage());
    }
    }
    public static Connection getConnection(){
        return con;
    }
}