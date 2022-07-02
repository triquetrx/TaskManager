package com.triquetrx.SpringApplication.web.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Todo {
	
	private int id;
	private String user;
	@Size(min=10, message="Atleast 10 characters required")
	private String desc;
	@NotNull(message="Date needs be selected")
	private String todoDate;
	private boolean isDone;
	
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Todo(int id, String user, String desc, String todoDate, boolean isDone) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.todoDate = todoDate;
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTodoDate() {
		return todoDate;
	}

	public void setTodoDate(String todoDate) {
		this.todoDate = todoDate;
	}

	public boolean getIsDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", user=" + user + ", desc=" + desc + ", todoDate=" + todoDate + ", isDone=" + isDone
				+ "]";
	}
	
}
