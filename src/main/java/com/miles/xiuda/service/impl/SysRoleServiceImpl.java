package com.miles.xiuda.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miles.xiuda.dao.SysRoleDao;
import com.miles.xiuda.pojo.SysRole;
import com.miles.xiuda.service.SysRoleMenuService;
import com.miles.xiuda.service.SysRoleService;
import com.miles.xiuda.service.SysUserRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Resource
	private SysRoleDao sysRoleDao;
	@Resource
	private SysRoleMenuService sysRoleMenuService;
	@Autowired
	private SysUserRoleService sysUserRoleService;

	@Override
	public SysRole queryObject(Long roleId) {
		return sysRoleDao.queryObject(roleId);
	}

	@Override
	public List<SysRole> queryList(Map<String, Object> map) {
		return sysRoleDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysRoleDao.queryTotal(map);
	}

	@Override
	@Transactional
	public void save(SysRole role) {
		role.setCreateTime(new Date());
		sysRoleDao.save(role);

		// 保存角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
	}

	@Override
	@Transactional
	public void update(SysRole role) {
		sysRoleDao.update(role);
		// 更新角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
	}

	@Override
	@Transactional
	public void deleteBatch(Long[] roleIds) {
		sysRoleDao.deleteBatch(roleIds);
	}

}
