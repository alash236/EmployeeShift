package com.example.p01.vo.ClockDateVo;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShiftWorkList {

	private int shiftWorkId;

	private LocalTime startTime;

	private LocalTime endTime;

	public ShiftWorkList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShiftWorkList(int shiftWorkId, LocalTime startTime, LocalTime endTime) {
		super();
		this.shiftWorkId = shiftWorkId;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getShiftWorkId() {
		return shiftWorkId;
	}

	public void setShiftWorkId(int shiftWorkId) {
		this.shiftWorkId = shiftWorkId;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

}
