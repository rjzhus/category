package com.example.category.service.impl;

import com.example.category.entity.Menu;
import com.example.category.entity.MenuTree;
import com.example.category.mapper.MenuMapper;
import com.example.category.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (Menu表)服务实现类
 *
 * @author makejava
 * @since 2021-06-03 12:17:31
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Menu selectById(Integer id) {
        return this.menuMapper.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Menu> selectPage(int start, int limit) {
        return this.menuMapper.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Menu> selectAll() {
        return this.menuMapper.selectAll();
    }

    /**
     * 查询Tree
     *
     * @return 实例对象的集合
     */
    @Override
    public List<MenuTree> selectTree() {
        Integer parentId = 0;
        List<Menu> menuList = menuMapper.selectAll();
        return build(menuList, parentId);
    }

    /**
     * 递归查子菜单
     */
    private List<MenuTree> build(List<Menu> menuList, Integer parentId) {
        return menuList.stream().filter(menu -> menu.getParentId().intValue() == parentId.intValue())
                .map(menu -> {
                    MenuTree menuTree = new MenuTree();
                    BeanUtils.copyProperties(menu, menuTree);
                    List<MenuTree> childList = build(menuList, menuTree.getId());
                    if (childList != null && childList.size() > 0) {
                        menuTree.setChildList(childList);
                    }
                    return menuTree;
                }).collect(Collectors.toList());
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Menu> selectList(Menu menu) {
        return this.menuMapper.selectList(menu);
    }

    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Menu menu) {
        return this.menuMapper.insert(menu);
    }

    /**
     * 批量新增
     *
     * @param menus 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Menu> menus) {
        return this.menuMapper.batchInsert(menus);
    }

    /**
     * 修改数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @Override
    public Menu update(Menu menu) {
        this.menuMapper.update(menu);
        return this.selectById(menu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.menuMapper.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.menuMapper.count();
    }
}


