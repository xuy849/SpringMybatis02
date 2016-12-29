package com.springmybatis02.po;

import java.util.Date;

public class User {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getLast_updated_time() {
		return last_updated_time;
	}
	public void setLast_updated_time(Date last_updated_time) {
		this.last_updated_time = last_updated_time;
	}
	private int id;
	private String first_name;
	private String last_name;
	private Date last_updated_time;
}
