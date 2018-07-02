package com.example.demo;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Library
{
	// Create arraylist to hold books
	static List<Book> bookList = new ArrayList<>();
	
	// Add books to the arraylist
	static 
	{
		bookList.add(new Book("Frankenstein", "Mary Shelley"));
		bookList.add(new Book("Wuthering Heights", "Emily Brontë"));
		bookList.add(new Book("The Scarlet Letter", "Nathaniel Hawthorne"));
		bookList.add(new Book("Moby-Dick", "Herman Melville"));
		bookList.add(new Book("Little Women", "Louisa M. Alcott"));
		bookList.add(new Book("Alice's Adventures In Wonderland", "Lewis Carroll"));
		bookList.add(new Book("Huckleberry Finn", "Mark Twain"));
		bookList.add(new Book("The Strange Case of Dr Jekyll and Mr Hyde", "Robert Louis Stevenson"));	
		bookList.add(new Book("Through the Looking-Glass", "Lewis Carroll"));
		bookList.add(new Book("Gone with the Wind", "Margaret Mitchell"));
	}

	/**
	 * Displays all books. Used to test below methods in Java Application 
	 * @param books
	 */
	public void displayBooks(List<Book> books)
	{
		for (Book book: books)
		{
			System.out.println(book);
		}
	}
	
	/**
	 * Returns all the books in the arraylist
	 * @return
	 */
	public List<Book> displayAll() 
	{
		return bookList;
	}
	
	/**
	 * Displays the books sorted by the author's name
	 * @return
	 */
	public List<Book> displayByAuthor()
	{
		List<Book> sortedList = new ArrayList<>();
		
		sortedList.addAll(bookList);
		
		Collections.sort(sortedList, new AuthorComparator());
		
		return sortedList;
	}
	
	/**
	 * Returns the titles that matches the phrase the user entered. 
	 * @param searchTitle
	 * @return
	 */
	public List<Book> searchByTitle(String searchTitle)
	{
		// Arraylist for books that match phrase 
		List<Book> searchBooks = new ArrayList<>();
		
		for (Book book : bookList) 
		{
			// If title contains the phrase the user entered
			if (book.getTitle().contains(searchTitle)) 
			{
				// Add book to the new arraylist
				searchBooks.add(book);
			}
		}
		
		// Return the arraylist
		return searchBooks;		
	}
	
	/**
	 * Returns the titles that matches the author the user entered.  
	 * @param searchAuthor
	 * @return
	 */
	public List<Book> searchByAuthor(String searchAuthor)
	{
		// Arraylist for books that match name the user entered 
		List<Book> searchBooks = new ArrayList<>();
		
		for (Book book : bookList) 
		{
			// If the author's name is in the library, add the book to the arraylist
			if (book.getAuthor().equalsIgnoreCase(searchAuthor))
			{
				searchBooks.add(book);
			}
		}
		
		// Return the arraylist
		return searchBooks;		
	}
	
	/**
	 * Add a new book to the library(arraylist)
	 * @param book
	 */
	public void addBook(Book book)
	{
		bookList.add(book);			
	}
	
	/**
	 * Returns book that matches the ID user entered.
	 * @param ID
	 * @return
	 */
	public Book getByID(int ID)
	{
		Book book = null;
	
		for (Book book1 : bookList) 
		{
			if (book1.getID() == ID)
			{
				book = book1;
				break;
			}
		}
		
		return book;			
	}
	
	/**
	 * User enters an author's name to search for in library.
	 * Returns the books written by the author.
	 */
	public class AuthorComparator implements Comparator<Book>
	{
		@Override
		public int compare(Book b1, Book b2)
		{
			return b1.getAuthor().compareTo(b2.getAuthor());
		}		
	}
	
	
/*	
 * Test methods in Java Application
 * 
 * public static void main (String[] args)
	{
		Library library1 = new Library();
		
		System.out.println("Display by author");
		library1.displayBooks(library1.displayByAuthor());
		System.out.println("Search title");
		library1.displayBooks(library1.searchByTitle("Moby"));
		System.out.println("Added Treasure Island");
		library1.addBook(new Book("Treasure Island", "Robert Louis"));
		library1.displayBooks(library1.displayByAuthor());
		
		//displayByAuthor();
		
		//searchByTitle(String searchTitle);
		
		//addBook(Book book);		
	}	
*/
	
}
