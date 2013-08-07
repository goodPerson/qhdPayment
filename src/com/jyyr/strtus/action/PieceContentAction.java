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

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts2.ServletActionContext;
import com.jyyr.orm.TbReckonPieceContentInfoM;
import com.jyyr.service.TbReckonPieceContentInfoMService;
import com.opensymphony.xwork2.ActionSupport;
import com.jyyr.common.*;

/**
 * 
 * @author 董晓斌
 * 
 */

@SuppressWarnings("serial")
public class PieceContentAction extends ActionSupport {
	// 角色
	private String str_isMana;

	public String getStr_isMana() {
		return str_isMana;
	}

	public void setStr_isMana(String str_isMana) {
		this.str_isMana = str_isMana;
	}

	// @Resource
	TbReckonPieceContentInfoMService tbPieceContent;
	private static List<TbReckonPieceContentInfoM> mylist = new ArrayList<TbReckonPieceContentInfoM>();
	private static List<TbReckonPieceContentInfoM> myEprlist = new ArrayList<TbReckonPieceContentInfoM>();
	private String staticMonth = "";
	private String bigPiece;
	private String smallPiece;
	private String scoreVal;
	private String piecePrice;
	private String staticId;//经分工号
	private String roleName;
    private String userName;
	private String regionId;
    private String regionName;
	// 分页
	private int page = 1;
	private int rows = 10;
	// 操作
	private String delteID;
	// 查询
	private String fromDate = "";
	private String toDate = "";
	// 导出
	private String contentType;
	private FileInputStream downloadFile;
	private String fileName;
	private String exportType;
	// 导入
	private String impPath;// 文件路径

	private String userId;// 工号
//	private String fileName = "";
	private String dirPath = "D:/qinhuangdao/";
	private File file;
	private final static int BUFFER_SIZE = 16 * 1024;
	public String execute() {
		return "success";
	}

	// 获取相应条件的数据
	public String getPieceContentM() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.addHeader("Content-Type", "text/html;charset=gbk");
		bigPiece = URLDecoder.decode(bigPiece, "utf-8");
		smallPiece = URLDecoder.decode(smallPiece, "utf-8");
		if (!bigPiece.equals("")) {
			bigPiece = bigPiece.substring(2, bigPiece.length());
		}
		if (!smallPiece.equals("")) {
			smallPiece = smallPiece.substring(2, smallPiece.length());
		}
		if (!fromDate.equals("")) {
			int c = fromDate.indexOf(",");
			fromDate = fromDate.substring(2, fromDate.length());
		}
		if (!toDate.equals("")) {
			toDate = toDate.substring(2, toDate.length());
		}
		int totalCount = tbPieceContent.findPieceContentCount(fromDate, toDate,
				bigPiece, smallPiece);
		mylist = tbPieceContent.findPieceContent(fromDate, toDate, bigPiece,
				smallPiece, page, rows);
		myEprlist = tbPieceContent.exportyPieceContent(fromDate, toDate,
				bigPiece, smallPiece);
		JSONArray jsonArray = new JSONArray();
		if (mylist != null) {
			for (TbReckonPieceContentInfoM piece : mylist) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("value1", piece.getStatisMonth());
				jsonObject.put("value2", piece.getReckonPieceMCls());
				jsonObject.put("value3", piece.getReckonPieceSCls());
				jsonObject.put("value4", piece.getIntegralScore());
				jsonObject.put("value5", piece.getCoreUitPrice());
				jsonObject
						.put("value6",
								"<a href='javascript:EditPieceContent();'>编辑</a>&nbsp"
										+ "<a href='javascript:DelPieceContent();'>删除</a>");
				jsonArray.add(jsonObject);
			}
			JSONObject jsonObjectFinal = new JSONObject();
			jsonObjectFinal.put("rows", jsonArray);
			jsonObjectFinal.put("total", totalCount);
			PrintWriter printWriter = response.getWriter();
			printWriter.print(jsonObjectFinal.toString());
			printWriter.flush();
			printWriter.close();
		}
		return SUCCESS;
	}

	// 删除计件目录
	public String deletePiece() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		if (!"".equals(delteID)) {
			delteID = URLDecoder.decode(delteID, "utf-8");
		}
		Boolean isSuccess = tbPieceContent.deletePieceContentByID(delteID);
//		PrintWriter printWriter = response.getWriter();
		//printWriter.print(isSuccess ? "删除成功！" : "删除失败！");
		//printWriter.flush();
		//printWriter.close();
		return SUCCESS;
	}

	// 修改新的计件
	public String addPieceContent() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");
		response.addHeader("Content-Type", "text/html;charset=gbk");
		bigPiece = URLDecoder.decode(bigPiece, "utf-8");
		smallPiece = URLDecoder.decode(smallPiece, "utf-8");
		Boolean isSuccess = tbPieceContent.addOrUpdatePieceContent(staticMonth,
				bigPiece, smallPiece, scoreVal, piecePrice);
		//PrintWriter printWriter = response.getWriter();
		//printWriter.print(isSuccess ? "更新成功！" : "更新失败！");
		//printWriter.flush();
		//printWriter.close();
		//smallPiece = "";
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
	// 批量导入计件信息
	public String imPortPieceContent() throws IOException {
		POIFSFileSystem fs = null;
		HSSFWorkbook wb = null;
//		impPath = URLDecoder.decode(impPath, "utf-8");
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
		fs = new POIFSFileSystem(new FileInputStream(dirPath+uploadFileName));
		wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		List<TbReckonPieceContentInfoM> importList = new ArrayList<TbReckonPieceContentInfoM>();
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			TbReckonPieceContentInfoM temp = new TbReckonPieceContentInfoM();
			HSSFRow row = sheet.getRow(i + 1);
			if (row.getPhysicalNumberOfCells() == 5) {
				String monString = row.getCell(0).getStringCellValue();
				if (monString.length() == 6) {
					temp.setStatisMonth(monString);
				} else {
					monString = monString.substring(0, 6);
					temp.setStatisMonth(monString);
				}
				temp.setReckonPieceMCls(row.getCell(1).getStringCellValue());
				temp.setReckonPieceSCls(row.getCell(2).getStringCellValue());
				temp.setIntegralScore(Double.parseDouble(row.getCell(3)
						.getStringCellValue()));
				temp.setCoreUitPrice(Double.parseDouble(row.getCell(4)
						.getStringCellValue()));
				if (!importList.contains(temp)) {
					importList.add(temp);
				}
			}
		}
		tbPieceContent.importPieceContent(importList);
		return SUCCESS;
	}

	// 导出EXCEL

	@SuppressWarnings("deprecation")
	public String getDownloadFileJ() throws Exception {
		if (!bigPiece.equals("")) {
			bigPiece = URLDecoder.decode(bigPiece, "utf-8");
		}
		if (!smallPiece.endsWith("")) {
			smallPiece = URLDecoder.decode(smallPiece, "utf-8");
		}
		exportType = "xls";
		// 定义表头
		String header = "月份 计件大类 计件分项 积分值 积分单价";
		// 获取数据
		List l = myEprlist;// tbPieceContent.exportyPieceContent(fromDate,
							// toDate, bigPiece, smallPiece);
		List<Object[]> datalist = new ArrayList<Object[]>();
		for (int i = 0; i < l.size(); i++) {
			TbReckonPieceContentInfoM tb = (TbReckonPieceContentInfoM) l.get(i);
			Object[] obj = { tb.getStatisMonth(), tb.getReckonPieceMCls(),
					tb.getReckonPieceSCls(), tb.getIntegralScore(),
					tb.getCoreUitPrice() };
			datalist.add(obj);
		}
		FileInputStream result = PrintExcelUtil.getDownloadFile(exportType,
				"计件目录信息", "计件目录统计信息", header, datalist);
		contentType = "application/vnd.ms-excel;charset=utf-8";
		downloadFile = result;
		fileName = "计件目录信息.xls";
		fileName = new String(fileName.getBytes(), "ISO8859-1");
		return SUCCESS;
	}

	public String getStaticMonth() {
		return staticMonth;
	}

	public void setStaticMonth(String staticMonth) {
		this.staticMonth = staticMonth;
	}

	public String getBigPiece() {
		return bigPiece;
	}

	public void setBigPiece(String bigPiece) {
		this.bigPiece = bigPiece;
	}

	public String getSmallPiece() {
		return smallPiece;
	}

	public void setSmallPiece(String smallPiece) {
		this.smallPiece = smallPiece;
	}

	public String getScoreVal() {
		return scoreVal;
	}

	public void setScoreVal(String scoreVal) {
		this.scoreVal = scoreVal;
	}

	public String getPiecePrice() {
		return piecePrice;
	}

	public void setPiecePrice(String piecePrice) {
		this.piecePrice = piecePrice;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getDelteID() {
		return delteID;
	}

	public void setDelteID(String delteID) {
		this.delteID = delteID;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public TbReckonPieceContentInfoMService getTbPieceContent() {
		return tbPieceContent;
	}

	public void setTbPieceContent(
			TbReckonPieceContentInfoMService tbPieceContent) {
		this.tbPieceContent = tbPieceContent;
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

	public FileInputStream getDownloadFile() {
		return downloadFile;
	}

	public String getExportType() {
		return exportType;
	}

	public void setExportType(String exportType) {
		this.exportType = exportType;
	}

	public String getImpPath() {
		return impPath;
	}

	public void setImpPath(String impPath) {
		this.impPath = impPath;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
