package com.jyyr.service;
import com.jyyr.orm.TbCountryCntDay;

public interface TbCountryCntDayService {
	/**
	 * װ���ƶ����ڵ�������ͳ��
	 * param county ��������
	 * param staticDate ͳ������
	 */

	public TbCountryCntDay loadTbCountryCntDay(String county,String staticDate);
	/**
	 * �ж�ָ������ѯ�Ƿ���ڼ�¼
	 * @param county
	 * @param staticDate
	 * @return
	 */
	public boolean isExists(String county,String staticDate);
}
