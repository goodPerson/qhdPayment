package com.jyyr.service;

import com.jyyr.orm.TbCountryTotalMonth;
public interface TbCountryTotalMonthService {
	
	/**
	 * װ����ͳ����
	 * @param statisMonth
	 * @param county
	 * @return
	 */
	public TbCountryTotalMonth loadCountryTotalMonth(String statisMonth,String county);

}
