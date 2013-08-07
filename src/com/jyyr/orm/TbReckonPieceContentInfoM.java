package com.jyyr.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
 * 4���Ƽ�Ŀ¼��Ϣ��ѯ��ά��
 * 
 * @author ywz
 * 
 */

@Entity
@Table(name = "TB_CHNL_MANAGER_RECKON_PIECE_CONTENT_INFO_M", schema = "qinhuangdao")
public class TbReckonPieceContentInfoM {

	private String statisMonth; // �·�
	private String reckonPieceMCls; // �Ƽ�����
	private String reckonPieceSCls; // �Ƽ�����
	private Double integralScore; // ����ֵ
	private Double coreUitPrice; // ���ֵ���

	public TbReckonPieceContentInfoM() {
	};

	@Id
	@Column(name = "RECKON_PIECE_S_CLS", length = 50)
	public String getReckonPieceSCls() {
		return reckonPieceSCls;
	}

	public void setReckonPieceSCls(String reckonPieceSCls) {
		this.reckonPieceSCls = reckonPieceSCls;
	}

	@Column(name = "STATIS_MONTH", length = 10)
	public String getStatisMonth() {
		return statisMonth;
	}

	public void setStatisMonth(String statisMonth) {
		this.statisMonth = statisMonth;
	}

	@Column(name = "RECKON_PIECE_M_CLS", length = 50)
	public String getReckonPieceMCls() {
		return reckonPieceMCls;
	}

	public void setReckonPieceMCls(String reckonPieceMCls) {
		this.reckonPieceMCls = reckonPieceMCls;
	}

	@Column(name = "INTEGRAL_SCORE", length = 18)
	public Double getIntegralScore() {
		return integralScore;
	}

	public void setIntegralScore(Double integralScore) {
		this.integralScore = integralScore;
	}

	@Column(name = "SCORE_UNIT_PRICE", length = 18)
	public Double getCoreUitPrice() {
		return coreUitPrice;
	}

	public void setCoreUitPrice(Double coreUitPrice) {
		this.coreUitPrice = coreUitPrice;
	}

}
