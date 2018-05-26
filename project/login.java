package project;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setTitle("Login");

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsuranceAndBanking = new JLabel("Vehicle Insurance Management  System");
		lblInsuranceAndBanking.setFont(new Font("Bodoni MT Black", Font.BOLD, 21));
		lblInsuranceAndBanking.setBounds(28, 11, 549, 50);
		contentPane.add(lblInsuranceAndBanking);
		
		JLabel lblUsername = new JLabel("Enter Username");
		lblUsername.setFont(new Font("Castellar", Font.BOLD, 16));
		lblUsername.setBounds(20, 72, 204, 50);
		contentPane.add(lblUsername);
		
		username = new JTextField();
		username.setFont(new Font("Century Gothic", Font.BOLD, 17));
		username.setBounds(313, 77, 112, 37);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("Enter password");
		lblEnterPassword.setFont(new Font("Castellar", Font.BOLD, 16));
		lblEnterPassword.setBounds(20, 128, 204, 50);
		contentPane.add(lblEnterPassword);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_ENTER)
				{
					String uname=username.getText();
					String pass=passwordField.getText();
					
					if((uname.equals("admin")&& pass.equals("1234"))||(uname.equals("lion")&&pass.equals("5678")))
					{
						
						String sx=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
						System.out.println(sx);
						try
						{
							
							//String s1=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
							Class.forName("com.mysql.jdbc.Driver");
							Connection conx=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
							String sql1="INSERT INTO `logtable`(`user_id`, `last_login`) VALUES (?, ?)";
							PreparedStatement psy = conx.prepareStatement(sql1);
							psy.setString(1,uname);
							psy.setString(2,sx);
							psy.execute();
							conx.close();
						}
						catch(Exception j)
						{
							System.out.println(j.getMessage());
						}
						
						JOptionPane.showMessageDialog(username,"Login sucessful");
						home ho=new home();
						ho.setVisible(true);
						setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(username, "Invalid username or password ");
					}
				}
			}
		});
		passwordField.setFont(new Font("Century Gothic", Font.BOLD, 17));
		passwordField.setBounds(313, 136, 112, 37);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		
		btnLogin.setForeground(Color.BLACK);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String uname=username.getText();
				String pass=passwordField.getText();
				
				if((uname.equals("admin")&& pass.equals("1234"))||(uname.equals("lion")&&pass.equals("5678")))
				{
					
					String sx=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
				
					try
					{
						
						//String s1=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
						Class.forName("com.mysql.jdbc.Driver");
						Connection conx=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
						String sql1="INSERT INTO `logtable`(`user_id`, `last_login`) VALUES (?, ?)";
						PreparedStatement psy = conx.prepareStatement(sql1);
						psy.setString(1,uname);
						psy.setString(2,sx);
						psy.execute();
						conx.close();
					}
					catch(Exception j)
					{
						System.out.println(j.getMessage());
					}
					
					JOptionPane.showMessageDialog(username,"Login sucessful");
					home ho=new home();
					ho.setVisible(true);
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(username, "Invalid username or password ");
				}
			}

		});
	
		btnLogin.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
		btnLogin.setBounds(198, 298, 112, 37);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\project\\18-gif.gif"));
		lblNewLabel.setBounds(-23, 0, 600, 359);
		contentPane.add(lblNewLabel);
	}
}

