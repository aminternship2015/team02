package com.websystique.springmvc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;





@Entity
@Table(name = "post")
public class Post {

	@Id
	//@GeneratedValue(generator = "increment")
	//@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "post_id")
	private int postId;
	
	@NotNull
	@Column(name = "username")
	
	private String username;
	
	@NotNull
	@Column(name = "post_text")
	private String postText;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "created_at", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate createdAt;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}
	@ManyToOne
	@JoinTable(name="user", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "username") )
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		
		this.username = username;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
