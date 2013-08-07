package com.jyyr.service;

import java.util.List;

import com.jyyr.orm.TbMangerMonthBigClassCounts;

public interface TbMangerMonthBigClassCountsService {
   /**
    * 当月大类明细浏览
    */
	
	public List<TbMangerMonthBigClassCounts> browerTbMangerMonthBigClassCounts(String staffId, String staticDate, int pageSize, int pager);
   /**
    * 当月大类明细数量
    */
	public int bigClassCounts(String staffId,String staticDate);
	/**
	 * 下载大类明细
	 * @param staffId
	 * @param staticDate
	 * @return
	 */
	public List<TbMangerMonthBigClassCounts> loadTbMangerMonthBigClassCounts(String staffId, String staticDate);
}
