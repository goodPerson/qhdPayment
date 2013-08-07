package com.jyyr.service;
import java.util.List;

import com.jyyr.orm.TbCountryChnlDescDay;
public interface TbCountryChnlDescDayService {
	/**
	 * 装载后十名
	 * @param statisDate
	 * @param county
	 * @return
	 */
	public List<TbCountryChnlDescDay> loadTbCountryChnlDescDay(String statisDate ,String county);
	/**
	 * 是否存在
	 * @param statisDate
	 * @param county
	 * @return
	 */
	public boolean isExists(String statisDate ,String county);

}
