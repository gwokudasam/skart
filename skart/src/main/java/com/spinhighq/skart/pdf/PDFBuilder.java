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
import com.spinhighq.skart.model.StudentTable;

public class PDFBuilder extends AbstractITextPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<StudentTable> studentList =(List<StudentTable>)model.get("studentList");
		System.out.println(studentList.toString());
		//Write the Head line in the PDF
		document.add(new Paragraph("Student Details"));
		
		//Create the table in PDF FORMATE
		PdfPTable studentTable=new PdfPTable(15);
		studentTable.setWidthPercentage(100);
		//studentTable.setWidths(new float[] {1.0f,5.0f,5.0f,3.0f,3.0f,3.0f,1.0f,2.0f,5.0f,5.0f,5.0f,1.0f,1.0f,1.0f,3.0f});
		studentTable.setSpacingBefore(10);
		studentTable.setSpacingAfter(10);
		
		//define a font for table header row
		Font font=FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		
		//define a table header cell
		PdfPCell cell=new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(15);
		
		//write table header
		
		cell.setPhrase(new Phrase("Id",font));
		studentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("Name",font));
		studentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("Email",font));
		studentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("DateOfBirth",font));
		studentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("DateOfJoning",font));
		studentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("ClassName",font));
		studentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("Section",font));
		studentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("BloadGroup",font));
		studentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("Address",font));
		studentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("MobilePhone",font));
		studentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("ParentName",font));
		studentTable.addCell(cell);
		
		
		
		cell.setPhrase(new Phrase("CurrentAttendance",font));
		studentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("OveralAttendance",font));
		studentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("PreformanceRating",font));
		studentTable.addCell(cell);
		
		
		cell.setPhrase(new Phrase("Photo",font));
		studentTable.addCell(cell);
		
		//write a table row data
		for(StudentTable studentData :studentList ){
			studentTable.addCell(studentData.getId()+"");
			studentTable.addCell(studentData.getName());
			studentTable.addCell(studentData.getEmail());
			studentTable.addCell(studentData.getDateOfBirth());
			studentTable.addCell(studentData.getDateOfJoning());
			studentTable.addCell(studentData.getClassName());
			studentTable.addCell(studentData.getSection());
			studentTable.addCell(studentData.getBloadGroup());
			studentTable.addCell(studentData.getAddress());
			studentTable.addCell(studentData.getMobilePhone()+"");
			studentTable.addCell(studentData.getParentName());
			studentTable.addCell(studentData.getCurrentAttendance()+"");
			studentTable.addCell(studentData.getOveralAttendance()+"");
			studentTable.addCell(studentData.getPerformanceRating()+"");
			studentTable.addCell(studentData.getPhoto());
		}
		document.add(studentTable);
			
		
		InputStream file=getClass().getClassLoader().getResourceAsStream("database.properties");
      System.out.println(file);
      Properties prop=new Properties();
      prop.load(file);
      String schoolName=prop.getProperty("school.name");
      System.out.println("school.name"+schoolName);
		
		// Flush to HTTP response.
        DateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		  String timeStamp = format.format(new Date());
		  
		String fileName = schoolName+"_StudentTable_"+timeStamp+".pdf";
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		
		
	}
 
    

}
