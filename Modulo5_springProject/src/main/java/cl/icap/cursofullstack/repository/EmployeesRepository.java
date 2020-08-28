package cl.icap.cursofullstack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cl.icap.cursofullstack.model.dto.EmployeesDTO;

public interface EmployeesRepository extends JpaRepository<EmployeesDTO, Integer> {
    //public List<EmployeesDTO> findByJobID(String job_id);
	   //@Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
	   @Query("SELECT e.first_name FROM EmployeesDTO e WHERE e.job_id = :job_id")
	   public List<String> findByJobID(@Param("job_id") String job_id);
}
