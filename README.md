Primary School Management System 02

Overview

This is a console-based Primary School Management System built in Java. The project follows the MVC (Model-View-Controller) pattern, separating concerns for better maintainability:
	•	Student (Model): Represents the student entity.
	•	StudentDAO (Data Access Object): Handles database operations.
	•	StudentService (Service): Business logic for managing students.
	•	StudentUI (View): Console-based interface for user interaction.
	•	Main: Entry point; launches the StudentUI.

The system allows you to add, view, edit, and remove students from a MySQL database.

⸻

Features
	•	Add a new student with name and grade.
	•	View all students in the database.
	•	Edit a student’s name and grade by ID.
	•	Remove a student by ID.
	•	Input validation for numeric fields and grades (1–4).
	•	Database connection details are read from a db.properties file to keep credentials secure.

⸻

Setup
	1.	Clone the repository

git clone https://github.com/Shun89303/Primary-School-Management-System-02.git


	2.	Create MySQL database

CREATE DATABASE student_info;
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    grade INT
);


	3.	Add db.properties in the root folder

url=jdbc:mysql://localhost/student_info
user=root
password=your_password


	4.	Compile and run

javac -d bin src/primarySchoolManagementSystem02/*.java
java -cp bin primarySchoolManagementSystem02.Main



⸻

Usage
	•	Run the program.
	•	Use the console menu to manage students.
	•	Follow prompts for entering names, IDs, and grades.

⸻

Notes
	•	Java 11+ recommended.
	•	MySQL JDBC driver required in classpath.
	•	Console-based; no GUI yet.

⸻
