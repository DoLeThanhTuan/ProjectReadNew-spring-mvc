package com.dolethanhtuan.util.convertObject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dolethanhtuan.dto.NewDTO;
import com.dolethanhtuan.entity.CategoryEntity;
import com.dolethanhtuan.entity.NewEntity;
import com.dolethanhtuan.repository.ICategoryRepository;

@Component
public class ConvertNew {
	@Autowired
	private ICategoryRepository categoryRepository;
	public NewDTO toDTO(NewEntity newE) {
		NewDTO newDTO = new NewDTO();
		newDTO.setTitle(newE.getTitle());
		newDTO.setContent(newE.getContent());
		newDTO.setShortDes(newE.getShortDescription());
		newDTO.setThumbnail(newE.getThumbnail());
		newDTO.setCategoryCode(newE.getCategory().getCode());
		newDTO.setId(newE.getId());
		newDTO.setCreateBy(newE.getCreateBy());
		newDTO.setCreateDate(newE.getCreateDate());
		newDTO.setModifiedBy(newE.getModifiedBy());
		newDTO.setModifiedDate(newE.getModifiedDate());
		return newDTO;
	}
	public NewEntity toEntity(NewDTO newDTO) {
		NewEntity newE = new NewEntity();
		newE.setTitle(newDTO.getTitle());
		newE.setContent(newDTO.getContent());
		newE.setShortDescription(newDTO.getShortDes());
		newE.setThumbnail(newDTO.getThumbnail());
		if(newDTO.getCategoryCode()!= null) {
			CategoryEntity cate = categoryRepository.findOneByCode(newDTO.getCategoryCode());
			newE.setCategory(cate);
		}
		return newE;
	}
	public NewEntity toEntity(NewEntity newEOld,NewDTO newDTO) {
		if(newDTO.getTitle() != null)
			newEOld.setTitle(newDTO.getTitle());
		if(newDTO.getContent() != null)
			newEOld.setContent(newDTO.getContent());
		if(newDTO.getThumbnail() != null)
			newEOld.setThumbnail(newDTO.getThumbnail());
		if(newDTO.getShortDes() != null)
			newEOld.setShortDescription(newDTO.getShortDes());
		if(newDTO.getCategoryCode() != null) {
			CategoryEntity cate = categoryRepository.findOneByCode(newDTO.getCategoryCode());
			newEOld.setCategory(cate);
		}
		return newEOld;
	}
	public List<NewDTO> toListDTO(List<NewEntity> listE){
		List<NewDTO> listDTO = new ArrayList<>();
		for (NewEntity newEntity : listE) {
			NewDTO newDTO = this.toDTO(newEntity);
			listDTO.add(newDTO);
		}
		return listDTO;
	}
}
