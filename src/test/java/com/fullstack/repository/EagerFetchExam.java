package com.fullstack.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fullstack.board.entity.Board;
import com.fullstack.board.entity.Reple;
import com.fullstack.board.repository.BoardRepository;
import com.fullstack.board.repository.RepleRepository;

@SpringBootTest
public class EagerFetchExam {

	@Autowired
	RepleRepository repleRepository;
	
	@Transactional
	@Test
	public void eagerTest() {
		
		Optional<Reple> result = repleRepository.findById(40L);
		
		Reple reple = result.get();
		System.out.println(reple);
		System.out.println(reple.getBoard());
	}
}
