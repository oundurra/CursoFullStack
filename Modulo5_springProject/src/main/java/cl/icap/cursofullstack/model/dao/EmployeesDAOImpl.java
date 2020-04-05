package cl.icap.cursofullstack.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.icap.cursofullstack.model.dto.EmployeesDTO;

@Repository
@Transactional
public class EmployeesDAOImpl implements EmployeesDAO {
	private String list = "SELECT * FROM employees ORDER BY employee_id";
	private String select = "SELECT * FROM employees WHERE employee_id=?";
	private String insert = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private String update = "UPDATE employees SET employee_id=?, first_name=?, last_name=?, email=?," + 
			"phone_number=?, hire_date=?, job_id=?, salary=?, commission_pct=?, manager_id=?," +
			"department_id=? WHERE employee_id=?";
	private String delete = "DELETE employees WHERE employee_id=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<EmployeesDTO> list() {
		List<EmployeesDTO> listEmployees = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(EmployeesDTO.class));
		return listEmployees;
	}

	@Override
	public EmployeesDTO get(String employee_id) {
	    Object[] args = {employee_id};
	    EmployeesDTO employeesDto;
	    
	    try {
	    	employeesDto = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(EmployeesDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	employeesDto=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	employeesDto=null;
	    	e.printStackTrace();
	    }
	    return employeesDto;
	}

	@Override
	public int insert(EmployeesDTO employeesDto) {
		int rows = 0;
	    Object[] args = {
	    		employeesDto.getEmployee_id(),
	    		employeesDto.getFirst_name(),
	    		employeesDto.getLast_name(),
	    		employeesDto.getEmail(),
	    		employeesDto.getPhone_number(),
	    		employeesDto.getHire_date(),
	    		employeesDto.getJob_id(),
	    		employeesDto.getSalary(),
	    		employeesDto.getCommission_pct(),
	    		employeesDto.getManager_id(),
	    		employeesDto.getDepartment_id()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

	@Override
	public int update(EmployeesDTO employeesDto) {
		int rows = 0;
	    Object[] args = {
	    		employeesDto.getEmployee_id(),
	    		employeesDto.getFirst_name(),
	    		employeesDto.getLast_name(),
	    		employeesDto.getEmail(),
	    		employeesDto.getPhone_number(),
	    		employeesDto.getHire_date(),
	    		employeesDto.getJob_id(),
	    		employeesDto.getSalary(),
	    		employeesDto.getCommission_pct(),
	    		employeesDto.getManager_id(),
	    		employeesDto.getDepartment_id(),
	    		employeesDto.getEmployee_id(),
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

	@Override
	public int delete(String employee_id) {
		int rows = 0;
	    Object[] args = {employee_id};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
}
