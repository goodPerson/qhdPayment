package com.jyyr.orm;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
/**
 *  ��������������Ϣ��
 * @author kb
 *
 */
@SuppressWarnings("serial")
@Entity
@Table (name="TB_CHNL_MANAGER_BASIC_INFO_M",schema="qinhuangdao")
public class TbBasicInfoM implements java.io.Serializable{
	
	
	private String  statisMonth; //�·�	
	private String  countyName; //����	
	private String  name;		//����	
	private String  id;			//���	
	private String  prncpArea;	//��������	
	private String  userStat;	//״̬	
	private String  post;		//��λ	
	private String  entryTime;	//��ְʱ��	
	private String  leftTime;	//��ְʱ��

	public TbBasicInfoM(){};
	

	@Column(name = "STATIS_MONTH",length=10)
	public String getStatisMonth() {
		return statisMonth;
	}

	public void setStatisMonth(String statisMonth) {
		this.statisMonth = statisMonth;
	}

	@Column(name = "COUNTY_NAME",length=100)
	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	@Column(name = "NAME",length=26)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Id
   // @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "ID",length=128)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "PRNCP_AREA",length=20)
	public String getPrncpArea() {
		return prncpArea;
	}

	public void setPrncpArea(String prncpArea) {
		this.prncpArea = prncpArea;
	}

	@Column(name = "USER_STAT",length=20)
	public String getUserStat() {
		return userStat;
	}

	public void setUserStat(String userStat) {
		this.userStat = userStat;
	}

	@Column(name = "POST",length=20)
	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	@Column(name = "ENTRY_TIME",length=10)
	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	@Column(name = "LEAVE_TIME",length=10)
	public String getLeftTime() {
		return leftTime;
	}

	public void setLeftTime(String leftTime) {
		this.leftTime = leftTime;
	}
	
	
}
