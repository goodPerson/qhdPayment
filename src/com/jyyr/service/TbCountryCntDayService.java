package com.jyyr.service;
import com.jyyr.orm.TbCountryCntDay;

public interface TbCountryCntDayService {
	/**
	 * 装载制定日期的区县日统计
	 * param county 区县名称
	 * param staticDate 统计日期
	 */

	public TbCountryCntDay loadTbCountryCntDay(String county,String staticDate);
	/**
	 * 判断指定条查询是否存在记录
	 * @param county
	 * @param staticDate
	 * @return
	 */
	public boolean isExists(String county,String staticDate);
}
