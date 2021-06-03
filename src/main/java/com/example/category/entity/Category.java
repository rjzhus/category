package com.example.category.entity;

import java.io.Serializable;

/**
 * (Category)实体类
 *
 * @author makejava
 * @since 2021-06-03 07:20:41
 */
public class Category implements Serializable {
    private static final long serialVersionUID = 404235573904070855L;
    /**
    * 主键ID
    */
    private Integer id;
    /**
    * 名称
    */
    private String name;
    /**
    * 上级id
    */
    private Integer pid;

    public Category() {
    }

    public Category(Integer id, String name, Integer pid) {
        this.id = id;
        this.name = name;
        this.pid = pid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString(){
        return "Category {" +
            "id : " + id + ", " +
            "name : " + name + ", " +
            "pid : " + pid + ", " +
        '}';
    }
}