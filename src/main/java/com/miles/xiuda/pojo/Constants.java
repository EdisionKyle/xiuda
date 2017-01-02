package com.miles.xiuda.pojo;

public class Constants {

	/**
	 *  说明：菜单类型
	 *  创建时间：2016年12月31日 下午11:26:04
	 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
	 *  @author milesloner
	 */
	public enum MenuType {
		/**
		 * 目录
		 */
		CATALOG(0),
		/**
		 * 菜单
		 */
		MENU(1),
		/**
		 * 按钮
		 */
		BUTTON(2);

		private int value;

		private MenuType(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	/*
	 * 前台返回数据标识
	 */
	public static final String DATA = "data";

}
