package cl.icap.cursofullstack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cl.icap.cursofullstack.model.dto.UsersDTO;

public interface UsersRepository extends JpaRepository<UsersDTO, Integer> {
	Optional<UsersDTO> findByUserName(String userName);
}