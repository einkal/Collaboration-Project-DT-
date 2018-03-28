package com.niit.Freya.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="BLOGCOMMENT")
@Component
@SequenceGenerator(name="blogcommentIdSeq",sequenceName="blogcomment_id_seq")
public class BlogComment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="blogcommentIdSeq")
	
	int commentID;
	String userName;
	int blogID;
	Date CommentDate;
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getBlogID() {
		return blogID;
	}
	public void setBlogID(int blogID) {
		this.blogID = blogID;
	}
	public Date getCommentDate() {
		return CommentDate;
	}
	public void setCommentDate(Date commentDate) {
		CommentDate = commentDate;
	}
	
	
}
