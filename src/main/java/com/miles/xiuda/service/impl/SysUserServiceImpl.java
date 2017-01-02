package com.miles.xiuda.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miles.xiuda.dao.SysUserDao;
import com.miles.xiuda.pojo.SysUser;
import com.miles.xiuda.service.SysUserRoleService;
import com.miles.xiuda.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Resource
	private SysUserDao sysUserDao;
	@Resource
	private SysUserRoleService sysUserRoleService;

	@Override
	public List<String> queryAllPerms(Long userId) {
		return sysUserDao.queryAllPerms(userId);
	}

	@Override
	public List<Long> queryAllMenuId(Long userId) {
		return sysUserDao.queryAllMenuId(userId);
	}

	@Override
	public SysUser queryByUserName(String username) {
		return sysUserDao.queryByUserName(username);
	}

	@Override
	public SysUser queryObject(Long userId) {
		return sysUserDao.queryObject(userId);
	}

	@Override
	public List<SysUser> queryList(Map<String, Object> map) {
		return sysUserDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysUserDao.queryTotal(map);
	}

	@Override
	@Transactional
	public void save(SysUser user) {
		user.setCreateTime(new Date());
		// sha256加密
		user.setPassword(new Sha256Hash(user.getPassword()).toHex());
		sysUserDao.save(user);

		// 保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
	}

	@Override
	@Transactional
	public void update(SysUser user) {
		if (StringUtils.isBlank(user.getPassword())) {
			user.setPassword(null);
		} else {
			user.setPassword(new Sha256Hash(user.getPassword()).toHex());
		}
		sysUserDao.update(user);

		// 保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
	}

	@Override
	@Transactional
	public void deleteBatch(Long[] userId) {
		sysUserDao.deleteBatch(userId);
	}

	@Override
	public int updatePassword(Long userId, String password, String newPassword) {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("password", password);
		map.put("newPassword", newPassword);
		return sysUserDao.updatePassword(map);
	}

}
