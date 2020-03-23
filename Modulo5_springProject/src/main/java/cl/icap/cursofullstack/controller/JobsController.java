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

import cl.icap.cursofullstack.model.dto.JobsDTO;
import cl.icap.cursofullstack.service.JobsService;

@Controller
@RequestMapping(value="/jobs")
public class JobsController {	
	@Autowired
	JobsService jobsService;
	
	@RequestMapping(value="/list")
	public @ResponseBody List<JobsDTO> ajaxList(HttpServletRequest req, HttpServletResponse res) {
		List<JobsDTO> list = jobsService.list();
		return list;
	}
	
	@RequestMapping(value="/get")
	public @ResponseBody JobsDTO ajaxGet(HttpServletRequest req, HttpServletResponse res) {
		JobsDTO job = jobsService.get(req.getParameter("job_id"));
		return job;
	}
	
	@RequestMapping(value="/delete")
	public @ResponseBody int ajaxDelete(HttpServletRequest req, HttpServletResponse res) {
		int rows = jobsService.delete(req.getParameter("job_id"));
		return rows;
	}
	
	@RequestMapping(value="/insert")
	public @ResponseBody int ajaxInsert(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		try {
			String requestData = req.getReader().lines().collect(Collectors.joining());
			JobsDTO job = new Gson().fromJson(requestData, JobsDTO.class);
			rows = jobsService.insert(job);
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
			JobsDTO job = new Gson().fromJson(requestData, JobsDTO.class);
			rows = jobsService.update(job);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return rows;
	}
	
}
