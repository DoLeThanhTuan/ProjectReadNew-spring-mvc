package com.dolethanhtuan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dolethanhtuan.dto.MyUserDTO;
import com.dolethanhtuan.entity.RoleEntity;
import com.dolethanhtuan.entity.UserEntity;
import com.dolethanhtuan.repository.IUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUsernameAndStatus(username, 1);
		
		if (userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (RoleEntity role: userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		MyUserDTO myUser = new MyUserDTO(userEntity.getUsername(), userEntity.getPassword(), 
							true, true, true, true, authorities);
		myUser.setFullname(userEntity.getFullname());
		return myUser;
	}
}
