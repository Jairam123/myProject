package com.girnarsoft.library.beans;

public class BookDetails {

	private int serialNo;
	private String bookName;
	private int quantity;
	private String author;

	public BookDetails(int serialNo, String bookName, int quantity, String author) {
		super();
		this.serialNo = serialNo;
		this.bookName = bookName;
		this.quantity = quantity;
		this.author = author;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
