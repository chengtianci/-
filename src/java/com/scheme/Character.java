package com.scheme;

/**
 * Created by cheng on 2017/11/27.
 */
public class Character {
    private String id;
    private String name;

    public Character(String _id,String _name) {
        this.setId(_id);
        this.setName(_name);
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
}
