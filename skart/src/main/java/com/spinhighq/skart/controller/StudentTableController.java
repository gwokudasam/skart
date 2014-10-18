package com.spinhighq.skart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spinhighq.skart.business.exception.StudentException;
import com.spinhighq.skart.model.StudentTable;
import com.spinhighq.skart.service.StudentTableService;
import com.spinhighq.skart.web.dto.datatable.bean.StudentTableBean;
import com.spinhighq.skart.web.dto.datatable.response.StudentTableListResponse;
import com.spinhighq.skart.web.dto.datatable.response.StudentTableResponse;

@Controller
public class StudentTableController {

	@Autowired
	private StudentTableService studentTableService;

	@RequestMapping(value = "/Student_Table", method = RequestMethod.GET)
	public String show(ModelMap model) {
		return "Student_Table";
	}

	@RequestMapping(value = "/student/addStudent", method = RequestMethod.POST)
	@ResponseBody
	public StudentTableResponse insertGroup(
			@ModelAttribute StudentTableBean bean, BindingResult result) {
		StudentTableResponse studentTableResponse;

		// System.out.println(bean.getPhoto().getBytes());

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
			@RequestParam String jtSorting) {
		StudentTableListResponse listResponse;
		List<StudentTableBean> beans;
		try {
			int studentCount = studentTableService.getStudentCount();
			beans = studentTableService.listStudents(jtStartIndex, jtPageSize, jtSorting);
			listResponse = new StudentTableListResponse("OK", studentCount,
					beans);
		} catch (Exception e) {
			listResponse = new StudentTableListResponse("ERROR", e.getMessage());
		}

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

	@RequestMapping(value = "/student/getStudentByClassNmae/{className}")
	@ResponseBody
	public StudentTableListResponse getStudentByClassNmae(
			@PathVariable String className) throws StudentException {
		StudentTableListResponse listResponse;
		System.out.println(className);
		List<StudentTable> studentTableBean;

		try {
			int studentCount = studentTableService.getStudentCount();
			studentTableBean = studentTableService
					.getStudentByClassNmae(className);
			listResponse = new StudentTableListResponse("OK", null,
					studentCount, studentTableBean);
		} catch (Exception e) {
			listResponse = new StudentTableListResponse("ERROR", e.getMessage());
		}

		return listResponse;

	}
	

}
