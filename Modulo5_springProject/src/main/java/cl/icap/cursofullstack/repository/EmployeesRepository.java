package cl.icap.cursofullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.icap.cursofullstack.model.dto.EmployeesDTO;

public interface EmployeesRepository extends JpaRepository<EmployeesDTO, Integer> {

}
