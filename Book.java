package com.example.demo;

public class Book
{
	static int counter = 0;
	String title;
	String author;
	int ID;
			
	public Book(String title, String author)
	{
		super();
		this.title = title;
		this.author = author;
		this.ID = counter++;		
	}


	public String getTitle()
	{
		return title;
	}


	public void setTitle(String title)
	{
		this.title = title;
	}


	public String getAuthor()
	{
		return author;
	}


	public void setAuthor(String author)
	{
		this.author = author;
	}
	

	public int getID()
	{
		return ID;
	}

	public void setID(int iD)
	{
		ID = iD;
	}

	@Override
	public String toString()
	{
		return "ID: " + ID + " " + title + " by " + author;
	}	

}
