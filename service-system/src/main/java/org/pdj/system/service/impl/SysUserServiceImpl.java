package org.pdj.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.pdj.model.system.SysRole;
import org.pdj.model.system.SysUser;
import org.pdj.model.system.SysUserRole;
import org.pdj.model.vo.AssginRoleVo;
import org.pdj.model.vo.SysUserQueryVo;
import org.pdj.system.mapper.SysRoleMapper;
import org.pdj.system.mapper.SysUserMapper;
import org.pdj.system.mapper.SysUserRoleMapper;
import org.pdj.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public IPage<SysUser> selectPage(Page<SysUser> pageParam, SysUserQueryVo userQueryVo) {
        return sysUserMapper.selectPage(pageParam, userQueryVo);
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        SysUser sysUser = sysUserMapper.selectById(id);
        sysUser.setStatus(status);
        sysUserMapper.updateById(sysUser);
    }

//    @Override
//    public Map<String, Object> getRolesByUserId(Long userId) {
//        //获取所有角色
//        List<SysRole> roles = sysRoleMapper.selectList(null);
////根据用户id查询
//        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("user_id", userId);
////获取用户已分配的角色
//        List<SysUserRole> userRoles = sysUserRoleMapper.selectList(queryWrapper);
//        //获取用户已分配的角色id
//        List<Long> userRoleIds = new ArrayList<>();
//        for (SysUserRole userRole : userRoles) {
//            userRoleIds.add(userRole.getRoleId());
//        }
////创建返回的Map
//        Map<String, Object> returnMap = new HashMap<>();
//        returnMap.put("allRoles", roles);
//        returnMap.put("userRoleIds", userRoleIds);
//        return returnMap;
//    }
//
//    @Override
//    public void doAssign(AssginRoleVo assginRoleVo) {
//        //根据用户id删除原来分配的角色
//        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("user_id", assginRoleVo.getUserId());
//        sysUserRoleMapper.delete(queryWrapper);
////获取所有的角色id
//        List<Long> roleIdList = assginRoleVo.getRoleIdList();
//        for (Long roleId : roleIdList) {
//            if (roleId != null) {
//                SysUserRole sysUserRole = new SysUserRole();
//                sysUserRole.setUserId(assginRoleVo.getUserId());
//                sysUserRole.setRoleId(roleId);
////保存
//                sysUserRoleMapper.insert(sysUserRole);
//            }
//        }
//    }
}
