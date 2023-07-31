package com.dolethanhtuan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dolethanhtuan.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
	public UserEntity findOneByUsernameAndStatus(String username,int status);
	public UserEntity findOneByUsername(String username);
}
