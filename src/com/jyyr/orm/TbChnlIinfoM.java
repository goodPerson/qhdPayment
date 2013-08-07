package com.jyyr.orm;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
/**
 * 2、渠道经理渠道信息查询与维护
 * @author ywz
 *
 */
@Entity
@Table (name="TB_CHNL_MANAGER_CHNL_INFO_M",schema="qinhuangdao")
public class TbChnlIinfoM {
	
	
	private String  statisMonth; //月份	
	private String  countyName; //县区	
	private String  name;		//姓名	
	private String  id;			//编号	
	private String prncpArea;	//负责区域	
	private String prncpChnlId;	//负责区域	
	private String prncpChnlName;//负责区域
	private String pnncpChnlType;//负责区域

	public TbChnlIinfoM(){};
		
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

	@Column(name = "NAME",length=36)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ID",length=32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "PRNCP_AREA",length=128)
	public String getPrncpArea() {
		return prncpArea;
	}

	public void setPrncpArea(String prncpArea) {
		this.prncpArea = prncpArea;
	}

	@Id 
//    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "PRNCP_CHNL_ID",length=32)
	public String getPrncpChnlId() {
		return prncpChnlId;
	}

	public void setPrncpChnlId(String prncpChnlId) {
		this.prncpChnlId = prncpChnlId;
	}

	@Column(name = "PRNCP_CHNL_NAME",length=128)
	public String getPrncpChnlName() {
		return prncpChnlName;
	}

	public void setPrncpChnlName(String prncpChnlName) {
		this.prncpChnlName = prncpChnlName;
	}

	@Column(name = "PRNCP_CHNL_TYPE",length=50)
	public String getPnncpChnlType() {
		return pnncpChnlType;
	}

	public void setPnncpChnlType(String pnncpChnlType) {
		this.pnncpChnlType = pnncpChnlType;
	}
	
	
}