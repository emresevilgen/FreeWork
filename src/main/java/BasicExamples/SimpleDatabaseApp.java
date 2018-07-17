package BasicExamples;

import java.sql.*;
import java.util.Scanner;

public class SimpleDatabaseApp {
	
	public static void main(String[] args) {
		final String url = "jdbc:mysql://localhost:3306/freework";
		final String username = "emresevilgen";
		final String password = "1234";
		Connection myConnection;
		Statement myStatement;
		ResultSet myResult;
		Scanner scan = new Scanner( System.in);
		int selection;
		String name;
		String surname;
		
		try {
			myConnection = DriverManager.getConnection(url, username, password);
			
			myStatement = myConnection.createStatement();
			myResult = myStatement.executeQuery("select * from users");
			
			
			
			do {
				System.out.println("1. Insert new person" + "\n2. List all people" + "\n4. Exit");
				System.out.print("Enter your selection: ");
				selection = scan.nextInt();
				System.out.println();
				
				if (selection == 1) {
					System.out.print("Ad: ");
					name = scan.nextLine();
					name = scan.nextLine();
					System.out.print("Soyad: ");
					surname = scan.nextLine();
					
					try {
						myStatement.executeUpdate("insert into users" + "(name, surname)" + "values ('" + name + "', '" + surname + "')");
						System.out.println("\n" + name + " " + surname + " successfuly added to database.\n");
					}
					catch (Exception e) {
						System.out.println("\n" + name + " " + surname + " can't be added to database.\n");
					}
					
				}
				else if (selection == 2) {
					myResult = myStatement.executeQuery("select * from users");
					if (!myResult.next())
						System.out.println("List is empty.");
					else {
						do {
							System.out.println(myResult.getString("name") + " " + myResult.getString("surname"));
						} while (myResult.next());
					}
					System.out.println();
				}
				else if (selection != 4){
					System.out.println("Invalid selection\n");
				}
				
			} while (selection != 4);
			
			scan.close();
			myResult.close();
			myStatement.close();
			myConnection.close();
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		
		
	}
	
}