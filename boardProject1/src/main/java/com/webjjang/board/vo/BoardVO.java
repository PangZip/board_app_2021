package com.webjjang.board.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {

	private int postNo;
	private String postTitle, postContent, postWriter;
	private Date postDate;
	private int postHit;

}
