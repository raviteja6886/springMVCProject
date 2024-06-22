package com.bookstore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MyBooks {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String bookName;
	private String authorName;
	private String price;
	public MyBooks(String bookName, String authorName, String price) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
	}
	public MyBooks() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "MyBooks [id=" + id + ", bookName=" + bookName + ", authorName=" + authorName + ", price=" + price + "]";
	}


}
