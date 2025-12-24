package primarySchoolManagementSystem02;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO 
{
	
	private final String url;
	private final String user;
	private final String password;
	
	public StudentDAO() 
	{
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("db.properties")) 
        {
            props.load(fis);
        } 
        catch (IOException e) 
        {
            throw new RuntimeException("Failed to load database properties", e);
        }

        this.url = props.getProperty("url");
        this.user = props.getProperty("user");
        this.password = props.getProperty("password");
    }
	
	private Connection getConnection() throws SQLException 
	{
		return DriverManager.getConnection(url, user, password);
	}
	
	public void insertStudent(Student student) 
	{
		String sql = "insert into students(name, grade) values(?,?)";
		try (Connection connection = getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);) 
		{
			pst.setString(1, student.getName());
			pst.setInt(2, student.getGrade());
			int affectedRows = pst.executeUpdate();
//			if (affectedRows > 0) 
//			{
//				System.out.println("Insert Student Complete");
//			}
		} 
		catch (SQLException e) 
		{
			System.out.println("SQL exception at insertStudent method in StudentDAO: " + e.getMessage());
		}
		
	}
	
	public void updateStudent(Student student) 
	{
		String sql = "update students set name=?, grade=? where id=?";
		
		try (Connection connection = getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);) 
		{
			pst.setString(1, student.getName());
			pst.setInt(2, student.getGrade());
			pst.setInt(3, student.getId());
			int affectedRows = pst.executeUpdate();
//			if (affectedRows > 0) 
//			{
//				System.out.println("Update Student Complete");
//			}
		} 
		catch (SQLException e) 
		{
			System.out.println("SQL exception at updateStudent method in StudentDAO: " + e.getMessage());
		}
		
	}
	
	public void deleteStudent(int id) 
	{
		String sql = "delete from students where id=?";
		try (Connection connection = getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);) 
		{
			pst.setInt(1, id);
			int affectedRows = pst.executeUpdate();
//			if (affectedRows > 0) 
//			{
//				System.out.println("Delete Student Complete");
//			}
		} 
		catch (SQLException e) 
		{
			System.out.println("SQL exception at deleteStudent method in StudentDAO: "+ e.getMessage());
		}
	}
	
	public List<Student> getAllStudents() 
	{
		List<Student> students = new ArrayList<>();
		String sql = "select id, name, grade from students";
		try (Connection connection = getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();) 
		{
			
			while (rs.next()) 
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int grade = rs.getInt("grade");
				students.add(new Student(id, name, grade));
			}
			
		} 
		catch (SQLException e) 
		{
			System.out.println("SQL exception at getAllStudents method in StudentDAO: " + e.getMessage());
		}
		return students;
	}
	
	public Student findStudentById(int id) 
	{
		String sql = "select * from students where id=?";
		
		try (Connection connection = getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);) 
		{
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery();) 
			{
				if (rs.next()) 
				{
					String name = rs.getString("name");
					int grade = rs.getInt("grade");
					return new Student(id, name, grade);
				}
			}
		} 
		catch (SQLException e) 
		{
			System.out.println("SQL exception at findStudentById method in StudentDAO: " + e.getMessage());
		}
		return null;
	}

}
