package com.twpnn.demo.simpleblog.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "greeting")
public class Greeting implements Serializable {

	private static final long serialVersionUID = -2762287468620149210L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@Column(name = "greeting_text")
	private String greetingText;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "greeting_date")
	private Date greetingDate;

	@Column(name = "USERNAME")
	private String username;
 
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGreetingText() {
		return greetingText;
	}

	public void setGreetingText(String greetingText) {
		this.greetingText = greetingText;
	}

	public Date getGreetingDate() {
		return greetingDate;
	}

	public void setGreetingDate(Date greetingDate) {
		this.greetingDate = greetingDate;
	}

}
