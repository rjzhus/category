package com.example.category.controller;

import com.example.category.entity.Menu;
import com.example.category.entity.MenuTree;
import com.example.category.service.MenuService;
import org.springframework.web.bind.annotation.*;
import com.example.category.entity.Response;

import java.util.List;

import javax.annotation.Resource;

/**
 * (Menu)控制层
 *
 * @author makejava
 * @since 2021-06-03 12:17:31
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    /**
     * 服务对象
     */
    @Resource
    private MenuService menuService;

    /**
     * 通过主键查询单条数据
     *
     * @param menu 参数对象
     * @return 单条数据
     */
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Response<Menu> selectOne(Menu menu) {
        Menu result = menuService.selectById(menu.getId());
        if (result != null) {
            return Response.createSuccessResponse("查询成功", result);
        }
        return Response.createErrorResponse("查询失败");
    }

    /**
     * 新增一条数据
     *
     * @param menu 实体类
     * @return Response对象
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Response<Menu> insert(@RequestBody Menu menu) {
        int result = menuService.insert(menu);
        if (result > 0) {
            return Response.createSuccessResponse("新增成功", menu);
        }
        return Response.createErrorResponse("新增失败");
    }

    /**
     * 修改一条数据
     *
     * @param menu 实体类
     * @return Response对象
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public Response<Menu> update(@RequestBody Menu menu) {
        Menu result = menuService.update(menu);
        if (result != null) {
            return Response.createSuccessResponse("修改成功", result);
        }
        return Response.createErrorResponse("修改失败");
    }

    /**
     * 删除一条数据
     *
     * @param menu 参数对象
     * @return Response对象
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public Response<Menu> delete(Menu menu) {
        int result = menuService.deleteById(menu.getId());
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
    public Response<List<Menu>> selectAll() {
        List<Menu> menus = menuService.selectAll();
        if (menus != null) {
            return Response.createSuccessResponse("查询成功", menus);
        }
        return Response.createErrorResponse("查询失败");
    }

    /**
     * 查询tree
     *
     * @return Response对象
     */
    @RequestMapping(value = "selectTree", method = RequestMethod.GET)
    public Response<List<MenuTree>> selectTree() {
        List<MenuTree> menus = menuService.selectTree();
        if (menus != null) {
            return Response.createSuccessResponse("查询成功", menus);
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
    public Response<List<Menu>> selectPage(Integer start, Integer limit) {
        List<Menu> menus = menuService.selectPage(start, limit);
        if (menus != null) {
            return Response.createSuccessResponse("查询成功", menus);
        }
        return Response.createErrorResponse("查询失败");
    }

}


