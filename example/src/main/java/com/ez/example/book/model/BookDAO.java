package com.ez.example.book.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ez.example.common.SearchVO;

@Mapper
public interface BookDAO {
	int insertBook(BookVO vo);
	List<BookVO> selectAll(SearchVO vo);
	int getTotalRecord(SearchVO vo);
}
