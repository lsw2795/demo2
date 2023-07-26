package com.ez.example.book.model;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ez.example.common.SearchVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
	private final BookDAO bookDao;
	
	@Override
	public int insertBook(BookVO vo) {
		return bookDao.insertBook(vo);
	}

	@Override
	public List<BookVO> selectAll(SearchVO vo) {
		return bookDao.selectAll(vo);
	}

	@Override
	public int getTotalRecord(SearchVO vo) {
		return bookDao.getTotalRecord(vo);
	}

}
