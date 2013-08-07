package com.jyyr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.record.formula.functions.True;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyyr.dao.BaseDAO;
import com.jyyr.orm.TbReckonPieceContentInfoM;
import com.jyyr.service.TbReckonPieceContentInfoMService;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.contrib.HSSFCellUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �Ƽ�Ŀ¼��Ϣ��ѯ��ά���ӿ�
 * 
 * @author ������
 * 
 */
public class TbReckonPieceContentInfoMServiceImpl implements
		TbReckonPieceContentInfoMService {
	BaseDAO dao;

	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	/**
	 * ��ҳ��ȡ�Ƽ�Ŀ¼��¼
	 * 
	 * @param staticMonth1
	 *            ��ʼʱ��
	 * @param staticMonth2
	 *            ��ֹʱ��
	 * @param bigPiece
	 *            �Ƽ�����
	 * @param smallPiece�Ƽ�����
	 * @param pageSize
	 *            ҳ����ʾ��¼��
	 * @param pager
	 *            �ڼ�ҳ
	 * @return ���ؼ���
	 */
	public List<TbReckonPieceContentInfoM> findPieceContent(
			String staticMonth1, String staticMonth2, String bigPiece,
			String smallPiece, int pageSize, int pager) {
		String hql = "from TbReckonPieceContentInfoM as a ";
		if (!staticMonth1.equals("") && !staticMonth2.equals("")) {
			hql += "where";
			hql += " a.statisMonth>=" + "'" + staticMonth1 + "'"
					+ " and a.statisMonth<=" + "'" + staticMonth2 + "'";
			if (!bigPiece.equals("")) {
				hql += " and a.reckonPieceMCls like" + " '%" + bigPiece + "%'";
			}
			if (!smallPiece.equals("")) {
				hql += " and a.reckonPieceSCls like" + " '%" + smallPiece + "%'";
			}
		} else if (staticMonth1.equals("") && staticMonth2.equals("")) {
			if (!bigPiece.equals("") || !smallPiece.equals("")) {
				hql += "where ";
				if (!bigPiece.equals("") && smallPiece.equals("")) {
					hql += "  a.reckonPieceMCls like" + " '%" + bigPiece + "%'";
				} else if (bigPiece.equals("") && !smallPiece.equals("")) {
					hql += "  a.reckonPieceSCls like" + " '%" + smallPiece + "%'";
				} else if (!bigPiece.equals("") && !smallPiece.equals("")) {
					hql += "  a.reckonPieceMCls like" + " '%" + bigPiece + "%'"
							+ " and a.reckonPieceSCls like" + " '%" + smallPiece
							+ "%'";
				}
			}
		}
		hql +=" order by a.reckonPieceSCls";
		List l = dao.listCondition(hql, pager, pageSize);
		List<TbReckonPieceContentInfoM> list = new ArrayList<TbReckonPieceContentInfoM>();
		for (int i = 0; i < l.size(); i++) {
			TbReckonPieceContentInfoM tbReckonPieceContentInfoM = (TbReckonPieceContentInfoM) l
					.get(i);
			list.add(tbReckonPieceContentInfoM);
		}
		return list;
	}

	/**
	 * ��ȡ�Ƽ�Ŀ¼��¼��
	 * 
	 * @param staticMonth1
	 *            ��ʼʱ��
	 * @param staticMonth2
	 *            ��ֹʱ��
	 * @param bigPiece�Ƽ�����
	 * @param smallPiece�Ƽ�����
	 * @return ���ؼ�����Ŀ
	 */
	public int findPieceContentCount(String staticMonth1, String staticMonth2,
			String bigPiece, String smallPiece) {
		String hql = "select count(*) from TbReckonPieceContentInfoM as a ";
		if (!staticMonth1.equals("") && !staticMonth2.equals("")) {
			hql += "where";
			hql += " a.statisMonth>=" + "'" + staticMonth1 + "'"
					+ " and a.statisMonth<=" + "'" + staticMonth2 + "'";
			if (!bigPiece.equals("")) {
				hql += " and a.reckonPieceMCls like" + " '%" + bigPiece + "%'";
			}
			if (!smallPiece.equals("")) {
				hql += " and a.reckonPieceSCls like" + " '%" + smallPiece + "%'";
			}
		} else if (staticMonth1.equals("") && staticMonth2.equals("")) {
			if (!bigPiece.equals("") || !smallPiece.equals("")) {
				hql += "where ";
				if (!bigPiece.equals("") && smallPiece.equals("")) {
					hql += "  a.reckonPieceMCls like" + " '%" + bigPiece + "%'";
				} else if (bigPiece.equals("") && !smallPiece.equals("")) {
					hql += "  a.reckonPieceSCls like" + " '%" + smallPiece + "%'";
				} else if (!bigPiece.equals("") && !smallPiece.equals("")) {
					hql += "  a.reckonPieceMCls like" + " '%" + bigPiece + "%'"
							+ " and a.reckonPieceSCls like" + " '%" + smallPiece
							+ "%'";
				}
			}
		}
		return dao.countAllCondition(hql);
	}

	/**
	 * ɾ���Ƽ�Ŀ¼��Ϣ
	 * 
	 * @param id
	 *            ɾ���Ƽ�Ŀ¼ID
	 * @return
	 */
	public boolean deletePieceContentByID(String id) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		try {
			dao.delById(TbReckonPieceContentInfoM.class, id);
			isSuccess = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	/**
	 * ��ӻ��޸ļƼ�Ŀ¼��Ϣ
	 * 
	 * @param month
	 *            �·�
	 * @param bigPieceCls
	 *            �Ƽ�����
	 * @param pieceType
	 *            �Ƽ�����
	 * @param scoreVal
	 *            ����ֵ
	 * @param piecePrice
	 *            ���ֵ���
	 * @return
	 */
	public Boolean addOrUpdatePieceContent(String month, String bigPieceCls,
			String pieceType, String scoreVal, String piecePrice) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		TbReckonPieceContentInfoM piece = new TbReckonPieceContentInfoM();
		piece.setStatisMonth(month);
		piece.setReckonPieceMCls(bigPieceCls.toString());
		piece.setReckonPieceSCls(pieceType.toString());
		piece.setIntegralScore(Double.parseDouble(scoreVal));
		piece.setCoreUitPrice(Double.parseDouble(piecePrice));
		try {
			dao.saveOrUpdate(piece);
			isSuccess = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	/**
	 * �����Ƽ�Ŀ¼��Ϣ
	 * 
	 * @param staticMonth1
	 *            ��ʼʱ��
	 * @param staticMonth2
	 *            ����ʱ��
	 * @param bigPiece
	 *            �Ƽ�����
	 * @param smallPiece
	 *            �Ƽ�����
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public List exportyPieceContent(String staticMonth1, String staticMonth2,
			String bigPiece, String smallPiece) {
		// ƴhql
		String hql = "from TbReckonPieceContentInfoM as a ";
		if (!staticMonth1.equals("") && !staticMonth2.equals("")) {
			hql += "where";
			hql += " a.statisMonth>=" + "'" + staticMonth1 + "'"
					+ " and a.statisMonth<=" + "'" + staticMonth2 + "'";
			if (!bigPiece.equals("")) {
				hql += " and a.reckonPieceMCls like" + " '%" + bigPiece + "%'";
			}
			if (!smallPiece.equals("")) {
				hql += " and a.reckonPieceSCls like" + " '%" + smallPiece + "%'";
			}
		} else if (staticMonth1.equals("") && staticMonth2.equals("")) {
			if (!bigPiece.equals("") || !smallPiece.equals("")) {
				hql += "where ";
				if (!bigPiece.equals("") && smallPiece.equals("")) {
					hql += "  a.reckonPieceMCls like" + " '%" + bigPiece + "%'";
				} else if (bigPiece.equals("") && !smallPiece.equals("")) {
					hql += "  a.reckonPieceSCls like" + " '%" + smallPiece + "%'";
				} else if (!bigPiece.equals("") && !smallPiece.equals("")) {
					hql += "  a.reckonPieceMCls like" + " '%" + bigPiece + "%'"
							+ " and a.reckonPieceSCls like" + " '%" + smallPiece
							+ "%'";
				}
			}
		}
		// ��ȡ����
		List l = dao.listConditionAll(hql);
		return l;
	}

	/**
	 * ����Ƽ�Ŀ¼
	 * 
	 * @param impList
	 *            ����ļ���
	 */
	public void importPieceContent(List<TbReckonPieceContentInfoM> impList) {
		for (int i = 0; i < impList.size(); i++) {
			TbReckonPieceContentInfoM temp = new TbReckonPieceContentInfoM();
			temp = impList.get(i);
			String id = temp.getReckonPieceSCls().trim();
			String hqlString = "select count(*) from TbReckonPieceContentInfoM as a where a.reckonPieceSCls="
					+ "'" + id + "'";
			if (!isExistPieceContent(hqlString)) {
				try {
					dao.saveOrUpdate(temp);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * �жϼ�¼�Ƿ����
	 * 
	 * @param hql
	 *            �ж�sql
	 * @return
	 */
	public boolean isExistPieceContent(String hql) {
		if (dao.countAllCondition(hql) == 1) {
			return true;
		} else {
			return false;
		}
	}

}
