package cl.icap.cursofullstack.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cl.icap.cursofullstack.model.dto.EmployeesDTO;
import cl.icap.cursofullstack.service.EmployeesService;

@Controller
@RequestMapping(value="/employees")
public class EmployeesController {	
	@Autowired
	EmployeesService employeesService;
	
	@RequestMapping(value="/list")
	public @ResponseBody List<EmployeesDTO> ajaxList(HttpServletRequest req, HttpServletResponse res) {
		List<EmployeesDTO> list = employeesService.list();
		return list;
	}
	
	@RequestMapping(value="/get")
	public @ResponseBody EmployeesDTO ajaxGet(HttpServletRequest req, HttpServletResponse res) {
		EmployeesDTO job = employeesService.get(req.getParameter("employee_id"));
		return job;
	}
	
	@RequestMapping(value="/delete")
	public @ResponseBody int ajaxDelete(HttpServletRequest req, HttpServletResponse res) {
		int rows = employeesService.delete(req.getParameter("employee_id"));
		return rows;
	}
	
	@RequestMapping(value="/insert")
	public @ResponseBody int ajaxInsert(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		try {
			String requestData = req.getReader().lines().collect(Collectors.joining());
		    Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			EmployeesDTO employee = gson.fromJson(requestData, EmployeesDTO.class);
			rows = employeesService.insert(employee);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return rows;
	}
	
	@RequestMapping(value="/update")
	public @ResponseBody int ajaxUpdate(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		try {
			String requestData = req.getReader().lines().collect(Collectors.joining());
			
			System.out.println(requestData);
		    Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			EmployeesDTO employee = gson.fromJson(requestData, EmployeesDTO.class);
			rows = employeesService.update(employee);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return rows;
	}
	
}
