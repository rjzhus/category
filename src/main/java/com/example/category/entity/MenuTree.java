package com.example.category.entity;

import java.util.List;

/**
 * @author zrj
 * @date 2021/6/3
 * @since V1.0
 **/
public class MenuTree {
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

    private List<MenuTree> childList;

    public MenuTree() {
    }

    public MenuTree(Integer id, String name, String icon, String path, String types, Integer parentId, Integer seq, List<MenuTree> childList) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.path = path;
        this.types = types;
        this.parentId = parentId;
        this.seq = seq;
        this.childList = childList;
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

    public List<MenuTree> getChildList() {
        return childList;
    }

    public void setChildList(List<MenuTree> childList) {
        this.childList = childList;
    }

    @Override
    public String toString() {
        return "MenuTree{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", path='" + path + '\'' +
                ", types='" + types + '\'' +
                ", parentId=" + parentId +
                ", seq=" + seq +
                ", childList=" + childList +
                '}';
    }
}
