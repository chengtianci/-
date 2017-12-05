package com.servlet;

import com.db.DB;
import com.scheme.Student;

import javax.servlet.RequestDispatcher;
import java.io.IOException;

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
        String forward = "";
        String ID = request.getParameter("id").toString();
        String PSD = request.getParameter("psd").toString();
        Student s = db.selectSingleStudent(ID);
//        out.print(s.getPassword());
//        out.print(PSD);
//        out.print(s.getPassword().equals(PSD));
        if(s.getPassword().equals(PSD)){
            forward = "./index.jsp";
            // 设置用户名专属的session值
            request.getSession().setAttribute("id", ID);
        }else {
            forward = "./login.jsp";
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
        requestDispatcher.forward(request, response);
    }
}
