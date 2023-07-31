package com.dolethanhtuan.util.convertObject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dolethanhtuan.dto.CategoryDTO;
import com.dolethanhtuan.entity.CategoryEntity;

@Component
public class ConvertCategory {
	public CategoryDTO toDTO(CategoryEntity cateE) {
		CategoryDTO cateDTO = new CategoryDTO();
		if(cateE.getId() != null)
			cateDTO.setId(cateE.getId());
		if(cateE.getCreateBy() != null)
			cateDTO.setCreateBy(cateE.getCreateBy());
		if(cateE.getCreateDate() != null)
			cateDTO.setCreateDate(cateE.getCreateDate());
		if(cateE.getModifiedBy() != null)
			cateDTO.setModifiedBy(cateE.getModifiedBy());;
		if(cateE.getModifiedDate() != null)
			cateDTO.setModifiedDate(cateE.getModifiedDate());
		if(cateE.getCode() != null)
			cateDTO.setCode(cateE.getCode());
		if(cateE.getName() != null)
			cateDTO.setName(cateE.getName());
		return cateDTO;
	}
	public List<CategoryDTO> toListDTO(List<CategoryEntity> listE){
		List<CategoryDTO> listDTO = new ArrayList<>();
		for (CategoryEntity categoryEntity : listE) {
			CategoryDTO cateDTO = this.toDTO(categoryEntity);
			listDTO.add(cateDTO);
		}
		return listDTO;
	}
}
