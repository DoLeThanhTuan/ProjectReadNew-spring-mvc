package com.dolethanhtuan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolethanhtuan.dto.UserDTO;
import com.dolethanhtuan.entity.UserEntity;
import com.dolethanhtuan.repository.IUserRepository;
import com.dolethanhtuan.service.IUserService;
import com.dolethanhtuan.util.convertObject.ConvertUser;
import com.dolethanhtuan.util.encrypt.EncryptMD5;
@Service
public class UserService implements IUserService{

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private ConvertUser convertUser;
	
	public UserDTO save(UserDTO userDTO) {
		// Nếu trong DB đã tồn tại username thì thông báo lỗi đã tồn tại
		if(userRepository.findOneByUsername(userDTO.getUsername())!= null) {
			return null;
		}
		userDTO.setPassword(EncryptMD5.toMD5(userDTO.getPassword()));
		userDTO.setStatus(1);
		UserEntity userE = convertUser.toEntity(userDTO);
		return convertUser.toDTO(userRepository.save(userE));
	}
	@Override
	public UserDTO getNewMost() {
		// TODO Auto-generated method stub
//		UserEntity u = userRepository.findOne
		return null;
	}

}
