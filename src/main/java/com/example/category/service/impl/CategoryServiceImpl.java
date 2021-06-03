package com.example.category.service.impl;

import com.example.category.entity.Category;
import com.example.category.entity.CategoryVo;
import com.example.category.mapper.CategoryMapper;
import com.example.category.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (Category表)服务实现类
 *
 * @author makejava
 * @since 2021-06-03 07:20:44
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Category selectById(Integer id) {
        return this.categoryMapper.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Category> selectPage(int start, int limit) {
        return this.categoryMapper.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<Category> selectAll() {
        return this.categoryMapper.selectAll();
     }

    @Override
    public List<CategoryVo> selectTree() {
         // 查询全部数据
        List<Category> categoryList = categoryMapper.selectAll();

        // categoryList转换为categoryVoList
        List<CategoryVo> categoryVoList = categoryList.stream().map(category -> {
            CategoryVo categoryVo = new CategoryVo();
            BeanUtils.copyProperties(category, categoryVo);
            return categoryVo;
        }).collect(Collectors.toList());

        //获取得所有parentId为0的数据，也就是一级目录
        //用于封装数据，取得他的孩子（也就是下级目录）的数据
        List<CategoryVo> categoryVoTree = categoryVoList.stream()
                .filter(categoryVo -> categoryVo.getPid().equals(0))
                .map((categoryVoParent) -> {
                    categoryVoParent.setChildren(getChildrenData(categoryVoParent, categoryVoList));
                    return categoryVoParent;
                }).collect(Collectors.toList());

        return categoryVoTree;
    }

    /**
     * 获取孩子（下级目录）的方法，递归实现
     */
    private List<CategoryVo> getChildrenData(CategoryVo root, List<CategoryVo> all) {
        List<CategoryVo> children = all.stream().filter(categoryVo ->
                categoryVo.getPid().equals(root.getId())
        ).map(categoryVo -> {
            categoryVo.setChildren(getChildrenData(categoryVo, all));
            return categoryVo;
        }).collect(Collectors.toList());
        return children;
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Category> selectList(Category category) {
        return this.categoryMapper.selectList(category);
    }
    
    /**
     * 新增数据
     *
     * @param category 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Category category) {
        return this.categoryMapper.insert(category);
    }

    /**
     * 批量新增
     *
     * @param categorys 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Category> categorys) {
        return this.categoryMapper.batchInsert(categorys);
    }

    /**
     * 修改数据
     *
     * @param category 实例对象
     * @return 实例对象
     */
    @Override
    public Category update(Category category) {
        this.categoryMapper.update(category);
        return this.selectById(category.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.categoryMapper.deleteById(id);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.categoryMapper.count();
     }
}