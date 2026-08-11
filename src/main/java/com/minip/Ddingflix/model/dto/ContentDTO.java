package com.minip.Ddingflix.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContentDTO {

	private String contentId;
	private String contentTitle;
	private int contentPrice;
	private int contentAgeLimit;
	private LocalDate contentUploadDate;

}
