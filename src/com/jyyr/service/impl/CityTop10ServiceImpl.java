package com.jyyr.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbChnlMagrScoreTop10M;
import com.jyyr.service.CityTop10Service;

public class CityTop10ServiceImpl implements CityTop10Service {
	/** ͨ������ע��DAO���ʵ�� */

	BaseDAO dao;

	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}
		
	@SuppressWarnings("unchecked")
	public List<TbChnlMagrScoreTop10M> top10(String statisMonth) {
		Date date=new Date();
		SimpleDateFormat from = new SimpleDateFormat("yyyyMMdd"); //����ĸ�ʽ�����Լ�����
		//format()������������ʽ��ʱ��ķ���
		String times = from.format(date);
		

		return dao.query("from TbChnlMagrScoreTop10M as a where a.STATIS_MONTH='"+statisMonth+"' and a.CHNL_MAGR_ORDER<11 order by a.CHNL_MAGR_ORDER ");
		//fetch first 10 rows only
	}

	public TbChnlMagrScoreTop10M findmaxmonth() {
		String hql="from TbChnlMagrScoreTop10M as a order by a.STATIS_MONTH desc ";
		return (TbChnlMagrScoreTop10M) dao.loadObject(hql);
	}
	
}
