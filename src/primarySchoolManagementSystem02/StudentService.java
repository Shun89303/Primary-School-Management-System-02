package primarySchoolManagementSystem02;

//import java.util.HashMap;
//import java.util.Map;

public class StudentService 
{
	
//	private final Map<Integer, Student> students;
	
	public StudentService() 
	{
//		this.students = new HashMap<>();
	}
	
	public void addStudent(String name, int grade) 
	{
		Student student = new Student(name, grade);
//		students.put(student.getId(), student);
		System.out.println("Student added");
	}
	
	public void removeStudent(int id) 
	{
//		if (students.remove(id) != null) {
//			System.out.println("Student removed");
//		}
//		else {
//			System.out.println("Student not found");
//		}
	}
	
	public void editStudent(int id, String name, int grade) 
	{
//		Student student = students.get(id);
//		if (student == null) {
//			System.out.println("Student not found");
//			return;
//		}
//		student.setName(name);
//		student.setGrade(grade);
//		System.out.println("Student info updated");
	}
	
	public void viewAllStudents() 
	{
//		if (students.isEmpty()) 
//		{
//			System.out.println("No students to display.");
//			return;
//		}
//		System.out.println("All Students:");
//		for (Student s : students.values()) 
//		{
//			System.out.println(s);
//		}
	}
}