package com.jyyr.service;
import java.util.List;

import com.jyyr.orm.TbMagerDayCounts;
import com.jyyr.orm.TbMangerMonthBigClassCounts;
import com.jyyr.orm.TbReckonPiecePayDealInfoD;
/**
 * 渠道计件项目日明细信息查询接口
 * @author ywz
 *
 */
public interface TbReckonPiecePayDealInfoDService {

	/**
	 * 渠道经理大类业务统计
	 */
	public TbMangerMonthBigClassCounts magerBigClassPayCount(String staffId);
	/**
	 * 渠道经理日统计
	 */
	public TbMagerDayCounts ChnlMagerDayCount(String staffId );
	
	
	/**
	 * 装载指定渠道经理业绩信息
	 */
	public TbReckonPiecePayDealInfoD loadTbrppdinif(String staffId);
	
	/**
	 * 渠道经理渠道数量
	 */
	public int chanlCounts(String param);
	
	/**
	 * 渠道经理积分统计
	 */	
	public float scoreCounts(String param);
	/**
	 * 渠道经理薪酬统计
	 */	
	public float payCounts(String param);
	/**
	 * 大类业务薪酬统计
	 */	
	public float bigClassPayCounts(String bigClassName, String workerNo);
	
	
	/**获取 日积分*/
	public float scoreDayCounts(String workerNo,String yearMontheDay);
	
	/**浏览详细业务信息*/
	public List<TbReckonPiecePayDealInfoD> browserBusDetail(String workerNo,String yearMontheDay, int pageSize, int pager);
	
	/**查询详细业务数量*/
	public int queryCountsDetail(String workerNo,String yearMontheDay,int pageSize , int pager);
}
