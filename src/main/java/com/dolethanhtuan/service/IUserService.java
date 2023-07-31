package com.dolethanhtuan.service;

import com.dolethanhtuan.dto.UserDTO;

public interface IUserService {
	UserDTO save(UserDTO userE);
	UserDTO getNewMost();
}
