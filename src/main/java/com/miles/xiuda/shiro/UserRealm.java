package com.miles.xiuda.shiro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.miles.xiuda.pojo.SysMenu;
import com.miles.xiuda.pojo.SysUser;
import com.miles.xiuda.service.SysMenuService;
import com.miles.xiuda.service.SysUserService;

/**
 *  类名：UserRealm.java
 *  说明：认证/授权
 *  创建时间：2017年1月1日 下午5:08:32
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
public class UserRealm extends AuthorizingRealm {

	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysMenuService sysMenuService;

	/**
	 * 授权(验证权限时调用)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SysUser user = (SysUser) principals.getPrimaryPrincipal();
		Long userId = user.getUserId();

		List<String> permsList = null;

		// 系统管理员，拥有最高权限
		if (userId == 1) {
			List<SysMenu> menuList = sysMenuService
					.queryList(new HashMap<String, Object>());
			permsList = new ArrayList<>(menuList.size());
			for (SysMenu menu : menuList) {
				permsList.add(menu.getPerms());
			}
		} else {
			permsList = sysUserService.queryAllPerms(userId);
		}

		// 用户权限列表
		Set<String> permsSet = new HashSet<String>();
		for (String perms : permsList) {
			if (StringUtils.isBlank(perms)) {
				continue;
			}
			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
		}

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permsSet);
		return info;
	}

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());

		// 查询用户信息
		SysUser user = sysUserService.queryByUserName(username);

		// 账号不存在
		if (user == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}

		// 密码错误
		if (!password.equals(user.getPassword())) {
			throw new IncorrectCredentialsException("账号或密码不正确");
		}

		// 账号锁定
		if (user.getStatus() == 0) {
			throw new LockedAccountException("账号已被锁定,请联系管理员");
		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,
				password, getName());
		return info;
	}

}
