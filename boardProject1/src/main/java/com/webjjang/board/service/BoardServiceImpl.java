package com.webjjang.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.webjjang.board.mapper.BoardMapper;
import com.webjjang.board.util.Criteria;
import com.webjjang.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> getBoardList(Criteria cri){
		System.out.println("this is mapper");
		System.out.println("mapper.selectBoardList(cri) : " + mapper.selectBoardList(cri));
		return mapper.selectBoardList(cri);
	}

	@Override
	public int getCountAll(Criteria cri) {
		return mapper.selectCountAll(cri);
	}

}
