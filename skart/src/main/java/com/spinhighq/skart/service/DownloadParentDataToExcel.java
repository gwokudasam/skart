package com.spinhighq.skart.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spinhighq.skart.Excel.ParentFillManager;
import com.spinhighq.skart.Excel.ParentLayouter;
import com.spinhighq.skart.Excel.Writer;
import com.spinhighq.skart.model.ParentTable;

@Service("downloadParent")
@Transactional
public class DownloadParentDataToExcel {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void DownloadXLS(HttpServletResponse response)
			throws ClassNotFoundException {
		// 1. Create new workbook
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 2. Create new worksheet
		HSSFSheet worksheet = workbook.createSheet("POI Worksheet");

		// 3. Define starting indices for rows and columns
		int startRowIndex = 0;
		int startColIndex = 0;

		// 4. Build layout
		// Build title, date, and column headers
		ParentLayouter.buildReport(worksheet, startRowIndex, startColIndex);

		// 5. Fill report
		ParentFillManager.fillReport(worksheet, startRowIndex, startColIndex,
				getParentData());

		// reading school name in properties file
		InputStream file=getClass().getClassLoader().getResourceAsStream("database.properties");
	    System.out.println(file);
	    Properties prop=new Properties();
	    try {
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String parentName=prop.getProperty("parent.name");
	    System.out.println("school.name"+parentName);
	 // 6. Set the response properties
		DateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		String timeStamp = format.format(new Date());

		String fileName = parentName+"_ParentTable_" + timeStamp + ".xls";

		response.setHeader("Content-Disposition", "attachment; filename="
				+ fileName);
		// Make sure to set the correct content type
		response.setContentType("application/vnd.ms-excel");

		// 7. Write to the output stream
		Writer.write(response, worksheet);
	}

	/**
	 * Retrieves the datasource as as simple Java List. The datasource is
	 * retrieved from a Hibernate HQL query.
	 */
	@SuppressWarnings("unchecked")
	// @Transactional
	private List<ParentTable> getParentData() {

		
		// Retrieve session
		Session session = sessionFactory.getCurrentSession();
		// Create query for retrieving products
		Query query = session.createQuery("from ParentTable");
		// Execute query
		List<ParentTable> list = query.list();
		// Return the list
		return list;

	}


}
