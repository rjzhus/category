package com.example.category.controller;

import com.example.category.entity.Category;
import com.example.category.entity.CategoryVo;
import com.example.category.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import com.example.category.entity.Response;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Resource;

import static org.apache.ibatis.ognl.DynamicSubscript.all;

/**
 * (Category)控制层
 *
 * @author makejava
 * @since 2021-06-03 07:20:41
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    /**
     * 服务对象
     */
    @Resource
    private CategoryService categoryService;

    /**
     * 通过主键查询单条数据
     *
     * @param category 参数对象
     * @return 单条数据
     */
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Response<Category> selectOne(Category category) {
        Category result = categoryService.selectById(category.getId());
        if (result != null) {
            return Response.createSuccessResponse("查询成功", result);
        }
        return Response.createErrorResponse("查询失败");
    }

    /**
     * 新增一条数据
     *
     * @param category 实体类
     * @return Response对象
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Response<Category> insert(@RequestBody Category category) {
        int result = categoryService.insert(category);
        if (result > 0) {
            return Response.createSuccessResponse("新增成功", category);
        }
        return Response.createErrorResponse("新增失败");
    }

    /**
     * 修改一条数据
     *
     * @param category 实体类
     * @return Response对象
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public Response<Category> update(@RequestBody Category category) {
        Category result = categoryService.update(category);
        if (result != null) {
            return Response.createSuccessResponse("修改成功", result);
        }
        return Response.createErrorResponse("修改失败");
    }

    /**
     * 删除一条数据
     *
     * @param category 参数对象
     * @return Response对象
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public Response<Category> delete(Category category) {
        int result = categoryService.deleteById(category.getId());
        if (result > 0) {
            return Response.createSuccessResponse("删除成功", null);
        }
        return Response.createErrorResponse("删除失败");
    }

    /**
     * 查询全部
     *
     * @return Response对象
     */
    @RequestMapping(value = "selectAll", method = RequestMethod.GET)
    public Response<List<Category>> selectAll() {
        List<Category> categorys = categoryService.selectAll();
        if (categorys != null) {
            return Response.createSuccessResponse("查询成功", categorys);
        }
        return Response.createErrorResponse("查询失败");
    }

    /**
     * 查询树形结构
     *
     * @return Response对象
     */
    @RequestMapping(value = "selectTree", method = RequestMethod.GET)
    public Response<List<CategoryVo>> selectTree() {
        List<CategoryVo> categoryVoList = categoryService.selectTree();
        if (categoryVoList != null) {
            return Response.createSuccessResponse("查询成功", categoryVoList);
        }
        return Response.createErrorResponse("查询失败");
    }

    /**
     * 分页查询
     *
     * @param start 偏移
     * @param limit 条数
     * @return Response对象
     */
    @RequestMapping(value = "selectPage", method = RequestMethod.GET)
    public Response<List<Category>> selectPage(Integer start, Integer limit) {
        List<Category> categorys = categoryService.selectPage(start, limit);
        if (categorys != null) {
            return Response.createSuccessResponse("查询成功", categorys);
        }
        return Response.createErrorResponse("查询失败");
    }

}