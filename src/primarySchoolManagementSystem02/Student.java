package primarySchoolManagementSystem02;

public class Student 
{
    private final int id;
    private String name;
    private int grade;

    private static int idCounter = 1;

    public Student(String name, int grade) 
    {
        this.id = idCounter++;
        this.name = name;
        this.grade = grade;
    }
    
    public Student(int id, String name, int grade) 
    {
    	this.id = id;
    	this.name = name;
    	this.grade = grade;
    }

    public int getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public int getGrade() 
    {
        return grade;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setGrade(int grade) 
    {
        this.grade = grade;
    }

    @Override
    public String toString() 
    {
        return "ID: " + id +
               ", Name: " + name +
               ", Grade: " + grade;
    }
}