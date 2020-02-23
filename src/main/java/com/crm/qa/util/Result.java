package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class Result 
{
	static String  TESTDATA_SHEET_PATH="C:/Users/Jitendra/workspace/FreeCRM/src/main/java/com/crm/qa/testdata/FreeCRMTestData.xlsx";
	 public static String ColName="Result";
     public static  int col_num;
      static HSSFWorkbook workbook;
      static HSSFSheet worksheet;
      public void writeTestData(String Ress, int DR,String sheetName) throws Exception
  	{
  		FileInputStream file=null;
  		try
  		{
  			file=new FileInputStream(TESTDATA_SHEET_PATH);
  		}
  		catch(FileNotFoundException e)
  		{
  			e.printStackTrace();
  		}
  		workbook=new HSSFWorkbook(file);
          worksheet=workbook.getSheet(sheetName);
          HSSFRow Row=worksheet.getRow(0);
          int sheetIndex=workbook.getSheetIndex(sheetName);
          DataFormatter formatter = new DataFormatter();
          if(sheetIndex==-1)
          {
              System.out.println("No such sheet in file exists");
          } else      {
          	col_num=-1;
                  for(int i=0;i<Row.getLastCellNum();i++)
                  {
                      HSSFCell cols=Row.getCell(i);
                      String colsval=formatter.formatCellValue(cols);
                      if(colsval.trim().equalsIgnoreCase(ColName.trim()))
                      {
                          col_num=i;
                          break;
                      }
                  }
                  Row= worksheet.getRow(DR);
                  try
                      {
                      //get my Row which is equal to Data  Result and that colNum
                          HSSFCell cell=worksheet.getRow(DR).getCell(col_num);
                          // if no cell found then it create cell
                          if(cell==null) {
                              cell=Row.createCell(col_num);                           
                          }
                          //Set Result is pass in that cell number
                          cell.setCellValue(Ress);
                                           
                           
                      }
                  catch (Exception e)
                  {
                      System.out.println(e.getMessage()); 
                  } 
                  FileOutputStream file_output_stream=new FileOutputStream(TESTDATA_SHEET_PATH);
                  workbook.write(file_output_stream);
                  file_output_stream.close();
                  if(col_num==-1) {
                      System.out.println("Column you are searching for does not exist");
                  }
                }
           }	

}
