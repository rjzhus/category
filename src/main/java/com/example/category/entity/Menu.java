package com.example.category.entity;

import java.io.Serializable;

/**
 * (Menu)实体类
 *
 * @author makejava
 * @since 2021-06-03 12:17:31
 */
public class Menu implements Serializable {
    private static final long serialVersionUID = 463931699045241399L;
    /**
     * 菜单id
     */
    private Integer id;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 图标
     */
    private String icon;
    /**
     * 路径
     */
    private String path;
    /**
     * 菜单类型:Folder目录/Link页面
     */
    private String types;
    /**
     * 父菜单名称
     */
    private Integer parentId;
    /**
     * 排序
     */
    private Integer seq;


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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "Menu {" +
                "id : " + id + ", " +
                "name : " + name + ", " +
                "icon : " + icon + ", " +
                "path : " + path + ", " +
                "types : " + types + ", " +
                "parentId : " + parentId + ", " +
                "seq : " + seq + ", " +
                '}';
    }
}


