package com.fullstack.board.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.board.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	


}
