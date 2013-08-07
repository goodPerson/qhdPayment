package com.jyyr.orm;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
/**
 * �����Ƽ���Ŀ����ϸ��Ϣ��ѯ
 * @author ywz
 *
 */

@Entity
@Table (name="TB_CHNL_MANAGER_RECKON_PIECE_PAY_DEAL_INFO_D",schema="qinhuangdao")
public class TbReckonPiecePayDealInfoD {
	
	
	private String statisDate; //����	
	private String countyName;	//����	
	private String name;		//����	
	private String staffId;		//Ա�����	
	private String prncpArea;	//��������	
	private String chnlId;		//��������	
	private String ChnlName;	//��������
	private String reckonPieceMClsName;	//�Ƽ���Ŀ��������
	private String reckonPieceSClsName;	//�Ƽ���ĿС������
	private String curDayDevCnt;	//���շ�չ��
	private String curDayDevScore;	//���շ�չ����
	private Double curDayPay;		//���շ�չн��
	private Double monSumDevCnt;	//���ۼƷ�չ��
	private Double monSumDevScore;	//���ۼƷ�չ����
	private Double monSumPay;		//���ۼƷ�չн��

	public TbReckonPiecePayDealInfoD(){};
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STATIS_DATE",length=10)
	public String getStatisDate() {
		return statisDate;
	}

	public void setStatisDate(String statisDate) {
		this.statisDate = statisDate;
	}

	@Column(name = "COUNTY_NAME",length=100)
	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	@Column(name = "NAME",length=32)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "STAFF_ID",length=32)
	public String getStaffId() {
		return staffId;
	}

	
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	@Column(name = "PRNCP_AREA",length=128)
	public String getPrncpArea() {
		return prncpArea;
	}

	public void setPrncpArea(String prncpArea) {
		this.prncpArea = prncpArea;
	}

	@Column(name = "CHNL_ID",length=32)
	public String getChnlId() {
		return chnlId;
	}

	public void setChnlId(String chnlId) {
		this.chnlId = chnlId;
	}


	@Column(name = "CHNL_NAME",length=200)
	public String getChnlName() {
		return ChnlName;
	}

	public void setChnlName(String chnlName) {
		ChnlName = chnlName;
	}

	@Column(name = "RECKON_PIECE_M_CLS_NAME",length=50)
	public String getReckonPieceMClsName() {
		return reckonPieceMClsName;
	}

	public void setReckonPieceMClsName(String reckonPieceMClsName) {
		this.reckonPieceMClsName = reckonPieceMClsName;
	}

	@Column(name = "RECKON_PIECE_S_CLS_NAME",length=50)
	public String getReckonPieceSClsName() {
		return reckonPieceSClsName;
	}

	public void setReckonPieceSClsName(String reckonPieceSClsName) {
		this.reckonPieceSClsName = reckonPieceSClsName;
	}

	@Column(name = "CUR_DAY_DEV_CNT",length=18)
	public String getCurDayDevCnt() {
		return curDayDevCnt;
	}

	public void setCurDayDevCnt(String curDayDevCnt) {
		this.curDayDevCnt = curDayDevCnt;
	}

	@Column(name = "CUR_DAY_DEV_SCORE",length=18)
	public String getCurDayDevScore() {
		return curDayDevScore;
	}

	public void setCurDayDevScore(String curDayDevScore) {
		this.curDayDevScore = curDayDevScore;
	}

	@Column(name = "CUR_DAY_PAY",length=18)
	public Double getCurDayPay() {
		return curDayPay;
	}

	public void setCurDayPay(Double curDayPay) {
		this.curDayPay = curDayPay;
	}

	@Column(name = "MON_SUM_DEV_CNT",length=18)
	public Double getMonSumDevCnt() {
		return monSumDevCnt;
	}

	public void setMonSumDevCnt(Double monSumDevCnt) {
		this.monSumDevCnt = monSumDevCnt;
	}

	@Column(name = "MON_SUM_DEV_SCORE",length=18)
	public Double getMonSumDevScore() {
		return monSumDevScore;
	}

	public void setMonSumDevScore(Double monSumDevScore) {
		this.monSumDevScore = monSumDevScore;
	}

	@Column(name = "MON_SUM_PAY",length=18)
	public Double getMonSumPay() {
		return monSumPay;
	}

	public void setMonSumPay(Double monSumPay) {
		this.monSumPay = monSumPay;
	}
	
	
	
}
