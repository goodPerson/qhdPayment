package com.jyyr.service;
import com.jyyr.orm.TbCountyStaticMonth;
public interface TbCountyStaticMonthService {
	/**
	 * ��������µ�����
	 * @param county
	 * @param staticMonth
	 * @return
	 */
	public TbCountyStaticMonth loadrecently(String county, String staticMonth,String sType);
}
