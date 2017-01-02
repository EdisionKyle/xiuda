package com.miles.xiuda.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.miles.xiuda.util.Retmap;

/**
 *  类名：RTExceptionHandler.java
 *  说明：异常统一拦截器
 *  创建时间：2017年1月1日 上午3:32:02
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
public class RTExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request
				.getHeader("X-Requested-With") != null && request.getHeader(
				"X-Requested-With").indexOf("XMLHttpRequest") > -1))) {// 同步请求
			ModelAndView mav = new ModelAndView("error");
			return mav;
		} else {// 异步请求
			Retmap r = new Retmap();
			try {
				if (ex instanceof RTException) {
					r.put("code", ((RTException) ex).getCode());
					r.put("msg", ((RTException) ex).getMessage());
				} else if (ex instanceof DuplicateKeyException) {
					r = Retmap.error("数据库中已存在该记录");
				} else if (ex instanceof AuthorizationException) {
					r = Retmap.error("没有权限，请联系管理员授权");
				} else {
					r = Retmap.error();
				}
				PrintWriter writer = response.getWriter();
				writer.write(JSONObject.toJSONString(r));
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

}
