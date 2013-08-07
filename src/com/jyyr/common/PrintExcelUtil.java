package com.jyyr.common;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.contrib.HSSFCellUtil;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.struts2.ServletActionContext;

import com.jyyr.pojo.UserInfo;

/**
 * �ù��������ڱ���ĵ���;
 * 
 * @author Administrator
 * 
 */
public class PrintExcelUtil {

	@SuppressWarnings("deprecation")
	public static FileInputStream getDownloadFile(String exportType,
			String sheetName, String titleName, String header,
			List<Object[]> operationDatas) throws Exception {
		if ("xls".equals(exportType)) {
			HttpServletRequest request = ServletActionContext.getRequest();
			// UserInfo userInfo =
			// (UserInfo)request.getSession().getAttribute("userInfo");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
			Calendar calendar = Calendar.getInstance();
			String currentTime = sdf.format(calendar.getTime());

			// ����������
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet(sheetName);

			// ��������
			HSSFFont headFont = workbook.createFont();
			headFont.setColor(HSSFColor.SEA_GREEN.index);
			headFont.setFontName("����");
			headFont.setFontHeightInPoints((short) 14);
			headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			headFont.setUnderline(HSSFFont.ANSI_CHARSET);

			// ��ͷ
			HSSFFont headFont1 = workbook.createFont();
			headFont1.setColor(HSSFColor.SEA_GREEN.index);
			headFont1.setFontName("����");
			headFont1.setFontHeightInPoints((short) 10);
			headFont1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			// ����
			HSSFFont hfont = workbook.createFont();
			hfont.setColor(HSSFColor.BLUE.index);
			headFont1.setFontName("����");
			headFont1.setFontHeightInPoints((short) 10);
			hfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			HSSFCellStyle headStyle = workbook.createCellStyle();
			headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			headStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			headStyle.setLocked(true);
			headStyle.setFont(headFont);

			HSSFCellStyle headStyle1 = workbook.createCellStyle();
			headStyle1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			headStyle1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			headStyle1.setLocked(true);
			headStyle1.setFont(headFont1);

			HSSFCellStyle headStyle2 = workbook.createCellStyle();
			headStyle2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			headStyle2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			headStyle2.setBottomBorderColor(HSSFColor.BLACK.index);
			headStyle2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			headStyle2.setBorderRight(HSSFCellStyle.BORDER_THIN);
			headStyle2.setTopBorderColor(HSSFColor.BLACK.index);
			headStyle2.setBorderTop(HSSFCellStyle.BORDER_THIN);
			headStyle2.setFillBackgroundColor(HSSFColor.YELLOW.index);
			headStyle2.setFillForegroundColor(HSSFColor.YELLOW.index);
			headStyle2.setFont(hfont);

			HSSFCellStyle style = workbook.createCellStyle();

			style.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBottomBorderColor(HSSFColor.BLACK.index);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setRightBorderColor(HSSFColor.BLACK.index);
			style.setLeftBorderColor(HSSFColor.BLACK.index);
			style.setTopBorderColor(HSSFColor.BLACK.index);

			// ������һ��
			HSSFRow row0 = sheet.createRow(0);
			// ������һ��
			// HSSFCellUtil.createCell(row0, 0, "");
			HSSFCell row0cell = row0.createCell(0);
			row0cell.setCellValue("");

			HSSFRow row1 = sheet.createRow(1);
			// HSSFCellUtil.createCell(row1, 0, titleName, headStyle);
			HSSFCell row1cell = row1.createCell(0);
			row1cell.setCellValue(titleName);
			row1cell.setCellStyle(headStyle2);

			// ����������
			HSSFRow row2 = sheet.createRow(4);

			String[] headerArray = header.trim().split("\\s");
			for (int j = 0; j < headerArray.length; j++) {
				sheet.setColumnWidth(j, headerArray[j].length() * 500 + 1000);
				// HSSFCellUtil.createCell(row2, j, headerArray[j], headStyle2);
				HSSFCell row2cell = row2.createCell(j);
				row2cell.setCellValue(headerArray[j]);
				row2cell.setCellStyle(headStyle2);
			}
			// �ϲ���Ԫ��
			CellRangeAddress range1 = new CellRangeAddress(1, 2, 0,
					headerArray.length - 1);
			sheet.addMergedRegion(range1);

			CellRangeAddress rangeM = new CellRangeAddress(3, 3, 0,
					headerArray.length - 1);
			sheet.addMergedRegion(rangeM);
			// ҵ�����ݵ���
			if (operationDatas != null) {
				for (int i = 0; i < operationDatas.size(); i++) {
					HSSFRow rowi = sheet.createRow(i + 5);
					Object[] datas = operationDatas.get(i);
					for (int j = 0; j < datas.length; j++) {
						if (datas[j] == null
								|| "[item: null]".equals(datas[j] + "")) {
							datas[j] = "��������";
						}
						// HSSFCellUtil.createCell(rowi, j, datas[j].toString(),
						// style);
						HSSFCell cell = rowi.createCell(j);
						cell.setCellValue(datas[j].toString());
					}
				}
			}

			// ��β
			int footRowNum1 = sheet.getLastRowNum() + 1;
			HSSFRow lastRow1 = sheet.createRow(footRowNum1 + 1);
			// HSSFCellUtil.createCell(lastRow1, 0, "��ѯʱ�䣺" + currentTime +
			// "      ����Ա��"+userInfo.getUser().getUserName(), headStyle1);
			HSSFCell lastrow1Cell = lastRow1.createCell(0);
			lastrow1Cell.setCellValue("��ѯʱ�䣺" + currentTime + "      ����Ա��");
			lastrow1Cell.setCellStyle(headStyle1);
			// �ϲ���Ԫ��
			CellRangeAddress range2 = new CellRangeAddress(footRowNum1 + 1,
					footRowNum1 + 1, 0, headerArray.length - 1);
			sheet.addMergedRegion(range2);

			int footRowNum = sheet.getLastRowNum() + 2;
			HSSFRow lastRow = sheet.createRow(footRowNum + 1);
			// HSSFCellUtil.createCell(lastRow, 0,
			// "����:"+userInfo.getUser().getDept() +
			// "      ����Ա��:"+userInfo.getGroup().getUserGroupName(),
			// headStyle1);
			// HSSFCellUtil.createCell(lastRow, 0, "����:" + "      ����Ա��:",
			// headStyle1);
			HSSFCell lastrowCell = lastRow.createCell(0);
			lastrowCell.setCellValue("����:" + "      ����Ա��:");
			lastrowCell.setCellStyle(headStyle1);
			// �ϲ���Ԫ��
			CellRangeAddress range3 = new CellRangeAddress(footRowNum + 1,
					footRowNum + 1, 0, headerArray.length - 1);
			sheet.addMergedRegion(range3);

			File dir = new File(FileProcess.EXPORT_PATH);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			FileProcess.deleteExpireFile(FileProcess.EXPORT_PATH);

			String filename = UUID.randomUUID().toString() + ".xls";
			File file = new File(dir + "/" + filename);

			FileOutputStream os = new FileOutputStream(file);
			workbook.write(os);
			os.close();

			FileInputStream result = new FileInputStream(dir + "/" + filename);

			return result;
		}
		return null;
	}
}
