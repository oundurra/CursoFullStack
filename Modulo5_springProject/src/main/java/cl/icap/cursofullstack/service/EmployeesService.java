package cl.icap.cursofullstack.service;

import java.util.List;
import cl.icap.cursofullstack.model.dto.EmployeesDTO;

public interface EmployeesService {
	public List<EmployeesDTO> findAll();
	public List<String> findByJobID(String job_id);
	public EmployeesDTO getOne(Integer employee_id);
	public EmployeesDTO save(EmployeesDTO employeesDTO);
	public void delete(EmployeesDTO employeesDTO);
}
