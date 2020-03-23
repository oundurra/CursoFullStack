package cl.icap.cursofullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.icap.cursofullstack.model.dao.JobsDAO;
import cl.icap.cursofullstack.model.dto.JobsDTO;

@Service
public class JobsServiceImpl implements JobsService {
	
	@Autowired
	JobsDAO jobsDAO;
	
	public List<JobsDTO> list() {
		return jobsDAO.list();
	}
	
	public JobsDTO get(String job_id) {
		return jobsDAO.get(job_id);
	}

	public int delete(String job_id) {
		return jobsDAO.delete(job_id);
	}
	
	public int insert(JobsDTO jobsDTO) {
		return jobsDAO.insert(jobsDTO);
	}
	
	public int update(JobsDTO jobsDTO) {
		return jobsDAO.insert(jobsDTO);
	}
}
