package com.ez.example.book.model;

import java.util.List;

import com.ez.example.common.SearchVO;

public interface BookService {
	int insertBook(BookVO vo);
	List<BookVO> selectAll(SearchVO vo);
	int getTotalRecord(SearchVO vo);
}
