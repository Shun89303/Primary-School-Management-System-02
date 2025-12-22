package primarySchoolManagementSystem02;

import java.awt.*;

import javax.swing.*;

public class StudentGUI extends JFrame
{
	private final StudentService studentService;
	private JTextField addName, editID, editName, removeID;
	private JButton addStdB, editStdB, removeStdB, viewStdB;
	private JTextArea viewStdArea;
	
	public StudentGUI() 
	{
		this.studentService = new StudentService();
		initComponents();
		addActionListeners();
	}
	
	private void initComponents() 
	{
		setTitle("Primary School Manangement System");
		setSize(500, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		JPanel mainP = new JPanel();
		mainP.setLayout(new BoxLayout(mainP, BoxLayout.Y_AXIS));
		mainP.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		container.add(mainP);
		
		JPanel addStdP = addStudentPanel();
		mainP.add(addStdP);
		
		JPanel editStdP = editStudentPanel();
		mainP.add(editStdP);
		
		JPanel removeStdP = removeStudentPanel();
		mainP.add(removeStdP);
		
		JPanel viewStdP = viewStudentsPanel();
		mainP.add(viewStdP);
		
		setVisible(true);
	}
	
	private JPanel addStudentPanel() 
	{
		JPanel addStdP = new JPanel(new GridLayout(1, 2));
		addStdP.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JPanel nameGradeP = new JPanel(new GridLayout(2, 1));
		JPanel nameP = new JPanel(new FlowLayout());
		JPanel gradeP = new JPanel(new FlowLayout());
		JPanel gradeccsP = new JPanel(new FlowLayout()); 
		JPanel buttonP = new JPanel(new FlowLayout());
		
		nameP.add(new JLabel("Name: "));
		addName = new JTextField();
		addName.setPreferredSize(new Dimension(180, 25));
		nameP.add(addName);
		
		gradeP.add(new JLabel("Grade: "));
		gradeP.add(gradeccsP);
		
		JRadioButton grade1 = new JRadioButton("1");
		gradeccsP.add(grade1);
		JRadioButton grade2 = new JRadioButton("2");
		gradeccsP.add(grade2);
		JRadioButton grade3 = new JRadioButton("3");
		gradeccsP.add(grade3);
		JRadioButton grade4 = new JRadioButton("4");
		gradeccsP.add(grade4);
		
		ButtonGroup gradeGroup = new ButtonGroup();
		gradeGroup.add(grade1);
		gradeGroup.add(grade2);
		gradeGroup.add(grade3);
		gradeGroup.add(grade4);
		
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
		editStdP.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JPanel idNameGradeP = new JPanel(new GridLayout(3, 1));
		JPanel idP = new JPanel(new FlowLayout());
		JPanel nameP = new JPanel(new FlowLayout());
		JPanel gradeP = new JPanel(new FlowLayout());
		JPanel gradeccsP = new JPanel(new FlowLayout()); 
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
		
		JRadioButton grade1 = new JRadioButton("1");
		gradeccsP.add(grade1);
		JRadioButton grade2 = new JRadioButton("2");
		gradeccsP.add(grade2);
		JRadioButton grade3 = new JRadioButton("3");
		gradeccsP.add(grade3);
		JRadioButton grade4 = new JRadioButton("4");
		gradeccsP.add(grade4);
		
		ButtonGroup gradeGroup = new ButtonGroup();
		gradeGroup.add(grade1);
		gradeGroup.add(grade2);
		gradeGroup.add(grade3);
		gradeGroup.add(grade4);
		
		gradeP.add(gradeccsP);
		
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
		removeStdP.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
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
		viewStdP.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
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
	
	private void addActionListeners() {
		
	}
}