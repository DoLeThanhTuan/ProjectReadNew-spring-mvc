package com.dolethanhtuan.util.convertObject;

import org.springframework.stereotype.Component;

import com.dolethanhtuan.dto.UserDTO;
import com.dolethanhtuan.entity.UserEntity;

@Component
public class ConvertUser {
	public UserDTO toDTO(UserEntity userE) {
		UserDTO userDTO = new UserDTO(userE.getFullname(), userE.getUsername(), userE.getPassword(), userE.getPassword());
		userDTO.setStatus(userE.getStatus());
		userDTO.setId(userE.getId());
		userDTO.setCreateBy(userE.getCreateBy());
		userDTO.setCreateDate(userE.getCreateDate());
		userDTO.setModifiedBy(userE.getModifiedBy());
		userDTO.setModifiedDate(userE.getModifiedDate());
		return userDTO;
	}
	public UserEntity toEntity(UserDTO userDTO) {
		return new UserEntity(userDTO.getUsername(), userDTO.getPassword(),userDTO.getFullname(), userDTO.getStatus());
	}
}
