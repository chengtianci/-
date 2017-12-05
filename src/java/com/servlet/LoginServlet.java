package com.servlet;

import com.db.DB;
import com.scheme.Student;

import java.io.IOException;

import static java.lang.System.out;

/**
 * Created by cheng on 2017/11/13.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request,
                           javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        DB db = DB.getInstance();
        Student s = db.selectSingleStudent(request.getAttribute("firstname").toString());
        if(s.getPassword() == request.getAttribute("psd").toString()){
            response.sendRedirect("./login.jsp");
        }else {
            response.sendRedirect("./index.jsp");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        DB db = DB.getInstance();
        out.print(request.getAttribute("id").toString());
//        Student s = db.selectSingleStudent(request.getAttribute("id").toString());
//        if(s.getPassword() == request.getAttribute("psd").toString()){
//            response.sendRedirect("./login.jsp");
//        }else {
//            response.sendRedirect("./index.jsp");
//        }
    }
}
