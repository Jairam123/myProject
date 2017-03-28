package com.girnarsoft.library.action;

import java.util.ArrayList;
import java.util.List;
import com.girnarsoft.library.beans.BookDetails;
import com.opensymphony.xwork2.ActionSupport;

public class LibraryBooksAction extends ActionSupport {
	private static List<BookDetails> booksList = new ArrayList<>();
	private List<Integer> checkBoxes;

	static {
		booksList.add(new BookDetails(1, "Java", 5, "James Goseling"));
		booksList.add(new BookDetails(2, "C", 5, "DR"));
		booksList.add(new BookDetails(3, "PHP", 5, "PHP"));
	}

	@Override
	public String execute() {
		setCheckBoxes(checkBoxes);
		return "success";
	}

	public String returnBooks() {
		for (int checkBoxIndex = 0; checkBoxIndex < checkBoxes.size(); checkBoxIndex++) {
			int booksListIndex = checkBoxes.get(checkBoxIndex);
			BookDetails bookDetails = booksList.get(booksListIndex);
			bookDetails.setQuantity((bookDetails.getQuantity() + 1));
		}
		return "return";
	}

	public String borrowBooks() {
		for (int checkBoxIndex = 0; checkBoxIndex < checkBoxes.size(); checkBoxIndex++) {
			int booksListIndex = checkBoxes.get(checkBoxIndex);
			BookDetails bookDetails = booksList.get(booksListIndex);
			bookDetails.setQuantity((bookDetails.getQuantity() - 1));
		}
		return "borrow";
	}

	public List<BookDetails> getBooksList() {
		return booksList;
	}

	public List<Integer> getCheckBoxes() {
		return checkBoxes;
	}

	public void setCheckBoxes(List<Integer> checkBoxes) {
		this.checkBoxes = checkBoxes;
	}
	public String goBack(){
		return "success";
	}
}
