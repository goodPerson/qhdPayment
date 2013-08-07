package com.jyyr.service.impl;

import com.jyyr.dao.BaseDAO;
import com.jyyr.service.TbDayCountsDetailService;

public class TbDayCountsDetailServiceImpl implements TbDayCountsDetailService {
	BaseDAO dao;

	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}
	
}
