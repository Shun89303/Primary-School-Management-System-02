package primarySchoolManagementSystem02;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class StudentGUI extends JFrame
{
	private final StudentService studentService;
	private JTextField addName, editID, editName, removeID;
	private JButton addStdB, editStdB, removeStdB, viewStdB;
	private JTextArea viewStdArea;
	private JComboBox<String> addGradeCombo;
	private JComboBox<String> editGradeCombo;
	
	public StudentGUI() 
	{
		this.studentService = new StudentService();
		initComponents();
		addActionListeners();
	}
	
	private void initComponents() 
	{
		setTitle("Primary School Manangement System");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		JPanel mainP = new JPanel();
		mainP.setLayout(new BoxLayout(mainP, BoxLayout.Y_AXIS));
		mainP.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JScrollPane scrollPane = new JScrollPane(mainP);
		scrollPane.setPreferredSize(new Dimension(700, 800));
		container.add(scrollPane, BorderLayout.CENTER);
		
		JPanel addStdP = addStudentPanel();
		mainP.add(addStdP);
		
		JPanel editStdP = editStudentPanel();
		mainP.add(editStdP);
		
		JPanel removeStdP = removeStudentPanel();
		mainP.add(removeStdP);
		
		JPanel viewStdP = viewStudentsPanel();
		mainP.add(viewStdP);
		
		pack();
		setLocationRelativeTo(null);
		refreshStudentView();
		setVisible(true);
	}
	
	private JPanel addStudentPanel() 
	{
		JPanel addStdP = new JPanel(new GridLayout(1, 2));
		TitledBorder addBorder = BorderFactory.createTitledBorder("Add Student");
		addBorder.setTitleFont(new Font("Arial", Font.BOLD, 14));
		addBorder.setTitleColor(Color.BLUE);
		addStdP.setBorder(BorderFactory.createCompoundBorder(addBorder,
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JPanel nameGradeP = new JPanel(new GridLayout(2, 1));
		JPanel nameP = new JPanel(new FlowLayout());
		JPanel gradeP = new JPanel(new FlowLayout());
		JPanel buttonP = new JPanel(new FlowLayout());
		
		nameP.add(new JLabel("Name: "));
		addName = new JTextField();
		addName.setPreferredSize(new Dimension(180, 25));
		nameP.add(addName);
		
		gradeP.add(new JLabel("Grade: "));
		
		String[] grades = {"Select Grade", "1", "2", "3", "4"};
		addGradeCombo = new JComboBox<>(grades);
		gradeP.add(addGradeCombo);
		
		nameGradeP.add(nameP);
		nameGradeP.add(gradeP);
		
		addStdB = new JButton("Add");
		addStdB.setPreferredSize(new Dimension(80, 60));
		buttonP.add(addStdB);
		
		addStdP.add(nameGradeP);
		addStdP.add(buttonP);
		
		return addStdP;
	}
	
	private JPanel editStudentPanel() 
	{
		JPanel editStdP = new JPanel(new GridLayout(1, 2));
		TitledBorder editBorder = BorderFactory.createTitledBorder("Edit Student");
		editBorder.setTitleFont(new Font("Arial", Font.BOLD, 14));
		editBorder.setTitleColor(Color.MAGENTA);
		editStdP.setBorder(BorderFactory.createCompoundBorder(editBorder,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JPanel idNameGradeP = new JPanel(new GridLayout(3, 1));
		JPanel idP = new JPanel(new FlowLayout());
		JPanel nameP = new JPanel(new FlowLayout());
		JPanel gradeP = new JPanel(new FlowLayout());
		JPanel buttonP = new JPanel(new FlowLayout());
		
		JLabel idLabel = new JLabel("ID: ");
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idLabel.setPreferredSize(new Dimension(50, 25));
		idP.add(idLabel);
		editID = new JTextField();
		editID.setPreferredSize(new Dimension(180, 25));
		idP.add(editID);
		
		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setPreferredSize(new Dimension(50, 25));
		nameP.add(nameLabel);
		editName = new JTextField();
		editName.setPreferredSize(new Dimension(180, 25));
		nameP.add(editName);
		
		gradeP.add(new JLabel("Grade: "));
		
		String[] grades = {"Select Grade", "1", "2", "3", "4"};
		editGradeCombo = new JComboBox<>(grades);
		gradeP.add(editGradeCombo);
		
		editStdB = new JButton("Edit");
		editStdB.setPreferredSize(new Dimension(80, 60));
		buttonP.add(editStdB);
		
		idNameGradeP.add(idP);
		idNameGradeP.add(nameP);
		idNameGradeP.add(gradeP);
		
		editStdP.add(idNameGradeP);
		editStdP.add(buttonP);
		
		return editStdP;
	}
	
	private JPanel removeStudentPanel() 
	{
		JPanel removeStdP = new JPanel(new GridLayout(1, 2));
		TitledBorder removeBorder = BorderFactory.createTitledBorder("Remove Student");
		removeBorder.setTitleFont(new Font("Arial", Font.BOLD, 14));
		removeBorder.setTitleColor(Color.RED);
		removeStdP.setBorder(BorderFactory.createCompoundBorder(removeBorder,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JPanel idP = new JPanel(new FlowLayout());
		JPanel buttonP = new JPanel(new FlowLayout());
		
		idP.add(new JLabel("ID: "));
		removeID = new JTextField();
		removeID.setPreferredSize(new Dimension(180, 25));
		idP.add(removeID);
		
		removeStdB = new JButton("Remove");
		removeStdB.setPreferredSize(new Dimension(80, 60));
		buttonP.add(removeStdB);
		
		removeStdP.add(idP);
		removeStdP.add(buttonP);
		
		return removeStdP;
	}
	
	private JPanel viewStudentsPanel() 
	{
		JPanel viewStdP = new JPanel(new BorderLayout());
		TitledBorder viewBorder = BorderFactory.createTitledBorder("View Students");
		viewBorder.setTitleFont(new Font("Arial", Font.BOLD, 14));
	    viewBorder.setTitleColor(Color.DARK_GRAY);
	    viewStdP.setBorder(BorderFactory.createCompoundBorder(viewBorder,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		viewStdB = new JButton("View");
		viewStdB.setPreferredSize(new Dimension(80, 30));
		viewStdP.add(viewStdB, BorderLayout.NORTH);
		
		viewStdArea = new JTextArea();
		JScrollPane viewStdPane = new JScrollPane(viewStdArea);
		viewStdArea.setEditable(false);
		viewStdArea.setLineWrap(true);
		viewStdArea.setWrapStyleWord(true);
		viewStdArea.setPreferredSize(new Dimension(400, 250));
		viewStdP.add(viewStdPane, BorderLayout.CENTER);
		
		return viewStdP;
	}
	
	private int getSelectedGrade(JComboBox<String> gradeCombo) 
	{
		int selectedIndex = gradeCombo.getSelectedIndex();
		return (selectedIndex > 0) ? selectedIndex : -1;
	}
	
	private void addStdAction() 
	{
		addStdB.addActionListener(e -> {
			String name = addName.getText().trim();
			int grade = getSelectedGrade(addGradeCombo);
			
			if (name.isEmpty() || grade == -1) {
				JOptionPane.showMessageDialog(this, "Please enter a name and select a grade.",
												"Input Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			studentService.addStudent(name, grade);
			
			JOptionPane.showMessageDialog(this, "Student added successfully!");
			addName.setText("");
			addGradeCombo.setSelectedIndex(0);
			
			refreshStudentView();
		});
	}
	
	private void editStdAction() 
	{
		editStdB.addActionListener(e -> {
	        String idText = editID.getText().trim();
	        String name = editName.getText().trim();
	        int grade = getSelectedGrade(editGradeCombo);

	        if (idText.isEmpty() || name.isEmpty() || grade == -1) {
	            JOptionPane.showMessageDialog(this, "Please enter ID, name, and select a grade.", 
	                                          "Input Error", JOptionPane.WARNING_MESSAGE);
	            return;
	        }

	        int id;
	        try {
	            id = Integer.parseInt(idText);
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "ID must be a number.", 
	                                          "Input Error", JOptionPane.WARNING_MESSAGE);
	            return;
	        }

	        boolean success = studentService.editStudent(id, name, grade);
	        if (success) {
	            JOptionPane.showMessageDialog(this, "Student edited successfully!");
	            editID.setText("");
	            editName.setText("");
	            editGradeCombo.setSelectedIndex(0);
	        } else {
	            JOptionPane.showMessageDialog(this, "Student with ID " + id + " not found.", 
	                                          "Edit Failed", JOptionPane.ERROR_MESSAGE);
	        }
	        refreshStudentView();
	    });
	}
	
	private void removeStdAction() 
	{
		removeStdB.addActionListener(e -> {
	        String idText = removeID.getText().trim();

	        if (idText.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Please enter the student ID to remove.", 
	                                          "Input Error", JOptionPane.WARNING_MESSAGE);
	            return;
	        }

	        int id;
	        try {
	            id = Integer.parseInt(idText);
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "ID must be a number.", 
	                                          "Input Error", JOptionPane.WARNING_MESSAGE);
	            return;
	        }

	        boolean success = studentService.removeStudent(id);
	        if (success) {
	            JOptionPane.showMessageDialog(this, "Student removed successfully!");
	            removeID.setText("");
	        } else {
	            JOptionPane.showMessageDialog(this, "Student with ID " + id + " not found.", 
	                                          "Remove Failed", JOptionPane.ERROR_MESSAGE);
	        }
	        refreshStudentView();
	    });
	}
	
	private void viewStdAction() 
	{
		viewStdB.addActionListener(e -> {
	        viewStdArea.setText(""); // clear previous text
	        studentService.getAllStudents().forEach(student -> {
	            viewStdArea.append(student.toString() + "\n");
	        });
	    });
	}
	
	private void refreshStudentView() 
	{
		viewStdArea.setText(""); // clear previous text
        studentService.getAllStudents().forEach(student -> {
            viewStdArea.append(student.toString() + "\n");
        });
	}
	
	private void addActionListeners() 
	{
		addStdAction();
		
		editStdAction();
		
		removeStdAction();
		
		viewStdAction();
	}
}