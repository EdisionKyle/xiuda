package com.miles.xiuda.dao;

import java.util.List;
import java.util.Map;

/**
 *  类名：BaseDao.java
 *  说明：Dao基类
 *  创建时间：2016年12月31日 下午10:53:33
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
public interface BaseDao<T> {

	void save(T t);

	void save(Map<String, Object> map);

	void saveBatch(List<T> list);

	int update(T t);

	int update(Map<String, Object> map);

	int delete(Object id);

	int delete(Map<String, Object> map);

	int deleteBatch(Object[] id);

	T queryObject(Object id);

	List<T> queryList(Map<String, Object> map);

	List<T> queryList(Object id);

	int queryTotal(Map<String, Object> map);

	int queryTotal();

}
