package com.spinhighq.skart.Excel;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;

import com.spinhighq.skart.model.ParentTable;

public class ParentFillManager {
	
	/**
	  * Fills the report with content
	  * 
	  * @param worksheet
	  * @param startRowIndex starting row offset
	  * @param startColIndex starting column offset
	  * @param datasource the data source
	  */
	 
	public static void fillReport(HSSFSheet worksheet, int startRowIndex, int startColIndex, List<ParentTable> parentData) {
	  // Row offset
	  startRowIndex += 2;
	   
	  // Create cell style for the body
	  HSSFCellStyle bodyCellStyle = worksheet.getWorkbook().createCellStyle();
	  bodyCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
	  bodyCellStyle.setWrapText(true);
	   
	  // Create body
	  for (int i=startRowIndex; i+startRowIndex-2< parentData.size()+2; i++) {
	   // Create a new row
	   HSSFRow row = worksheet.createRow((short) i+1);
	 
	   // Retrieve the id value
	   HSSFCell cell1 = row.createCell(startColIndex+0);
	   cell1.setCellValue(parentData.get(i-2).getId());
	   cell1.setCellStyle(bodyCellStyle);
	 
	   // Retrieve the name value
	   HSSFCell cell2 = row.createCell(startColIndex+1);
	   cell2.setCellValue(parentData.get(i-2).getName());
	   cell2.setCellStyle(bodyCellStyle);
	 
	   // Retrieve the email value
	   HSSFCell cell3 = row.createCell(startColIndex+2);
	   cell3.setCellValue(parentData.get(i-2).getDateOfBirth());
	   cell3.setCellStyle(bodyCellStyle);
	 
	   // Retrieve the dateOfBirth power value
	   HSSFCell cell4 = row.createCell(startColIndex+3);
	   cell4.setCellValue(parentData.get(i-2).getBloadGroup());
	   cell4.setCellStyle(bodyCellStyle);
	 
	   // Retrieve the DateOfJoning value
	   HSSFCell cell5 = row.createCell(startColIndex+4);
	   cell5.setCellValue(parentData.get(i-2).getRelation());
	   cell5.setCellStyle(bodyCellStyle);
	   
	  
	   
	   // Retrieve the bloadGorup value
	   HSSFCell cell6 = row.createCell(startColIndex+5);
	   cell6.setCellValue(parentData.get(i-2).getEducation());
	   cell6.setCellStyle(bodyCellStyle);
	   
	   // Retrieve the address value
	   HSSFCell cell7 = row.createCell(startColIndex+6);
	   cell7.setCellValue(parentData.get(i-2).getOccupation());
	   cell7.setCellStyle(bodyCellStyle);
	   
	   // Retrieve the mobilePhone value
	   HSSFCell cell8 = row.createCell(startColIndex+7);
	   cell8.setCellValue(parentData.get(i-2).getIncome());
	   cell8.setCellStyle(bodyCellStyle);
	   
	   // Retrieve the parentName value
	   HSSFCell cell9 = row.createCell(startColIndex+8);
	   cell9.setCellValue(parentData.get(i-2).getPresentAddress());
	   cell9.setCellStyle(bodyCellStyle);
	   
	   
	   
	   // Retrieve the currentAttendance value
	   HSSFCell cell10 = row.createCell(startColIndex+9);
	   cell10.setCellValue(parentData.get(i-2).getPermanentAddress());
	   cell10.setCellStyle(bodyCellStyle);
	   
	   // Retrieve the overalAttendance value
	   HSSFCell cell11 = row.createCell(startColIndex+10);
	   cell11.setCellValue(parentData.get(i-2).getCity());
	   cell11.setCellStyle(bodyCellStyle);
	   
	   // Retrieve the performanceRating value
	   HSSFCell cell12 = row.createCell(startColIndex+11);
	   cell12.setCellValue(parentData.get(i-2).getState());
	   cell12.setCellStyle(bodyCellStyle);
	   
	   // Retrieve the photo value
	   HSSFCell cell13 = row.createCell(startColIndex+12);
	   cell13.setCellValue(parentData.get(i-2).getCountry());
	   cell13.setCellStyle(bodyCellStyle);
	   
	   HSSFCell cell14 = row.createCell(startColIndex+12);
	   cell14.setCellValue(parentData.get(i-2).getMobilePhone());
	   cell14.setCellStyle(bodyCellStyle);
	   
	   HSSFCell cell15 = row.createCell(startColIndex+12);
	   cell15.setCellValue(parentData.get(i-2).getEmail());
	   cell15.setCellStyle(bodyCellStyle);
	   
	   
	   
	  }
	 }

}
