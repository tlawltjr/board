package com.fullstack.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fullstack.board.dto.PageRequestDTO;
import com.fullstack.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/board")//Root 서버 하위에(localhost:8080/{context Mapping})되어서
//board 하위에 오는 모든 요청은 이 컨트롤러가 잡습니다
public class BoardController {

	private final BoardService boardService;
	
	//이번엔 각 context 하위의 요청마다 처리해줄 요청 매핑을 선언 해야합니다
	//기본적으로 get 방식은 @Get Post --> @Post
	@GetMapping("/list")
	public void list(PageRequestDTO pageRequestDTO, Model model) {
		log.info("리스트 페이지 요청");
		model.addAttribute("PageResObj", boardService.getList(pageRequestDTO));
	}
	
	
}
