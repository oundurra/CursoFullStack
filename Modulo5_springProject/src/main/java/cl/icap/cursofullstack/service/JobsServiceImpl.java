package cl.icap.cursofullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.icap.cursofullstack.model.dto.JobsDTO;
import cl.icap.cursofullstack.repository.JobsRepository;

@Service
public class JobsServiceImpl implements JobsService {
	
	@Autowired
	JobsRepository jobsRepository;
	
	public List<JobsDTO> list() {
		return jobsRepository.findAll();
	}
	
	public JobsDTO get(String job_id) {
		return jobsRepository.getOne(job_id);
	}
	public void delete(JobsDTO jobsDTO) {
		jobsRepository.delete(jobsDTO);
	}
	
	public JobsDTO insert(JobsDTO jobsDTO) {
		return jobsRepository.save(jobsDTO);
	}
	
	public JobsDTO update(JobsDTO jobsDTO) {
		return jobsRepository.save(jobsDTO);
	}
}
