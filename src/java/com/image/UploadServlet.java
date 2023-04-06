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
public class UploadServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        String id=(String)session.getAttribute("id");
              try{
                  Random r=new Random();
             int iii=r.nextInt(100000+5000)-4000;            
        String sss=""+iii; 
        int iiii=r.nextInt(100000+5000)-4000;            
        String ssss=""+iiii;     
                  
        Part img2=request.getPart("image1"); 
        Part img3=request.getPart("image2");
         out.println(img2);
        out.println(img3);
        
        InputStream inputStream2=null;
        InputStream inputStream3=null;
        
        if(img2!=null){
            inputStream2=img2.getInputStream();
            
               }
         if(img3!=null){
            inputStream3=img3.getInputStream();
            
               }
        
        
          Connection con=DBCon.getCon();
        PreparedStatement pst=con.prepareStatement("update ureg set img2=?,imgid2=?where id='"+id+"'");
      if(inputStream2!=null){
        pst.setBlob(1,inputStream2);
      pst.setString(2,sss);
      }
     int i=pst.executeUpdate();
     if(i>0){
         response.sendRedirect("Upload2.jsp?msg=success");
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
