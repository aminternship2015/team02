package com.endava.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="dbo.Posts")
public class Posts {
public Posts(){}
	 
	public Posts(int postId, int userId, String postText, String createdAt) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.postText = postText;
		this.createdAt = createdAt;
	}

	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Column(name="post_id")
	private int postId;
	
	@Column(name="user_id")
    @ForeignKey(name="FK_Posts_Users")
	private int userId;
	
	@Column(name="post_text")
	private String postText;
	
	@Column(name="created_at")
	private String createdAt;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	
	@JoinColumn(name = "user_id", nullable = false)	
	@ManyToOne(fetch = FetchType.LAZY)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
