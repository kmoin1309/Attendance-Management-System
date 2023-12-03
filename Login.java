import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.sun.jdi.connect.spi.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.event.ActionEvent;

public class Login {

	protected JFrame frame;
	private JTextField txtuserid;
	private JPasswordField passwordField;
	public String globaluserid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtuserid = new JTextField();
		txtuserid.setBounds(298, 145, 256, 35);
		frame.getContentPane().add(txtuserid);
		txtuserid.setColumns(10);

		JLabel lbluserid = new JLabel("User ID");
		lbluserid.setFont(new Font("Tahoma", Font.BOLD, 26));
		lbluserid.setBounds(150, 145, 127, 35);
		frame.getContentPane().add(lbluserid);

		passwordField = new JPasswordField();
		passwordField.setBounds(298, 206, 256, 35);
		frame.getContentPane().add(passwordField);

		JLabel lblpassword = new JLabel("Password");
		lblpassword.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblpassword.setBounds(150, 202, 136, 35);
		frame.getContentPane().add(lblpassword);

		Choice cbrole = new Choice();
		cbrole.setFont(new Font("Dialog", Font.PLAIN, 20));
		cbrole.setBounds(298, 264, 256, 32);
		frame.getContentPane().add(cbrole);

		cbrole.add("Student");
		cbrole.add("Faculty");
		cbrole.add("Administrator");

		JButton btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// login button code.........................................

				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con = DriverManager
							.getConnection("jdbc:mysql://localhost:3306/student_attendance", "root", "12345678");
					String sql = "select* from User_Information where User_Id=? and User_Password=? and Role=?";

					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, txtuserid.getText());
					pst.setString(2, passwordField.getText());
					pst.setString(3, cbrole.getSelectedItem());

					String r = cbrole.getSelectedItem().toString();

					ResultSet rs = pst.executeQuery();

					globaluserid = txtuserid.getText();

					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Username and Password Matched.");
						frame.dispose();
						// .............
						if (r == "Student") {
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
						} else if (r == "Faculty") {
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
						} else if (r == "Administrator") {
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
						txtuserid.setText("");
						passwordField.setText("");

					}

					else {
						JOptionPane.showMessageDialog(null, "Wrong Information");
						txtuserid.setText("");
						passwordField.setText("");
					}

					con.close();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});
		btnlogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnlogin.setBounds(442, 331, 112, 35);
		frame.getContentPane().add(btnlogin);

		JButton btnsignup = new JButton("Signup");
		btnsignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				/// ekhane signup ashbe
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
		});
		btnsignup.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnsignup.setBounds(594, 331, 127, 35);
		frame.getContentPane().add(btnsignup);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(12, 13, 184, 35);
		frame.getContentPane().add(lblNewLabel);
	}
}

