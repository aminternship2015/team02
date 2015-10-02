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
@Table(name="dbo.Relations")
public class Relations {

	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Column(name="relation_id")
	int relation_id;	
	
	@Column(name="user_id")
    @ForeignKey(name="FK_Posts_Users")
	private int userId;
	
	@Column(name="followed_id")
	@ForeignKey(name="FK_Posts_Followed")
	private int followedId;

	public Relations( int userId, int followedId) {
		super();
		
		this.userId = userId;
		this.followedId = followedId;
	}

	public int getRelation_id() {
		return relation_id;
	}

	public void setRelation_id(int relation_id) {
		this.relation_id = relation_id;
	}

	@JoinColumn(name = "user_id", nullable = false)	
	@ManyToOne(fetch = FetchType.LAZY)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@JoinColumn(name = "user_id", nullable = false)	
	@ManyToOne(fetch = FetchType.LAZY)
	public int getFollowedId() {
		return followedId;
	}

	public void setFollowedId(int followedId) {
		this.followedId = followedId;
	}
	
}
