package com.jyyr.service;

import com.jyyr.orm.TbMonthLineChart;

public interface TbMonthLineChartService {
	/**
	 * 月统计折线图 接口
	 */
	
	/**
	 * 装载制定渠道经理对象
	 */
	public TbMonthLineChart loadtbMonthLineChart(String id, String sType);
}
