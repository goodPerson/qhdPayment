package com.jyyr.service;
import java.util.List;

import com.jyyr.orm.TbCountryCountsMonth;

public interface TbCountryCountsMonthService {
	/**
	 * 装载制定的区县统计
	 * @param statisMonth
	 * @param county
	 * @return
	 */
	public TbCountryCountsMonth loadAssignCountyMonth(String statisMonth, String county);
	/**
	 * 判断查询的条件是否存在
	 * @param statisMonth
	 * @param county
	 * @return
	 */
	public boolean isExists(String statisMonth, String county);
	/**
	 * 查询表中的最大日期
	 */
	public List<TbCountryCountsMonth> findMaxdate();
}
