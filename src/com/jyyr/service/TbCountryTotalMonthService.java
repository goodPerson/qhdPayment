package com.jyyr.service;

import com.jyyr.orm.TbCountryTotalMonth;
public interface TbCountryTotalMonthService {
	
	/**
	 * 装载总统计量
	 * @param statisMonth
	 * @param county
	 * @return
	 */
	public TbCountryTotalMonth loadCountryTotalMonth(String statisMonth,String county);

}
