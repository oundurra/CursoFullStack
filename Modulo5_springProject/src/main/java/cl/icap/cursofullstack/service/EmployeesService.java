package cl.icap.cursofullstack.service;

import java.util.List;
import cl.icap.cursofullstack.model.dto.EmployeesDTO;

public interface EmployeesService {
	public List<EmployeesDTO> list();
	public EmployeesDTO get(String employee_id);
	public int insert(EmployeesDTO employeesDTO);
	public int update(EmployeesDTO employeesDTO);
	public int delete(String employee_id);
}
