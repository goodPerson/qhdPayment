package com.jyyr.service;

import java.util.List;

import com.jyyr.orm.TbCityMonDevScoreInfoM;

public interface TbCityMonDevScoreInfoMService {

	@SuppressWarnings("unchecked")
	public abstract List<TbCityMonDevScoreInfoM> getData(String statisMonth);

}