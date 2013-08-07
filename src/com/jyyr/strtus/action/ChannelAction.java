package com.jyyr.strtus.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts2.ServletActionContext;

import com.jyyr.common.PrintExcelUtil;
import com.jyyr.orm.TbAccomdCoffcntLinfoM;
import com.jyyr.orm.TbBasicInfoM;
import com.jyyr.orm.TbChnlIinfoM;
import com.jyyr.service.TbBasicInfoMService;
import com.jyyr.service.TbChnlIinfoMService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 渠道经理渠道信息
 * @author lyk、kb
 *
 */
@SuppressWarnings("serial")
public class ChannelAction extends ActionSupport implements ModelDriven<TbChnlIinfoM>{
	TbChnlIinfoMService Service;//渠道经理渠道信息查询与维护接口

	private TbChnlIinfoM model=new TbChnlIinfoM();//用于封装系统用户属性模型
	public TbChnlIinfoM getModel() {
		return model;
	}
	public TbChnlIinfoMService getService() {
		return Service;
	}
	public void setService(TbChnlIinfoMService service) {
		Service = service;
	}
	public void setModel(TbChnlIinfoM model) {
		this.model = model;
	}
	/**所需要的参数*/
	private String statisMonth;//开始时间
	private String statisMonth1;//结束时间
	private String countyName;//区县名称
	private String id;
	private String name;
	private List<String> countys;
	private List<String> prncpAreas;
	private List<String> names;
	private String prncpArea;
	private String prncpChnlId;
	private String prncpChnlName;
	private String pnncpChnlType;
	private String msg;
	private String msg_update;
	private String imsg="";
	private TbBasicInfoM basicInfoM;
	private String userId;
    private String staticId;
	private String roleName;
	private String userName;
	private String regionId;
	private String regionName;
	
	
	

	public TbBasicInfoM getBasicInfoM() {
		return basicInfoM;
	}
	public void setBasicInfoM(TbBasicInfoM basicInfoM) {
		this.basicInfoM = basicInfoM;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	private static List<TbChnlIinfoM> exportChnlIinfoMList=new ArrayList<TbChnlIinfoM>();//导出的数据
	String contentType;//内容类型
	FileInputStream downloadFile;//	
//	String fileName;//文件名
	private String path;//导入的文件的路径
	private String fileName = "";
	private String dirPath = "D:/qinhuangdao/";
	private File file;
	private final static int BUFFER_SIZE = 16 * 1024;
	private static String quanXianCountyName="";//

	private static String quanXianPost="";//
	
/**根据用户基础信息进行权限控制并跳转到指定页面*/
	public String execute1() {		
		List<TbBasicInfoM> chnlList=new ArrayList<TbBasicInfoM>();		
		basicInfoM=new TbBasicInfoM();
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
	
	/**查询指定区县的记录,把数据转化为JSON在JSP中的datagrid中展示*/
	public String makeJson() throws Exception{
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
		//		int pageno =Integer.parseInt(request.getParameter("page"));
		//		int pagesize=Integer.parseInt(request.getParameter("rows"));
		if (model.getStatisMonth()!=null&&!"".equals(model.getStatisMonth())) {
			statisMonth =model.getStatisMonth();
		}else {
			statisMonth="";
		}

		if (request.getParameter("statisMonth1")!=null&&!"".equals(request.getParameter("statisMonth1"))) {
			statisMonth1 = request.getParameter("statisMonth1");
		}else {
			statisMonth1="";
		}

		if (quanXianCountyName!="秦皇岛市"&&!"秦皇岛市".equals(quanXianCountyName)) {
			countyName=quanXianCountyName;
		}else {
			if (model.getCountyName()!=null&&!"".equals(model.getCountyName())&&!"--全部--".equals(URLDecoder.decode( model.getCountyName(), "utf-8"))) {
				if ("秦皇岛市".equals(model.getCountyName())) {
					countyName="";
				}else {
					countyName =URLDecoder.decode( model.getCountyName(), "utf-8");
				}				
			}else {
				countyName="";
			}
		}

		if (model.getId()!=null&&!"".equals(model.getId())) {
			id =model.getId();
		}else {
			id="";
		}
		if (model.getName()!=null&&!"".equals(model.getName())) {
			name =URLDecoder.decode( model.getName(), "utf-8");
		}else {
			name="";
		}
		if (model.getPrncpArea()!=null&&!"".equals(model.getPrncpArea())&&!"--全部--".equals(URLDecoder.decode( model.getPrncpArea(), "utf-8"))) {
			prncpArea =URLDecoder.decode( model.getPrncpArea(), "utf-8");
		}else {
			prncpArea="";
		}

		List<TbChnlIinfoM> list = Service.findChnl(statisMonth,statisMonth1, countyName, prncpArea,id, name, pageno, pagesize);
		int totalCount=Service.countlist(statisMonth,statisMonth1, countyName, prncpArea,id, name);
		//List<TbAccomdCoffcntLinfoM> list = Service.findall();
		exportChnlIinfoMList=Service.exportChnl(statisMonth, statisMonth1, countyName, prncpArea, id, name);
		JSONArray jsonArray = new JSONArray();
		if (list != null) {
			for (int i=0;i<list.size();i++){
				TbChnlIinfoM piece=list.get(i);

				//for (TbAccomdCoffcntLinfoM piece : list) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("value1", piece.getStatisMonth());
				jsonObject.put("value2", piece.getCountyName());
				jsonObject.put("value3", piece.getName());
				jsonObject.put("value4", piece.getId());
				jsonObject.put("value5", piece.getPrncpArea());
				jsonObject.put("value6", piece.getPrncpChnlId());
				jsonObject.put("value7", piece.getPrncpChnlName());
				jsonObject.put("value8", piece.getPnncpChnlType());
				if (quanXianPost=="区县负责人"||"区县负责人".equals(quanXianPost)) {
					jsonObject
					.put("value9",
							"<a href='javascript:DelChnl();'>删除</a>");
				}				
				jsonArray.add(jsonObject);
			}
			JSONObject jsonObjectFinal1 = new JSONObject();
			jsonObjectFinal1.put("total", totalCount);
			jsonObjectFinal1.put("rows", jsonArray);
			PrintWriter printWriter = response.getWriter();
			printWriter.print(jsonObjectFinal1.toString());

			printWriter.flush();
			printWriter.close();
		}

		return SUCCESS;
	}
	/**把区县转化为json,在JSP中combox中使用*/
	public String makeJson1() throws Exception{
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
	public String makeJson3() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		if (model.getCountyName()!=null&&!"".equals(model.getCountyName())&&!"--全部--".equals(URLDecoder.decode( model.getCountyName(), "utf-8"))) {
			countyName =URLDecoder.decode( model.getCountyName(), "utf-8");
		}else {
			countyName="";
		}
		prncpAreas =Service.findAllArea(countyName);
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();


		for (int i=prncpAreas.size();i>=0;i--) {
			if (i!=prncpAreas.size()) {
				String county=prncpAreas.get(i);
				jsonObject.put("id", county);
				jsonObject.put("text", county);
			}else {
				jsonObject.put("id", "--全部--");
				jsonObject.put("text", "--全部--");
			}

			jsonArray.add(jsonObject);
		}


		PrintWriter printWriter = response.getWriter();
		printWriter.print(jsonArray.toString());

		printWriter.flush();
		printWriter.close();
		return SUCCESS;
	}
	/**把员工姓名转化JSON在JSP中的combox中使用*/
	public String makeJson4() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		names =Service.findAllname();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();

		for (int i=0;i<names.size();i++){
			jsonObject.put("id", i+1);
			jsonObject.put("text", names.get(i));
			jsonArray.add(jsonObject);
		}
		PrintWriter printWriter = response.getWriter();
		printWriter.print(jsonArray.toString());

		printWriter.flush();
		printWriter.close();
		return SUCCESS;
	}
	/**删除记录*/
	public String delchnl() throws Exception {
		//TbAccomdCoffcntLinfoM coe = new TbAccomdCoffcntLinfoM();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		if (model.getPrncpChnlId()!=null){
			if (Service.delCnl(model.getPrncpChnlId())){
				msg="删除成功!";
//				PrintWriter printWriter = response.getWriter();
//				printWriter.print(msg);
//
//				printWriter.flush();
//				printWriter.close();
			}else{
				msg="删除失败!";
//				PrintWriter printWriter = response.getWriter();
//				printWriter.print(msg);
//				printWriter.flush();
//				printWriter.close();				
			}	
		}

		return "DEL";
	}

	/**编辑记录*/  
	public String Updatechnl() throws Exception{        	
		TbChnlIinfoM cof = new TbChnlIinfoM();
		cof.setStatisMonth(model.getStatisMonth());
		cof.setCountyName(URLDecoder.decode( model.getCountyName(), "utf-8"));
		cof.setName(URLDecoder.decode( model.getName(), "utf-8"));
		cof.setId(model.getId());
		cof.setPrncpArea(URLDecoder.decode( model.getPrncpArea(), "utf-8"));
		cof.setPrncpChnlId(model.getPrncpChnlId());
		cof.setPrncpChnlName(URLDecoder.decode( model.getPrncpChnlName(), "utf-8"));
		cof.setPnncpChnlType(URLDecoder.decode( model.getPnncpChnlType(), "utf-8"));
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		if(Service.saveOrUpdateCnl(cof)){
             msg_update="更新成功";
//			PrintWriter printWriter = response.getWriter();
//			printWriter.print(msg_update);
//			printWriter.flush();
//			printWriter.close();		
		}else{
			msg_update="更新失败";
//			PrintWriter printWriter = response.getWriter();
//			printWriter.print(msg_update);
//			printWriter.flush();
//			printWriter.close();
		}
		return "UPD";
	}
	/**查询指定渠道编码的名称和类型*/
	public String findnt() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		prncpChnlId=model.getPrncpChnlId();
		prncpChnlName=Service.findchnlname(prncpChnlId);
		pnncpChnlType=Service.findchnltype(prncpChnlId);
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("prncpChnlName", prncpChnlName);
		jsonObject.put("pnncpChnlType", pnncpChnlType);
		jsonArray.add(jsonObject);
		//JSONObject jsonObjectFinal1 = new JSONObject();
		//jsonObjectFinal1.put("datas", jsonArray);
		PrintWriter printWriter = response.getWriter();
		printWriter.print(jsonArray.toString());
	
		printWriter.flush();
		printWriter.close();
		return SUCCESS;		
	}
	/***导出渠道信息**/
	public String exportChanel() throws Exception {

		HttpServletResponse response = ServletActionContext.getResponse();
		String  exportType = "xls";
		// 定义表头
		String header = "月份 区县 姓名 编号 负责区域 负责渠道编码 渠道名称 负责渠道类型";
		// 获取数据
		List l = exportChnlIinfoMList;
		List<Object[]> datalist = new ArrayList<Object[]>();
		for (int i = 0; i < l.size(); i++) {
			TbChnlIinfoM chnlIinfoM = (TbChnlIinfoM) l.get(i);
			Object[] obj = { chnlIinfoM.getStatisMonth(), chnlIinfoM.getCountyName(),
					chnlIinfoM.getName(), chnlIinfoM.getId(),
					chnlIinfoM.getPrncpArea(),chnlIinfoM.getPrncpChnlId(),
					chnlIinfoM.getPrncpChnlName(),chnlIinfoM.getPnncpChnlType()};
			datalist.add(obj);
		}
		FileInputStream result = PrintExcelUtil.getDownloadFile(exportType,
				"渠道经理渠道基础信息", "渠道经理渠道基础信息", header, datalist);
		contentType = "application/vnd.ms-excel;charset=utf-8";
		downloadFile = result;
		fileName = "渠道经理渠道基础信息.xls";
		fileName = new String(fileName.getBytes(), "ISO8859-1");

		return "exportChanel";
	}

	
	private static void copy(File src, File dst) {
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);

				out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (true) {
					int temp = in.read(buffer);
					if (temp == -1)
						break;
					out.write(buffer, 0, temp);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**导入渠道经理渠道信息
	 * @throws IOException */
	public String importChanel() throws IOException {
		int countSucess=0;
		int countFail=0;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		
//		path=URLDecoder.decode(request.getParameter("path"),"utf-8");		
		if (fileName != null) {
			fileName = URLDecoder.decode(fileName, "UTF-8");
		}

		File uploadDir = new File(dirPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		String uploadFileName = new Date().getTime() + fileName;
		File uploadFile = new File(dirPath, uploadFileName);
		if (!uploadFile.exists()) {
			try {
				uploadFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (file != null) {
			copy(file, uploadFile);// 上传excel文件
		}
		
		POIFSFileSystem fs = null;

		HSSFWorkbook wb = null;

		fs = new POIFSFileSystem(new FileInputStream(dirPath+uploadFileName));

		wb = new HSSFWorkbook(fs);

		HSSFSheet sheet = wb.getSheetAt(0);

		HSSFRow row = null;

		HSSFCell cell = null;

		TbChnlIinfoM chnlIinfoM=new TbChnlIinfoM();

		int rowNum, cellNum;

		int i;

		String errorString="";

		String alertString="请检查对应行的渠道编码是否已存在，并且保证Excel文档中数据格式是文本类型！";

		rowNum = sheet.getLastRowNum();




		for (i = 1; i <= rowNum; i++) {

			row = sheet.getRow(i);

			cell = row.getCell((short) 0);

			chnlIinfoM.setStatisMonth(cell.getStringCellValue());

			cell = row.getCell((short) 1);

			chnlIinfoM.setCountyName(cell.getStringCellValue());

			cell = row.getCell((short) 2);

			chnlIinfoM.setName(cell.getStringCellValue());

			cell = row.getCell((short) 3);

			chnlIinfoM.setId(cell.getStringCellValue());

			cell = row.getCell((short) 4);

			chnlIinfoM.setPrncpArea(cell.getStringCellValue());

			cell = row.getCell((short) 5);

			chnlIinfoM.setPrncpChnlId(cell.getStringCellValue());

			cell = row.getCell((short) 6);

			chnlIinfoM.setPrncpChnlName(cell.getStringCellValue());

			cell = row.getCell((short) 7);

			chnlIinfoM.setPnncpChnlType(cell.getStringCellValue());

			if (chnlIinfoM.getPrncpChnlId()!=null&&!"".equals(chnlIinfoM.getPrncpChnlId())&&Service.isExistPId(chnlIinfoM.getPrncpChnlId())==false) {
				if(chnlIinfoM.getCountyName()==quanXianCountyName||quanXianCountyName.equals(chnlIinfoM.getCountyName())){
				if (Service.saveOrUpdateCnl(chnlIinfoM)) {
	
					countSucess=countSucess+1;
				}else {
	
					if (errorString=="") {
						errorString=""+(i+1);
					}else {
						errorString=errorString+","+(i+1);
					}
				}
			}
			}else {
	
				if (errorString=="") {
					errorString=""+(i+1);
				}else {
					errorString=errorString+","+(i+1);
				}
			}
		}

		countFail=rowNum-countSucess;

		//PrintWriter printWriter = response.getWriter();
		if (!"".equals(errorString)) {
			//printWriter.print("共"+rowNum+"条数据，成功："+countSucess+"条，失败："+countFail+"条!其中第"+errorString+"行导入失败！"+alertString);
		   imsg="共"+rowNum+"条数据，成功："+countSucess+"条，失败："+countFail+"条!其中第"+errorString+"行导入失败！"+alertString;
		}else {
			//printWriter.print("共"+rowNum+"条数据，成功："+countSucess+"条，失败："+countFail+"条!");
		   imsg="共"+rowNum+"条数据，成功："+countSucess+"条，失败："+countFail+"条!";
		}

		//printWriter.flush();
		//printWriter.close();
		return "importChanel";
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
	public void setFileFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMsg_update() {
		return msg_update;
	}
	public void setMsg_update(String msg_update) {
		this.msg_update = msg_update;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getImsg() {
		return imsg;
	}
	public void setImsg(String imsg) {
		this.imsg = imsg;
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
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	
    
}
