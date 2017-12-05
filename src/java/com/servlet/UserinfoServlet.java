package com.servlet;

import com.db.DB;
import com.scheme.Course;
import com.scheme.Interest;
import com.scheme.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by cheng on 2017/12/4.
 */
@javax.servlet.annotation.WebServlet(name = "CourseServlet")
public class UserinfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DB db = DB.getInstance();
        String ID = request.getParameter("ID").toString();
        Student student = db.selectSingleStudent(ID);
        Map<Integer, Course> characterMap = db.selectsingleCourse(ID);
        Map<Integer,Interest> interestMap = db.selectsingleInterset(ID);
        String rs = new String();
        rs += student.getId()+" "
                +student.getName()+" "
                +student.getQq()+" "
                +student.getTel()+" "
                +student.getSex()+" "
                +student.getProvince()+ " ;\n";
        for (Integer key:characterMap.keySet()) {
            rs += characterMap.get(key).getId()+" "
                    +characterMap.get(key).getName()+"\n";
        }
        for (Integer key:interestMap.keySet()) {
            rs += interestMap.get(key).getId()+" "
                    +interestMap.get(key).getName()+"\n";
        }

//        response.sendRedirect("./show.jsp");
        request.setAttribute("title","所有学生的信息");
        request.setAttribute("obj",rs);
//
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("./show.jsp");
        requestDispatcher.forward(request,response);
    }
}
