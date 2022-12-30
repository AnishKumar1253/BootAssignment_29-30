package com.masai.example.service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.masai.example.entity.Book;

public class BookServiceImpl implements BookService
{
private List<Book> books=new ArrayList<Book>();
	
	//to create a book and add it in the list using post request
	public Book createBook(Book book) {
		int flag=0;
		for(Book b:books) {
			if(b.getBookId()==book.getBookId()) {
				flag=1;
				break;
			}
		}
		if(flag==1) {
			System.out.println("Book is already present");
			return null;
		}
		else {
			books.add(book);
			System.out.println("The book has been added");
			return book;
		}
		
	}
	
	

	@Override
	public List<Book> getAllBooks() {
		return books;
	}
	
	

	@Override
	public Book getBook(int bookId) {
	
		
		List<Book> books=this.books.stream()
				.filter(b->b.getBookId()==bookId)
				.collect(Collectors.toList());
		System.out.println(books.toString());
		
		return books.get(0);
	}

	@Override
	public void deleteBook(int bookId) {
		int flag=0;
		for(Book b:books) {
			if(b.getBookId()==bookId) {
				flag=1;
				break;
			}
		}
		if(flag==1) {
		Book book=getBook(bookId);
		books.remove(book);
		System.out.println("the book has been deleted");
		}else {
			System.out.println("Book not found hence not deleted");
		}

	}




	@Override
	public void updateBook(Book book) {
	
		
		for(Book b:books) {
			if(b.getBookId()==book.getBookId()) {
				b.setName("MongoDB");
				System.out.println("The book has been updated successfully");
				return;
			}
			
		}
		System.out.println("The book could not be updated as it is not present");
		return;
		
	}




	@Override
	public void updateBookPrice(Book book,int price) {
		for(Book b:books) {
			if(b.getBookId()==book.getBookId()) {
				b.setPrice(price);
				System.out.println("the book has been updated with the given price");
				return;
			}
		}
		return;
		
	}
	

}
