package JSFExamples;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class PersonBean {

	private final String url = "jdbc:mysql://localhost:3306/freework";
	private final String username = "emresevilgen";
	private final String password = "1234";
	private Connection myConnection;
	private Statement myStatement;
	private ResultSet myResult;
	private List<Person> people;
	private Person person;
	
	public PersonBean() {
		person = new Person();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private void initStatement() {
		try {
			myConnection = DriverManager.getConnection(url, username, password);
			myStatement = myConnection.createStatement();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addToList(){
		String name = person.getName();
		String surname = person.getSurname();
		try {
			initStatement();
			myStatement.executeUpdate(
					"insert into users" + "(name, surname)" + "values ('" + name + "', '" + surname + "')");
			System.out.println("\n" + name + " " + surname + " successfuly added to database.\n");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info: ", "\"" + name + " " + surname + "\" successfuly added to database."));	
		} catch (Exception e) {
			System.out.println("\n" + name + " " + surname + " can't be added to database.\n");
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ","\"" + name + " " + surname + "\" can't be added to database."));
		   
		}
	
	}

	public List<Person> getPeople(){
		people = new ArrayList<Person>();
		String name;
		String surname;
		try {
			initStatement();
			myResult = myStatement.executeQuery("select * from users");
			
			if (!myResult.next()) {
				System.out.println("List is empty.");
			}
			do {
				name = myResult.getString("name");
				surname = myResult.getString("surname");
				people.add(new Person( name, surname));
				System.out.println(myResult.getString("name") + " " + myResult.getString("surname"));
			} while (myResult.next());
		
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return people;
	}
	

	public String getName() {
		return person.getName();
	}

	public void setName(String name) {
		person.setName(name);
	}

	public String getSurname() {
		return person.getSurname();
	}

	public void setSurname(String surname) {
		person.setSurname(surname);
	}

	
	
}
