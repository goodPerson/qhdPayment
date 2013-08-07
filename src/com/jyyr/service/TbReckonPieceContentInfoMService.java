package com.jyyr.service;

import java.util.List;
import com.jyyr.orm.TbReckonPieceContentInfoM;

/**
 * 计件目录信息查询与维护接口
 * 
 * @author 董晓斌
 * 
 */
public interface TbReckonPieceContentInfoMService {
	/**
	 * 分页获取计件目录记录
	 * 
	 * @param staticMonth1
	 *            起始时间
	 * @param staticMonth2
	 *            截止时间
	 * @param bigPiece
	 *            计件大类
	 * @param smallPiece计件分项
	 * @param pageSize
	 *            页面显示记录数
	 * @param pager
	 *            第几页
	 * @return 返回集合
	 */
	public List<TbReckonPieceContentInfoM> findPieceContent(
			String staticMonth1, String staticMonth2, String bigPiece,
			String smallPiece, int pageSize, int pager);

	/**
	 * 获取计件目录记录数
	 * 
	 * @param staticMonth1
	 *            起始时间
	 * @param staticMonth2
	 *            截止时间
	 * @param bigPiece计件大类
	 * @param smallPiece计件分项
	 * @return 返回集合数目
	 */
	public int findPieceContentCount(String staticMonth1, String staticMonth2,
			String bigPiece, String smallPiece);

	/**
	 * 删除计件目录信息
	 * 
	 * @param id
	 *            删除计件目录ID
	 * @return
	 */
	public boolean deletePieceContentByID(String id);

	/**
	 * 添加或修改计件目录信息
	 * 
	 * @param month
	 *            月份
	 * @param bigPieceCls
	 *            计件大类
	 * @param pieceType
	 *            计件分项
	 * @param scoreVal
	 *            积分值
	 * @param piecePrice
	 *            积分单价
	 * @return
	 */
	public Boolean addOrUpdatePieceContent(String month, String bigPieceCls,
			String pieceType, String scoreVal, String piecePrice);

	/**
	 * 导出计件目录信息
	 * 
	 * @param staticMonth1
	 *            起始时间
	 * @param staticMonth2
	 *            截至时间
	 * @param bigPiece
	 *            计件大类
	 * @param smallPiece
	 *            计件分项
	 * @return
	 */
	public List exportyPieceContent(String staticMonth1, String staticMonth2,
			String bigPiece, String smallPiece);

	/**
	 * 导入计件目录
	 * 
	 * @param impList
	 *            导入的集合
	 */
	public void importPieceContent(List<TbReckonPieceContentInfoM> impList);

	/**
	 * 判断记录是否存在
	 * 
	 * @param hql
	 *            判断sql
	 * @return
	 */
	public boolean isExistPieceContent(String hql);
}
