package com.example.p01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.p01.dao.ClockDateDao;
import com.example.p01.dto.ClockOffDto;
import com.example.p01.service.ifs.ClockDateService;
import com.example.p01.service.impl.ClockServiceImpl;
import com.example.p01.vo.ClockDateVo.AddClockDateRes;
import com.example.p01.vo.ClockDateVo.AddClockOffReq;
import com.example.p01.vo.ClockDateVo.AddClockOnReq;
import com.example.p01.vo.ClockDateVo.FixClockReq;
import com.example.p01.vo.ClockDateVo.GetOneRes;
import com.example.p01.vo.headVo.BasicRes;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClockDateController2 {

	@Autowired
	private ClockDateService clockDateService;

	@Autowired
	private ClockDateDao clockDateDao;

	// 下班打卡2
	@PostMapping(value = "/clock/off2")
	public BasicRes clickOff2(@RequestBody ClockOffDto dto) throws Exception {
		return clockDateService.clockOff2(dto);
	}

}
