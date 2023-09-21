package org.pdj.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.pdj.common.result.R;
import org.pdj.model.system.SysUser;
import org.pdj.model.vo.SysUserQueryVo;
import org.pdj.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "用户管理")
@RestController
@CrossOrigin
@RequestMapping("/admin/system/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "获取分页列表")
    @GetMapping("/{page}/{limit}")
    public R index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "userQuerYVo", value = "查询对象", required = false)
            SysUserQueryVo userQueryVo) {
        Page<SysUser> pageParam = new Page<>(page, limit);
        IPage<SysUser> pageModel = sysUserService.selectPage(pageParam, userQueryVo);
        return R.ok(pageModel);
    }

    @ApiOperation(value = "获取用户")
    @GetMapping("/get/{id}")
    public R get(@PathVariable Long id) {
        SysUser user = sysUserService.getById(id);
        return R.ok(user);
    }

    @ApiOperation(value = "保存用户")
    @PostMapping("/save")
    public R save(@RequestBody SysUser user) {
        sysUserService.save(user);
        return R.ok();
    }

    //根据用户获取角色数据
//    @ApiOperation(value = "根据用户获取角色数据")
//    @GetMapping("/toAssign/{userId}")
//    public R toAssign(@PathVariable Long userId){
//        Map<String,Object> roleMap = sysUserService.getRolesByUserId(userId);
//        return R.ok(roleMap);
//    }
//
//    //根据用户分配角色
//    @ApiOperation(value = "根据用户分配角色")
//    @PostMapping("/doAssign")
//    public R doAssign(@RequestBody AssignRoleVo assignRoleVo){
//        sysUserService.doAssign(assignRoleVo);
//        return R.ok();
//    }

    @ApiOperation(value = "更新状态")
    @GetMapping("updateStatus/{id}/{status}")
    public R updateStatus(@PathVariable Long id, @PathVariable Integer status) {
        sysUserService.updateStatus(id, status);
        return R.ok();
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("/update")
    public R updateById(@RequestBody SysUser user) {
        sysUserService.updateById(user);
        return R.ok();
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/remove/{id}")
    public R remove(@PathVariable Long id) {
        sysUserService.removeById(id);
        return R.ok();
    }
}
