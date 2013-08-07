package com.jyyr.strtus.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.jyyr.orm.TbCountyDevCntStatisInfoD;
import com.jyyr.service.TbCountyDevCntStatisInfoDService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



@SuppressWarnings("serial")
public class TbCountyDevCntStatisInfoDAction extends ActionSupport implements ModelDriven<TbCountyDevCntStatisInfoD>{
	/** 通过依赖注入ColumnsService组件实例 */
	TbCountyDevCntStatisInfoDService tbCountyDevCntStatisInfoDService;
	private TbCountyDevCntStatisInfoD model=new TbCountyDevCntStatisInfoD();
	
	public String entryStatisInfoD() {
		return SUCCESS;
	}
	
	public String browserStatisInfoD() throws IOException {		
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		String statisDate=tbCountyDevCntStatisInfoDService.findall().get(0).getSTATIS_DATE();
		System.out.print(statisDate);
		List<TbCountyDevCntStatisInfoD> tbCountyDevCntStatisInfoDsList=tbCountyDevCntStatisInfoDService.browserCntStatisInfoDs(statisDate);
		JSONArray jsonArray = new JSONArray();
		DecimalFormat df = new  DecimalFormat("#.00");
		if (tbCountyDevCntStatisInfoDsList != null) {
			for (int i=0;i<tbCountyDevCntStatisInfoDsList.size();i++) {
				TbCountyDevCntStatisInfoD cntStatisInfoD=new TbCountyDevCntStatisInfoD();			
				cntStatisInfoD=tbCountyDevCntStatisInfoDsList.get(i);
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("value1", cntStatisInfoD.getSTATIS_DATE());
				jsonObject.put("value2", cntStatisInfoD.getCOUNTY());
				jsonObject.put("value3", cntStatisInfoD.getCHNL_MAGR_TOTAL_CNT());
				jsonObject.put("value4", cntStatisInfoD.getCHNL_TOTAL_CNT());
				jsonObject.put("value5", cntStatisInfoD.getDAY_TOTAL_SCORE_CNT());
				jsonObject.put("value6", cntStatisInfoD.getCUR_MON_TOTAL_SCORE_CNT());
				jsonObject.put("value7", df.format(cntStatisInfoD.getCUR_MON_TOTAL_PAY()));
				jsonArray.add(jsonObject);
			} 
			JSONObject jsonObjectFinal = new JSONObject();
			jsonObjectFinal.put("rows", jsonArray); 
			jsonObjectFinal.put("total", tbCountyDevCntStatisInfoDsList.size());
			PrintWriter out=response.getWriter();
			out.print(jsonObjectFinal.toString());
			out.flush();
			out.close();
		}
		return SUCCESS;
	}	










	public TbCountyDevCntStatisInfoDService getTbCountyDevCntStatisInfoDService() {
		return tbCountyDevCntStatisInfoDService;
	}
	public void setTbCountyDevCntStatisInfoDService(
			TbCountyDevCntStatisInfoDService tbCountyDevCntStatisInfoDService) {
		this.tbCountyDevCntStatisInfoDService = tbCountyDevCntStatisInfoDService;
	}
	public TbCountyDevCntStatisInfoD getModel() {
		return model;
	}
	public void setModel(TbCountyDevCntStatisInfoD model) {
		this.model = model;
	}


}
