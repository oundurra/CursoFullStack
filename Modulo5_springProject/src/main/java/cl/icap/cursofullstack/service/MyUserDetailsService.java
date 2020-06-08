package cl.icap.cursofullstack.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.icap.cursofullstack.model.dto.UsersDTO;
import cl.icap.cursofullstack.repository.UsersRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UsersRepository usersRepository;

	@Override
	public MyUserDetailsServiceImpl loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<UsersDTO> usersDTO = usersRepository.findByUserName(userName.toUpperCase());
		
		usersDTO.orElseThrow(() -> new UsernameNotFoundException("Not Found: " + userName));
		
		return usersDTO.map(MyUserDetailsServiceImpl::new).get();
	}
}
