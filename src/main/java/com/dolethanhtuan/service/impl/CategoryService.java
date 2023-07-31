package com.dolethanhtuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolethanhtuan.dto.CategoryDTO;
import com.dolethanhtuan.entity.CategoryEntity;
import com.dolethanhtuan.repository.ICategoryRepository;
import com.dolethanhtuan.service.ICategoryService;
import com.dolethanhtuan.util.convertObject.ConvertCategory;
@Service
public class CategoryService implements ICategoryService{
	@Autowired
	private ICategoryRepository categoryRepository;
	@Autowired
	private ConvertCategory convertCate;
	
	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryEntity> listE = categoryRepository.findAll();
		return convertCate.toListDTO(listE);
	}
}
