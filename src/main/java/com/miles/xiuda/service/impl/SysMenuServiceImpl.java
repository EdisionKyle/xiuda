package com.miles.xiuda.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.miles.xiuda.dao.SysMenuDao;
import com.miles.xiuda.pojo.Constants.MenuType;
import com.miles.xiuda.pojo.SysMenu;
import com.miles.xiuda.service.SysMenuService;
import com.miles.xiuda.service.SysRoleMenuService;
import com.miles.xiuda.service.SysUserService;

@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Resource
	private SysMenuDao sysMenuDao;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysRoleMenuService sysRoleMenuService;

	@Override
	public List<SysMenu> queryListParentId(Long parentId, List<Long> menuIdList) {
		List<SysMenu> menuList = sysMenuDao.queryListParentId(parentId);
		if (menuIdList == null) {
			return menuList;
		}

		List<SysMenu> userMenuList = new ArrayList<>();
		for (SysMenu menu : menuList) {
			if (menuIdList.contains(menu.getMenuId())) {
				userMenuList.add(menu);
			}
		}
		return userMenuList;
	}

	@Override
	public List<SysMenu> queryNotButtonList() {
		return sysMenuDao.queryNotButtonList();
	}

	@Override
	public List<SysMenu> getUserMenuList(Long userId) {
		// 系统管理员，拥有最高权限
		if (userId == 1) {
			return getAllMenuList(null);
		}

		// 用户菜单列表
		List<Long> menuIdList = sysUserService.queryAllMenuId(userId);
		return getAllMenuList(menuIdList);
	}

	@Override
	public SysMenu queryObject(Long menuId) {
		return sysMenuDao.queryObject(menuId);
	}

	@Override
	public List<SysMenu> queryList(Map<String, Object> map) {
		return sysMenuDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysMenuDao.queryTotal(map);
	}

	@Override
	public void save(SysMenu menu) {
		sysMenuDao.save(menu);
	}

	@Override
	public void update(SysMenu menu) {
		sysMenuDao.update(menu);
	}

	@Override
	@Transactional
	public void delete(SysMenu menu) {
		sysMenuDao.delete(menu.getMenuId());
		Map<String, Object> param = Maps.newHashMap();
		param.put("parentIds", menu.getParentIds());
		sysMenuDao.deleteByParentIds(param);
	}

	/**
	 * 获取所有菜单列表
	 */
	private List<SysMenu> getAllMenuList(List<Long> menuIdList) {
		// 查询根菜单列表
		List<SysMenu> menuList = queryListParentId(0L, menuIdList);
		// 递归获取子菜单
		getMenuTreeList(menuList, menuIdList);

		return menuList;
	}

	/**
	 * 递归
	 */
	private List<SysMenu> getMenuTreeList(List<SysMenu> menuList,
			List<Long> menuIdList) {
		List<SysMenu> subMenuList = new ArrayList<SysMenu>();

		for (SysMenu menu : menuList) {
			if (menu.getType() == MenuType.CATALOG.getValue()) {// 目录
				menu.setList(getMenuTreeList(
						queryListParentId(menu.getMenuId(), menuIdList),
						menuIdList));
			}
			subMenuList.add(menu);
		}
		return subMenuList;
	}

}
