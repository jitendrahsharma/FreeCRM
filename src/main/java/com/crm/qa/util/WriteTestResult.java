package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteTestResult
{
public static String  TESTDATA_SHEET_PATH="C:/Users/Jitendra/workspace/FreeCRM/src/main/java/com/crm/qa/testdata/FreeCRMTestData.xlsx";
//public String path;
public FileInputStream fis=null;
public FileOutputStream fos=null;
public XSSFWorkbook workbook=null;
public XSSFSheet sheet=null;
public XSSFRow row=null;
public XSSFCell cell=null;
public boolean setCellData(String sheetName,String colName,int rowNum, String data){
	try{
	fis = new FileInputStream(TESTDATA_SHEET_PATH); 
	workbook = new XSSFWorkbook(fis);

	if(rowNum<=0)
		return false;
	
	int index = workbook.getSheetIndex(sheetName);
	int colNum=-1;
	if(index==-1)
		return false;
	sheet = workbook.getSheetAt(index);
	row=sheet.getRow(0);
	for(int i=0;i<row.getLastCellNum();i++){
		//System.out.println(row.getCell(i).getStringCellValue().trim());
		if(row.getCell(i).getStringCellValue().trim().equals(colName))
			colNum=i;
	}
	if(colNum==-1)
		return false;

	sheet.autoSizeColumn(colNum); 
	row = sheet.getRow(rowNum-1);
	if (row == null)
		row = sheet.createRow(rowNum-1);
	
	cell = row.getCell(colNum);	
	if (cell == null)
        cell = row.createCell(colNum);
     cell.setCellValue(data);
     fos = new FileOutputStream(TESTDATA_SHEET_PATH);
     workbook.write(fos);
     fos.close();	
     }
	catch(Exception e){
		e.printStackTrace();
		return false;
	}
	return true;
}

}
