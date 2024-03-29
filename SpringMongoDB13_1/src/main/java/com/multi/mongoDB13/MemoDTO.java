package com.multi.mongoDB13;

import java.util.Date;

//db와 클래스간의 mapping
//RDB(row) -- JAVA(DTO) : ORM
//NO-SQL(document) -- JAVA(DTO) : ORM 
public class MemoDTO{

	private String _id;
	private String name;
	private String content;
	private Date date;
	private String weather;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	@Override
	public String toString() {
		return "MemoVO [_id=" + _id + ", name=" + name + ", content=" + content + ", date=" + date + ", weather="
				+ weather + "]";
	}

}
