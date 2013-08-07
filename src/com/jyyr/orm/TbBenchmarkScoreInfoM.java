package com.jyyr.orm;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
/**
 * 5����׼������Ϣ��ѯ��ά��
 * @author ywz
 *
 */
@Entity
@Table (name="TB_CHNL_MANAGER_BENCHMARK_SCORE_INFO_M",schema="qinhuangdao")
public class TbBenchmarkScoreInfoM {
	
	
	private String statisMonth;	//�·�	
	private String countyName;	//����	
	private String area;		//����	
	private Double benchmarkScore;//��׼����

	public TbBenchmarkScoreInfoM(){};
	
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
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

	@Column(name = "AREA",length=128)
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "BENCHMARK_SCORE",length=18)
	public Double getBenchmarkScore() {
		return benchmarkScore;
	}

	public void setBenchmarkScore(Double benchmarkScore) {
		this.benchmarkScore = benchmarkScore;
	}
	
	
}
