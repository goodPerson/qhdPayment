package com.jyyr.service;

import java.util.List;

import com.jyyr.orm.TbCityMonDevScorePayInfoMon;

public interface TbCityMonDevScorePayInfoMonService {
	/**
	 * 查询今年所有的记录
	 * @lyk
	 */
	public List<TbCityMonDevScorePayInfoMon> findall();
	/**
	 * 查询去年所有的记录
	 * @lyk
	 */
	public List<TbCityMonDevScorePayInfoMon> findall1();

}
