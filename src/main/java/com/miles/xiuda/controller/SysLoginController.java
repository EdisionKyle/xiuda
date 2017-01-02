package com.miles.xiuda.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.miles.xiuda.util.Retmap;
import com.miles.xiuda.util.ShiroUtil;

/**
 *  类名：SysLoginController.java
 *  说明：登录相关
 *  创建时间：2017年1月1日 上午1:41:23
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
@Controller
public class SysLoginController {

	@Resource
	private Producer captchaProducer;

	@RequestMapping("/kaptchaImage")
	public void captcha(HttpServletResponse response) throws ServletException,
			IOException {
		response.setDateHeader("Expires", 0);
		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
		// return image/jpeg
		response.setContentType("image/jpeg");
		// 生成文字验证码
		String text = captchaProducer.createText();
		// 生成图片验证码
		BufferedImage image = captchaProducer.createImage(text);
		// 保存到shiro session
//		ShiroUtil.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
	}

	/**
	 * 登录
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/login", method = RequestMethod.POST)
	public Retmap login(String username, String password, String captcha)
			throws IOException {
//		String kaptcha = ShiroUtil.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
//		if (!captcha.equalsIgnoreCase(kaptcha)) {
//			return Retmap.error("验证码不正确");
//		}
		try {
			Subject subject = ShiroUtil.getSubject();
			// sha256加密
			password = new Sha256Hash(password).toHex();
			UsernamePasswordToken token = new UsernamePasswordToken(username,
					password);
			subject.login(token);
		} catch (UnknownAccountException e) {
			return Retmap.error(e.getMessage());
		} catch (IncorrectCredentialsException e) {
			return Retmap.error(e.getMessage());
		} catch (LockedAccountException e) {
			return Retmap.error(e.getMessage());
		} catch (AuthenticationException e) {
			return Retmap.error("账户验证失败");
		}

		return Retmap.ok();
	}

	/**
	 * 退出
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		ShiroUtil.logout();
		return "redirect:login.html";
	}

}
