package com.scheme;

/**
 * Created by cheng on 2017/11/27.
 */
public class Student {
    private String id;
    private String name;
    private String password;
    private String qq;
    private String tel;
    private String sex;
    private String province;

    public Student(String _id,String _name,String _password ) {
        this.setId(_id);
        this.setName(_name);
        this.setPassword(_password);
    }

    public Student() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
