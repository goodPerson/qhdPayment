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
 * ����ϵ����Ϣ
 * @author lyk
 *
 */
@SuppressWarnings("serial")
public class CoffcntInfoAction extends ActionSupport implements ModelDriven<TbAccomdCoffcntLinfoM>{

	TbAccomdCoffcntLinfoMService Service;//����ϵ����Ϣ��ѯ��ά���ӿ�
	/**����Ҫ�Ĳ���*/
	private String county;//����
	private String area;//����
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

	private TbAccomdCoffcntLinfoM model=new TbAccomdCoffcntLinfoM();//���ڷ�װϵͳ�û�����ģ��	
	

	private static List<TbAccomdCoffcntLinfoM> exportList=new ArrayList<TbAccomdCoffcntLinfoM>();

	public static List<TbAccomdCoffcntLinfoM> getExportList() {
		return exportList;
	}

	public static void setExportList(List<TbAccomdCoffcntLinfoM> exportList) {
		CoffcntInfoAction.exportList = exportList;
	}

    /**�����û�������Ϣ����Ȩ�޿��Ʋ���ת��ָ��ҳ��*/
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
				if (quanXianPost=="��������"||"��������".equals(quanXianPost)) {

					return "FAIL";
				}else {
					return SUCCESS;
				}
			}else {
				//JOptionPane.showMessageDialog(null, "�Բ�����û��Ȩ�޵�¼��","��ʾ",JOptionPane.PLAIN_MESSAGE);

				return "FAIL";
			}			
		}else {
			//JOptionPane.showMessageDialog(null, "�Բ�����û��Ȩ�޵�¼��","��ʾ",JOptionPane.PLAIN_MESSAGE);

			return "FAIL";
		}
	}


	/**������ת��Ϊjson,��JSP��combox��ʹ��*/
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
					jsonObjectFinal.put("id", "--ȫ��--");
					jsonObjectFinal.put("text", "--ȫ��--");
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
	
	/**����������ת��JSON��JSP�е�combox��ʹ��*/
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
					jsonObjectFinal.put("text", "--ȫ��--");
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
	
	/**ɾ����¼*/
	public String delrecd() throws Exception {
		//TbAccomdCoffcntLinfoM coe = new TbAccomdCoffcntLinfoM();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		if (model.getArea()!=null){
			if (Service.delCoff(URLDecoder.decode( model.getArea(), "utf-8"))){
                     dmsg="ɾ���ɹ�";
//				PrintWriter printWriter = response.getWriter();
//				printWriter.print("ɾ���ɹ�");
//				printWriter.flush();
//				printWriter.close();

			}else{
				  dmsg="ɾ��ʧ��";
//				PrintWriter printWriter = response.getWriter();
//				printWriter.print("ɾ��ʧ��");
//				printWriter.flush();
//				printWriter.close();
				//String message = "ɾ��ʧ��";
			}	
		}

		return "DEL";
	}
	/**�༭����ϵ����¼*/    
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
			umsg="���³ɹ�";
//			PrintWriter printWriter = response.getWriter();
//			printWriter.print("���³ɹ�");
//			printWriter.flush();
//			printWriter.close();
		}else{
			umsg="����ʧ��";
			PrintWriter printWriter = response.getWriter();
			printWriter.print("����ʧ��");
			printWriter.flush();
			printWriter.close();
		}
		return "UPD";
	}
	/**��ѯָ�����صļ�¼,������ת��ΪJSON��JSP�е�datagrid��չʾ*/
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
		if (quanXianCountyName!="�ػʵ���"&&!"�ػʵ���".equals(quanXianCountyName)) {
			county=quanXianCountyName;
		}else {
			if (model.getCounty()!=null&&!"".equals(model.getCounty())&&!"--ȫ��--".equals(URLDecoder.decode( model.getCounty(), "utf-8"))) {
				county =URLDecoder.decode( model.getCounty(), "utf-8");
			}else {
				county="";
			}
		}
		
		if (model.getArea()!=null&&!"".equals(model.getArea())&&!"--ȫ��--".equals( URLDecoder.decode( model.getArea(), "utf-8"))) {
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
				if (quanXianPost=="��������Ա"||"��������Ա".equals(quanXianPost)) {
					jsonObject
					.put("value9",
							"<a href='javascript:EditCoffcnt();'>�༭</a>&nbsp"
									+ "<a href='javascript:DelCoffcnt();'>ɾ��</a>");
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
	/**������ѯ��������*/
	public String getDownloadFileJ() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		exportType = "xls";
		// �����ͷ
		String header = "�·� ���� ���� ���ŵ���ϵ�� �ն˵���ϵ�� ����ҵ�����ϵ�� Ӫ�������ϵ�� ���շѵ���ϵ��";
		// ��ȡ����
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
				"�ػʵ�����ϵ����Ϣ", "��ϸ��Ϣ", header, datalist);
		contentType = "application/vnd.ms-excel;charset=utf-8";
		downloadFile = result;
		fileName = "�ػʵ�����ϵ����Ϣ.xls";
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
