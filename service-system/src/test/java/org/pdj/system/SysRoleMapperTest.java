                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             package org.pdj.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.pdj.model.system.SysRole;
import org.pdj.system.mapper.SysRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class SysRoleMapperTest {
    @Autowired
    SysRoleMapper sysRoleMapper;

    //添加
    @Test
    public void testInsert(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("role");
        sysRole.setDescription("角色管理员");
        int R = sysRoleMapper.insert(sysRole);
        System.out.println(R); //影响的行数
        System.out.println(sysRole.getId()); //id自动回填
    }

//    修改
    @Test
    public void testUpdateById(){
        SysRole sysRole = new SysRole();
        BigDecimal bd = new BigDecimal(9);
        sysRole.setId(bd.longValue());
        sysRole.setRoleName("角色管理员1");
        int R = sysRoleMapper.updateById(sysRole);
        System.out.println(R);
    }

//    删除
@Test
public void testDeleteById(){
    int R = sysRoleMapper.deleteById("2");
    System.out.println(R);
}
//批量删除
    @Test
    public void testDeleteBatchIds() {
        int R = sysRoleMapper.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println(R);
    }

//分页查询
@Test
public void getByPage(){
    Page<SysRole> page = new Page<>();
    page.setCurrent(0);
    page.setSize(2);
    QueryWrapper<SysRole> qw = new QueryWrapper<>();
    qw.like("role_name","f");   //like ne eq
//    Page<SysRole> result = sysRoleMapper.selectPage(page,null);
//    List<SysRole> records = result.getRecords();
//    records.forEach(System.out::println);
//    for (SysRole sysRole:records){
//        System.out.println(sysRole);    //soutv
//    }
}

//根据id查询
    @Test
    public void testQueryById(){
        SysRole sysRole = sysRoleMapper.selectById(11);
        System.out.println("sysRole = " + sysRole);
    }

    //查询所有
    @Test
    public void testQueryAll(){
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        for (SysRole sysRole : sysRoles){
            System.out.println("sysRole" + sysRoles);
        }
    }
}
