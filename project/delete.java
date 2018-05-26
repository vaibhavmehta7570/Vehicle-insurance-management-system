package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class delete extends JFrame {

	private JPanel contentPane;
	private JTextField td;
	private JButton btnBack;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete frame = new delete();
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
	public delete() {
		setTitle("Delete");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterVehicleId = new JLabel("Enter Policy ID to delete :");
		lblEnterVehicleId.setForeground(SystemColor.control);
		lblEnterVehicleId.setFont(new Font("Tw Cen MT", Font.PLAIN, 19));
		lblEnterVehicleId.setBounds(-1, 45, 247, 33);
		contentPane.add(lblEnterVehicleId);
		
		td = new JTextField();
		td.setBounds(216, 53, 111, 20);
		contentPane.add(td);
		td.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(SystemColor.control);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String p_id=td.getText();
				int p=JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the data?","delete",JOptionPane.YES_NO_OPTION);
				if(p==0)
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
						String query = "delete from vehicle where policy_id=?";
						PreparedStatement ps = con.prepareStatement(query);
						ps.setString(1,p_id);
						JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
						ps.execute();
					}
					catch (Exception e3)
					{
						System.out.println(e3.getMessage());
					}
				}
			}
		});
		btnDelete.setFont(new Font("Monospaced", Font.BOLD, 18));
		btnDelete.setBounds(361, 49, 103, 23);
		contentPane.add(btnDelete);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.control);
		btnBack.setFont(new Font("Monospaced", Font.BOLD, 18));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vehicle v=new vehicle();
				v.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\project\\a510b570faa3481c096726012de59f45.gif"));
		lblNewLabel.setBounds(-11, -31, 511, 313);
		contentPane.add(lblNewLabel);
	}

}
