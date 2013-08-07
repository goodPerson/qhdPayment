package com.jyyr.service;

import java.util.List;

import com.jyyr.orm.TbChnlMagrScoreDesc10M;

public interface CityDesc10Service {

	@SuppressWarnings("unchecked")
	public abstract List<TbChnlMagrScoreDesc10M> desc10(String statisMonth);

}