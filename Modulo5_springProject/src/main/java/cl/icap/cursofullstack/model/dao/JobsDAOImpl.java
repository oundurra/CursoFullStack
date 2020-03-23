package cl.icap.cursofullstack.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.icap.cursofullstack.model.dto.JobsDTO;

@Repository
@Transactional
public class JobsDAOImpl implements JobsDAO {
	private String list = "SELECT * FROM jobs";
	private String select = "SELECT * FROM jobs WHERE job_id=?";
	private String insert = "INSERT INTO jobs VALUES (?,?,?,?)";
	private String update = "UPDATE jobs SET job_id=?, job_title=?, min_salary=?, max_salary=? WHERE job_id=?";
	private String delete = "DELETE jobs WHERE job_id=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<JobsDTO> list() {
		List<JobsDTO> listJobs = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(JobsDTO.class));
		return listJobs;
	}

	@Override
	public JobsDTO get(String job_id) {
	    Object[] args = {job_id};
	    JobsDTO jobsDTO;
	    
	    try {
	    	jobsDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(JobsDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	jobsDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	jobsDTO=null;
	    	e.printStackTrace();
	    }
	    return jobsDTO;
	}

	@Override
	public int insert(JobsDTO jobsDto) {
		int rows = 0;
	    Object[] args = {
	    		jobsDto.getJob_id(),
	    		jobsDto.getJob_title(),
	    		jobsDto.getMin_salary(),
	    		jobsDto.getMax_salary()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

	@Override
	public int update(JobsDTO jobsDto) {
		int rows = 0;
	    Object[] args = {
	    		jobsDto.getJob_id(),
	    		jobsDto.getJob_title(),
	    		jobsDto.getMin_salary(),
	    		jobsDto.getMax_salary()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

	@Override
	public int delete(String job_id) {
		int rows = 0;
	    Object[] args = {job_id};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
}
