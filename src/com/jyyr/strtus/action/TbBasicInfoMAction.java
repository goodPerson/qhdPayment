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
import java.net.URLEncoder;
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
import com.jyyr.orm.TbBasicInfoM;
import com.jyyr.service.TbBasicInfoMService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@SuppressWarnings("serial")
public class TbBasicInfoMAction extends ActionSupport implements ModelDriven<TbBasicInfoM>{
	/** ͨ������ע��ColumnsService���ʵ�� */
	TbBasicInfoMService service;

	/** Ա���������������г��õĲ���ֵ */
	private String actionMsg;	//Action�䴫�ݵ���Ϣ����
	private String addMsg;  //��ӵ�msg
	private String upMsg; //�޸�msg
	private  List<TbBasicInfoM> basicInfoMList;//�������������Ϣ�б�
	private static List<TbBasicInfoM> exportBasicInfoMList= new ArrayList<TbBasicInfoM>();	//�����������������Ϣ�б�
	private String id;//����������
	private String staticId;//���ֹ���
	private String roleName;
    private String userName;
	private String regionId;
    private String regionName;
	private static String quanXianCountyName="";//

	private static String quanXianPost="";//



	/**Ա��������Ϣ�б��ҳ�Ĳ���*/
	private int pageNo; //��ǰҳ��
	private int pageSize; //ÿҳ��¼��

	private String page;
	private String rows;
	private int total;

	private String path;//������ļ���·��
	private String fileName = "";
	private String dirPath = "D:/qinhuangdao/";
	private File file;
	private final static int BUFFER_SIZE = 16 * 1024;
	String contentType;//��������
	FileInputStream downloadFile;//
	String imsg="";
//	String fileName;//�ļ���

	//����ģ������
	private TbBasicInfoM model=new TbBasicInfoM();//���ڷ�װԱ������ģ��

	/**�����û�����ҳ��
	 * ����url���ݵ�Id������ͨ��Id��ȡ��Ӧ��ְλ�����������������IdΪ���ַ���û��Ȩ�޽��˸�ҳ��
	 * �����������ܽ����޸ġ����������롢ɾ������
	 * �и����ˡ���������Ա�ܲ鿴
	 **/
	public String entry() throws IOException {		
		List<TbBasicInfoM> basicInfoMsByIdLsit=new ArrayList<TbBasicInfoM>();
		TbBasicInfoM basicInfoM1=new TbBasicInfoM();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		String idString=request.getParameter("Id");
		if (idString!=null&&!"".equals(idString)) {
			basicInfoMsByIdLsit=service.findUserById(idString);
			if (basicInfoMsByIdLsit.size()!=0) {
				basicInfoM1=basicInfoMsByIdLsit.get(0);
				quanXianCountyName=basicInfoM1.getCountyName();
				quanXianPost=basicInfoM1.getPost();
				request.setAttribute("quanXianCountyName", quanXianCountyName);
				request.setAttribute("quanXianPost", quanXianPost);
				if (quanXianPost=="��������"||"��������".equals(quanXianPost)) {
		
					return "FAIL";
				}else {
					return SUCCESS;
				}
			}else {	
				return "FAIL";
			}			
		}else {
			return "FAIL";
		}		
	}

	/**
	 * ��ȡ�����б�����Json�����󶨵������˵�
	 * */
	public String county() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		List<String> countys = service.browseCounty(quanXianCountyName);
		JSONArray jsonArray = new JSONArray();
		if (countys != null) {
			if (countys.size()>1) {
				for (int i=countys.size();i>=0;i--) {
					JSONObject jsonObjectFinal = new JSONObject();

					if (i!=countys.size()) {
						String county=countys.get(i);
						jsonObjectFinal.put("id", county);
						jsonObjectFinal.put("countyName", county);
					}else {
						jsonObjectFinal.put("id", "--ȫ��--");
						jsonObjectFinal.put("countyName", "--ȫ��--");
					}

					jsonArray.add(jsonObjectFinal);
				}
			}else {
				JSONObject jsonObjectFinal = new JSONObject();
				String county=countys.get(0);
				jsonObjectFinal.put("id", county);
				jsonObjectFinal.put("countyName", county);
				jsonArray.add(jsonObjectFinal);
			}	
			PrintWriter out=response.getWriter();
			out.print(jsonArray.toString());
			out.flush();
			out.close();

		}

		return SUCCESS;
	}

	/**
	 * ��ȡ�����б�����Json�����󶨵������˵�
	 * */
	public String area() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		String countyName=URLDecoder.decode(request.getParameter("countyName"),"utf-8");

		List<String> areas = service.browseArea(countyName);
		JSONArray jsonArray = new JSONArray();
		if (areas != null) {
			for (int i=areas.size();i>=0;i--) {

				JSONObject jsonObjectFinal = new JSONObject();
				if (i!=areas.size()) {
					String county=areas.get(i);
					jsonObjectFinal.put("id", i+1);
					jsonObjectFinal.put("areaName", county);
				}else {
					jsonObjectFinal.put("id", i+1);
					jsonObjectFinal.put("areaName", "--ȫ��--");
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

	/** ��������Ա���������� 
	 *
	 **/
	public String addTbBasicInfoM() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		TbBasicInfoM tempTbBasicInfoM = new TbBasicInfoM();
		tempTbBasicInfoM.setCountyName(URLDecoder.decode(model.getCountyName(),"utf-8"));
		tempTbBasicInfoM.setEntryTime(model.getEntryTime());
		tempTbBasicInfoM.setLeftTime(model.getLeftTime());
		tempTbBasicInfoM.setName(URLDecoder.decode(model.getName(),"utf-8"));
		tempTbBasicInfoM.setPost(URLDecoder.decode(model.getPost(),"utf-8"));
		tempTbBasicInfoM.setPrncpArea(URLDecoder.decode(model.getPrncpArea(),"utf-8"));
		tempTbBasicInfoM.setStatisMonth(model.getStatisMonth());
		tempTbBasicInfoM.setUserStat(URLDecoder.decode(model.getUserStat(),"utf-8"));
		if (model.getId()!=null&&!"".equals(model.getId())&&service.isIdExist(model.getId())==false) {
			tempTbBasicInfoM.setId(model.getId());
			if (service.saveOrUpdateBasicInfoM(tempTbBasicInfoM)){
				addMsg="�����ɹ���";
//				PrintWriter printWriter = response.getWriter();
//				printWriter.print("�����ɹ���");
//				printWriter.flush();
//				printWriter.close();
			}else{
				addMsg="����ʧ�ܣ�";
//				PrintWriter printWriter = response.getWriter();
//				printWriter.print("����ʧ�ܣ�");
//				printWriter.flush();
//				printWriter.close();
			}
		}
		

		return "addTbBasicInfoM";
	}

	/**ɾ������
	 * 
	 * */
	public String delUser() throws IOException{

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		if (model.getId()!=null){
			if (service.delBasicInfoM(model.getId())){
				actionMsg="ɾ���ɹ���";
//				request.setAttribute("actionMsg",actionMsg);
//				PrintWriter printWriter = response.getWriter();
//				printWriter.print("ɾ���ɹ���");
//				printWriter.flush();
//				printWriter.close();

			}else{
				actionMsg="ɾ��ʧ�ܣ�";
//				request.setAttribute("actionMsg",actionMsg);
//				PrintWriter printWriter = response.getWriter();
//				printWriter.print("ɾ��ʧ�ܣ�");
//				printWriter.flush();
//				printWriter.close();
			}			
		}
//		actionMsg = URLEncoder.encode(actionMsg,"gbk");
		return "delUser";
	}

	/**�޸���Ϣ
	 * @throws IOException */
	public String updateAndAddUser() throws IOException {	
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		TbBasicInfoM tempTbBasicInfoM = new TbBasicInfoM();
		tempTbBasicInfoM.setCountyName(URLDecoder.decode(model.getCountyName(),"utf-8"));
		tempTbBasicInfoM.setEntryTime(model.getEntryTime());
		tempTbBasicInfoM.setLeftTime(model.getLeftTime());
		tempTbBasicInfoM.setName(URLDecoder.decode(model.getName(),"utf-8"));
		tempTbBasicInfoM.setPost(URLDecoder.decode(model.getPost(),"utf-8"));
		tempTbBasicInfoM.setPrncpArea(URLDecoder.decode(model.getPrncpArea(),"utf-8"));
		tempTbBasicInfoM.setStatisMonth(model.getStatisMonth());
		tempTbBasicInfoM.setUserStat(URLDecoder.decode(model.getUserStat(),"utf-8"));
		tempTbBasicInfoM.setId(model.getId());
		if (service.saveOrUpdateBasicInfoM(tempTbBasicInfoM)){
			upMsg="���³ɹ���";
//			PrintWriter printWriter = response.getWriter();
//			printWriter.print("���³ɹ���");
//			printWriter.flush();
//			printWriter.close();
		}else{
			upMsg="����ʧ�ܣ�";
//			PrintWriter printWriter = response.getWriter();
//			printWriter.print("����ʧ�ܣ�");
//			printWriter.flush();
//			printWriter.close();
		}
		return "updateAndAddUser";
	}

	/**��ѯ�û���Ϣ
	 * @throws IOException */
	public String searchUser() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		if (request.getParameter("page")!=null&&!"".equals(request.getParameter("page"))) {
			pageNo=Integer.parseInt(request.getParameter("page"));
		}
		else {
			pageNo=1;
		}

		if (request.getParameter("rows")!=null&&!"".equals(request.getParameter("rows"))) {
			pageSize=Integer.parseInt(request.getParameter("rows"));
		}else {
			pageSize=10;
		}

		String dateString;
		String toDateString;
		String countyString;
		String areaString;
		String nameString;
		String idString;

		if (quanXianCountyName!="�ػʵ���"&&!"�ػʵ���".equals(quanXianCountyName)) {
			countyString=quanXianCountyName;
		}else {

			if (model.getCountyName()!=null&&!"".equals(model.getCountyName())&&!"--ȫ��--".equals(URLDecoder.decode(model.getCountyName(),"utf-8"))) {
				countyString=URLDecoder.decode(model.getCountyName(),"utf-8");
			}else{
				countyString="";
			}
		}

		if (model.getPrncpArea()!=null&&!"".equals(model.getPrncpArea())&&!"--ȫ��--".equals(URLDecoder.decode(model.getPrncpArea(),"utf-8"))) {
			areaString=URLDecoder.decode(model.getPrncpArea(),"utf-8");
		}else{
			areaString="";
		}

		if (model.getName()!=null&&!"".equals(model.getName())) {
			nameString=URLDecoder.decode(model.getName(), "utf-8");
		}else {
			nameString="";
		}

		if (model.getStatisMonth()!=null&&!"".equals(model.getStatisMonth())) {
			dateString=URLDecoder.decode(model.getStatisMonth(),"utf-8");
		}else {
			dateString="";
		}

		if (request.getParameter("StatisMonth1")!=null&&!"".equals(request.getParameter("StatisMonth1"))) {
			toDateString=request.getParameter("StatisMonth1");
		}else {
			toDateString="";
		}

		if (model.getId()!=null&&!"".equals(model.getId())) {
			idString=URLDecoder.decode(model.getId(),"utf-8");
		}else {
			idString="";
		}

		basicInfoMList = service.findBasicInfoM(dateString,toDateString,countyString,areaString,nameString,idString, pageNo, pageSize);//pageNo, pageSize
		exportBasicInfoMList=service.findBasicInfoM1(dateString,toDateString,countyString,areaString,nameString,idString);
		JSONArray jsonArray = new JSONArray();
		if (basicInfoMList != null) {
			for (int i=0;i<basicInfoMList.size();i++) {
				TbBasicInfoM piece=basicInfoMList.get(i);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("value1", piece.getStatisMonth());
				jsonObject.put("value2", piece.getCountyName());
				jsonObject.put("value3", piece.getName());
				jsonObject.put("value4", piece.getId());
				jsonObject.put("value5", piece.getPrncpArea());
				jsonObject.put("value6", piece.getUserStat());
				jsonObject.put("value7", piece.getPost());
				jsonObject.put("value8", piece.getEntryTime());
				if (piece.getLeftTime()!=null&&!"".equals(piece.getLeftTime())) {
					jsonObject.put("value9", piece.getLeftTime());
				}else {
					jsonObject.put("value9", "--");
				}				
				if (quanXianPost=="���ظ�����"||"���ظ�����".equals(quanXianPost)) {
					jsonObject.put("value10",
							"<a href='javascript:editUser();'>�༭</a>&nbsp"
									+ "<a href='javascript:delUser();'>ɾ��</a>");
				}
				jsonArray.add(jsonObject);
			}
			total=exportBasicInfoMList.size();

			JSONObject jsonObjectFinal = new JSONObject();
			jsonObjectFinal.put("rows", jsonArray); 
			jsonObjectFinal.put("total", total);
			PrintWriter out=response.getWriter();
			out.print(jsonObjectFinal.toString());
			out.flush();
			out.close();
		}
		return SUCCESS;
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
	/**���빤��
	 * @throws IOException */
	@SuppressWarnings("deprecation")
	public String importUser() throws IOException {
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
			copy(file, uploadFile);// �ϴ�excel�ļ�
		}
		
		POIFSFileSystem fs = null;

		HSSFWorkbook wb = null;

		fs = new POIFSFileSystem(new FileInputStream(dirPath+uploadFileName));

		wb = new HSSFWorkbook(fs);

		HSSFSheet sheet = wb.getSheetAt(0);

		HSSFRow row = null;

		HSSFCell cell = null;

		TbBasicInfoM basicInfoM = new TbBasicInfoM();

		int rowNum;

		int i;

		String errorString="";
		String errorString1="";

		rowNum = sheet.getLastRowNum();




		for (i = 1; i <= rowNum; i++) {

			row = sheet.getRow(i);

			cell = row.getCell((short) 0);

			basicInfoM.setStatisMonth(cell.getStringCellValue());

			cell = row.getCell((short) 1);

			basicInfoM.setCountyName(cell.getStringCellValue());

			cell = row.getCell((short) 2);

			basicInfoM.setName(cell.getStringCellValue());

			cell = row.getCell((short) 3);

			basicInfoM.setId(cell.getStringCellValue());

			cell = row.getCell((short) 4);

			basicInfoM.setPrncpArea(cell.getStringCellValue());

			cell = row.getCell((short) 5);

			basicInfoM.setUserStat(cell.getStringCellValue());

			cell = row.getCell((short) 6);

			basicInfoM.setPost(cell.getStringCellValue());

			cell = row.getCell((short) 7);

			basicInfoM.setEntryTime(cell.getStringCellValue());

			cell = row.getCell((short) 8);
			
			basicInfoM.setLeftTime(cell.getStringCellValue());
			if (basicInfoM.getId()!=null&&!"".equals(basicInfoM.getId())&&service.isIdExist(basicInfoM.getId())==false) {
				if(basicInfoM.getCountyName()==quanXianCountyName||quanXianCountyName.equals(basicInfoM.getCountyName())||basicInfoM.getPost()=="��������"||"��������".equals(basicInfoM.getPost())){
					if (service.saveOrUpdateBasicInfoM(basicInfoM)) {
						countSucess=countSucess+1;
					}else {
						if (errorString=="") {
							errorString=""+(i+1);
						}else {
							errorString=errorString+","+(i+1);
						}
					}
				}else {				
					if (errorString1=="") {						
						errorString1=""+(i+1);
					}else {						
						errorString1=errorString1+","+(i+1);
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

//		PrintWriter printWriter = response.getWriter();
		if (!"".equals(errorString)&&!"".equals(errorString1)) {
			imsg="��"+rowNum+"�����ݣ��ɹ���"+countSucess+"����ʧ�ܣ�"+countFail+"��!���е�"+errorString+"�е���ʧ������Ϊ�����Ѵ��ڣ�"+"������ʧ�����е�"+errorString1+"������ΪȨ�޲��㵼�µģ���˶Թ��ź�����Ȩ�ޣ����ұ�֤Excel�ĵ������ݸ�ʽ���ı����ͣ�";
			//printWriter.print("��"+rowNum+"�����ݣ��ɹ���"+countSucess+"����ʧ�ܣ�"+countFail+"��!���е�"+errorString+"�е���ʧ������Ϊ�����Ѵ��ڣ�"+"������ʧ�����е�"+errorString1+"������ΪȨ�޲��㵼�µģ���˶Թ��ź�����Ȩ�ޣ����ұ�֤Excel�ĵ������ݸ�ʽ���ı����ͣ�");
		}else if(!"".equals(errorString)&&"".equals(errorString1)){
			imsg="��"+rowNum+"�����ݣ��ɹ���"+countSucess+"����ʧ�ܣ�"+countFail+"��!���е�"+errorString+"�е���ʧ������Ϊ�����Ѵ��ڣ���˶Թ��ţ����ұ�֤Excel�ĵ������ݸ�ʽ���ı����ͣ�";
			//printWriter.print("��"+rowNum+"�����ݣ��ɹ���"+countSucess+"����ʧ�ܣ�"+countFail+"��!���е�"+errorString+"�е���ʧ������Ϊ�����Ѵ��ڣ���˶Թ��ţ����ұ�֤Excel�ĵ������ݸ�ʽ���ı����ͣ�");
		}else if("".equals(errorString)&&!"".equals(errorString1)){
			imsg="��"+rowNum+"�����ݣ��ɹ���"+countSucess+"����ʧ�ܣ�"+countFail+"��!���е�"+errorString1+"�е���ʧ������ΪȨ�޲��㵼�µģ�"+"������ʧ�����е�"+errorString1+"������ΪȨ�޲��㵼�µģ���˶�����Ȩ�ޣ����ұ�֤Excel�ĵ������ݸ�ʽ���ı����ͣ�";
			//printWriter.print("��"+rowNum+"�����ݣ��ɹ���"+countSucess+"����ʧ�ܣ�"+countFail+"��!���е�"+errorString1+"�е���ʧ������ΪȨ�޲��㵼�µģ�"+"������ʧ�����е�"+errorString1+"������ΪȨ�޲��㵼�µģ���˶�����Ȩ�ޣ����ұ�֤Excel�ĵ������ݸ�ʽ���ı����ͣ�");
		}else if("".equals(errorString)&&"".equals(errorString1)){
			imsg="��"+rowNum+"�����ݣ��ɹ���"+countSucess+"����ʧ�ܣ�"+countFail+"��!";
			//printWriter.print("��"+rowNum+"�����ݣ��ɹ���"+countSucess+"����ʧ�ܣ�"+countFail+"��!");
		}

//		printWriter.flush();
//		printWriter.close();
		return "importUser";
	}

	/**��������
	 * @throws Exception */
	public String exportUser() throws Exception {

		HttpServletResponse response = ServletActionContext.getResponse();
		String  exportType = "xls";
		// �����ͷ
		String header = "�·� ���� ���� ���� �������� ״̬ ��λ ��ְʱ�� ��ְʱ��";
		// ��ȡ����
		List l = exportBasicInfoMList;
		List<Object[]> datalist = new ArrayList<Object[]>();
		for (int i = 0; i < l.size(); i++) {
			TbBasicInfoM basicInfoM = (TbBasicInfoM) l.get(i);
			Object[] obj = { basicInfoM.getStatisMonth(), basicInfoM.getCountyName(),
					basicInfoM.getName(), basicInfoM.getId(),
					basicInfoM.getPrncpArea(),basicInfoM.getUserStat(),
					basicInfoM.getPost(),basicInfoM.getEntryTime(),basicInfoM.getLeftTime() };
			datalist.add(obj);
		}
		FileInputStream result = PrintExcelUtil.getDownloadFile(exportType,
				"�������������Ϣ", "�������������Ϣ", header, datalist);
		contentType = "application/vnd.ms-excel;charset=utf-8";
		downloadFile = result;
		fileName = "�������������Ϣ.xls";
		fileName = new String(fileName.getBytes(), "ISO8859-1");

		return "exportUser";
	}

	public FileInputStream getDownloadFile() {
		return downloadFile;
	}

	public void setDownloadFile(FileInputStream downloadFile) {
		this.downloadFile = downloadFile;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}




	public String getFileName() {
		return fileName;
	}


	public void setFileFileName(String fileName) {
		this.fileName = fileName;
	}



	public TbBasicInfoMService getService() {
		return service;
	}

	public void setService(TbBasicInfoMService service) {
		this.service = service;
	}

	public String getActionMsg() {
		return actionMsg;
	}
	public void setActionMsg(String actionMsg) {
		this.actionMsg = actionMsg;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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



	public void setModel(TbBasicInfoM model) {
		this.model = model;
	}

	public TbBasicInfoM getModel() {
		return model;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getAddMsg() {
		return addMsg;
	}

	public void setAddMsg(String addMsg) {
		this.addMsg = addMsg;
	}

	public String getUpMsg() {
		return upMsg;
	}

	public void setUpMsg(String upMsg) {
		this.upMsg = upMsg;
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
