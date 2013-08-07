package com.jyyr.strtus.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.ibm.db2.jcc.am.mo;
import com.jyyr.common.PrintExcelUtil;
import com.jyyr.orm.TbAccomdCoffcntLinfoM;
import com.jyyr.orm.TbBasicInfoM;
import com.jyyr.orm.TbChnlIinfoM;
import com.jyyr.service.TbAccomdCoffcntLinfoMService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 调节系数信息
 * @author lyk
 *
 */
@SuppressWarnings("serial")
public class CoffcntInfoAction extends ActionSupport implements ModelDriven<TbAccomdCoffcntLinfoM>{

	TbAccomdCoffcntLinfoMService Service;//调节系数信息查询与维护接口
	/**所需要的参数*/
	private String county;//区县
	private String area;//区域
	private List<String> countys;
	private String result;
	private int total=0;
	private String page;
	private String rows;
	private String contentType;
	private FileInputStream downloadFile;
	private String fileName;
	private String exportType;
	private String umsg;
	private String dmsg;
    private String userId;
	private String staticId;
    private String roleName;
	private String userName;
	private String regionId;
	private String regionName;

	private static String quanXianCountyName="";//

	private static String quanXianPost="";//

	private TbAccomdCoffcntLinfoM model=new TbAccomdCoffcntLinfoM();//用于封装系统用户属性模型	
	

	private static List<TbAccomdCoffcntLinfoM> exportList=new ArrayList<TbAccomdCoffcntLinfoM>();

	public static List<TbAccomdCoffcntLinfoM> getExportList() {
		return exportList;
	}

	public static void setExportList(List<TbAccomdCoffcntLinfoM> exportList) {
		CoffcntInfoAction.exportList = exportList;
	}

    /**根据用户基础信息进行权限控制并跳转到指定页面*/
	public String execute() {
		List<TbBasicInfoM> chnlList=new ArrayList<TbBasicInfoM>();		
		TbBasicInfoM basicInfoM=new TbBasicInfoM();
		HttpServletRequest request = ServletActionContext.getRequest();
		String idString=request.getParameter("Id");
		if (idString!=null&&!"".equals(idString)) {			
			chnlList=Service.findUserById(idString);
			if (chnlList.size()!=0) {				
				basicInfoM=chnlList.get(0);
				quanXianCountyName=basicInfoM.getCountyName();
				quanXianPost=basicInfoM.getPost();
				request.setAttribute("quanXianCountyName", quanXianCountyName);
				request.setAttribute("quanXianPost", quanXianPost);
				if (quanXianPost=="渠道经理"||"渠道经理".equals(quanXianPost)) {

					return "FAIL";
				}else {
					return SUCCESS;
				}
			}else {
				//JOptionPane.showMessageDialog(null, "对不起，您没有权限登录！","提示",JOptionPane.PLAIN_MESSAGE);

				return "FAIL";
			}			
		}else {
			//JOptionPane.showMessageDialog(null, "对不起，您没有权限登录！","提示",JOptionPane.PLAIN_MESSAGE);

			return "FAIL";
		}
	}


	/**把区县转化为json,在JSP中combox中使用*/
	public String setJson1() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		countys =Service.findAllCounty(quanXianCountyName);
		JSONArray jsonArray = new JSONArray();	
		
		if (countys.size()>1) {
			for (int i=countys.size();i>=0;i--) {
				JSONObject jsonObjectFinal = new JSONObject();

				if (i!=countys.size()) {
					String county=countys.get(i);
					jsonObjectFinal.put("id", county);
					jsonObjectFinal.put("text", county);
				}else {
					jsonObjectFinal.put("id", "--全部--");
					jsonObjectFinal.put("text", "--全部--");
				}

				jsonArray.add(jsonObjectFinal);
			}
		}else {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", countys.get(0));
			jsonObject.put("text", countys.get(0));
			jsonArray.add(jsonObject);
		}
		PrintWriter printWriter = response.getWriter();
		printWriter.print(jsonArray.toString());
		printWriter.flush();
		printWriter.close();
		return SUCCESS;
	}
	
	/**把区域数据转化JSON在JSP中的combox中使用*/
	public String setJsonArea() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		String countyName=URLDecoder.decode(request.getParameter("countyName"),"utf-8");

		List<String> areas = Service.browseArea(countyName);
		JSONArray jsonArray = new JSONArray();
		if (areas != null) {
			for (int i=areas.size();i>=0;i--) {

				JSONObject jsonObjectFinal = new JSONObject();
				if (i!=areas.size()) {
					String county=areas.get(i);
					jsonObjectFinal.put("id", i+1);
					jsonObjectFinal.put("text", county);
				}else {
					jsonObjectFinal.put("id", i+1);
					jsonObjectFinal.put("text", "--全部--");
				}				
				jsonArray.add(jsonObjectFinal);
			}
			PrintWriter out=response.getWriter();
			out.print(jsonArray.toString());
			out.flush();
			out.close();
		}
		return SUCCESS;
	}
	
	/**删除记录*/
	public String delrecd() throws Exception {
		//TbAccomdCoffcntLinfoM coe = new TbAccomdCoffcntLinfoM();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		if (model.getArea()!=null){
			if (Service.delCoff(URLDecoder.decode( model.getArea(), "utf-8"))){
                     dmsg="删除成功";
//				PrintWriter printWriter = response.getWriter();
//				printWriter.print("删除成功");
//				printWriter.flush();
//				printWriter.close();

			}else{
				  dmsg="删除失败";
//				PrintWriter printWriter = response.getWriter();
//				printWriter.print("删除失败");
//				printWriter.flush();
//				printWriter.close();
				//String message = "删除失败";
			}	
		}

		return "DEL";
	}
	/**编辑调节系数记录*/    
	public String Updatercd() throws Exception{ 
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		TbAccomdCoffcntLinfoM cof = new TbAccomdCoffcntLinfoM();
		cof.setStatisMonth(model.getStatisMonth());
		cof.setCounty(URLDecoder.decode( model.getCounty(), "utf-8"));
		cof.setArea(URLDecoder.decode( model.getArea(), "utf-8"));
		cof.setCardAccomdCoffcnt(model.getCardAccomdCoffcnt());
		cof.setTmnlAccmdCoffcnt(model.getTmnlAccmdCoffcnt());
		cof.setDataActAccomdCoffcnt(model.getDataActAccomdCoffcnt());
		cof.setGenerChargeAccomdCofcnt(model.getGenerChargeAccomdCofcnt());
		cof.setMarktActAccomdCoffcnt(model.getMarktActAccomdCoffcnt());

		if(Service.saveOrUpdateCnt(cof)){
			umsg="更新成功";
//			PrintWriter printWriter = response.getWriter();
//			printWriter.print("更新成功");
//			printWriter.flush();
//			printWriter.close();
		}else{
			umsg="更新失败";
			PrintWriter printWriter = response.getWriter();
			printWriter.print("更新失败");
			printWriter.flush();
			printWriter.close();
		}
		return "UPD";
	}
	/**查询指定区县的记录,把数据转化为JSON在JSP中的datagrid中展示*/
	public String setJson() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		int pageno;
		int pagesize;
		if (request.getParameter("page")==null || ""==request.getParameter("page")){
			pageno=1;
		}else{

			pageno=Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("rows")==null || ""==request.getParameter("rows")){
			pagesize=10;
		}else{
			pagesize=Integer.parseInt(request.getParameter("rows"));
		}
		if (quanXianCountyName!="秦皇岛市"&&!"秦皇岛市".equals(quanXianCountyName)) {
			county=quanXianCountyName;
		}else {
			if (model.getCounty()!=null&&!"".equals(model.getCounty())&&!"--全部--".equals(URLDecoder.decode( model.getCounty(), "utf-8"))) {
				county =URLDecoder.decode( model.getCounty(), "utf-8");
			}else {
				county="";
			}
		}
		
		if (model.getArea()!=null&&!"".equals(model.getArea())&&!"--全部--".equals( URLDecoder.decode( model.getArea(), "utf-8"))) {
			area = URLDecoder.decode( model.getArea(), "utf-8");
		}else {
			area="";
		}
		
		
		List<TbAccomdCoffcntLinfoM> list = Service.scanneChnl(county,area, pageno, pagesize);
		int totalCount=Service.countlist(county,area);
		exportList=Service.findall(county, area);
		//List<TbAccomdCoffcntLinfoM> list = Service.findall();
		JSONArray jsonArray = new JSONArray();
		if (list != null) {
			for (int i=0;i<list.size();i++){
				TbAccomdCoffcntLinfoM piece=list.get(i);

				//for (TbAccomdCoffcntLinfoM piece : list) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("value1", piece.getStatisMonth());
				jsonObject.put("value3", piece.getArea());
				jsonObject.put("value2", piece.getCounty());
				jsonObject.put("value4", piece.getCardAccomdCoffcnt());
				jsonObject.put("value6", piece.getDataActAccomdCoffcnt());
				jsonObject.put("value8", piece.getGenerChargeAccomdCofcnt());
				jsonObject.put("value7", piece.getMarktActAccomdCoffcnt());
				jsonObject.put("value5", piece.getTmnlAccmdCoffcnt());
				if (quanXianPost=="超级管理员"||"超级管理员".equals(quanXianPost)) {
					jsonObject
					.put("value9",
							"<a href='javascript:EditCoffcnt();'>编辑</a>&nbsp"
									+ "<a href='javascript:DelCoffcnt();'>删除</a>");
				}
				jsonArray.add(jsonObject);
			}
			JSONObject jsonObjectFinal = new JSONObject();
			jsonObjectFinal.put("total", totalCount);
			jsonObjectFinal.put("rows", jsonArray);
			PrintWriter printWriter = response.getWriter();
			printWriter.print(jsonObjectFinal.toString());
			printWriter.flush();
			printWriter.close();
		}

		return SUCCESS;
	}
	/**导出查询到的数据*/
	public String getDownloadFileJ() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		exportType = "xls";
		// 定义表头
		String header = "月份 区县 区域 卡号调节系数 终端调节系数 数据业务调节系数 营销活动调节系数 代收费调节系数";
		// 获取数据
		if (model.getCounty()!=null&&!"".equals(model.getCounty())) {
			county =URLDecoder.decode( model.getCounty(), "utf-8");
		}else {
			county="";
		}
		
		List<TbAccomdCoffcntLinfoM> list1 = exportList;

		List<Object[]> datalist = new ArrayList<Object[]>();
		for (int i = 0; i < list1.size(); i++) {
			TbAccomdCoffcntLinfoM piece=list1.get(i);
			Object[] obj = { piece.getStatisMonth(),piece.getCounty(),piece.getArea(),piece.getCardAccomdCoffcnt(),
					piece.getTmnlAccmdCoffcnt(),piece.getDataActAccomdCoffcnt(),piece.getMarktActAccomdCoffcnt(),piece.getGenerChargeAccomdCofcnt()};
			datalist.add(obj);
		}
		FileInputStream result = PrintExcelUtil.getDownloadFile(exportType,
				"秦皇岛调节系数信息", "详细信息", header, datalist);
		contentType = "application/vnd.ms-excel;charset=utf-8";
		downloadFile = result;
		fileName = "秦皇岛调节系数信息.xls";
		fileName = new String(fileName.getBytes(), "ISO8859-1");
		return SUCCESS;
	}


	public TbAccomdCoffcntLinfoMService getService() {
		return Service;
	}
	public void setService(TbAccomdCoffcntLinfoMService service) {
		Service = service;
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}


	public String getContentType() {
		return contentType;
	}


	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	public FileInputStream getDownloadFile() {
		return downloadFile;
	}


	public void setDownloadFile(FileInputStream downloadFile) {
		this.downloadFile = downloadFile;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getExportType() {
		return exportType;
	}


	public void setExportType(String exportType) {
		this.exportType = exportType;
	}


	public void setModel(TbAccomdCoffcntLinfoM model) {
		this.model = model;
	}

	public TbAccomdCoffcntLinfoM getModel() {
		return model;
	}

	public String getUmsg() {
		return umsg;
	}

	public void setUmsg(String umsg) {
		this.umsg = umsg;
	}

	public String getDmsg() {
		return dmsg;
	}

	public void setDmsg(String dmsg) {
		this.dmsg = dmsg;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStaticId() {
		return staticId;
	}

	public void setStaticId(String staticId) {
		this.staticId = staticId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
    

}
