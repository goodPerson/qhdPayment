package com.jyyr.service;
import java.util.List;

import com.jyyr.orm.TbCountryCountsMonth;

public interface TbCountryCountsMonthService {
	/**
	 * װ���ƶ�������ͳ��
	 * @param statisMonth
	 * @param county
	 * @return
	 */
	public TbCountryCountsMonth loadAssignCountyMonth(String statisMonth, String county);
	/**
	 * �жϲ�ѯ�������Ƿ����
	 * @param statisMonth
	 * @param county
	 * @return
	 */
	public boolean isExists(String statisMonth, String county);
	/**
	 * ��ѯ���е��������
	 */
	public List<TbCountryCountsMonth> findMaxdate();
}
