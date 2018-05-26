package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;

public class home extends JFrame {
	String User_Id;
	String Last_Login;
	String item[]={"User_Id","Last_Login"};
	JFrame frame4;
	JTable table4;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBikecar = new JButton("Vehicle Insurance");
		btnBikecar.setBackground(Color.LIGHT_GRAY);
		btnBikecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vehicle bk=new vehicle();
				bk.setVisible(true);
				setVisible(false);
			}
		});
		btnBikecar.setFont(new Font("Monospaced", Font.BOLD, 20));
		btnBikecar.setBounds(180, 62, 256, 38);
		contentPane.add(btnBikecar);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.LIGHT_GRAY);
		btnLogout.setIcon(null);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login log=new login();
				setVisible(false);
				log.setVisible(true);
				setVisible(false);
				
			}
		});
		btnLogout.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		btnLogout.setBounds(25, 11, 113, 25);
		contentPane.add(btnLogout);
		
		JButton btnLastLogin = new JButton("Last Login");
		btnLastLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Showing Table Data....");
				showTableData4();
			}
			private void showTableData4()
			{
				frame4=new JFrame("Dtabase Search Result");
				DefaultTableModel model4=new DefaultTableModel();
				model4.setColumnIdentifiers(item);
				table4=new JTable();
				table4.setModel(model4);
				JScrollPane scroll=new JScrollPane(table4);
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
					
					String sql="SELECT * FROM logtable ORDER BY last_login DESC";
					
					PreparedStatement ps=con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					int i=0;
					while(rs.next())
					{
						User_Id=rs.getString(1);
						Last_Login=rs.getString(2);
						model4.addRow(new Object[]{User_Id,Last_Login});
						i++;
					}
					if(i<1)
					{
						System.out.println("no record found");
					
					}
					else
					{
						System.out.println("record found");
					}
				}
					catch(Exception o)
					{
						System.out.println(o.getMessage());
					}
					frame4.getContentPane().add(scroll);
					frame4.setVisible(true);
					frame4.setSize(400,300);
				
		
			}
		});
		btnLastLogin.setBackground(Color.LIGHT_GRAY);
		btnLastLogin.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		btnLastLogin.setBounds(471, 11, 113, 24);
		contentPane.add(btnLastLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\java project\\fica-gif1.gif"));
		lblNewLabel.setBounds(-32, 0, 716, 418);
		contentPane.add(lblNewLabel);
	}
}
