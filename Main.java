package primarySchoolManagementSystem02;

import java.util.*;

public class Main 
{
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) 
	{
		
		StudentService service = new StudentService();
		
		while(true) 
		{
			printMenu();
			int menuChoice = menuChoiceHelper();
			
			switch (menuChoice) 
			{
				case 1: 
					System.out.println("Enter name");
					String name = scanner.nextLine();
					
					int grade = gradeHelper();
					
					service.addStudent(name, grade);
					break;
				case 2: service.viewAllStudents(); break;
				case 3: 
					int idEdit = idHelper();
					
					System.out.println("Enter new name");
					String newName = scanner.nextLine();
					
					int newGrade = gradeHelper();
					
					service.editStudent(idEdit, newName, newGrade);
					break;
				case 4: 
					int idRemove = idHelper();
					service.removeStudent(idRemove);
					break;
			case 5: 
				System.out.println("End of system");
				return;
					default: System.out.println("Choose an option (1, 2, 3, 4, 5)");
			}
		}
	}

	public static void printMenu() 
	{
		System.out.println("Menu");
		System.out.println("1. Add student");
		System.out.println("2. View all students");
		System.out.println("3. Edit student");
		System.out.println("4. Remove student");
		System.out.println("5. Exit");
	}
	
	public static int menuChoiceHelper() 
	{
		int menuChoice = 0;
		while (true) 
		{
			System.out.println("Choose an option (1, 2, 3, 4, 5)");
			try {
				menuChoice = scanner.nextInt();
			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("Invalid. Enter number");
				continue;
			} 
			scanner.nextLine();
			break;
		}
		return menuChoice;
	}
	
	public static int idHelper() 
	{
		int id = 0;
		while (true) 
		{
			System.out.println("Enter id");
			try {
				id = scanner.nextInt();
			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("Invalid. Enter number");
				continue;
			}
			scanner.nextLine();
			break;
		}
		return id;
	}
	
	public static int gradeHelper() 
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
