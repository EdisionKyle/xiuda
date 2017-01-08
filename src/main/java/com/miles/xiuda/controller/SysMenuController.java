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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miles.xiuda.handler.RTException;
import com.miles.xiuda.pojo.Constants.MenuType;
import com.miles.xiuda.pojo.SysMenu;
import com.miles.xiuda.service.SysMenuService;
import com.miles.xiuda.util.Retmap;

/**
 *  类名：SysMenuController.java
 *  说明：系统菜单
 *  创建时间：2017年1月1日 上午2:02:55
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
@Controller
@RequestMapping("/sys/menu")
public class SysMenuController extends AbstractController {

	@Resource
	private SysMenuService sysMenuService;

	/**
	 * 所有菜单列表
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("offset", 0);
		map.put("limit", 30);

		// 查询列表数据
		List<SysMenu> menuList = sysMenuService.queryList(map);

		model.addAttribute("list", menuList);
		return "sys/menu-list";
	}

	@RequestMapping(value = "/menu-edit", method = RequestMethod.GET)
	public String menuEdit(@RequestParam(value = "parentId", required = false) Long parentId,
			@RequestParam(value = "menuId" , required = false) Long menuId, Model model) {
		SysMenu parent = null;
		SysMenu menu = new SysMenu();
		if(parentId != null) {
			parent = sysMenuService.queryObject(parentId);
			menu.setParentId(parentId);
			menu.setType(parent.getType() + 1);
			menu.setParentIds(parent.makeSelfAsParentIds());
		} else if(menuId == null){
			menu.setParentId(0L);
			menu.setType(0);
			menu.setParentIds("0/");
		}
		if(menuId  != null) {
			menu = sysMenuService.queryObject(menuId);
			parent = sysMenuService.queryObject(menu.getParentId());
		}
		model.addAttribute("parent", parent);
		model.addAttribute("menu", menu);
		return "sys/menu-edit";
	}

	/**
	 * 选择菜单(添加、修改菜单)
	 */
	@RequestMapping("/select")
	@RequiresPermissions("sys:menu:select")
	public Retmap select() {
		// 查询列表数据
		List<SysMenu> menuList = sysMenuService.queryNotButtonList();

		// 添加顶级菜单
		SysMenu root = new SysMenu();
		root.setMenuId(0L);
		root.setName("一级菜单");
		root.setParentId(-1L);
		root.setOpen(true);
		menuList.add(root);

		return Retmap.ok().put("menuList", menuList);
	}

	/**
	 * 角色授权菜单
	 */
	@ResponseBody
	@RequestMapping(value = "/perms", method = RequestMethod.GET)
	public Retmap perms() {
		// 查询列表数据
		List<SysMenu> menuList = sysMenuService
				.queryList(new HashMap<String, Object>());

		return Retmap.ok().put("menuList", menuList);
	}

	/**
	 * 菜单信息
	 */
	@RequestMapping("/info/{menuId}")
	public Retmap info(@PathVariable("menuId") Long menuId) {
		SysMenu menu = sysMenuService.queryObject(menuId);
		return Retmap.ok().put("menu", menu);
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Retmap save(@RequestBody SysMenu menu) {
		// 数据校验
//		verifyForm(menu);
		if(menu.getMenuId() != null) {
			sysMenuService.update(menu);
		} else{
			sysMenuService.save(menu);
		}
		return Retmap.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:menu:update")
	public Retmap update(@RequestBody SysMenu menu) {
		// 数据校验
		verifyForm(menu);

		sysMenuService.update(menu);

		return Retmap.ok();
	}

	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Retmap delete(Long menuId) {
		if (menuId.longValue() <= 28) {
			return Retmap.error("系统菜单，不能删除");
		}
		SysMenu menu = sysMenuService.queryObject(menuId);
		if(menu != null) {
			sysMenuService.delete(menu);
			return Retmap.ok();
		} else {
			return Retmap.error("找不到指定菜单，无法删除");
		}

	}

	/**
	 * 用户菜单列表
	 */
	@ResponseBody
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Retmap user() {
		List<SysMenu> menuList = sysMenuService.getUserMenuList(getUserId());

		return Retmap.ok().put("menuList", menuList);
	}

	/**
	 * 用户菜单列表
	 */
	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public Retmap test() {

		return Retmap.ok();
	}
	
	/**
	 * 验证参数是否正确
	 */
	private void verifyForm(SysMenu menu) {
		if (StringUtils.isBlank(menu.getName())) {
			throw new RTException("菜单名称不能为空");
		}

		if (menu.getParentId() == null) {
			throw new RTException("上级菜单不能为空");
		}

		// 菜单
		if (menu.getType() == MenuType.MENU.getValue()) {
			if (StringUtils.isBlank(menu.getUrl())) {
				throw new RTException("菜单URL不能为空");
			}
		}

		// 上级菜单类型
		int parentType = MenuType.CATALOG.getValue();
		if (menu.getParentId() != 0) {
			SysMenu parentMenu = sysMenuService.queryObject(menu.getParentId());
			parentType = parentMenu.getType();
		}

		// 目录、菜单
		if (menu.getType() == MenuType.CATALOG.getValue()
				|| menu.getType() == MenuType.MENU.getValue()) {
			if (parentType != MenuType.CATALOG.getValue()) {
				throw new RTException("上级菜单只能为目录类型");
			}
			return;
		}

		// 按钮
		if (menu.getType() == MenuType.BUTTON.getValue()) {
			if (parentType != MenuType.MENU.getValue()) {
				throw new RTException("上级菜单只能为菜单类型");
			}
			return;
		}
	}

}
