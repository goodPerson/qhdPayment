package com.jyyr.service;

import java.util.List;
import com.jyyr.orm.TbReckonPieceContentInfoM;

/**
 * �Ƽ�Ŀ¼��Ϣ��ѯ��ά���ӿ�
 * 
 * @author ������
 * 
 */
public interface TbReckonPieceContentInfoMService {
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
			String smallPiece, int pageSize, int pager);

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
			String bigPiece, String smallPiece);

	/**
	 * ɾ���Ƽ�Ŀ¼��Ϣ
	 * 
	 * @param id
	 *            ɾ���Ƽ�Ŀ¼ID
	 * @return
	 */
	public boolean deletePieceContentByID(String id);

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
			String pieceType, String scoreVal, String piecePrice);

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
	public List exportyPieceContent(String staticMonth1, String staticMonth2,
			String bigPiece, String smallPiece);

	/**
	 * ����Ƽ�Ŀ¼
	 * 
	 * @param impList
	 *            ����ļ���
	 */
	public void importPieceContent(List<TbReckonPieceContentInfoM> impList);

	/**
	 * �жϼ�¼�Ƿ����
	 * 
	 * @param hql
	 *            �ж�sql
	 * @return
	 */
	public boolean isExistPieceContent(String hql);
}
