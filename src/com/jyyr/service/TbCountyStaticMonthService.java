package com.jyyr.service;
import com.jyyr.orm.TbCountyStaticMonth;
public interface TbCountyStaticMonthService {
	/**
	 * 返回最近月的数据
	 * @param county
	 * @param staticMonth
	 * @return
	 */
	public TbCountyStaticMonth loadrecently(String county, String staticMonth,String sType);
}
