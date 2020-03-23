package cl.icap.cursofullstack.model.dao;

import java.util.List;

import cl.icap.cursofullstack.model.dto.EmployeesDTO;

public interface EmployeesDAO {
	public List<EmployeesDTO> list();
	public EmployeesDTO get(String job_id);
	public int insert(EmployeesDTO employeesDTO);
	public int update(EmployeesDTO employeesDTO);
	public int delete(EmployeesDTO employeesDTO);
}