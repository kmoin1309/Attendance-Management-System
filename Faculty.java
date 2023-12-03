import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JPanel;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class Faculty {

	protected JFrame frame4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Faculty window = new Faculty();
					window.frame4.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Faculty() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @param <DatePicker>
	 */
	private <DatePicker> void initialize() {
		frame4 = new JFrame();
		frame4.setBounds(100, 100, 1200, 700);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.getContentPane().setLayout(null);

		JLabel lblFacultyWindow = new JLabel("Faculty Window");
		lblFacultyWindow.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblFacultyWindow.setBounds(12, 13, 226, 44);
		frame4.getContentPane().add(lblFacultyWindow);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(12, 70, 367, 451);
		frame4.getContentPane().add(panel);
		panel.setLayout(null);

		Choice choice_1 = new Choice();
		choice_1.setBounds(172, 177, 165, 27);
		panel.add(choice_1);

		Choice choice_2 = new Choice();
		choice_2.setBounds(172, 222, 165, 22);
		panel.add(choice_2);

		Choice choice_3 = new Choice();
		choice_3.setBounds(172, 103, 165, 27);
		panel.add(choice_3);

		Choice choice_4 = new Choice();
		choice_4.setBounds(172, 344, 165, 27);
		panel.add(choice_4);

		choice_4.add("Present");
		choice_4.add("Absent");
		choice_4.add("Late");

		JLabel lblCourseId = new JLabel("Course Id");
		lblCourseId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCourseId.setBounds(12, 177, 148, 22);
		panel.add(lblCourseId);

		JLabel lblCourseInitial = new JLabel("Course Initial");
		lblCourseInitial.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCourseInitial.setBounds(12, 222, 148, 22);
		panel.add(lblCourseInitial);

		JLabel lblFacultyId = new JLabel("Faculty Id");
		lblFacultyId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFacultyId.setBounds(12, 103, 148, 22);
		panel.add(lblFacultyId);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStatus.setBounds(12, 344, 148, 22);
		panel.add(lblStatus);

		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setBounds(12, 23, 148, 22);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

		textField_1 = new JTextField();
		textField_1.setBounds(172, 22, 165, 27);
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText("YYYY-MM-DD");

		JLabel lblStudentId = new JLabel("Student Id");
		lblStudentId.setBounds(12, 299, 148, 22);
		panel.add(lblStudentId);
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 16));

		Choice choice = new Choice();
		choice.setBounds(172, 299, 165, 22);
		panel.add(choice);

		JButton btnNewButton_1 = new JButton("Show");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// this will show all faculty id from database.................................
				int itemCount = choice_3.getItemCount();

				for (int i = 0; i < itemCount; i++) {
					choice_3.remove(0);
				}

				// for faculty id
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");

					String sql = "SELECT Faculty_Id FROM faculty_information";

					java.sql.PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {
						String name = rs.getString("Faculty_Id");
						choice_3.addItem(name);
					}

					pst.close();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_1.setBounds(258, 72, 79, 25);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// will show courseid and course initial.......................
				int itemCount1 = choice_1.getItemCount();

				for (int i = 0; i < itemCount1; i++) {
					choice_1.remove(0);
				}
				int itemCount2 = choice_2.getItemCount();

				for (int i = 0; i < itemCount2; i++) {
					choice_2.remove(0);
				}
				String fid = choice_3.getSelectedItem().toString();

				// for course id
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");

					String sql1 = "SELECT Course_Id FROM course_information WHERE Faculty_Id='" + fid + "'";

					java.sql.PreparedStatement pst = con.prepareStatement(sql1);
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {
						String name = rs.getString("Course_Id");
						choice_1.addItem(name);
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

					String sql2 = "SELECT Course_Initial FROM course_information WHERE Faculty_Id='" + fid + "'";

					java.sql.PreparedStatement pst = con.prepareStatement(sql2);
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {
						String name = rs.getString("Course_Initial");
						choice_2.addItem(name);
					}

					pst.close();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(140, 133, 74, 25);
		panel.add(btnNewButton_2);

		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// add students according to course..................
				int itemCount3 = choice.getItemCount();

				for (int i = 0; i < itemCount3; i++) {
					choice.remove(0);
				}

				String cid = choice_1.getSelectedItem().toString();

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
						choice.addItem(name);
					}

					pst.close();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBounds(140, 250, 74, 25);
		panel.add(button);

		JButton btnNewButton = new JButton("Take Attendance");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// take the attendance..............................................

				try {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");

					String date = textField_1.getText();
					String stid = choice.getSelectedItem().toString();
					String cid = choice_1.getSelectedItem().toString();
					String cini = choice_2.getSelectedItem().toString();
					String fid = choice_3.getSelectedItem().toString();
					String sts = choice_4.getSelectedItem().toString();
					// String facultyid05= choice_5.getSelectedItem().toString();

					java.sql.Statement stmt = con.createStatement();
					String dbin = "INSERT INTO attendance VALUES('" + date + "','" + stid + "','" + cid + "','" + cini
							+ "','" + fid + "','" + sts + "')";

					stmt.execute(dbin);
					stmt.close();

					JOptionPane.showMessageDialog(null, "Attendance Taken");

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setBounds(100, 406, 153, 32);
		panel.add(btnNewButton);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(391, 70, 762, 314);
		frame4.getContentPane().add(textArea);

		JButton btnNewButton_3 = new JButton("Show Data");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// show the attendance database...........................
				textArea.setText("");
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");

					String cid = choice_1.getSelectedItem().toString();
					String sql = "SELECT* FROM attendance WHERE Course_Id=('" + cid + "');";

					java.sql.PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {
						textArea.append(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  "
								+ rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6) + "\n");
					}

					pst.close();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_3.setBounds(713, 397, 97, 25);
		frame4.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// logout for frame 4....................................
				frame4.dispose();

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
		btnNewButton_4.setBounds(12, 552, 103, 44);
		frame4.getContentPane().add(btnNewButton_4);

		JLabel label = new JLabel("Course Id");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(391, 470, 148, 22);
		frame4.getContentPane().add(label);

		Choice choice_5 = new Choice();
		choice_5.setBounds(558, 470, 165, 22);
		frame4.getContentPane().add(choice_5);

		JLabel label_1 = new JLabel("Faculty Id");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(391, 435, 148, 22);
		frame4.getContentPane().add(label_1);

		Choice choice_6 = new Choice();
		choice_6.setBounds(558, 435, 165, 22);
		frame4.getContentPane().add(choice_6);

		JButton btnNewButton_5 = new JButton("Show");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemCount = choice_6.getItemCount();

				for (int i = 0; i < itemCount; i++) {
					choice_6.remove(0);
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
						choice_6.addItem(name);
					}

					pst.close();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}

		});
		btnNewButton_5.setBounds(729, 435, 75, 25);
		frame4.getContentPane().add(btnNewButton_5);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// for message..............................................

				// will show courseid and course initial.......................
				int itemCount1 = choice_5.getItemCount();

				for (int i = 0; i < itemCount1; i++) {
					choice_5.remove(0);
				}

				String fid = choice_6.getSelectedItem().toString();

				// for course id
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");

					String sql1 = "SELECT Course_Id FROM course_information WHERE Faculty_Id='" + fid + "'";

					java.sql.PreparedStatement pst = con.prepareStatement(sql1);
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {
						String name = rs.getString("Course_Id");
						choice_5.addItem(name);
					}

					pst.close();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnAdd.setBounds(729, 470, 75, 25);
		frame4.getContentPane().add(btnAdd);

		JLabel lblMessage = new JLabel("Message");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMessage.setBounds(391, 499, 148, 22);
		frame4.getContentPane().add(lblMessage);

		textField_2 = new JTextField();
		textField_2.setBounds(558, 499, 242, 75);
		frame4.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton_6 = new JButton("Send");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// save the message into database...............................

				try {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");

					String fid = choice_6.getSelectedItem().toString();
					String cid = choice_5.getSelectedItem().toString();
					String message = textField_2.getText();
					// String facultyid05= choice_5.getSelectedItem().toString();

					java.sql.Statement stmt = con.createStatement();
					String dbin = "INSERT INTO message VALUES('" + message + "','" + cid + "','" + fid + "')";

					stmt.execute(dbin);
					stmt.close();

					JOptionPane.showMessageDialog(null, "Message Sent");

					textField_2.setText("");

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_6.setBounds(816, 479, 97, 42);
		frame4.getContentPane().add(btnNewButton_6);

	}
}
