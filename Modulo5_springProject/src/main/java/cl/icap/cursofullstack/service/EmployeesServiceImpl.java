package cl.icap.cursofullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.icap.cursofullstack.model.dao.EmployeesDAO;
import cl.icap.cursofullstack.model.dto.EmployeesDTO;

@Service
public class EmployeesServiceImpl implements EmployeesService {
	
	@Autowired
	EmployeesDAO employeesDAO;
	
	public List<EmployeesDTO> list() {
		return employeesDAO.list();
	}
	
	public EmployeesDTO get(String employee_id) {
		return employeesDAO.get(employee_id);
	}

	public int delete(String employee_id) {
		return employeesDAO.delete(employee_id);
	}
	
	public int insert(EmployeesDTO employeesDTO) {
		return employeesDAO.insert(employeesDTO);
	}
	
	public int update(EmployeesDTO employeesDTO) {
		return employeesDAO.update(employeesDTO);
	}
}
