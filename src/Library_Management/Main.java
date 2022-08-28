package Library_Management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("\t\t ---Welcome To Library---");
		while(true) {
		System.out.println("[0] to exit");
		System.out.println("[1] for Admin ");
		System.out.println("[2] for Member");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Log lg = new Log();
		Admin admin = new Admin();
		switch(n) {
		case 0:
			return;
		case 1:
			try {
				admin.adminLogIn("admin.txt");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			break;
		case 2:
			System.out.println();
			System.out.println("Enter [1] for log in");
			System.out.println("Enter [2] for creat a account");
			int choice = s.nextInt();
			switch(choice) {
			case 1:
				try {
					lg.logIn("log.txt");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					lg.creatAccount("log.txt");
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println();
				System.out.println("Please log in now");
				try {
					lg.logIn("log.txt");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
			}
		
		}
		}

	}
	

}
