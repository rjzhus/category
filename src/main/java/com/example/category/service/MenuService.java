package com.example.category.service;

import com.example.category.entity.Menu;
import com.example.category.entity.MenuTree;

import java.util.List;
import java.util.Map;

/**
 * (Menu)表服务接口
 *
 * @author makejava
 * @since 2021-06-03 12:17:31
 */
public interface MenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Menu selectById(Integer id);

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Menu> selectPage(int start, int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Menu> selectAll();

    /**
     * 查询树
     *
     * @return 对象列表
     */
    List<MenuTree> selectTree();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param menu 实例对象
     * @return 对象列表
     */
    List<Menu> selectList(Menu menu);

    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 影响行数
     */
    int insert(Menu menu);

    /**
     * 批量新增
     *
     * @param menus 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<Menu> menus);

    /**
     * 修改数据
     *
     * @param menu 实例对象
     * @return 修改
     */
    Menu update(Menu menu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}


