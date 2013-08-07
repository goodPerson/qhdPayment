package com.jyyr.service;

import java.util.List;

import com.jyyr.orm.TbCityPieceMClsInfoM;
import com.jyyr.orm.TbCountyServCntInfoD;

public interface TbCityPieceMClsInfoMService {
	/**
	 * 查询当天所有大类营销情况；
	 * @param statisDate
	 * @return
	 */
	public List<TbCityPieceMClsInfoM> findpiece(String statisDate);
	/**
	 * 查询各县营销情况；
	 */
	public List<TbCountyServCntInfoD> findcounty(String statisDate);
	/**
	 * 查询最大日期
	 */
	public List<TbCityPieceMClsInfoM> findmaxdate();

}
