package com.jyyr.service;

import java.util.List;

import com.jyyr.orm.TbMangerMonthBigClassCounts;

public interface TbMangerMonthBigClassCountsService {
   /**
    * ���´�����ϸ���
    */
	
	public List<TbMangerMonthBigClassCounts> browerTbMangerMonthBigClassCounts(String staffId, String staticDate, int pageSize, int pager);
   /**
    * ���´�����ϸ����
    */
	public int bigClassCounts(String staffId,String staticDate);
	/**
	 * ���ش�����ϸ
	 * @param staffId
	 * @param staticDate
	 * @return
	 */
	public List<TbMangerMonthBigClassCounts> loadTbMangerMonthBigClassCounts(String staffId, String staticDate);
}
