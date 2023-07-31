package com.dolethanhtuan.service;

import org.springframework.data.domain.Pageable;

import com.dolethanhtuan.dto.NewDTO;
import com.dolethanhtuan.dto.PageDTO;

public interface INewService {
	NewDTO save(NewDTO newDTO);
	NewDTO findOneById(Long id);
	void delete(Long ids[]);
	PageDTO<NewDTO> findAll(Pageable page);
//	NewDTO findOneNewest();
}
