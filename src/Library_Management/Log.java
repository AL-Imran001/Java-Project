package Library_Management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Log {
	private int id;
	private String firstName;
	private String lastName;
	private int pin;
	private int number;
	private String address;
	
	public Log() {
		
	}
	public Log(int id, String firstName, String lastName, int pin ,int number ,String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pin = pin;
		this.number = number;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
public void logIn(String file) throws FileNotFoundException {
	    int current =0;
		File f = new File(file);
		Scanner s = new Scanner(f);
		while(s.hasNext()) {
			s.nextLine();
			current++;
		}
		s = new Scanner(f);
		Log[] lg = new Log[current];
		int temp =0;
		while(s.hasNext()) {
			id = s.nextInt();
			firstName = s.next();
			lastName = s.next();
			pin = s.nextInt();
			number = s.nextInt();
			address =s.next();
			lg[temp]=new Log(id,firstName,lastName,pin,number,address);
			temp++;
		}
		boolean flag = false;
		int n=0;
		System.out.println("Enter id no : ");
		
		s = new Scanner(System.in);
		int inputId= s.nextInt();
		for(int i=0; i<temp; i++) {
			if(inputId==lg[i].id) {
				System.out.println("Enter pin");
				int inputPin = s.nextInt();
				if(inputPin == lg[i].pin) {
					flag =true;
				n=i;
				}
			}
		}
		if(flag == true) {
			System.out.println("Welcome "+lg[n].firstName+ " "+lg[n].lastName);
			while(true) {
		System.out.println();
		System.out.println("Enter [0] to exit");
		System.out.println("Enter [1] for see the book list");
		System.out.println("Enter [2] for Book List with Writer name and catagory");
		System.out.println("Enter [3] for Search Book");
		Books book = new Books();
		int choice = s.nextInt();
		
		switch(choice) {
		case 0:
			return;
		case 1:
			book.bookName("book_list.txt");
			break;
		case 2:
			book.allBook("book_list.txt");
			break;
		case 3:
			book.searchBookByName("book_list.txt");
			break;
		}
		}
		}
		else
			System.out.println("Yor enter id did not found . Try again");
	}
public void creatAccount(String fileName) throws IOException {
		Scanner s = new Scanner(System.in);
		int id , pin,number;
		String firstName,lastName,address;
		FileWriter fw = new FileWriter(fileName,true);
		System.out.println("Enter your id :");
		id = s.nextInt();
		System.out.println("Enter your first name :");
		firstName = s.next();
		System.out.println("Enter your last name : ");
		lastName = s.next();
		System.out.println("Enter a pin code : ");
		pin = s.nextInt();
		System.out.println("Enter your phone number :");
		number =s.nextInt();
		System.out.println("Enter your address :");
		address = s.next();
		fw.write(id+" "+firstName+" "+lastName+" "+pin+" "+number +" "+address+"\n");
		fw.close();
	}
public void deleteAccount(String file) throws IOException {
		File f = new File(file);
		Scanner s = new Scanner(f);
		int temp=0,current =0, index=0;
		while(s.hasNext()) {
			s.nextLine();
			temp++;
		}
		Log[] lg = new Log[temp];
		s= new Scanner(f);
		while(s.hasNext()) {
			id = s.nextInt();
			firstName = s.next();
			lastName = s.next();
			pin = s.nextInt();
			number = s.nextInt();
			address =s.next();
			lg[current] = new Log(id,firstName,lastName,pin,number,address);
			current++;
		}
		s = new Scanner(System.in);
		System.out.println("Enter id that you want to delete");
		int searchId = s.nextInt();
		for(int i=0; i<current ; i++) {
			if(searchId == lg[i].id) {
				index =i;
			}
		}
		FileWriter fw = new FileWriter(file);
		for(int i=0; i<lg.length; i++) {
			if(i!=index) {
		fw.write(lg[i].id+" "+lg[i].firstName+" "+lg[i].lastName+" "+lg[i].pin+" "+number+" "+address+"\n");
	
			}
		}
		fw.close();
		
	}
public void memberList(String file) throws FileNotFoundException {
	 int current =0;
		File f = new File(file);
		Scanner s = new Scanner(f);
		while(s.hasNext()) {
			s.nextLine();
			current++;
		}
		s = new Scanner(f);
		Log[] lg = new Log[current];
		int temp =0;
		while(s.hasNext()) {
			id = s.nextInt();
			firstName = s.next();
			lastName = s.next();
			pin = s.nextInt();
			number = s.nextInt();
			address =s.next();
			lg[temp]=new Log(id,firstName,lastName,pin,number,address);
			temp++;
		}
		for(int i=0; i<lg.length ;i++) {
			System.out.println(lg[i].id +" "+lg[i].firstName+" "+lg[i].lastName);
		}
}
public void seeNumber_address(String file) throws FileNotFoundException {
	 int current =0,index=0;
	 boolean flag =false;
		File f = new File(file);
		Scanner s = new Scanner(f);
		while(s.hasNext()) {
			s.nextLine();
			current++;
		}
		s = new Scanner(f);
		Log[] lg = new Log[current];
		int temp =0;
		while(s.hasNext()) {
			id = s.nextInt();
			firstName = s.next();
			lastName = s.next();
			pin = s.nextInt();
			number = s.nextInt();
			address =s.next();
			lg[temp]=new Log(id,firstName,lastName,pin,number,address);
			temp++;
		}
		s = new Scanner(System.in);
		System.out.println("Enter members id");
		int searchId =s.nextInt();
		for(int i=0; i<lg.length ;i++) {
			if(searchId == lg[i].id) {
				flag =true ;
				index =i;
			
			}
		}
		if(flag == true)
			System.out.println(lg[index].number +" "+lg[index].address);
    }
}
