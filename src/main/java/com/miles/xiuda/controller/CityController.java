package com.miles.xiuda.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miles.xiuda.pojo.Constants;
import com.miles.xiuda.service.CityService;

@Controller
@RequestMapping("/city")
public class CityController {

	@Resource
	private CityService cityService;

	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constants.DATA, cityService.getAllCity());
		return map;
	}

	@RequestMapping(value = "/detail/${bianhao}")
	@ResponseBody
	public Map<String, Object> detail(@PathVariable("bianhao") String bianhao) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constants.DATA, cityService.getCityById(bianhao));
		return map;
	}

}
