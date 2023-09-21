package org.pdj.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.pdj.common.result.R;
import org.pdj.model.system.SysRole;
import org.pdj.model.vo.SysRoleQueryVo;
import org.pdj.system.service.SysRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SysRoleServiceTest {
    @Autowired
    SysRoleService sysRoleService;

    //分页
    @Test
    public void testGetPage() {
        Page<SysRole> pageParam = new Page<>(1,3);
        IPage<SysRole> pageModel = sysRoleService.selectPage(pageParam, new SysRoleQueryVo());
        pageModel.getRecords().forEach(System.out::println);
    }

    //    查询所有
    @Test
    public void testQueryAll(){
        List<SysRole> sysRoles = sysRoleService.list();
        for (SysRole sysRole : sysRoles) {
            System.out.println("sysRole = " + sysRole);
        }
    }
}
