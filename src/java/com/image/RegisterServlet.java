/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.image;

import com.dbcon.DBCon;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


@MultipartConfig(maxFileSize = 20*1024*1024)
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
       Random r=new Random();
        try{
             int ii=r.nextInt(100000+5000)-4000;            
        String ss=""+ii; 
        
        
       String id=request.getParameter("id");
       
       session.setAttribute("id",id);
        String name=request.getParameter("name");    
        String email=request.getParameter("email"); 
        String mobile=request.getParameter("mobile");
        String address=request.getParameter("address"); 
        String uname=request.getParameter("uname");
        String pwd=request.getParameter("pwd"); 
        Part img1=request.getPart("image1");
        
            
            InputStream inputStream1=null;
      
     
           if(img1!=null){
            inputStream1=img1.getInputStream();
            
               }
           Connection con=DBCon.getCon();
        PreparedStatement pst=con.prepareStatement("insert into ureg values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        pst.setString(1,id);
        pst.setString(2,name);
        pst.setString(3,email);
        pst.setString(4,mobile);
        pst.setString(5,address);
        pst.setString(6,uname);
        pst.setString(7,pwd);
        if(inputStream1!=null){
          pst.setBlob(8, inputStream1);
          pst.setString(9,ss);
        }
         pst.setString(10,"waiting");
         pst.setString(11,"waiting");
         pst.setString(12,"waiting");
         pst.setString(13,"waiting");
       
       int i=pst.executeUpdate();
       if(i>0){
         response.sendRedirect("Upload.jsp?msg=success");  
       }else{
        response.sendRedirect("register.jsp?msg=failed");    
       } 
            
        
            
        }catch(Exception e){
           out.println(e); 
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
