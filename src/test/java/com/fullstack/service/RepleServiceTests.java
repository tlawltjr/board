package com.fullstack.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fullstack.board.dto.RepleDTO;
import com.fullstack.board.service.RepleService;

@SpringBootTest
public class RepleServiceTests {

	@Autowired
	private RepleService repleService;
	
	@Test
	public void testRepList() {
		Long bno = 95L;
		List<RepleDTO> repList = repleService.getList(bno);
		repList.forEach(dto->System.out.println(dto));
	}
	
}
