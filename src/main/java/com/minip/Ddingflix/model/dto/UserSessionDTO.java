package com.minip.Ddingflix.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserSessionDTO {

	private String userId;
	private String userName;
	private int userBalance;
	
}
