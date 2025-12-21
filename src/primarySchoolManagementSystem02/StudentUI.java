package primarySchoolManagementSystem02;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentUI 
{
	private final StudentService studentService;
	private final Scanner scanner;
	
	StudentUI() 
	{
		this.studentService = new StudentService();
		this.scanner = new Scanner(System.in);
	}
	
	public void start() 
	{
		while(true) 
		{
			printMenu();
			int menuChoice = menuChoiceHelper();
			
			switch (menuChoice) 
			{
				case 1: handleAddStudent(); break;
				case 2: handleViewAllStudents(); break;
				case 3: handleEditStudent(); break;
				case 4: handleRemoveStudent(); break;
				case 5: System.out.println("End of system"); return;
					default: System.out.println("Invalid. Enter (1-5)");
			}
		}
	}
	
	public void printMenu() 
	{
		System.out.println("Menu");
		System.out.println("1. Add student");
		System.out.println("2. View all students");
		System.out.println("3. Edit student");
		System.out.println("4. Remove student");
		System.out.println("5. Exit");
	}
	
	public void handleAddStudent() 
	{
		System.out.println("Enter name");
		String name = scanner.nextLine();
		
		int grade = gradeHelper();
		
		studentService.addStudent(name, grade);
	}
	
	public void handleViewAllStudents() 
	{
		List<Student> students = studentService.getAllStudents();
		if (students.isEmpty()) 
		{
			System.out.println("No Students recorded yet");
		}
		else 
		{
			for (Student s : students) 
			{
				System.out.println(s);
			}
		}
	}	
	
	public void handleEditStudent() 
	{
		int idEdit = idHelper();
		
		System.out.println("Enter new name");
		String newName = scanner.nextLine();
		
		int newGrade = gradeHelper();
		
		boolean status = studentService.editStudent(idEdit, newName, newGrade);
		if (!status) 
		{
			System.out.println("ID not found");
		}
	}
	
	public void handleRemoveStudent() 
	{
		int idRemove = idHelper();
		boolean status = studentService.removeStudent(idRemove);
		if (!status) 
		{
			System.out.println("ID not found");
		}
	}
	
	public int menuChoiceHelper() 
	{
		int menuChoice = 0;
		while (true) 
		{
			System.out.println("Choose an option (1, 2, 3, 4, 5)");
			try 
			{
				menuChoice = scanner.nextInt();
			} 
			catch (InputMismatchException e) 
			{
				scanner.nextLine();
				System.out.println("Invalid. Enter number");
				continue;
			} 
			scanner.nextLine();
			break;
		}
		return menuChoice;
	}
	
	public int idHelper() 
	{
		int id = 0;
		while (true) 
		{
			System.out.println("Enter id");
			try 
			{
				id = scanner.nextInt();
			} 
			catch (InputMismatchException e) 
			{
				scanner.nextLine();
				System.out.println("Invalid. Enter number");
				continue;
			}
			scanner.nextLine();
			break;
		}
		return id;
	}
	
	public int gradeHelper() 
	{
		int grade = 0;
		while (true) 
		{
			System.out.println("Enter new grade");
			try 
			{
				grade = scanner.nextInt();
			} 
			catch (InputMismatchException e) 
			{
				scanner.nextLine();
				System.out.println("Invalid. Enter number");
				continue;
			} 
			if (grade < 1 || grade > 4) 
			{
				scanner.nextLine();
				System.out.println("Enter grade (1, 2, 3, 4)");
				continue;
			}
			scanner.nextLine();
			break;
		}
		return grade;
	}
}