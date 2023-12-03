import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.event.ActionEvent;

public class Signup {

	protected JFrame frame2;
	private JTextField txtuserid_s;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	java.sql.Connection con;
	String pass1, pass2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 800, 500);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);

		txtuserid_s = new JTextField();
		txtuserid_s.setBounds(397, 79, 229, 31);
		frame2.getContentPane().add(txtuserid_s);
		txtuserid_s.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(397, 141, 229, 31);
		frame2.getContentPane().add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(397, 201, 229, 31);
		frame2.getContentPane().add(passwordField_1);

		JList list = new JList();
		list.setBounds(436, 274, 0, 13);
		frame2.getContentPane().add(list);

		JLabel lblNewLabel = new JLabel("User ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(169, 79, 216, 31);
		frame2.getContentPane().add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPassword.setBounds(169, 141, 216, 31);
		frame2.getContentPane().add(lblPassword);

		JLabel lblRetypePassword = new JLabel("Re-Type Password");
		lblRetypePassword.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblRetypePassword.setBounds(169, 201, 216, 31);
		frame2.getContentPane().add(lblRetypePassword);

		JLabel lblNewLabel_1 = new JLabel("Role");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(169, 259, 216, 28);
		frame2.getContentPane().add(lblNewLabel_1);

		Choice choiceBox = new Choice();
		choiceBox.setFont(new Font("Dialog", Font.PLAIN, 20));
		choiceBox.setBounds(397, 259, 229, 31);
		frame2.getContentPane().add(choiceBox);

		choiceBox.add("Student");
		choiceBox.add("Faculty");
		choiceBox.add("Administrator");

		JLabel lblNewLabel_2 = new JLabel("Signup");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_2.setBounds(29, 13, 162, 31);
		frame2.getContentPane().add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pass1 == pass2) {

					try {
						Class.forName("com.mysql.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance", "root",
								"12345678");
						String selectedValue = choiceBox.getSelectedItem().toString();// ..
						String userId = txtuserid_s.getText();
						int userid = Integer.parseInt(userId);// ..
						pass1 = passwordField.getText();// ..

						java.sql.Statement stmt = con.createStatement();
						String dbin = "INSERT INTO user_information VALUES('" + userid + "','" + pass1 + "','"
								+ selectedValue + "')";

						stmt.execute(dbin);
						stmt.close();

						txtuserid_s.setText("");
						passwordField.setText("");
						passwordField_1.setText("");

						JOptionPane.showMessageDialog(null, "Account Successfully Created.");

					} catch (SQLIntegrityConstraintViolationException e2) {
						System.out.println("Account already exist with this ID");
						JOptionPane.showMessageDialog(null, "Account already exist with this ID");
						txtuserid_s.setText("");
						passwordField.setText("");
						passwordField_1.setText("");
					} catch (Exception e1) {
						System.out.println(e1);
					}
				}

				else {
					JOptionPane.showMessageDialog(null, "Password doesnot match");
					txtuserid_s.setText("");
					passwordField.setText("");
					passwordField_1.setText("");
				}

			}

		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(501, 315, 125, 35);
		frame2.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// back will show login window.....................
				frame2.dispose();
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(29, 377, 97, 31);
		frame2.getContentPane().add(btnNewButton_1);

	}

}
