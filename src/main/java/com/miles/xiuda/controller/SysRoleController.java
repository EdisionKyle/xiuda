package com.miles.xiuda.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miles.xiuda.pojo.SysRole;
import com.miles.xiuda.service.SysRoleMenuService;
import com.miles.xiuda.service.SysRoleService;
import com.miles.xiuda.util.Retmap;

/**
 *  类名：SysRoleController.java
 *  说明：角色管理
 *  创建时间：2017年1月1日 上午2:05:21
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
@Controller
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {

	@Resource
	private SysRoleService sysRoleService;
	@Resource
	private SysRoleMenuService sysRoleMenuService;

	/**
	 * 角色列表
	 */
	@RequestMapping("/list")
	public String list(Integer page, Integer limit, Model model) {
		page = 1;
		limit = 10;
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		// 查询列表数据
		List<SysRole> list = sysRoleService.queryList(map);
		model.addAttribute("list", list);
		return "role/role_list";
	}
	
	/**
	 * 跳转到添加角色页面
	 * @return
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "role/role_add";
	}

	/**
	 * 角色列表
	 */
	@RequestMapping("/select")
	@RequiresPermissions("sys:role:select")
	public Retmap select() {
		// 查询列表数据
		List<SysRole> list = sysRoleService
				.queryList(new HashMap<String, Object>());
		return Retmap.ok().put("list", list);
	}

	/**
	 * 角色信息
	 */
	@RequestMapping("/info/{roleId}")
	@RequiresPermissions("sys:role:info")
	public Retmap info(@PathVariable("roleId") Long roleId) {
		SysRole role = sysRoleService.queryObject(roleId);
		// 查询角色对应的菜单
		List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
		role.setMenuIdList(menuIdList);
		return Retmap.ok().put("role", role);
	}

	/**
	 * 保存角色
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:role:save")
	public Retmap save(@RequestBody SysRole role) {
		if (StringUtils.isBlank(role.getRoleName())) {
			return Retmap.error("角色名称不能为空");
		}
		sysRoleService.save(role);
		return Retmap.ok();
	}

	/**
	 * 修改角色
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:role:update")
	public Retmap update(@RequestBody SysRole role) {
		if (StringUtils.isBlank(role.getRoleName())) {
			return Retmap.error("角色名称不能为空");
		}
		sysRoleService.update(role);
		return Retmap.ok();
	}

	/**
	 * 删除角色
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:role:delete")
	public Retmap delete(@RequestBody Long[] roleIds) {
		sysRoleService.deleteBatch(roleIds);
		return Retmap.ok();
	}

}
