package primarySchoolManagementSystem02;

import java.util.List;

public class StudentService 
{
	private final StudentDAO studentDAO;
	
	public StudentService() 
	{
		this.studentDAO = new StudentDAO();
	}
	
	public void addStudent(String name, int grade) 
	{
		Student student = new Student(name, grade);
		studentDAO.insertStudent(student);
	}
	
	public boolean removeStudent(int id) 
	{
		Student student = studentDAO.findStudentById(id);
		if (student == null) {
			return false;
		}
		studentDAO.deleteStudent(id);
		return true;
	}
	
	public boolean editStudent(int id, String name, int grade) 
	{
		Student student = studentDAO.findStudentById(id);
		if (student == null) {
			return false;
		}
		student.setName(name);
		student.setGrade(grade);
		studentDAO.updateStudent(student);
		return true;
	}
	
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}
}