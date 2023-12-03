import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.JEditorPane;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Student extends Login {

	protected JFrame frame3;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student window = new Student();
					window.frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Student() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame3 = new JFrame();
		frame3.setBounds(100, 100, 1200, 700);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Student Window");
		lblNewLabel.setBounds(12, 0, 226, 44);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		frame3.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Course Initial");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(12, 169, 145, 16);
		frame3.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(37, 228, 56, 16);
		frame3.getContentPane().add(lblNewLabel_2);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(356, 70, 517, 329);
		frame3.getContentPane().add(textArea);

		textField = new JTextField();
		textField.setBounds(163, 109, 181, 22);
		frame3.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(globaluserid);

		Choice choice = new Choice();
		choice.setBounds(163, 169, 181, 22);
		frame3.getContentPane().add(choice);

		JButton btnNewButton = new JButton("Check Attendance");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// show the attendance.............................
				textArea.setText("");
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");

					String stid = textField.getText();
					String crini = choice.getSelectedItem().toString();
					String sql = "SELECT* FROM attendance WHERE Student_Id=('" + stid + "') AND Course_Initial=('"
							+ crini + "');";

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
		btnNewButton.setBounds(105, 228, 145, 32);
		frame3.getContentPane().add(btnNewButton);

		Button button = new Button("Show");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// course initial according to studentid
				int itemCount = choice.getItemCount();

				for (int i = 0; i < itemCount; i++) {
					choice.remove(0);
				}
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance",
							"root", "12345678");

					String str = textField.getText();
					String sql = "SELECT DISTINCT Course_Initial FROM attendance  WHERE Student_Id = ('" + str + "');";

					java.sql.PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {
						String name = rs.getString("Course_Initial");
						choice.addItem(name);
					}

					pst.close();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		button.setBounds(266, 139, 72, 24);
		frame3.getContentPane().add(button);

		JLabel lblNewLabel_3 = new JLabel("Student Id");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(12, 112, 145, 16);
		frame3.getContentPane().add(lblNewLabel_3);

		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// logout for frame 3..........................................
				frame3.dispose();

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
		btnNewButton_1.setBounds(37, 409, 109, 32);
		frame3.getContentPane().add(btnNewButton_1);

	}
}
