import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;

import java.awt.Choice;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Button;

public class Administrator {

	protected JFrame frame5;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_19;
	private JTextField textField_20;
	private JPasswordField textField_8;
	private JPasswordField textField_14;
	private JTextField textField_18;
	private JTextField textField_21;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator window = new Administrator();
					window.frame5.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Administrator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame5 = new JFrame();
		frame5.setBounds(100, 100, 1200, 700);
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.getContentPane().setLayout(null);

		JLabel lblAdministratorWindow = new JLabel("Administrator Window");
		lblAdministratorWindow.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblAdministratorWindow.setBounds(12, 13, 301, 44);
		frame5.getContentPane().add(lblAdministratorWindow);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.BLACK);
		panel.setBounds(12, 63, 362, 490);
		frame5.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Student Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(12, 50, 109, 16);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(12, 85, 109, 16);
		panel.add(lblNewLabel_1);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLastName.setBounds(12, 121, 109, 16);
		panel.add(lblLastName);

		JLabel lblStreetAddress = new JLabel("Street Address");
		lblStreetAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStreetAddress.setBounds(12, 158, 145, 16);
		panel.add(lblStreetAddress);

		JLabel lblNewLabel_2 = new JLabel("City");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(12, 201, 109, 16);
		panel.add(lblNewLabel_2);

		JLabel lblPostalCode = new JLabel("Postal Code");
		lblPostalCode.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPostalCode.setBounds(12, 242, 109, 16);
		panel.add(lblPostalCode);

		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMobileNo.setBounds(12, 282, 109, 16);
		panel.add(lblMobileNo);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmail.setBounds(12, 320, 70, 16);
		panel.add(lblEmail);

		JLabel lblNewLabel_3 = new JLabel("Set Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(12, 368, 145, 16);
		panel.add(lblNewLabel_3);

		Choice comboBox_1 = new Choice();
		comboBox_1.setBounds(192, 406, 158, 22);
		panel.add(comboBox_1);

		comboBox_1.add("Student");

		JButton btnNewButton = new JButton("Create Student Profile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Student profile..........................................

				try {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");
					String studentid2 = textField.getText();
					int studentid01 = Integer.parseInt(studentid2);
					String stpassword = textField_8.getText();
					String role_s = comboBox_1.getSelectedItem().toString();

					java.sql.Statement stmt = con.createStatement();
					String dbin2 = "INSERT INTO user_information VALUES('" + studentid01 + "','" + stpassword + "','"
							+ role_s + "')";
					stmt.execute(dbin2);
					stmt.close();

					JOptionPane.showMessageDialog(null, "Student User Account Created.");

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");
					String studentid1 = textField.getText();
					int studentid = Integer.parseInt(studentid1);
					String stfname = textField_1.getText();
					String stlname = textField_2.getText();
					String staddress = textField_3.getText();
					String stcity = textField_4.getText();
					String stpostalcode = textField_5.getText();
					String stmobileno = textField_6.getText();
					String stemail = textField_7.getText();

					System.out.println("alright");

					java.sql.Statement stmt = con.createStatement();
					String dbin1 = "INSERT INTO student VALUES('" + studentid + "','" + stfname + "','" + stlname
							+ "','" + staddress + "','" + stcity + "','" + stpostalcode + "','" + stmobileno + "','"
							+ stemail + "','" + studentid + "')";

					System.out.println("alright2");
					stmt.execute(dbin1);
					System.out.println("alright45");

					System.out.println("alright3");
					stmt.close();
					System.out.println("alright4");

					JOptionPane.showMessageDialog(null, "Student Account Successfully Created.");

					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
					textField_8.setText("");

				}
				/*
				 * catch (SQLIntegrityConstraintViolationException e2) {
				 * System.out.println("Account already exist with this ID");
				 * JOptionPane.showMessageDialog(null, "Account already exist with this ID");
				 * textField.setText("");
				 * textField_1.setText("");
				 * textField_2.setText("");
				 * textField_3.setText("");
				 * textField_4.setText("");
				 * textField_5.setText("");
				 * textField_6.setText("");
				 * textField_7.setText("");
				 * textField_8.setText("");
				 * }
				 */catch (Exception e1) {
					System.out.println(e1);
					JOptionPane.showMessageDialog(null,
							"Acc Already Exist or check- Mobilenumber and postal code must contain 11 digits and 4 digits");
				}

			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(71, 446, 213, 31);
		panel.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(192, 49, 158, 22);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(192, 84, 158, 22);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(192, 120, 158, 22);
		panel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(192, 157, 158, 22);
		panel.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(192, 200, 158, 22);
		panel.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(192, 241, 158, 22);
		panel.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(192, 281, 158, 22);
		panel.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(192, 319, 158, 22);
		panel.add(textField_7);

		textField_8 = new JPasswordField();
		textField_8.setBounds(192, 367, 158, 22);
		panel.add(textField_8);

		JLabel lblNewLabel_4 = new JLabel("Role");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(12, 407, 70, 16);
		panel.add(lblNewLabel_4);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(399, 63, 362, 364);
		frame5.getContentPane().add(panel_1);

		JLabel lblFacultyId = new JLabel("Faculty ID");
		lblFacultyId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFacultyId.setBounds(12, 50, 109, 16);
		panel_1.add(lblFacultyId);

		JLabel lblFacultyName = new JLabel("Faculty Name");
		lblFacultyName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFacultyName.setBounds(12, 85, 130, 16);
		panel_1.add(lblFacultyName);

		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDepartment.setBounds(12, 121, 130, 16);
		panel_1.add(lblDepartment);

		JLabel lblMobileNo_1 = new JLabel("Mobile No.");
		lblMobileNo_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMobileNo_1.setBounds(12, 158, 145, 16);
		panel_1.add(lblMobileNo_1);

		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmail_1.setBounds(12, 201, 109, 16);
		panel_1.add(lblEmail_1);

		JLabel lblSetPassword = new JLabel("Set Password");
		lblSetPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSetPassword.setBounds(12, 242, 145, 16);
		panel_1.add(lblSetPassword);

		Choice choice = new Choice();
		choice.setBounds(192, 281, 158, 22);
		panel_1.add(choice);
		choice.add("Faculty");

		JButton btnCreateFacultyProfile = new JButton("Create Faculty Profile");
		btnCreateFacultyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// faculty information starts here...................................

				try {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");

					String facultyid = textField_9.getText();
					int facultyidid01 = Integer.parseInt(facultyid);
					String fpassword = textField_14.getText();
					String role_f = choice.getSelectedItem().toString();

					java.sql.Statement stmt = con.createStatement();
					String dbin2 = "INSERT INTO user_information VALUES('" + facultyidid01 + "','" + fpassword + "','"
							+ role_f + "')";
					stmt.execute(dbin2);
					stmt.close();

					JOptionPane.showMessageDialog(null, "Faculty User Account Created.");

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");
					String facultyid1 = textField_9.getText();
					int facultyid02 = Integer.parseInt(facultyid1);
					String fname = textField_10.getText();
					String fdepartment = textField_11.getText();
					String fmobileno = textField_12.getText();
					String femail = textField_13.getText();

					System.out.println("alright");

					java.sql.Statement stmt = con.createStatement();
					String dbin5 = "INSERT INTO faculty_information VALUES('" + facultyid02 + "','" + fname + "','"
							+ fdepartment + "','" + fmobileno + "','" + femail + "','" + facultyid02 + "')";

					System.out.println("alright2");
					stmt.execute(dbin5);
					stmt.close();

					JOptionPane.showMessageDialog(null, "Faculty Account Successfully Created.");

					textField_9.setText("");
					textField_10.setText("");
					textField_11.setText("");
					textField_12.setText("");
					textField_13.setText("");
					textField_14.setText("");

				}
				/*
				 * catch (SQLIntegrityConstraintViolationException e2) {
				 * System.out.println("Account already exist with this ID");
				 * JOptionPane.showMessageDialog(null, "Account already exist with this ID");
				 * textField.setText("");
				 * textField_1.setText("");
				 * textField_2.setText("");
				 * textField_3.setText("");
				 * textField_4.setText("");
				 * textField_5.setText("");
				 * textField_6.setText("");
				 * textField_7.setText("");
				 * textField_8.setText("");
				 * }
				 */catch (Exception e1) {
					System.out.println(e1);
					JOptionPane.showMessageDialog(null, e1);
					// JOptionPane.showMessageDialog(null, "Acc Already Exist or check- Mobilenumber
					// and postal code must contain 11 digits and 4 digits");
				}

			}

		});
		btnCreateFacultyProfile.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCreateFacultyProfile.setBounds(78, 320, 213, 31);
		panel_1.add(btnCreateFacultyProfile);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(192, 49, 158, 22);
		panel_1.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(192, 84, 158, 22);
		panel_1.add(textField_10);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(192, 120, 158, 22);
		panel_1.add(textField_11);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(192, 157, 158, 22);
		panel_1.add(textField_12);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(192, 200, 158, 22);
		panel_1.add(textField_13);

		textField_14 = new JPasswordField();
		textField_14.setBounds(192, 241, 158, 22);
		panel_1.add(textField_14);

		JLabel label = new JLabel("Role");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(12, 281, 70, 16);
		panel_1.add(label);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(Color.BLACK);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(786, 63, 362, 393);
		frame5.getContentPane().add(panel_2);

		JLabel lblCourseId = new JLabel("Course Id");
		lblCourseId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCourseId.setBounds(12, 50, 109, 16);
		panel_2.add(lblCourseId);

		JLabel lblCourseInitial = new JLabel("Course Initial");
		lblCourseInitial.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCourseInitial.setBounds(12, 85, 145, 16);
		panel_2.add(lblCourseInitial);

		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCourseName.setBounds(12, 121, 145, 16);
		panel_2.add(lblCourseName);

		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSemester.setBounds(12, 158, 145, 16);
		panel_2.add(lblSemester);

		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblYear.setBounds(12, 201, 109, 16);
		panel_2.add(lblYear);

		JLabel lblSection = new JLabel("Section");
		lblSection.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSection.setBounds(12, 242, 109, 16);
		panel_2.add(lblSection);

		JLabel lblFacultyId_1 = new JLabel("Faculty ID");
		lblFacultyId_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFacultyId_1.setBounds(12, 307, 109, 16);
		panel_2.add(lblFacultyId_1);

		Choice comboBox = new Choice();
		comboBox.setBounds(192, 157, 158, 22);
		panel_2.add(comboBox);

		comboBox.add("Spring");
		comboBox.add("Summer");
		comboBox.add("Fall");

		Choice choice_1 = new Choice();
		choice_1.setBounds(192, 307, 158, 22);
		panel_2.add(choice_1);

		JButton btnNewButton_1 = new JButton("Show");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemCount = choice_1.getItemCount();

				for (int i = 0; i < itemCount; i++) {
					choice_1.remove(0);
				}
				// here we show faculty id from faculty information.................

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");

					String sql = "SELECT Faculty_Id FROM faculty_information";

					java.sql.PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {
						String name = rs.getString("Faculty_Id");
						choice_1.addItem(name);
					}

					pst.close();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});
		btnNewButton_1.setBounds(192, 276, 97, 25);
		panel_2.add(btnNewButton_1);

		JButton btnCreateCourse = new JButton("Launch Course");
		btnCreateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// we will add course here..............................

				try {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");

					String courseid = textField_15.getText();
					int courseid01 = Integer.parseInt(courseid);
					String courseinitial = textField_16.getText();
					String coursename = textField_17.getText();
					String semester = comboBox.getSelectedItem().toString();
					String year = textField_19.getText();
					String section = textField_20.getText();
					String facultyid02 = choice_1.getSelectedItem().toString();

					java.sql.Statement stmt = con.createStatement();
					String dbin2 = "INSERT INTO course_information VALUES('" + courseid01 + "','" + courseinitial
							+ "','" + coursename + "','" + semester + "','" + year + "','" + section + "','"
							+ facultyid02 + "')";

					stmt.execute(dbin2);
					stmt.close();

					JOptionPane.showMessageDialog(null, "Course added successfully.");

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});
		btnCreateCourse.setBounds(79, 347, 213, 31);
		panel_2.add(btnCreateCourse);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(192, 49, 158, 22);
		panel_2.add(textField_15);

		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(192, 84, 158, 22);
		panel_2.add(textField_16);

		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(192, 120, 158, 22);
		panel_2.add(textField_17);

		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(192, 200, 158, 22);
		panel_2.add(textField_19);

		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(192, 241, 158, 22);
		panel_2.add(textField_20);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(399, 440, 362, 200);
		frame5.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		Choice choice_2 = new Choice();
		choice_2.setBounds(168, 33, 184, 22);
		panel_3.add(choice_2);

		Choice choice_3 = new Choice();
		choice_3.setBounds(168, 64, 184, 22);
		panel_3.add(choice_3);

		Choice choice_4 = new Choice();
		choice_4.setBounds(168, 99, 184, 22);
		panel_3.add(choice_4);

		Choice choice_5 = new Choice();
		choice_5.setBounds(168, 136, 184, 22);
		panel_3.add(choice_5);

		JButton btnNewButton_2 = new JButton("Show");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// show data from database to add students........................
				int itemCount1 = choice_2.getItemCount();

				for (int i = 0; i < itemCount1; i++) {
					choice_2.remove(0);
				}
				int itemCount2 = choice_3.getItemCount();

				for (int i = 0; i < itemCount2; i++) {
					choice_3.remove(0);
				}
				int itemCount3 = choice_4.getItemCount();

				for (int i = 0; i < itemCount3; i++) {
					choice_4.remove(0);
				}
				int itemCount4 = choice_5.getItemCount();

				for (int i = 0; i < itemCount4; i++) {
					choice_5.remove(0);
				}
				// for student id
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");

					String sql = "SELECT Student_Id FROM student";

					java.sql.PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {
						String name = rs.getString("Student_Id");
						choice_2.addItem(name);
					}

					pst.close();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

				// for course id
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");

					String sql = "SELECT Course_Id FROM course_information";

					java.sql.PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {
						String name = rs.getString("Course_Id");
						choice_3.addItem(name);
					}

					pst.close();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

				// for course initial
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");

					String sql = "SELECT Course_Initial FROM course_information";

					java.sql.PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {
						String name = rs.getString("Course_Initial");
						choice_4.addItem(name);
					}

					pst.close();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

				// for facukty id
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");

					String sql = "SELECT Faculty_Id FROM faculty_information";

					java.sql.PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {
						String name = rs.getString("Faculty_Id");
						choice_5.addItem(name);
					}

					pst.close();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});
		btnNewButton_2.setBounds(127, 0, 110, 25);
		panel_3.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Add Student");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// then this button will add the student....................

				try {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");

					String studentid05 = choice_2.getSelectedItem().toString();
					String courseid05 = choice_3.getSelectedItem().toString();
					String courseinitial05 = choice_4.getSelectedItem().toString();
					String facultyid05 = choice_5.getSelectedItem().toString();

					java.sql.Statement stmt = con.createStatement();
					String dbin3 = "INSERT INTO student_has_course_information VALUES('" + studentid05 + "','"
							+ courseid05 + "','" + courseinitial05 + "','" + facultyid05 + "')";

					stmt.execute(dbin3);
					stmt.close();

					JOptionPane.showMessageDialog(null, "Student added to the course");

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_3.setBounds(127, 175, 110, 25);
		panel_3.add(btnNewButton_3);

		JLabel lblNewLabel_5 = new JLabel("Student Id");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(12, 39, 110, 16);
		panel_3.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Course Id");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(12, 70, 110, 16);
		panel_3.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Course Initial");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(12, 105, 110, 16);
		panel_3.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Faculty Id");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(12, 142, 110, 16);
		panel_3.add(lblNewLabel_8);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(786, 469, 362, 171);
		frame5.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_9 = new JLabel("Administrator Id");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setBounds(12, 28, 146, 16);
		panel_4.add(lblNewLabel_9);

		JLabel lblAdministratorName = new JLabel("Administrator Name");
		lblAdministratorName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdministratorName.setBounds(12, 66, 146, 16);
		panel_4.add(lblAdministratorName);

		JLabel lblAdministratorId = new JLabel("For User Id");
		lblAdministratorId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdministratorId.setBounds(12, 101, 113, 16);
		panel_4.add(lblAdministratorId);

		textField_18 = new JTextField();
		textField_18.setBounds(180, 26, 170, 22);
		panel_4.add(textField_18);
		textField_18.setColumns(10);

		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(180, 64, 170, 22);
		panel_4.add(textField_21);

		Choice choice_6 = new Choice();
		choice_6.setBounds(250, 101, 100, 22);
		panel_4.add(choice_6);

		Button button = new Button("Show");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// this will show all the user id of administrator..................
				int itemCount6 = choice_6.getItemCount();

				for (int i = 0; i < itemCount6; i++) {
					choice_6.remove(0);
				}

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");

					String sql = "SELECT User_Id FROM user_information WHERE Role='Administrator'";

					java.sql.PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {
						String name = rs.getString("User_Id");
						choice_6.addItem(name);
					}

					pst.close();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		button.setBounds(180, 101, 64, 24);
		panel_4.add(button);

		JButton btnNewButton_4 = new JButton("Update");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// this will uupdate administrator information

				try {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");

					String adid = textField_18.getText();
					String adname = textField_21.getText();
					String aduid = choice_6.getSelectedItem().toString();

					java.sql.Statement stmt = con.createStatement();
					String dbin5 = "INSERT INTO administrator VALUES('" + adid + "','" + adname + "','" + aduid + "')";

					stmt.execute(dbin5);
					stmt.close();

					JOptionPane.showMessageDialog(null, "Successfully Updated.");

					textField_18.setText("");
					textField_21.setText("");

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});
		btnNewButton_4.setBounds(147, 146, 97, 25);
		panel_4.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Logout");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// logout for frame 5........................................

				frame5.dispose();

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Login window = new Login();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_5.setBounds(130, 582, 97, 34);
		frame5.getContentPane().add(btnNewButton_5);

	}
}
