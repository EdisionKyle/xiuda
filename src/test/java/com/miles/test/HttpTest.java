package com.miles.test;

import com.miles.xiuda.util.HttpUtil;

public class HttpTest {

	public static void main(String[] args) {

		String url = "http://localhost:8080/vshare/user/detail";
		String result = HttpUtil.getInstance().sendHttpGet(url);
		System.out.println(result);
	}

}
