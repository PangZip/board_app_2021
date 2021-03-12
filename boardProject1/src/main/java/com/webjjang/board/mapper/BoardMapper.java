package com.webjjang.board.mapper;

import java.util.List;

import com.webjjang.board.util.Criteria;
import com.webjjang.board.vo.BoardVO;

public interface BoardMapper {

	// 게시판 리스트
	public List<BoardVO> selectBoardList(Criteria cri);
	
	public int selectCountAll(Criteria cri);
}
