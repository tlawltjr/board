package com.fullstack.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.fullstack.board.dto.RepleDTO;
import com.fullstack.board.entity.Board;
import com.fullstack.board.entity.Reple;
import com.fullstack.board.repository.RepleRepository;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RepleServiceImpl implements RepleService {

    private final RepleRepository repleRepository;

    @Override
    public Long register(RepleDTO repleDTO) {

        Reple reple = dtoToEntity(repleDTO);

        repleRepository.save(reple);

        return reple.getPno();
    }

    @Override
    public List<RepleDTO> getList(Long bno) {

        List<Reple> result =  repleRepository
                .getRepByBoardOrderByPno(Board.builder().bno(bno).build());

        return result.stream().map(reple -> entityToDTO(reple)).collect(Collectors.toList());
    }

    @Override
    public void modify(RepleDTO repleDTO) {

        Reple reple= dtoToEntity(repleDTO);

        repleRepository.save(reple);

    }

    @Override
    public void remove(Long pno) {

        repleRepository.deleteById(pno);
    }


}
