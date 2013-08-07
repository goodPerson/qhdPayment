package com.jyyr.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbCountyDevCntStatisInfoD;
import com.jyyr.service.TbCountyDevCntStatisInfoDService;

public class TbCountyDevCntStatisInfoDServiceImpl implements TbCountyDevCntStatisInfoDService {

	BaseDAO dao;

	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see com.jyyr.service.impl.TbCountyDevCntStatisInfoDService#browserCntStatisInfoDs()
	 */
	public List<TbCountyDevCntStatisInfoD> findall() {
		String hql="from TbCountyDevCntStatisInfoD as a order by a.STATIS_DATE desc";
		return dao.query(hql);
	}
	@SuppressWarnings("unchecked")
	public List<TbCountyDevCntStatisInfoD> browserCntStatisInfoDs(String statisDate) {
//		Date date = new Date(); 
//		//format������������ָ����ʱ���ʽ��ʽ��ʱ��� 
//		SimpleDateFormat from = new SimpleDateFormat("yyyyMMdd"); //����ĸ�ʽ�����Լ����� 
//		//format()������������ʽ��ʱ��ķ��� 
//		String times = from.format(date); 
//		System.out.println(times);
		String hql="from TbCountyDevCntStatisInfoD as a where a.STATIS_DATE='"+statisDate+"' order by a.COUNTY";
		
		return dao.query(hql);
	}

	
}
