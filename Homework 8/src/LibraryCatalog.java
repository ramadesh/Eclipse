import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * A class that stores books and acts as a library'
 *
 *
 * @author Rama Deshpande 
 * @version Oct 19, 2020
 */

public class LibraryCatalog 
{
	private ArrayList<Book> books;
	private String fileName;
	
	public LibraryCatalog(String fileName) throws FileNotFoundException, BookParseException
	{
	    this.fileName = fileName;
		File f = new File(fileName); 
	    FileReader fr = new FileReader(f);
	    BufferedReader bfr = new BufferedReader(fr);
	    String line = null;
	    books = new ArrayList<>();
	    try {
			line = bfr.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
        while (line != null) {
            books.add(parseBook(line));
            try {
    			line = bfr.readLine();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        }
        try {
			bfr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Book parseBook(String line) throws BookParseException
	{
		String[] bookTitles = line.split(" ");
		if (bookTitles.length != 5)
		{
			throw new BookParseException("Error Parsing Book! Data provided in single line is invalid!");
		}
        try {
        	int index0;
        	for(int i = 0; i < bookTitles[0].length(); i++)
        	{
        		if (bookTitles[0].indexOf("_") != -1)
        		{
        			index0 = bookTitles[0].indexOf("_");
        			bookTitles[0] = bookTitles[0].substring(0, index0) + " " + bookTitles[0].substring(index0 + 1);
        		}
        	}
        	for(int i = 0; i < bookTitles[1].length(); i++)
        	{
        		if (bookTitles[1].indexOf("_") != -1)
        		{
        			index0 = bookTitles[1].indexOf("_");
        			bookTitles[1] = bookTitles[1].substring(0, index0) + " " + bookTitles[1].substring(index0 + 1);
        		}
        	}
        	Book book = new Book(bookTitles[0], bookTitles[1], 
                                 Float.parseFloat(bookTitles[2]), 
                                 Integer.parseInt(bookTitles[3]), 
                                 Integer.parseInt(bookTitles[4]));
        	return book;
        } catch (NumberFormatException e) {
        	throw new BookParseException("Error Parsing Book! Failed to parse numbers from file!");
        }
	}

	public ArrayList<Book> searchByName(String bookName) throws BookNotFoundException
	{
		boolean found = false;
		ArrayList<Book> searchByName = new ArrayList<>();
		for (Book oneBook: books)
		{
			if (oneBook.getBookName().indexOf(bookName.toLowerCase()) != -1)
			{
				searchByName.add(oneBook);
				found = true;
			}
		}
		if (found == false) 
		{
			throw new BookNotFoundException("No books found with the given book name!");
		}
		return searchByName;
	}
	
	public void borrowBook(String bookName) throws BookNotFoundException
	{
		boolean found = false;
		for (Book aBook: books)
		{
			if (aBook.getQuantity() == 0)
			{
				throw new BookNotFoundException("The given book was not found.");
			}
			if (aBook.getBookName().indexOf(bookName.toLowerCase()) != -1)
			{
				aBook.setQuantity(aBook.getQuantity() - 1);
				found = true;
			}
		}
		if (found == false)
		{
			throw new BookNotFoundException("The given book was not found.");
		}
		
	}
	
	public void writeChangesToFile() throws FileNotFoundException
	{
		File f = new File(fileName);
	    FileOutputStream fos = new FileOutputStream(f, true);
	    PrintWriter pw = new PrintWriter(fos); 
	    for (Book theBook : books)
		{
		    String[] bookNames = theBook.getBookName().split(" ");
		    String[] bookAuthors = theBook.getAuthorName().split(" ");
		    Book book1 = new Book(bookNames[0] 
                                  + "_" 
                                  + bookNames[1], bookAuthors[0] 
                                  + "_" 
                                  + bookAuthors[1], 
                                  theBook.getPrice(), 
                                  theBook.getQuantity(), 
                                  theBook.getYear());
		    pw.println(book1.getBookName() 
                       + " " + book1.getAuthorName() 
                       + " " + book1.getPrice() + " " 
                       + book1.getQuantity() + " " 
                       + book1.getYear());
		}
	    pw.close();
	}
	
	public ArrayList<Book> getBookList()
	{
		return books;
	}

	public ArrayList<Book> searchByAuthor(String authorName) throws BookNotFoundException
	{
		boolean found = false;
		ArrayList<Book> searchByAuthor = new ArrayList<>();
		for (Book oneBook: books)
		{
			if(oneBook.getAuthorName().indexOf(authorName.toLowerCase()) != -1)
			{
				searchByAuthor.add(oneBook);
				found = true;
			}
		}
		if (found == false) 
		{
			throw new BookNotFoundException("No books found with the given author name!");
		}
		return searchByAuthor;
	}
	
}
