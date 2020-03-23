package cl.icap.cursofullstack.model.dao;

import java.util.List;

import cl.icap.cursofullstack.model.dto.EmployeesDTO;

public interface EmployeesDAO {
	public List<EmployeesDTO> list();
	public EmployeesDTO get(String job_id);
	public int insert(EmployeesDTO jobsDto);
	public int update(EmployeesDTO jobsDto);
	public int delete(String job_id);
}