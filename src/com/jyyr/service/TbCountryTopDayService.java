package com.jyyr.service;
import java.util.List;

import com.jyyr.orm.TbCountryTopDay;
public interface TbCountryTopDayService {
	/**
	 * 装载最近一天的渠道经理前十名
	 * @param statisDate
	 * @return
	 */	
	public List<TbCountryTopDay> loadCountyMagerTop(String statisDate,String county);
	
	/**
	 * 判断是否存在最近的记录
	 * @param statisDate
	 * @param county
	 * @return
	 */
	public boolean isExists(String statisDate,String county);
}
