package com.servlet;

import com.db.DB;
import com.scheme.Course;

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
public class CourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DB db = DB.getInstance();
        Map<Integer,Course> courseMap = db.selectCourse();
        String rs = new String();
        for (Integer key: courseMap.keySet()) {
            rs += courseMap.get(key).getName()+" ;";
        }
        request.setAttribute("title","所有课程的信息");
        request.setAttribute("obj",rs);
//
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("./show.jsp");
        requestDispatcher.forward(request,response);
    }
}
