package com.jyyr.service;
import java.util.List;

import com.jyyr.orm.TbCountryChnlDescDay;
public interface TbCountryChnlDescDayService {
	/**
	 * װ�غ�ʮ��
	 * @param statisDate
	 * @param county
	 * @return
	 */
	public List<TbCountryChnlDescDay> loadTbCountryChnlDescDay(String statisDate ,String county);
	/**
	 * �Ƿ����
	 * @param statisDate
	 * @param county
	 * @return
	 */
	public boolean isExists(String statisDate ,String county);

}
