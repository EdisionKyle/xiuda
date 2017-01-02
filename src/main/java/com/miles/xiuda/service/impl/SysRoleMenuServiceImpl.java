package com.miles.xiuda.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miles.xiuda.dao.SysRoleMenuDao;
import com.miles.xiuda.service.SysRoleMenuService;

@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

	@Resource
	private SysRoleMenuDao sysRoleMenuDao;

	@Override
	@Transactional
	public void saveOrUpdate(Long roleId, List<Long> menuIdList) {
		if (menuIdList.size() == 0) {
			return;
		}
		// 先删除角色与菜单关系
		sysRoleMenuDao.delete(roleId);

		// 保存角色与菜单关系
		Map<String, Object> map = new HashMap<>();
		map.put("roleId", roleId);
		map.put("menuIdList", menuIdList);
		sysRoleMenuDao.save(map);
	}

	@Override
	public List<Long> queryMenuIdList(Long roleId) {
		return sysRoleMenuDao.queryMenuIdList(roleId);
	}

}
