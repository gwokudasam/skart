package com.spinhighq.skart.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spinhighq.skart.business.exception.EmployeeException;
import com.spinhighq.skart.model.EmployeeTable;
import com.spinhighq.skart.service.DownloadEmployeeDataToExcel;
import com.spinhighq.skart.service.EmployeeTableService;
import com.spinhighq.skart.web.dto.datatable.bean.EmployeeTableBean;
import com.spinhighq.skart.web.dto.datatable.response.EmployeeTableListResponse;
import com.spinhighq.skart.web.dto.datatable.response.EmployeeTableResponse;


@Controller
public class EmployeeTableController {
	
	@Autowired
	private EmployeeTableService employeeTableService;
	
	@Resource(name = "downloadEmployee")
	private DownloadEmployeeDataToExcel dataToExcel;
	
	@RequestMapping(value="/Employee_Table", method=RequestMethod.GET)
	public String show(ModelMap model){
		return "Employee_Table";
	}
	
	@RequestMapping(value = "/employee/addEmployee", method = RequestMethod.POST)
	@ResponseBody
	public EmployeeTableResponse insertGroup(
	@ModelAttribute EmployeeTableBean bean, BindingResult result)
			throws IOException {
		EmployeeTableResponse employeeTableResponse;

		// System.out.println(photo.getBytes());

		if (result.hasErrors()) {
			employeeTableResponse = new EmployeeTableResponse("ERROR",
					"Form invalid");
		}

		try {
			employeeTableService.addEmployee(bean);
			employeeTableResponse = new EmployeeTableResponse("OK", bean);
		} catch (Exception e) {
			employeeTableResponse = new EmployeeTableResponse("ERROR",
					e.getMessage());
		}
		return employeeTableResponse;

	}

	@RequestMapping(value = "/employee/getAllEmployee", method = RequestMethod.POST)
	@ResponseBody
	public EmployeeTableListResponse getAllEmployee(
			@RequestParam int jtStartIndex, @RequestParam int jtPageSize,
			@RequestParam String jtSorting) {
		EmployeeTableListResponse listResponse;
		List<EmployeeTableBean> beans;
		try{
				int employeeCount = employeeTableService.getEmployeeCount();
				beans = employeeTableService.listEmployees(jtStartIndex,
						jtPageSize, jtSorting);
				listResponse = new EmployeeTableListResponse("OK", employeeCount,
						beans);
			
		} //try closed
		catch (Exception e) {
			listResponse = new EmployeeTableListResponse("ERROR", e.getMessage());
		}//catch closed

		return listResponse;

	}
	@RequestMapping(value = "/employee/updateEmployee", method = RequestMethod.POST)
	@ResponseBody
	public EmployeeTableResponse updateRole(
			@ModelAttribute EmployeeTableBean bean, BindingResult result) {
		EmployeeTableResponse employeeTableResponse;
		//System.out.println(bean);
		if (result.hasErrors()) {
			employeeTableResponse = new EmployeeTableResponse("ERROR",
					"Form invalid");
		}
		try {
			employeeTableService.updateEmployee(bean);
			employeeTableResponse = new EmployeeTableResponse("OK", bean);
			//System.out.println(bean);
		} catch (Exception e) {
			employeeTableResponse = new EmployeeTableResponse("ERROR",
					e.getMessage());
		}
		return employeeTableResponse;
	}
	
	@RequestMapping(value = "/employee/deleteEmployee", method = RequestMethod.POST)
	@ResponseBody
	public EmployeeTableResponse delete(@RequestParam String EmployeeId) {
		EmployeeTableResponse employeeTableResponse;
		try {
			employeeTableService.removeEmployee(new Integer(EmployeeId));
			employeeTableResponse = new EmployeeTableResponse("OK");
		} catch (Exception e) {
			employeeTableResponse = new EmployeeTableResponse("ERROR",
					e.getMessage());
		}

		return employeeTableResponse;

	}
	
	// Student Data Export to excel
		@RequestMapping(value = "employee/exportexcel", method = RequestMethod.POST)
		public void getXLS(HttpServletResponse response, Model model)
				throws ClassNotFoundException {

			// Delegate to downloadService. Make sure to pass an instance of
			// HttpServletResponse
			dataToExcel.DownloadXLS(response);

		}
		
		// Student Data Export to PDF
		@RequestMapping(value = "employee/exportpdf", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView downLoadPdf() throws EmployeeException {
			List<EmployeeTable> employeeList = employeeTableService.getEmployeeData();
			System.out.println(employeeList);
			return new ModelAndView("pdfViewEmployee", "employeeList", employeeList);

		}

}
