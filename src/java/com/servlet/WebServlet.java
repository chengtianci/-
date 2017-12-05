package com.servlet;

import com.db.DB;
import com.scheme.Student;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.Map;

/**
 * Created by cheng on 2017/11/13.
 */
public class WebServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request,
                           javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        DB db = DB.getInstance();
        Map<Integer,Student> studentMap = db.selectStudent();
        String rs = new String();
        for (Integer key:studentMap.keySet()) {
            rs += studentMap.get(key).getId()+" "
                    +studentMap.get(key).getName()+" "
                    +studentMap.get(key).getQq()+" "
                    +studentMap.get(key).getTel()+" "
                    +studentMap.get(key).getSex()+" "
                    +studentMap.get(key).getProvince()+" ;\n";
        }
//        response.sendRedirect("./show.jsp");
        request.setAttribute("title","所有学生的信息");
        request.setAttribute("obj",rs);
//
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("./show.jsp");
        requestDispatcher.forward(request,response);
    }
}
