package com.girnarsoft.library.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.girnarsoft.library.beans.BookDetails;
import com.girnarsoft.library.services.BookService;
import com.opensymphony.xwork2.ActionSupport;

public class LibraryBooksAction extends ActionSupport {
	private List<BookDetails> booksList ;
	private List<Integer> checkBoxes;
	private BookService bookService;
   public LibraryBooksAction() {
	   bookService = new BookService();
	   booksList = new ArrayList<>();
    }

	@Override
	public String execute() {
		try {
			    booksList = bookService.getTotalBooksDetails();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String returnBooks() {
		
		String status = "return" ;
		for (int checkBoxIndex = 0; checkBoxIndex < checkBoxes.size(); checkBoxIndex++) {
			int bookId = checkBoxes.get(checkBoxIndex);
			int quantity = bookService.getQuantityOfSpecficBook(bookId);
			bookService.upDateQuantityofSpecficBook(quantity+1, bookId);
		}
		return status;
	}

	public String borrowBooks() {
		String status = "borrow";
		for (int checkBoxIndex = 0; checkBoxIndex < checkBoxes.size(); checkBoxIndex++) {
			int bookId = checkBoxes.get(checkBoxIndex);
			int quantity = bookService.getQuantityOfSpecficBook(bookId);
			if(quantity == 0){
				status = "booksAreNotAvailable";
				return status;
			}else{
				  bookService.upDateQuantityofSpecficBook(quantity-1, bookId);
			}
		}
		return status;
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

	public String goBack() {
		return "success";
	}
}
