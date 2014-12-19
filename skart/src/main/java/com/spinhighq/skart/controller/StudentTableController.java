package com.spinhighq.skart.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javassist.bytecode.stackmap.TypeData.ClassName;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spinhighq.skart.business.exception.StudentException;
import com.spinhighq.skart.model.StudentTable;
import com.spinhighq.skart.service.DownloadStudentDataToExcel;
import com.spinhighq.skart.service.StudentTableService;
import com.spinhighq.skart.web.dto.datatable.bean.StudentTableBean;
import com.spinhighq.skart.web.dto.datatable.response.StudentTableListResponse;
import com.spinhighq.skart.web.dto.datatable.response.StudentTableResponse;

@Controller
public class StudentTableController {

	@Autowired
	private StudentTableService studentTableService;
	@Resource(name = "downloadStudent")
	private DownloadStudentDataToExcel dataToExcel;

	@RequestMapping(value = "/Student_Table", method = RequestMethod.GET)
	public String show(ModelMap model) {
		return "Student_Table";
	}

	@RequestMapping(value = "/student/addStudent", method = RequestMethod.POST)
	@ResponseBody
	public StudentTableResponse insertGroup(
			@ModelAttribute StudentTableBean bean, BindingResult result)
			throws IOException {
		StudentTableResponse studentTableResponse;

		// System.out.println(photo.getBytes());

		if (result.hasErrors()) {
			studentTableResponse = new StudentTableResponse("ERROR",
					"Form invalid");
		}

		try {
			studentTableService.addStudent(bean);
			studentTableResponse = new StudentTableResponse("OK", bean);
		} catch (Exception e) {
			studentTableResponse = new StudentTableResponse("ERROR",
					e.getMessage());
		}
		return studentTableResponse;

	}

	@RequestMapping(value = "/student/getAllStudent", method = RequestMethod.POST)
	@ResponseBody
	public StudentTableListResponse getAllStudents(
			@RequestParam int jtStartIndex, @RequestParam int jtPageSize,
			@RequestParam String jtSorting,
			@RequestParam("class") String className,
			@RequestParam String section) {
		StudentTableListResponse listResponse;
		List<StudentTableBean> beans;
		try {
			// start to if condition
			if (className.length() > 1) {
				className = className.substring(1);
				section = section.substring(1);
				int studentCount = studentTableService.getStudentCount();
				beans = studentTableService.getStudentTableData(className,
						section);
				listResponse = new StudentTableListResponse("OK", studentCount,
						beans);
			} // if condition ended
				// else condition start
			else {
				int studentCount = studentTableService.getStudentCount();
				beans = studentTableService.listStudents(jtStartIndex,
						jtPageSize, jtSorting);
				listResponse = new StudentTableListResponse("OK", studentCount,
						beans);
			}// else condition
		} // try closed
		catch (Exception e) {
			listResponse = new StudentTableListResponse("ERROR", e.getMessage());
		}// catch closed

		return listResponse;

	}

	@RequestMapping(value = "/student/updateStudent", method = RequestMethod.POST)
	@ResponseBody
	public StudentTableResponse updateRole(
			@ModelAttribute StudentTableBean bean, BindingResult result) {
		StudentTableResponse studentTableResponse;
		System.out.println(bean);
		if (result.hasErrors()) {
			studentTableResponse = new StudentTableResponse("ERROR",
					"Form invalid");
		}
		try {
			studentTableService.updateStudent(bean);
			studentTableResponse = new StudentTableResponse("OK", bean);
			System.out.println(bean);
		} catch (Exception e) {
			studentTableResponse = new StudentTableResponse("ERROR",
					e.getMessage());
		}
		return studentTableResponse;

	}

	@RequestMapping(value = "/student/deleteStudent", method = RequestMethod.POST)
	@ResponseBody
	public StudentTableResponse delete(@RequestParam String StudentId) {
		StudentTableResponse studentTableResponse;
		try {
			studentTableService.removeStudent(new Integer(StudentId));
			studentTableResponse = new StudentTableResponse("OK");
		} catch (Exception e) {
			studentTableResponse = new StudentTableResponse("ERROR",
					e.getMessage());
		}

		return studentTableResponse;

	}

	@RequestMapping(value = "/student/getStudentByClassName/{className}")
	@ResponseBody
	public Set<String> getStudentByClassName(@PathVariable String className)
			throws StudentException {
		List<String> sections = studentTableService
				.getStudentByClassName(className);
		Set<String> sectionDup = new HashSet<>(sections);
		return sectionDup;

	}

	// Student Data Export to excel
	@RequestMapping(value = "student/exportexcel", method = RequestMethod.POST)
	public void getXLS(HttpServletResponse response, Model model)
			throws ClassNotFoundException {

		// Delegate to downloadService. Make sure to pass an instance of
		// HttpServletResponse
		dataToExcel.DownloadXLS(response);

	}

	// Student Data Export to PDF
	@RequestMapping(value = "student/exportpdf", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView downLoadPdf() throws StudentException {
		List<StudentTable> studentList = studentTableService.getStudentData();
		System.out.println(studentList);
		return new ModelAndView("pdfViewStudent", "studentList", studentList);

	}

	@RequestMapping(value = "/student/getStudent/{className}/{section}", method = RequestMethod.GET)
	@ResponseBody
	public StudentTableListResponse getStudentTableData(
			@PathVariable String className, @PathVariable String section)
			throws StudentException {
		System.out.println(className + "==" + section);

		StudentTableListResponse listResponse;
		List<StudentTableBean> beans;
		try {
			int studentCount = studentTableService.getStudentCount();
			beans = studentTableService.getStudentTableData(className, section);
			listResponse = new StudentTableListResponse("OK", studentCount,
					beans);
		} catch (Exception e) {
			listResponse = new StudentTableListResponse("ERROR", e.getMessage());
		}
		System.out.println(listResponse);
		return listResponse;
	}

	/**
	 * 
	 * @param name
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "student/Photo", method = RequestMethod.POST)
	public @ResponseBody String uploadPhoto(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("../resources/" + name)));
				stream.write(bytes);
				stream.close();

				return "OK";
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You Failed to upload " + name
					+ " because the file was empty.";
		}

	}
	@RequestMapping(value="/student/className",method=RequestMethod.GET)
	@ResponseBody
	public List<String> getClassNameData(@RequestParam String className) throws StudentException{
		List<String> list = studentTableService.getClassNameData(className);
		System.out.println(list);
		return list;
		
	}
	
	/*@RequestMapping(value="/student/className",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView getClassNameData(@PathVariable String className)throws StudentException{
		
		List<String> list = studentTableService.getClassNameData(className);
		
		ModelAndView model = new ModelAndView("/resources/scripts/student.jtable.js");
		model.addObject("list",list);
		return model;
		
	}
*/
}
