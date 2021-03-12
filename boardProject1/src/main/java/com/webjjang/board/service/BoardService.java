package com.webjjang.board.service;

import java.util.List;

import com.webjjang.board.util.Criteria;
import com.webjjang.board.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> getBoardList(Criteria cri);
	
	public int getCountAll(Criteria cri);
	
	
}
