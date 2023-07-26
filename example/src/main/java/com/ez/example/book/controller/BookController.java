package com.ez.example.book.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ez.example.book.model.BookService;
import com.ez.example.book.model.BookVO;
import com.ez.example.common.ConstUtil;
import com.ez.example.common.PaginationInfo;
import com.ez.example.common.SearchVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	private final BookService bookService;
	
	
	@GetMapping("/write")
	public String write_get() {
		//1
		logger.info("책 등록 페이지");
		//2
		//3
		//4
		return "book/write";
	}
	
	@PostMapping("/write")
	public String write_post(@ModelAttribute BookVO vo, Model model) {
		//1
		logger.info("책 등록 파라미터, vo={}", vo);
		
		//2
		int cnt = bookService.insertBook(vo);
		logger.info("책 등록 결과, cnt={}", cnt);
	
		String msg = "책 등록 실패!", url = "/book/write";
		if(cnt>0) {
			msg = "책 등록 성공!";
			url = "/book/list";
		}
		//3
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
	
		//4
		return "common/message";
	}
	
	@RequestMapping("/list")
	public String list(@ModelAttribute SearchVO searchVo,Model model) {
		//1
		logger.info("책 목록 페이지");
		
		//2
		//[1]PaginationInfo 객체 생성
		PaginationInfo pagingInfo = new PaginationInfo();
		pagingInfo.setBlockSize(ConstUtil.BLOCK_SIZE);
		pagingInfo.setCurrentPage(searchVo.getCurrentPage());
		pagingInfo.setRecordCountPerPage(ConstUtil.RECORD_COUNT);

		//[2]SearchVo에 입력되지 않은 두 개의 변수에 값 셋팅
		searchVo.setRecordCountPerPage(ConstUtil.RECORD_COUNT);
		searchVo.setFirstRecordIndex(pagingInfo.getFirstRecordIndex());
		
		//2
		List<BookVO> list = bookService.selectAll(searchVo);
		logger.info("책 전체 조회 결과, list.size={}", list.size());
		
		int totalRecord = bookService.getTotalRecord(searchVo);
		logger.info("책 목록 전체 조회 - totalRecord={}", totalRecord);
		pagingInfo.setTotalRecord(totalRecord);
		
		//3
		model.addAttribute("list", list);
		model.addAttribute("pagingInfo", pagingInfo);
		
		//4
		return "book/list";
	}
	
}
