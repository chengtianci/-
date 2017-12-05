package com.scheme;

/**
 * Created by cheng on 2017/11/27.
 */
public class Course {
    private String id;
    private String name;

    public Course(String _id,String _name) {
        this.setId(_id);
        this.setName(_name);
    }
    public String getId() { return id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
