package com.spinhighq.skart.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spinhighq.skart.business.exception.ParentException;
import com.spinhighq.skart.model.ParentTable;
import com.spinhighq.skart.service.DownloadParentDataToExcel;
import com.spinhighq.skart.service.ParentTableService;
import com.spinhighq.skart.web.dto.datatable.bean.ParentTableBean;
import com.spinhighq.skart.web.dto.datatable.response.ParentTableListResponse;
import com.spinhighq.skart.web.dto.datatable.response.ParentTableResponse;

@Controller
public class ParentTableController {
	
	@Autowired
	private ParentTableService parentTableService;
	
	@Resource(name = "downloadParent")
	private DownloadParentDataToExcel dataToExcel;
	
	@RequestMapping(value="/Parent_Table", method=RequestMethod.GET)
	public String show(){
		return "Parent_Table";
	}
	
	@RequestMapping(value="/parent/addParent", method=RequestMethod.POST)
	@ResponseBody
	public ParentTableResponse insertGroup(@ModelAttribute ParentTableBean parentTableBean, BindingResult result)throws IOException{
		ParentTableResponse parentTableResponse;
		
		if(result.hasErrors()){
			parentTableResponse = new ParentTableResponse("ERROR","Form invalid");
		}
		try{
			parentTableService.addParent(parentTableBean);
			
			parentTableResponse = new ParentTableResponse("OK",parentTableBean);
			
		}
		catch(Exception e){
			parentTableResponse = new ParentTableResponse("ERROR", e.getMessage());
		}
		return parentTableResponse;
		
	}
	@RequestMapping(value = "/parent/getAllParent", method = RequestMethod.POST)
	@ResponseBody
	public ParentTableListResponse getAllParent(
			@RequestParam int jtStartIndex, @RequestParam int jtPageSize,
			@RequestParam String jtSorting) {
		ParentTableListResponse listResponse;
		List<ParentTableBean> beans;
		try{
				int parentCount = parentTableService.getParentCount();
				beans = parentTableService.listParents(jtStartIndex,
						jtPageSize, jtSorting);
				listResponse = new ParentTableListResponse("OK", parentCount,
						beans);
			
		} //try closed
		catch (Exception e) {
			listResponse = new ParentTableListResponse("ERROR", e.getMessage());
		}//catch closed

		return listResponse;

	}
	@RequestMapping(value = "/parent/updateParent", method = RequestMethod.POST)
	@ResponseBody
	public ParentTableResponse updateRole(
			@ModelAttribute ParentTableBean bean, BindingResult result) {
		ParentTableResponse parentTableResponse;
		//System.out.println(bean);
		if (result.hasErrors()) {
			parentTableResponse = new ParentTableResponse("ERROR",
					"Form invalid");
		}
		try {
			parentTableService.updateParent(bean);
			parentTableResponse = new ParentTableResponse("OK", bean);
			//System.out.println(bean);
		} catch (Exception e) {
			parentTableResponse = new ParentTableResponse("ERROR",
					e.getMessage());
		}
		return parentTableResponse;
	}
	
	@RequestMapping(value = "/parent/deleteParent", method = RequestMethod.POST)
	@ResponseBody
	public ParentTableResponse delete(@RequestParam String ParentId) {
		ParentTableResponse parentTableResponse;
		try {
			parentTableService.removeParent(new Integer(ParentId));
			parentTableResponse = new ParentTableResponse("OK");
		} catch (Exception e) {
			parentTableResponse = new ParentTableResponse("ERROR",
					e.getMessage());
		}

		return parentTableResponse;

	}
	
	// Student Data Export to excel
		@RequestMapping(value = "parent/exportexcel", method = RequestMethod.POST)
		public void getXLS(HttpServletResponse response, Model model)
				throws ClassNotFoundException {

			// Delegate to downloadService. Make sure to pass an instance of
			// HttpServletResponse
			dataToExcel.DownloadXLS(response);

		}
		
		// Student Data Export to PDF
		@RequestMapping(value = "parent/exportpdf", method = RequestMethod.POST)
		@ResponseBody
		public ModelAndView downLoadPdf() throws ParentException {
			List<ParentTable> parentList = parentTableService.getParentData();
			System.out.println(parentList);
			return new ModelAndView("pdfViewParent", "parentList", parentList);

		}


	

}
