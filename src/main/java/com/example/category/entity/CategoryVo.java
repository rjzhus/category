package com.example.category.entity;

import java.util.List;

/**
 * @author zrj
 * @date 2021/6/3
 * @since V1.0
 **/
public class CategoryVo {

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

    /**
     * 子节点
     */
    private List<CategoryVo> children;

    public CategoryVo() {
    }

    public CategoryVo(Integer id, String name, Integer pid, List<CategoryVo> children) {
        this.id = id;
        this.name = name;
        this.pid = pid;
        this.children = children;
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

    public List<CategoryVo> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryVo> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "CategoryVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", children=" + children +
                '}';
    }
}
