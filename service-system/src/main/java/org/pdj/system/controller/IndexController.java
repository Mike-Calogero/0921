package org.pdj.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.pdj.common.result.R;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "用户登录")
@RestController
@RequestMapping("/admin/system/index")
@CrossOrigin
public class IndexController {

    // {“code”:20000,"data":{"token":"admin-token"}}
    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public R login(){
        Map<String,Object> maps = new HashMap<>();
        maps.put("token","admin-token");
        return R.ok(maps);

    }

    @GetMapping("/info")
    public R info(){
        Map<String,Object> maps = new HashMap<>();
        maps.put("roles","[\"admin\"]");//向maps集合中put添加键值对数据
        maps.put("introduction","I am a super administrator");
        maps.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        maps.put("name","super hero");
        return R.ok(maps);
    }

    @PostMapping("/logout")
    public R logout(){
        return R.ok("success");
    }
}
