package com.example.demo.vo;

import lombok.Data;

@Data
public class message {
	private Integer id;
	private String memberno;
	private String title;
	private String content;
	public message(String memberno, String title, String content) {
		super();
		this.memberno = memberno;
		this.title = title;
		this.content = content;
	}
	public message() {
		super();
		// TODO Auto-generated constructor stub
	}
}
