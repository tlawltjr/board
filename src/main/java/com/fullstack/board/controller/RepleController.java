package com.fullstack.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.board.dto.RepleDTO;
import com.fullstack.board.service.RepleService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController//화면제공없이 데이터만 주고 받는 형태의 컨트롤러 선언
//위처럼 선언이 되면 자동으로 기본 데이터 입출형식이 JSON으로 설정됩니다
@RequestMapping("/reple")//리플 관련 데이터는 옆에 path 하위로 요청을 처리하도록 합니다
@Log4j2
@RequiredArgsConstructor
public class RepleController {
	
	private final RepleService repleService;
	
	//value 속성 중의 {}는 MVC 패턴에서 자주 쓰이는 패턴 표기법입니다
	//일반적으로 가변값이 들어올 때 매핑의 용도로 사용됩니다
	//현재는 board/bno(글번호)로 바로 요청이 오면 아래서 mapping을 시켜주고 
	//데이터는 JSON 객체로 생성해서 바인딩하겠다는 의미입니다
	@GetMapping(value = "/board/{bno}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RepleDTO>> getListByBoard(@PathVariable("bno") Long bno){ 
		log.info("bno------>" + bno);
		return new ResponseEntity<>(repleService.getList(bno), HttpStatus.OK);
	}
	
	
	
}
