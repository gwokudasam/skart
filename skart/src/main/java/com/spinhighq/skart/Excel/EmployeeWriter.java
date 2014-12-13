package com.spinhighq.skart.Excel;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;

public class EmployeeWriter {
	public static void write(HttpServletResponse response, HSSFSheet worksheet){
		try{
			// Retrieve the output stream
			ServletOutputStream outputStream=response.getOutputStream();
			 // Write to the output stream
			worksheet.getWorkbook().write(outputStream);
			//outputStream flush
			outputStream.flush();
		}
		catch(Exception e){
			System.out.println("unable to write report to the out putstream");
			
		}
		
	}


}
