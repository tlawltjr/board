package com.fullstack.board.service;

import com.fullstack.board.dto.RepleDTO;
import com.fullstack.board.entity.Board;
import com.fullstack.board.entity.Reple;

import java.util.List;

public interface RepleService {

    Long register(RepleDTO repleDTO); //댓글의 등록

    List<RepleDTO> getList(Long bno); //특정 게시물의 댓글 목록

    void modify(RepleDTO repleDTO); //댓글 수정

    void remove(Long rno); //댓글 삭제

    //DTO --> Entity변환
    default Reple dtoToEntity(RepleDTO repleDTO){

    	//제목글 얻어와야 하기에 Board 객체 생성
        Board board = Board.builder().bno(repleDTO.getBno()).build();

        Reple reple = Reple.builder()
                .pno(repleDTO.getPno())
                .text(repleDTO.getText())
                .repler(repleDTO.getRepler())
                .board(board)
                .build();

        return reple;
    }

    //reple객체를 repleDTO로 변환 Board 객체가 필요하지 않으므로 게시물 번호만
    default RepleDTO entityToDTO(Reple reple){

        RepleDTO dto = RepleDTO.builder()
                .pno(reple.getPno())
                .text(reple.getText())
                .repler(reple.getRepler())
                .regDate(reple.getRegDate())
                .modDate(reple.getModDate())
                .build();

        return dto;

    }
}