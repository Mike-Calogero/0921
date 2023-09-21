package org.pdj.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.pdj.model.system.SysRole;
import org.pdj.model.vo.SysRoleQueryVo;
import org.pdj.system.mapper.SysRoleMapper;
import org.pdj.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService{

    @Autowired
    SysRoleMapper sysRoleMapper;

//    public List<SysRole> getPage(int pageCount, int pageSiz, String name){
//        Page<SysRole> page = new Page<>();
//        page.setCurrent(pageCount);//当前页
//        page.setSize(pageSiz);//页面容量
//        QueryWrapper queryWrapper = new QueryWrapper();//模糊查询
//        queryWrapper.like("role_code",name);
//        IPage<SysRole> iPage = sysRoleMapper.selectPage(page,queryWrapper);
//        List<SysRole> list = iPage.getRecords();
//        return list;
//    }

    @Override
    public IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo sysRoleQueryVo) {
        return baseMapper.selectPage(pageParam,sysRoleQueryVo);
    }

}
