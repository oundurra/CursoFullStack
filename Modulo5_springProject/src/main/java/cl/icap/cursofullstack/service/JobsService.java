package cl.icap.cursofullstack.service;

import java.util.List;

import cl.icap.cursofullstack.model.dto.JobsDTO;

public interface JobsService {
	public List<JobsDTO> list();
	public JobsDTO get(String job_id);
	public JobsDTO insert(JobsDTO jobsDTO);
	public JobsDTO update(JobsDTO jobsDTO);
	public void delete(JobsDTO jobsDTO);
}
