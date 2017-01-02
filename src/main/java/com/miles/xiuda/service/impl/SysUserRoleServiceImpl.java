package com.miles.xiuda.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.miles.xiuda.dao.SysUserRoleDao;
import com.miles.xiuda.service.SysUserRoleService;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

	@Resource
	private SysUserRoleDao sysUserRoleDao;

	@Override
	public void saveOrUpdate(Long userId, List<Long> roleIdList) {
		if (roleIdList.size() == 0) {
			return;
		}
		// 先删除用户与角色关系
		sysUserRoleDao.delete(userId);
		// 保存用户与角色关系
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("roleIdList", roleIdList);
		sysUserRoleDao.save(map);
	}

	@Override
	public List<Long> queryRoleIdList(Long userId) {
		return sysUserRoleDao.queryRoleIdList(userId);
	}

	@Override
	public void delete(Long userId) {
		sysUserRoleDao.delete(userId);
	}

}
