package com.minip.Ddingflix.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.minip.Ddingflix.model.dto.UserDTO;

@Mapper
public interface UserMapper {

	UserDTO identify(@Param("userId") String userId, @Param("userPwd") String userPwd);
	
	int join(UserDTO user);
	
	UserDTO searchById(@Param("userId") String userId);
	
	int update(UserDTO currentUser);
	
	int delete(@Param("userId") String userId, @Param("userPwd") String userPwd);
}
