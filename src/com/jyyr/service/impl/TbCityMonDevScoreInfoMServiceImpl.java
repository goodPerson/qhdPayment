package com.jyyr.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbCityMonDevScoreInfoM;
import com.jyyr.service.TbCityMonDevScoreInfoMService;

public class TbCityMonDevScoreInfoMServiceImpl implements TbCityMonDevScoreInfoMService {
	/** 通过依赖注入DAO组件实例 */

	BaseDAO dao;

	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}
	
	/* (non-Javadoc)
	 * @see com.jyyr.service.impl.TbCityMonDevScoreInfoMService#getData()
	 */
	@SuppressWarnings("unchecked")
	public List<TbCityMonDevScoreInfoM> getData(String statisMonth) {
		Date date=new Date();
		SimpleDateFormat from = new SimpleDateFormat("yyyyMMdd"); //这里的格式可以自己设置 
		//format()方法是用来格式化时间的方法 
		String times = from.format(date); 
		System.out.println("月份："+times.substring(0, 6));
		return dao.query("from TbCityMonDevScoreInfoM as a where a.STATIS_MONTH='"+statisMonth+"'"); 
	}
}
