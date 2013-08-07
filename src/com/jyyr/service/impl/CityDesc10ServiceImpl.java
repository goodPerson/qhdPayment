package com.jyyr.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbChnlMagrScoreDesc10M;
import com.jyyr.service.CityDesc10Service;

public class CityDesc10ServiceImpl implements CityDesc10Service{
	/** 通过依赖注入DAO组件实例 */

	BaseDAO dao;

	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}
	
	@SuppressWarnings("unchecked")
	public List<TbChnlMagrScoreDesc10M> desc10(String statisMonth){
		Date date=new Date();
		SimpleDateFormat from = new SimpleDateFormat("yyyyMMdd"); //这里的格式可以自己设置 
		//format()方法是用来格式化时间的方法 
		String times = from.format(date); 	
				
		return dao.query("from TbChnlMagrScoreDesc10M as a where a.STATIS_MONTH='"+statisMonth+"' and a.DESC_ORDER<11 order by a.DESC_ORDER ");
		//fetch first 10 rows only
	}
}
