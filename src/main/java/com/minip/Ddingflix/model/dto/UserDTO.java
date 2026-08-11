package com.minip.Ddingflix.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

	private String userId;
	private String userPwd;
	private String userName;
	private int userAge;
	private int userBalance;
	
}
