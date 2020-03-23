package cl.icap.cursofullstack.model.dao;

import java.util.List;

import cl.icap.cursofullstack.model.dto.JobsDTO;

public interface JobsDAO {
	public List<JobsDTO> list();
	public JobsDTO get(String job_id);
	public int insert(JobsDTO jobsDto);
	public int update(JobsDTO jobsDto);
	public int delete(String job_id);
}