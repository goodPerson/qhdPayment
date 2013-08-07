package com.jyyr.service;

import java.util.List;

import com.jyyr.orm.TBMangerPieceSmallDay;
import com.jyyr.orm.TBMangerPieceSmallMonth;
import com.jyyr.orm.TbBasicInfoM;

public interface TBMangerPieceSmallDayService {
	/**
	 * 渠道经理计件分项月统计明细 分页
	 * @param 日期、县区、姓名、员工编号、渠道编码、渠道名称
	 * @return
	 */
	 public List findMagerPieceDay(String statisDate, String countyName, String name, String id, String prncpChnlId, String prncpChnlName, String bigPieceName, 
	            String smallPieceName, int pageNo, int pageSize);
	
	/**
	 * 渠道经理计件分项月统计数量
	 * @param 日期、县区、姓名、员工编号、渠道编码、渠道名称
	 * @return
	 */
	public int countMagerPieceDay(String statisDate ,String countyName,String name,String id,String prncpChnlId ,String prncpChnlName,String bigPieceName, String smallPieceName);
	
	/**
	 * 渠道经理计件分项月统计明细下载
	 * @param 日期、县区、姓名、员工编号、渠道编码、渠道名称
	 * @return
	 */
	 public List findMagerPieceDayNoPage(String statisDate, String countyName, String name, String id, String prncpChnlId, String prncpChnlName, String bigPieceName, 
	            String smallPieceName);
	
	/**获取指定Id的对象集合*/
	public List<TbBasicInfoM> findUserById(String id);
	/**
	 * 查询所有的县区
	 */
	public List<String> findAllCounty(String countyName);
	/**
	 * 查询所有的姓名
	 */
	public List<String > findAllnames(String name,String post,String county);
	
	 public List findAllbig();
	  public String findchnlid(String prncpChnlName);
	  public String findchnlname(String prncpChnlId);
	    public List findAllsmall(String bigpiecename);
}
