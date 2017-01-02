package com.miles.xiuda.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miles.xiuda.pojo.SysUser;
import com.miles.xiuda.service.SysUserRoleService;
import com.miles.xiuda.service.SysUserService;
import com.miles.xiuda.util.PageUtil;
import com.miles.xiuda.util.Retmap;
import com.miles.xiuda.util.ShiroUtil;

/**
 *  类名：SysUserController.java
 *  说明：系统用户
 *  创建时间：2017年1月1日 上午2:08:36
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {

	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysUserRoleService sysUserRoleService;

	/**
	 * 所有用户列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:user:list")
	public Retmap list(Integer page, Integer limit) {
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		// 查询列表数据
		List<SysUser> userList = sysUserService.queryList(map);
		int total = sysUserService.queryTotal(map);
		PageUtil pageUtil = new PageUtil(userList, total, limit, page);
		return Retmap.ok().put("page", pageUtil);
	}

	/**
	 * 获取登录的用户信息
	 */
	@RequestMapping("/info")
	public Retmap info() {
		return Retmap.ok().put("user", getUser());
	}

	/**
	 * 修改登录用户密码
	 */
	@RequestMapping("/password")
	public Retmap password(String password, String newPassword) {
		if (StringUtils.isBlank(newPassword)) {
			return Retmap.error("新密码不为能空");
		}
		// sha256加密
		password = new Sha256Hash(password).toHex();
		// sha256加密
		newPassword = new Sha256Hash(newPassword).toHex();
		// 更新密码
		int count = sysUserService.updatePassword(getUserId(), password,
				newPassword);
		if (count == 0) {
			return Retmap.error("原密码不正确");
		}
		// 退出
		ShiroUtil.logout();
		return Retmap.ok();
	}

	/**
	 * 用户信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("sys:user:info")
	public Retmap info(@PathVariable("userId") Long userId) {
		SysUser user = sysUserService.queryObject(userId);
		// 获取用户所属的角色列表
		List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
		user.setRoleIdList(roleIdList);
		return Retmap.ok().put("user", user);
	}

	/**
	 * 保存用户
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:user:save")
	public Retmap save(@RequestBody SysUser user) {
		if (StringUtils.isBlank(user.getUsername())) {
			return Retmap.error("用户名不能为空");
		}
		if (StringUtils.isBlank(user.getPassword())) {
			return Retmap.error("密码不能为空");
		}
		sysUserService.save(user);
		return Retmap.ok();
	}

	/**
	 * 修改用户
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:user:update")
	public Retmap update(@RequestBody SysUser user) {
		if (StringUtils.isBlank(user.getUsername())) {
			return Retmap.error("用户名不能为空");
		}
		sysUserService.update(user);
		return Retmap.ok();
	}

	/**
	 * 删除用户
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:user:delete")
	public Retmap delete(@RequestBody Long[] userIds) {
		if (ArrayUtils.contains(userIds, 1L)) {
			return Retmap.error("系统管理员不能删除");
		}
		if (ArrayUtils.contains(userIds, getUserId())) {
			return Retmap.error("当前用户不能删除");
		}
		sysUserService.deleteBatch(userIds);
		return Retmap.ok();
	}

}
