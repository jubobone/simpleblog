package com.twpnn.demo.simpleblog.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Post implements Serializable{

	private static final long serialVersionUID = 1553546194531563339L;
	
	@Id
	@Column(name = "post_id")
	@GeneratedValue
	private Long postId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name = "update_date")
	private Date updateDate;
	
	@Column(name = "author_id")
	private String postBy;
}
