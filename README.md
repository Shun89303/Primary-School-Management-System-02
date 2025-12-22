
Primary School Management System 02

Overview

This is a Primary School Management System built in Java. The project follows the MVC (Model-View-Controller) pattern for better separation of concerns and maintainability:
	•	Student (Model): Represents the student entity.
	•	StudentDAO (Data Access Object): Handles database operations.
	•	StudentService (Service): Business logic for managing students.
	•	StudentUI (Console View): Fully functional console-based interface for managing students.
	•	StudentGUI (Swing View): Skeleton GUI interface; currently, buttons and input fields do not perform any actions.
	•	Main: Entry point; launches the GUI by default.

The system uses a MySQL database to store student information.

⸻

Features
	•	Console version (fully functional):
	•	Add a new student with name and grade.
	•	View all students in the database.
	•	Edit a student’s name and grade by ID.
	•	Remove a student by ID.
	•	Input validation for numeric fields and grades (1–4).
	•	Database connection details read from a db.properties file for security.
	•	GUI version (skeleton, for future implementation):
	•	Panels and components for adding, editing, removing, and viewing students.
	•	Layout set up with Swing, including text fields, radio buttons, and buttons.
	•	No backend actions are currently wired to the GUI.

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

	4.	Compile the project

javac -d bin src/primarySchoolManagementSystem02/*.java

	5.	Run the program

	•	To launch the GUI skeleton:

java -cp bin primarySchoolManagementSystem02.Main

	•	To use the console version:

java -cp bin primarySchoolManagementSystem02.StudentUI


⸻

Notes
	•	Java 11+ recommended.
	•	MySQL JDBC driver required in classpath.
	•	Console version is fully functional; GUI is a skeleton and actions are not implemented yet.

⸻
