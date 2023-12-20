package com.example.demo.vo;

import lombok.Data;

@Data
public class activity {
	private Integer id;
	private String name;
	private String content;
	private String eventtime;
	public activity(String name, String content, String eventtime) {
		super();
		this.name = name;
		this.content = content;
		this.eventtime = eventtime;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEventtime() {
		return eventtime;
	}
	public void setEventtime(String eventtime) {
		this.eventtime = eventtime;
	}
	public activity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
