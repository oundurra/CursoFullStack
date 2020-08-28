package cl.icap.cursofullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.icap.cursofullstack.repository.EmployeesRepository;
import cl.icap.cursofullstack.model.dto.EmployeesDTO;

@Service
public class EmployeesServiceImpl implements EmployeesService {
	
	@Autowired
	EmployeesRepository employeesRepository;
	
	public List<EmployeesDTO> findAll() {
		return employeesRepository.findAll();
	}
	
	public EmployeesDTO getOne(Integer employee_id) {
		return employeesRepository.getOne(employee_id);
	}

	public void delete(EmployeesDTO employeesDTO) {
		employeesRepository.delete(employeesDTO);
	}
	
	public EmployeesDTO save(EmployeesDTO employeesDTO) {
		return employeesRepository.save(employeesDTO);
	}
	
    public List<String> findByJobID(String job_id) {
    	return employeesRepository.findByJobID(job_id);
    };
}
