package com.jyyr.service;
import java.util.List;

import com.jyyr.orm.TbCountryTopDay;
public interface TbCountryTopDayService {
	/**
	 * װ�����һ�����������ǰʮ��
	 * @param statisDate
	 * @return
	 */	
	public List<TbCountryTopDay> loadCountyMagerTop(String statisDate,String county);
	
	/**
	 * �ж��Ƿ��������ļ�¼
	 * @param statisDate
	 * @param county
	 * @return
	 */
	public boolean isExists(String statisDate,String county);
}
