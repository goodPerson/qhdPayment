package com.jyyr.service;

import java.util.List;

import com.jyyr.orm.TbChnlMagrScoreTop10M;

public interface CityTop10Service {

	@SuppressWarnings("unchecked")
	public List<TbChnlMagrScoreTop10M> top10(String statisMonth);
	
	public TbChnlMagrScoreTop10M findmaxmonth();

}