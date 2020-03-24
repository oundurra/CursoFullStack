package cl.icap.cursofullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.icap.cursofullstack.model.dto.JobsDTO;

public interface JobsRepository extends JpaRepository<JobsDTO, String> {

}
