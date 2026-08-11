package com.minip.Ddingflix.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.minip.Ddingflix.model.dto.ContentDTO;

@Mapper
public interface ContentMapper {

	List<ContentDTO> getList();
}
