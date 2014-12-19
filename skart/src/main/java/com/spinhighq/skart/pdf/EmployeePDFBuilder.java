package com.spinhighq.skart.pdf;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.spinhighq.skart.model.EmployeeTable;

public class EmployeePDFBuilder extends AbstractITextPdfView{
	@SuppressWarnings("unchecked")
	
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<EmployeeTable> employeeList =(List<EmployeeTable>)model.get("employeeList");
		System.out.println(employeeList.toString());
		//Write the Head line in the PDF
		document.add(new Paragraph("Employee Details"));
		
		//Create the table in PDF FORMATE
		PdfPTable employeeTable=new PdfPTable(13);
		employeeTable.setWidthPercentage(100);
		//employeeTable.setWidths(new float[] {1.0f,5.0f,5.0f,3.0f,3.0f,2.0f,5.0f,5.0f,5.0f,1.0f,1.0f,1.0f,3.0f});
		employeeTable.setSpacingBefore(10);
		employeeTable.setSpacingAfter(10);
		
		//define a font for table header row
		Font font=FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		
		//define a table header cell
		PdfPCell cell=new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(15);
		
		//write table header
		
		cell.setPhrase(new Phrase("Id",font));
		employeeTable.addCell(cell);
		
		cell.setPhrase(new Phrase("Name",font));
		employeeTable.addCell(cell);
		
		cell.setPhrase(new Phrase("Email",font));
		employeeTable.addCell(cell);
		
		cell.setPhrase(new Phrase("DateOfBirth",font));
		employeeTable.addCell(cell);
		
		cell.setPhrase(new Phrase("DateOfJoning",font));
		employeeTable.addCell(cell);
		
		
		
		
		
		cell.setPhrase(new Phrase("BloadGroup",font));
		employeeTable.addCell(cell);
		
		cell.setPhrase(new Phrase("Address",font));
		employeeTable.addCell(cell);
		
		cell.setPhrase(new Phrase("MobilePhone",font));
		employeeTable.addCell(cell);
		
		cell.setPhrase(new Phrase("ParentName",font));
		employeeTable.addCell(cell);
		
		
		
		cell.setPhrase(new Phrase("CurrentAttendance",font));
		employeeTable.addCell(cell);
		
		cell.setPhrase(new Phrase("OveralAttendance",font));
		employeeTable.addCell(cell);
		
		cell.setPhrase(new Phrase("PreformanceRating",font));
		employeeTable.addCell(cell);
		
		
		cell.setPhrase(new Phrase("Photo",font));
		employeeTable.addCell(cell);
		
		//write a table row data
		for(EmployeeTable employeeData :employeeList ){
			employeeTable.addCell(employeeData.getId()+"");
			employeeTable.addCell(employeeData.getName());
			employeeTable.addCell(employeeData.getEmail());
			employeeTable.addCell(employeeData.getDateOfBirth());
			employeeTable.addCell(employeeData.getDateOfJoning());
			employeeTable.addCell(employeeData.getBloadGroup());
			employeeTable.addCell(employeeData.getAddress());
			employeeTable.addCell(employeeData.getMobilePhone()+"");
			employeeTable.addCell(employeeData.getFatherName());
			employeeTable.addCell(employeeData.getCurrentAttendance()+"");
			employeeTable.addCell(employeeData.getOveralAttendance()+"");
			employeeTable.addCell(employeeData.getPerformanceRating()+"");
			employeeTable.addCell(employeeData.getPhoto());
		}
		document.add(employeeTable);
			
		
		InputStream file=getClass().getClassLoader().getResourceAsStream("database.properties");
	      System.out.println(file);
	      Properties prop=new Properties();
	      prop.load(file);
	      String schoolName=prop.getProperty("school.name");
	      System.out.println("school.name"+schoolName);
			
			// Flush to HTTP response.
	        DateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
			  String timeStamp = format.format(new Date());
			  
			String fileName = schoolName+"_EmployeeTable_"+timeStamp+".pdf";
	        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		
	}
 

}
