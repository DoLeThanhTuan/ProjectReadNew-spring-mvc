package com.dolethanhtuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dolethanhtuan.dto.NewDTO;
import com.dolethanhtuan.dto.PageDTO;
import com.dolethanhtuan.entity.NewEntity;
import com.dolethanhtuan.repository.INewRepository;
import com.dolethanhtuan.service.INewService;
import com.dolethanhtuan.util.convertObject.ConvertNew;
@Service
public class NewService implements INewService{

	@Autowired
	private INewRepository newRepository;
	@Autowired
	private ConvertNew convertNew;
	
	@Override
	@Transactional
	public PageDTO<NewDTO> findAll(Pageable page) {
		List<NewEntity> listE = newRepository.findAll(page).getContent();
		int totalPage = newRepository.findAll(page).getTotalPages();
		int limit = newRepository.findAll(page).getSize();
		int index = page.getPageNumber();
		PageDTO<NewDTO> pageDTO = new PageDTO<>(convertNew.toListDTO(listE), index+1, limit,totalPage);
		return pageDTO;
	}
	@Override
	@Transactional
	public NewDTO save(NewDTO newDTO) {
		// update
		NewEntity newE = new NewEntity();
		if(newDTO.getId() != null) {
			newE = newRepository.findOneById(newDTO.getId());
			newE = convertNew.toEntity(newE, newDTO);
		}
		else {
			newE = convertNew.toEntity(newDTO);
		}
		newRepository.save(newE);
		return convertNew.toDTO(newE);
		
	}

	@Override
	@Transactional
	public NewDTO findOneById(Long id) {
		NewEntity newE = newRepository.findOneById(id);
		if(newE == null)
			return null;
		return convertNew.toDTO(newE);
	}

	@Override
	@Transactional
	public void delete(Long[] ids) {
		for (Long o : ids) {
			if(newRepository.findOneById(o) != null)
				newRepository.delete(o);;
		}
	}
//	@Override
//	@Transactional
//	public NewDTO findOneNewest() {
//		return convertNew.toDTO(newRepository.findTest());
//	}

}
