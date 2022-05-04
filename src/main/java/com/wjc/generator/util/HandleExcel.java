package com.wjc.generator.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class HandleExcel {

	//导出文件存放地址
	public static final String EXPORT_EXCEL_LOCATION = "D:\\excelFile\\";

	public Map<String, Object> exportCSV(List<Object> firstCell,
			List<List<Object>> contentCells, String excelName, String filePathName) {
		Map<String, Object> result = new HashMap<String, Object>();
		File csvFile = null;
		BufferedWriter csvWtriter = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		csvFile = new File(filePathName + format.format(new Date()) + excelName + ".csv");
		File parent = csvFile.getParentFile();
		if (parent != null && !parent.exists()) {
			parent.mkdirs();
		}
		try {
			csvFile.createNewFile();
			// GB2312使正确读取分隔符","
			csvWtriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8"), 1024);
			// 写入文件头部
			writeRow(firstCell, csvWtriter);

			// 写入文件内容
			for (List<Object> row : contentCells) {
				writeRow(row, csvWtriter);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		result.put("url", csvFile);
		result.put("success", Boolean.valueOf(true));
		return result;

	}

	private void writeRow(List<Object> row, BufferedWriter csvWriter) throws IOException {
		for (Object data : row) {
			String rowStr = "\"" + data + "\",";
			csvWriter.write(rowStr);
		}
		csvWriter.newLine();
	}

	public String exportExcel(Map<Integer, Object> firstCell,
			List<Map<Integer, Object>> contentCells, String excelName, String filePath) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = excelName + format.format(new Date()) + ".xls";
		filePath = filePath + fileName;
		File file = new File(filePath);
		if (!file.isFile()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(excelName);
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle style = workbook.createCellStyle();

		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 11);
		font.setFontName("宋体");
		font.setBold(true);

		style.setFillForegroundColor((short) 63);
		style.setFont(font);

		HSSFCell cell = null;
		for (int i = 0; i < firstCell.size(); i++) {
			cell = row.createCell(i);
			cell.setCellStyle(style);
			cell.setCellValue(new HSSFRichTextString((String) firstCell.get(i)));
		}
		if (contentCells.size() <= 0) {
			return null;
		}
		for (int i = 0; i < contentCells.size(); i++) {
			row = sheet.createRow(i + 1);
			Map<Integer, Object> contentCell = contentCells.get(i);
			for (int j = 0; j < contentCell.size(); j++) {
				if(contentCell.get(j) == null){
					row.createCell(j).setCellValue("");
					continue;
				}
				row.createCell(j).setCellValue(contentCell.get(j).toString());
			}
		}
		try {
			OutputStream os = new FileOutputStream(file);
			workbook.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "excelFile\\" + fileName;
	}

	public List<Object> importExcel(MultipartFile uploadFile, String fileName) {
		List<Object> importData = new ArrayList<Object>();
		try {
			InputStream is = uploadFile.getInputStream();
			Workbook hssfWorkbook = null;
			if (fileName.endsWith("xlsx")) {
				hssfWorkbook = new XSSFWorkbook(is);
			} else if (fileName.endsWith("xls")) {
				hssfWorkbook = new HSSFWorkbook(is);
			}
			for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
				Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
				if (hssfSheet != null) {
					List<List<String>> sheets = new ArrayList<List<String>>();
					for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
						Row hssfRow = hssfSheet.getRow(rowNum);
						if(hssfRow == null){
							continue;
						}
						List<String> rows = new ArrayList<String>();
						for (int cellNum = 0; cellNum < hssfRow.getLastCellNum(); cellNum++) {
							Cell cell = hssfRow.getCell(cellNum);
							if(cell == null){
								rows.add("");
								continue;
							}
							if (CellType.NUMERIC.equals(cell.getCellTypeEnum())) {
								//判断是否为日期类型
								if(HSSFDateUtil.isCellDateFormatted(cell)){
									//用于转化为日期格式
									Date d = cell.getDateCellValue();
									DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									String cellContent = formater.format(d);
									rows.add(cellContent);
									continue;
								}
							}
							cell.setCellType(CellType.STRING);
							String cellContent = cell.getStringCellValue();
							rows.add(cellContent);
						}
						sheets.add(rows);
					}
					importData.add(sheets);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return importData;
	}

}
