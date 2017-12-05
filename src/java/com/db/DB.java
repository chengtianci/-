package com.db;

import com.scheme.Character;
import com.scheme.Course;
import com.scheme.Interest;
import com.scheme.Student;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

/**
 * Created by cheng on 2017/11/27.
 */
public class DB {
    // calss_one的库connection
    private Statement statement1;
    private Connection connection1;


    // calss_two的库connection
    private Connection connection2;
    private Statement statement2;



    private static DB ourInstance = new DB();

    public static DB getInstance() {
        return ourInstance;
    }

    private DB() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            out.println("无法加载jdbc驱动！");
            e.printStackTrace();
        }
        // 调用本地数据库的服务class_two
        String url1 = "jdbc:mysql://localhost:3306/class_one";
        String url2 = "jdbc:mysql://localhost:3306/class_two";
        // 调用方法，创建连接对象
        try {
//            connection = DriverManager.getConnection(url, "root", "");
            this.setConnection1(DriverManager.getConnection(url1, "root", ""));
            this.setConnection2(DriverManager.getConnection(url2, "root", ""));
//            statement = connection.createStatement();
            this.setStatement1(this.getConnection1().createStatement());
            this.setStatement2(this.getConnection2().createStatement());
//            out.println("成功连接到数据库！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//connection和statementde get set
    public Connection getConnection1() {
        return connection1;
    }

    public void setConnection1(Connection connection1) {
        this.connection1 = connection1;
    }

    public Connection getConnection2() {
        return connection2;
    }

    public void setConnection2(Connection connection2) {
        this.connection2 = connection2;
    }

    public Statement getStatement1() {
        return statement1;
    }

    public void setStatement1(Statement statement1) {
        this.statement1 = statement1;
    }

    public Statement getStatement2() {
        return statement2;
    }

    public void setStatement2(Statement statement2) {
        this.statement2 = statement2;
    }




    //inquire 方法
    public Map<Integer,Student> selectStudent() {
        Map<Integer,Student> map = new HashMap<Integer,Student>();
        String url1 = "select * from class_one.student";
        String url2 = "select * from class_two.student";
        try {
            ResultSet rs1 = this.getStatement1().executeQuery(url1);
            ResultSet rs2 = this.getStatement2().executeQuery(url2);
            int i = 0;

            while (rs1.next()) {
                Student instance = new Student(rs1.getString(1),
                        rs1.getString(2),
                        rs1.getString(3));
                instance.setSex(rs1.getString(4));
                instance.setQq(rs1.getString(5));
                instance.setTel(rs1.getString(6));
                instance.setProvince(rs1.getString(7));
                map.put(i,instance);
                i++;
            }

            while (rs2.next()) {
                Student instance = new Student(rs2.getString(1),
                        rs2.getString(2),
                        rs2.getString(3));
                instance.setSex(rs2.getString(4));
                instance.setTel(rs2.getString(5));
                map.put(i,instance);
                i++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return map;
    }
    public Map<Integer,Course> selectCourse() {
        Map<Integer,Course> map = new HashMap<Integer,Course>();
        String url1 = "select * from class_one.elective_course";
        String url2 = "select * from class_two.course";
        try {
            ResultSet rs = this.getStatement1().executeQuery(url1);
            ResultSet rs2 = this.getStatement2().executeQuery(url2);
            int i = 0 ;
            while (rs.next()){
                Course instance = new Course(rs.getString(1),rs.getString(2));
                map.put(i,instance);
                i++;
            };
            while (rs2.next()){
                Course instance = new Course(rs2.getString(1),rs2.getString(2));
                map.put(i,instance);
                i++;
            };
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
    public Map<Integer,Course> selectsingleCourse(String id) {
        Map<Integer,Course> map = new HashMap<Integer,Course>();
        String url1 ="select * from class_one.elective_course" +
                "  where eid = " +
                "(select eid from class_one.stu_ele_course " +
                "        where sid = "+ id +")";
        try {
            ResultSet rs1 = this.getStatement1().executeQuery(url1);
            int i = 0 ;
            while (rs1.next()) {
                Course instance = new Course(rs1.getString(1),
                        rs1.getString(2));
                map.put(i,instance);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
    public Map<Integer,Interest> selectsingleInterset(String id) {
        Map<Integer,Interest> map = new HashMap<Integer,Interest>();
        String url1 = "select * from class_one.interset" +
                "where intid =(select int_ID " +
                "from class_one.stu_int " +
                "where stuID =  "+id+")";
        String url2 = "select * from class_two.interest where idStudent ="+id;
        try {
            ResultSet rs = this.getStatement1().executeQuery(url1);
            ResultSet rs2 = this.getStatement2().executeQuery(url2);
            int i = 0 ;
            while (rs.next()){
                Interest instance = new Interest(rs.getString(1),rs.getString(2));
                map.put(i,instance);
                i++;
            };
            while (rs2.next()){
                Interest instance = new Interest(rs2.getString(1),rs2.getString(2));
                map.put(i,instance);
                i++;
            };
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
    public Map<Integer,Character> selectCharacter(String id) {
        Map<Integer,Character> map = new HashMap<Integer,Character>();
        String url1 ="select * from class_one.elective_course" +
                     "  where eid = " +
                        "(select eid from class_one.stu_ele_course " +
                        "        where sid = "+ id +")";
        try {
            ResultSet rs1 = this.getStatement1().executeQuery(url1);
            int i = 0 ;
            while (rs1.next()) {
                Character instance = new Character(rs1.getString(1),
                                                   rs1.getString(2));
                map.put(i,instance);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public Student selectSingleStudent(String id) {
        Student instance = new Student();
        String url1 = "select * from class_one.student where sid = "+ id;
        String url2 = "select * from class_two.student where stuID = "+ id;
        try {
            ResultSet rs1 = this.getStatement1().executeQuery(url1);
            ResultSet rs2 = this.getStatement2().executeQuery(url2);
            if ( rs1.next()){
                instance.setId(rs1.getString(1));
                instance.setName(rs1.getString(2));
                instance.setPassword(rs1.getString(3));
                instance.setSex(rs1.getString(4));
                instance.setQq(rs1.getString(5));
                instance.setTel(rs1.getString(6));
                instance.setProvince(rs1.getString(7));
            }
            if ( rs2.next() ){
                instance.setId(rs2.getString(1));
                instance.setName(rs2.getString(2));
                instance.setPassword(rs2.getString(3));
                instance.setSex(rs2.getString(4));
                instance.setTel(rs2.getString(5));
                instance.setQq(" ");
                instance.setProvince(" ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  instance;
    }

    public static void main(String[] args) {
        DB db = new DB();
//        Map<Integer,Student> studentMap = db.selectStudent();
//        for (Integer key:  studentMap.keySet()) {
//            out.println(key+" "+ studentMap.get(key).getName());
//        }
//        Map<Integer,Character> characterMap = db.selectCharacter("2017317210401");
//        for (Integer key: characterMap.keySet()) {
//            out.print(key+" "+characterMap.get(key).getName());
//        }
//        Map<Integer,Course> courseMap =db.selectCourse();
//        for (Integer key: courseMap.keySet()) {
//            out.print(key+" "+courseMap.get(key).getName());
//        }
//        Student s = db.selectSingleStudent("2017317210406");
//        out.print(s.getId());
//        out.print(s.getName());
//        out.print(s.getPassword());
    }

}

