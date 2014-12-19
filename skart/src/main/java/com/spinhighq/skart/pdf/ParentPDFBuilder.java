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
import com.spinhighq.skart.model.ParentTable;

public class ParentPDFBuilder extends AbstractITextPdfView {

	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<ParentTable> parentList =(List<ParentTable>)model.get("parentList");
		System.out.println(parentList.toString());
		//Write the Head line in the PDF
		document.add(new Paragraph("Parent Details"));
		
		//Create the table in PDF FORMATE
		PdfPTable parentTable=new PdfPTable(15);
		parentTable.setWidthPercentage(100);
		parentTable.setWidths(new float[] {3.0f,4.0f,4.0f,3.0f,5.0f,2.0f,5.0f,5.0f,4.0f,4.0f,4.0f,4.0f,3.0f,3.0f,3.0f});
		parentTable.setSpacingBefore(10);
		parentTable.setSpacingAfter(10);
		
		//define a font for table header row
		Font font=FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		
		//define a table header cell
		PdfPCell cell=new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(15);
		
		//write table header
		
		cell.setPhrase(new Phrase("Id",font));
		parentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("Name",font));
		parentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("DateOfBirth",font));
		parentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("BloadGroup",font));
		parentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("Relation",font));
		parentTable.addCell(cell);
				
		cell.setPhrase(new Phrase("Education",font));
		parentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("Occupation",font));
		parentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("Income",font));
		parentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("PresentAddress",font));
		parentTable.addCell(cell);
		
		
		
		cell.setPhrase(new Phrase("permanentAddress",font));
		parentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("City",font));
		parentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("State",font));
		parentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("Country",font));
		parentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("MobilePhone",font));
		parentTable.addCell(cell);
		
		cell.setPhrase(new Phrase("Email",font));
		parentTable.addCell(cell);
		
		//write a table row data
		for(ParentTable parentData :parentList ){
			parentTable.addCell(parentData.getId()+"");
			parentTable.addCell(parentData.getName());
			parentTable.addCell(parentData.getDateOfBirth());
			parentTable.addCell(parentData.getBloadGroup());
			parentTable.addCell(parentData.getRelation());
			parentTable.addCell(parentData.getEducation());
			parentTable.addCell(parentData.getOccupation());
			parentTable.addCell(parentData.getIncome()+"");
			parentTable.addCell(parentData.getPresentAddress());
			parentTable.addCell(parentData.getPermanentAddress());
			parentTable.addCell(parentData.getCity());
			parentTable.addCell(parentData.getState());
			parentTable.addCell(parentData.getCountry());
			parentTable.addCell(parentData.getMobilePhone()+"");
			parentTable.addCell(parentData.getEmail());
			
		}
		document.add(parentTable);
			
		
		InputStream file=getClass().getClassLoader().getResourceAsStream("database.properties");
	      System.out.println(file);
	      Properties prop=new Properties();
	      prop.load(file);
	      String parentName=prop.getProperty("parent.name");
	      System.out.println("parent.name"+parentName);
			
			// Flush to HTTP response.
	        DateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
			  String timeStamp = format.format(new Date());
			  
			String fileName = parentName+"_ParentTable_"+timeStamp+".pdf";
	        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		
	}
 

}
