package org.pdj.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiParam;
import org.pdj.common.result.R;
import org.pdj.model.system.SysRole;
import org.pdj.model.vo.SysRoleQueryVo;
import org.pdj.system.exception.AuthException;
import org.pdj.system.exception.GlobalException;
import org.pdj.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService;

    //删除角色
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除角色")
    public R removeById(@PathVariable @ApiParam(value = "角色id") long id) {
        boolean b = sysRoleService.removeById(id);
        if (b) {
            return R.ok(b);
        } else {
            return R.fail(b);
        }
    }

    //修改角色
    @PutMapping("/update")
    @ApiOperation(value = "修改角色")
    public R updateById(@RequestBody @ApiParam(value = "角色") SysRole sysRole) {
        boolean b = sysRoleService.updateById(sysRole);
        if (b) {
            return R.ok(b);
        } else {
            return R.fail(b);
        }
    }

    //批量删除角色
    @DeleteMapping("/delBatches")
    @ApiOperation(value = "批量删除角色")
    public R delBatches(@RequestBody @ApiParam(value = "批量删除") List<Long> ids) {
        boolean b = sysRoleService.removeByIds(ids);
        if (b) {
            return R.ok(b);
        } else {
            return R.fail(b);
        }
    }

//    分页
//    @ApiOperation(value = "获取分页列表")
//    @GetMapping("/{page}/{limit}")
//    public R getPages(
//            @ApiParam(name = "page", value = "当前页码", required = true)
//            @PathVariable Long page,
//            @ApiParam(name = "limit", value = "每页记录数", required = true)
//            @PathVariable Long limit,
//            @ApiParam(name = "roleQueryVo", value = "查询对象", required = false)
//            SysRole sysRole){
//        List<SysRole> list = sysRoleService.getPage(1,2,"c");
//        return R.ok(list);
//    }

//条件分页查询
//page表示当前页 limit表示每页显示的记录数
@GetMapping("/{page}/{limit}")
@ApiOperation(value = "分页查询")
public R index(
        @ApiParam(name = "page", value = "当前页码", required = true) @PathVariable long page,
        @ApiParam(name = "limit", value = "每页记录数", required = true) @PathVariable long limit,
        @ApiParam(name = "sysRoleQueryVo", value = "查询对象", required = false) SysRoleQueryVo sysRoleQueryVo ) {
    Page<SysRole> pageParam = new Page<>(page,limit);
    IPage<SysRole> pageModel = sysRoleService.selectPage(pageParam, sysRoleQueryVo);
    pageModel.getRecords().forEach(System.out::println);

    return R.ok(pageModel);
}


    //根据就角色ID查询
    @GetMapping("/get/{id}")
    @ApiOperation(value = "根据角色ID查询")
    public R get(@ApiParam(name="id", value = "角色Id", required = true) @PathVariable long id) {
        SysRole sysRole = sysRoleService.getById(id);
        return R.ok(sysRole);
    }

    //新增角色
    @PostMapping("/save")
    @ApiOperation(value = "新增角色")
    public R save(
            @RequestBody
            @ApiParam(value = "角色对象") SysRole sysRole) {
        boolean result = sysRoleService.save(sysRole);
        if (result) {
            return R.ok(true);
        } else {
            return R.fail(false);
        }
    }

    //查询所有
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有角色")
    public R findAll() throws AuthException{
        try{
            int zero = 10/0;
        }catch (Exception e){
            //自定义异常
//            throw new AuthException(2333,"你好");
            //特定异常
            e.printStackTrace();
        }

        List<SysRole> sysRoles = sysRoleService.list();
        return R.ok(sysRoles);
    }
//    @GetMapping("/get")
//    @ApiOperation(value = "查询全部")
//    public List<SysRole> get() {
//        return sysRoleService.list();
//    }


    //五种常见异常
    //空指针异常、IO、数组下标越界、类型转换、算数异常

}
