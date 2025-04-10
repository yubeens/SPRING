package org.example.springboard.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter  @Setter
public class BoardDTO {
	private int num;
	private String userid;
	private String subject;
	private String content;
	private Date regdate; // 작성일
}
