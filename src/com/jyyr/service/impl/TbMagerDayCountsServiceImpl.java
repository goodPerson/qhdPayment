package com.jyyr.service.impl;

import com.jyyr.dao.BaseDAO;
import com.jyyr.service.TbMagerDayCountsService;

public class TbMagerDayCountsServiceImpl implements TbMagerDayCountsService {
	BaseDAO dao;

	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}
	
}
