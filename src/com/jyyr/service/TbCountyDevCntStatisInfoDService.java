package com.jyyr.service;

import java.util.List;

import com.jyyr.orm.TbCountyDevCntStatisInfoD;

public interface TbCountyDevCntStatisInfoDService {

	public abstract List<TbCountyDevCntStatisInfoD> browserCntStatisInfoDs(String statisDate);
	
	public List<TbCountyDevCntStatisInfoD> findall();

}