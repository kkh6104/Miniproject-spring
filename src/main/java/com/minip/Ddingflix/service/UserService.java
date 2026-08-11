package com.minip.Ddingflix.service;

import org.springframework.stereotype.Service;

import com.minip.Ddingflix.model.dto.UserDTO;
import com.minip.Ddingflix.model.dto.UserSessionDTO;
import com.minip.Ddingflix.model.mapper.UserMapper;

@Service
public class UserService {
	
	private final UserMapper mapper;
	
	public UserService(UserMapper mapper) {
		this.mapper = mapper;
	}

	public UserDTO login(String userID, String pwd) throws RuntimeException{
		
		UserDTO currentUser = mapper.identify(userID, pwd);
		
		if(currentUser != null) {
			return currentUser;
		} else {
			throw new RuntimeException("아이디나 비밀번호가 잘못되었습니다.");
		}
	}
	
	public UserSessionDTO insert(UserDTO user) throws RuntimeException{
		
		int result = mapper.join(user);
		
		if(result == 0) {
			throw new RuntimeException("회원 가입에 실패하셨습니다.");
		}
		
		UserSessionDTO usd = new UserSessionDTO(user.getUserId(), user.getUserName(), user.getUserBalance());
		
		return usd;
	}
	
	public UserDTO searchById(String userID) {
		
		UserDTO currentUser = mapper.searchById(userID);
		
		return currentUser;
	}
	
	public UserDTO update(UserDTO currentUser) throws RuntimeException{
		
		int result = 0;
		result = mapper.update(currentUser);
		
		if(result > 0) {
			return currentUser;
		} else {
			throw new RuntimeException("회원 정보 수정에 실패하셨습니다.");
		}
	}
	
	public int delete(String userID, String pwd) {
		
		int result = 0;
		result = mapper.delete(userID, pwd);
		
		if(result > 0) {
			return result;
		} else {
			throw new RuntimeException("회원 탈퇴에 실패하셨습니다.");
		}
	}
	
}
