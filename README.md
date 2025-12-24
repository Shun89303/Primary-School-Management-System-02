
Primary School Management System 02

Primary School Management System 02 is a fully functional desktop prototype built in Java for managing student records in a primary school. It provides both a console-based interface and a Swing GUI to add, edit, remove, and view students, all backed by a MySQL database. This project serves as a foundation for a future web-based system with modern frontend and backend technologies.

Overview

This is a Primary School Management System built in Java as a desktop prototype. The project follows the MVC (Model-View-Controller) pattern for separation of concerns and maintainability:
	•	Student (Model): Represents the student entity.
	•	StudentDAO (Data Access Object): Handles database operations.
	•	StudentService (Service): Business logic for managing students.
	•	StudentUI (Console View): Fully functional console-based interface for managing students.
	•	StudentGUI (Swing View): GUI interface; fully functional with all student actions implemented.
	•	Main: Entry point; launches the GUI by default.

The system uses a MySQL database to store student information.

⸻

Features

Console version (fully functional):
	•	Add a new student with name and grade.
	•	View all students in the database.
	•	Edit a student’s name and grade by ID.
	•	Remove a student by ID.
	•	Input validation for numeric fields and grades (1–4).
	•	Database connection details read from a db.properties file for security.

GUI version (fully functional):
	•	Panels and components for adding, editing, removing, and viewing students.
	•	Table view displays students grouped by grade.
	•	Input validation with pop-up messages for errors.
	•	Layout built with Swing, including text fields, combo boxes, and buttons.

Database:
	•	MySQL database for persistent storage.
	•	Uses JDBC for database connectivity.

⸻

Status

Prototype Completed ✅
	•	This Java-based system is now fully functional as a desktop prototype.
	•	No further updates will be made to this Java version.
	•	Future development will continue as a web-based application, leveraging frontend technologies and a modern backend stack.

⸻

Setup
	1.	Clone the repository
```
git clone https://github.com/Shun89303/Primary-School-Management-System-02.git
```
	2.	Create MySQL database
```
CREATE DATABASE student_info;
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    grade INT
);
```
	3.	Add db.properties in the root folder
```
url=jdbc:mysql://localhost/student_info
user=root
password=your_password
```
	4.	Compile the project
```
javac -d bin src/primarySchoolManagementSystem02/*.java
```
	5.	Run the program

	•	Launch the GUI:
```
java -cp bin primarySchoolManagementSystem02.Main
```
	•	Use the console version:
```
java -cp bin primarySchoolManagementSystem02.StudentUI
```

⸻

Notes
	•	Java 11+ recommended.
	•	MySQL JDBC driver required in classpath.
	•	Console version is fully functional.
	•	GUI version is fully functional and mirrors console operations.
	•	This project now serves as a foundation for a web-based version of the system.

⸻

Roadmap: Web Version

Goal: Transition this desktop prototype to a fully web-based Primary School Management System.

Frontend:
	•	HTML, CSS, JavaScript
	•	React + Vite for modern SPA architecture
	•	Responsive design for desktop and mobile

Backend:
	•	Node.js + Express or Java + Spring Boot
	•	RESTful API endpoints for CRUD operations

Database:
	•	MySQL (reuse current schema)

Planned Features:
	•	User authentication for admins/teachers
	•	Student management (Add, Edit, Remove, View)
	•	Dynamic table views grouped by grade
	•	Search and filtering options
	•	Export/import student data (CSV/Excel)

Future Enhancements:
	•	Role-based access control
	•	Dashboard with analytics (e.g., number of students per grade)
	•	Notifications or reminders for student-related events

⸻
