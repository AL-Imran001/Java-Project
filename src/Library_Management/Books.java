package Library_Management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Books {
	private String bookName;
	private String firstName;
	private String lastName;
	private String catagory;
	
	public Books() {
		
	}
	public Books(String bookName, String firstName, String lastName, String catagory) {
		super();
		this.bookName = bookName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.catagory = catagory;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public void allBook(String file) throws FileNotFoundException {
		File f = new File(file);
		Scanner s = new Scanner(f);
		Books[] bk = new Books[500000];
		int temp = 0;
		while(s.hasNext()) {
			bookName = s.next();
			firstName = s.next();
			lastName = s.next();
			catagory = s.next();
			bk[temp]= new Books(bookName,firstName,lastName,catagory);
			temp++;
		}
		for(int i=0; i<temp ; i++) {
		 System.out.println(bk[i]); 
		}
		
	}
	public void bookName(String file) throws FileNotFoundException {
		int current =0;
		File f = new File(file);
		Scanner s = new Scanner(f);
		while(s.hasNext()) {
			s.nextLine();
			current++;
		}
		s = new Scanner(f);
		Books[] bk = new Books[current];
		int temp = 0;
		while(s.hasNext()) {
			bookName = s.next();
			firstName = s.next();
			lastName = s.next();
			catagory = s.next();
			bk[temp]= new Books(bookName,firstName,lastName,catagory);
			temp++;
		}
		for(int i=0; i<bk.length ; i++) {
		 System.out.println(bk[i].bookName); 
		}
		
		
	}
	public void searchBookByName(String file) throws FileNotFoundException {
		
		int temp =0;
		int current =0;
		File f = new File(file);
		Scanner s = new Scanner(f);
		while(s.hasNext()) {
			s.nextLine();
			temp++;
		}
		Books[] b = new Books[temp];
		s= new Scanner(f);
		while(s.hasNext()) {
			bookName = s.next();
			firstName = s.next();
			lastName = s.next();
			catagory = s.next();
			b[current]= new Books(bookName,firstName,lastName,catagory);
			current++;
		}
		int index =0;
		boolean flag =false;
		System.out.println("Enter book name :");
		s = new Scanner(System.in);
		String book = s.next();
		for(int i=0; i<current ; i++) {
			if(book.equalsIgnoreCase(b[i].bookName)) {
			flag = true;
			index=i;
			}
		}
		if(flag == true)
			System.out.println(b[index].bookName);
		else
			System.out.println("book not found");
		
		
	}
	public void add_book(String file) throws IOException {
		System.out.println("How many book do you want to add");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Books[] bk = new Books[n];
		File f= new File(file);
		for(int i=0; i<n; i++) {
			System.out.println("Enter book name :");
			String bookName = s.next();
			System.out.println("Writer first name :");
			String firstName = s.next();
			System.out.println("Writer last name :");
			String lastName = s.next();
			System.out.println("Which catagory :");
			String catagory = s.next();
			bk[i] = new Books(bookName,firstName,lastName,catagory);
			try {
				bk[i].add(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	public void add(String file) throws IOException {
		FileWriter fw = new FileWriter(file,true);
		fw.write(bookName+" "+firstName+" "+lastName+" "+catagory+"\n");
		fw.close();
	}
	@Override
	public String toString() {
		return "[Book Name = " + bookName + "\tWriter Name = " + firstName + " " + lastName + "\t catagory = "
				+ catagory + "]";
	}
	

}
