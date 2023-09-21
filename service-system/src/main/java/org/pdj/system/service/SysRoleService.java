package org.pdj.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.pdj.model.system.SysRole;
import org.pdj.model.vo.SysRoleQueryVo;

import java.util.List;


public interface SysRoleService extends IService<SysRole> {
    //分页
//    public List<SysRole> getPage(int pageCount,int pageSiz,String name);

    IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo sysRoleQueryVo);
}
