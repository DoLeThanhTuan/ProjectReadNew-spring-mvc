package com.dolethanhtuan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dolethanhtuan.entity.NewEntity;

public interface INewRepository extends JpaRepository<NewEntity, Long>{
	NewEntity findOneById(Long id);
}
