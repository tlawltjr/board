package com.fullstack.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fullstack.board.entity.Reple;

public interface RepleRepository extends JpaRepository<Reple, Long> {

	@Modifying//JPQL을 이용해서 Update, Delete 시엔 반드시 선언하셔야 합니다
	@Query("Delete From Reple r Where r.board.bno =:bno")
	void deleteByBno(@Param("bno") Long bno);

	
}
