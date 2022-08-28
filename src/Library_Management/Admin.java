package Library_Management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Admin {
	private String mail;
	private String password;
	private String firstName;
	private String lastName;
	public Admin() {
		
	}
	public Admin(String mail, String password,String firstName ,String lastName) {
		super();
		this.mail = mail;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstNmae() {
		return firstName;
	}
	public void setFirstNmae(String firstNmae) {
		this.firstName = firstNmae;
	}
	public String getLasltName() {
		return lastName;
	}
	public void setLasltName(String lasltName) {
		this.lastName = lasltName;
	}
	public void adminLogIn(String file) throws IOException {
		File f = new File(file);
		Scanner s = new Scanner(f);
		int temp = 0;
		int current =0;
		int index =0;
		boolean flag = false;
		while(s.hasNext()) {
			s.nextLine();
			temp++;
		}
		Admin[] ad = new Admin[temp];
		s = new Scanner(f);
		while(s.hasNext()) {
			mail = s.next();
			password = s.next();
			firstName = s.next();
			lastName = s.next();
			ad[current] = new Admin(mail , password ,firstName , lastName);
			current ++;
		}
		System.out.println("Enter Gmail >>");
		s = new Scanner(System.in);
		String gmail = s.next();
		for(int i=0; i<current ;i++) {
			if(gmail.equals(ad[i].mail)) {
				System.out.println("Enter yout password");
				String pass = s.next();
				if(pass.equals(ad[i].password)) {
					flag = true ;
					index = i;
				}
			}
		}
		if(flag == true) {
			System.out.println("\t\t---Welcome to admin panel ("+ad[index].firstName+" "+ad[index].lastName+")---");
			boolean b = true;
		while(b) {
		Log log = new Log();
		Books book = new Books();
		System.out.println();
		System.out.println("Enter [0] to exit");
		System.out.println("Enter [1] to see the members list");
		System.out.println("Enter [2] for search a member for phone number and address");
		System.out.println("Enter [3] for delete account");
		System.out.println("Enter [4] for add a book");
		System.out.println("Enter [5] for see book list");
		System.out.println("Enter [6] for Book List with Writer name and catagory");
		int choice = s.nextInt();
		switch(choice) {
		case 0:
			return ;
			
		case 1 :
			log.memberList("log.txt");
			break;
		case 2:
			log.seeNumber_address("log.txt");
			break;
		case 3:
			log.deleteAccount("log.txt");
			break;
		case 4:
			book.add_book("book_list.txt");
			break;
		case 5:
			book.bookName("book_list.txt");
			break;
		case 6:
			book.allBook("book_list.txt");
			break;
		
		}
		}
		}
		else
			System.out.println("Email is incorect");
	}

}
