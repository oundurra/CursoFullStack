package cl.icap.cursofullstack.service;

import java.util.List;
import cl.icap.cursofullstack.model.dto.JobsDTO;

public interface JobsService {
	public List<JobsDTO> list();
	public JobsDTO get(String job_id);
	public int insert(JobsDTO jobsDTO);
	public int update(JobsDTO jobsDTO);
	public int delete(String job_id);
}
