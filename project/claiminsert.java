package project;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class claiminsert extends JFrame {

	private JPanel contentPane;
	private JTextField cpi;
	private JTextField ctn;
	private JTextField crn;
	private JTextField cpd;
	private JTextField ced;
	private JTextField ca;
	private JTextField cca;
	private JTextField cvn;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					claiminsert frame = new claiminsert();
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
	public claiminsert() {
		setTitle("Claim Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 461);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPolicyId = new JLabel("Policy ID");
		lblPolicyId.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblPolicyId.setBounds(410, 42, 132, 14);
		contentPane.add(lblPolicyId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblName.setBounds(410, 67, 132, 14);
		contentPane.add(lblName);
		
		JLabel lblVehicleType = new JLabel("Vehicle Type");
		lblVehicleType.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblVehicleType.setBounds(410, 100, 132, 14);
		contentPane.add(lblVehicleType);
		
		JLabel lblVehicleNo = new JLabel("Vehicle No");
		lblVehicleNo.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblVehicleNo.setBounds(410, 127, 132, 14);
		contentPane.add(lblVehicleNo);
		
		JLabel lblRcNo = new JLabel("RC no.");
		lblRcNo.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblRcNo.setBounds(410, 155, 132, 20);
		contentPane.add(lblRcNo);
		
		JLabel lblPurchaseDate = new JLabel("Purchase Date");
		lblPurchaseDate.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblPurchaseDate.setBounds(410, 193, 132, 14);
		contentPane.add(lblPurchaseDate);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date");
		lblExpiryDate.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblExpiryDate.setBounds(410, 229, 132, 14);
		contentPane.add(lblExpiryDate);
		
		JLabel lblApprovedAmt = new JLabel("Approved Amt");
		lblApprovedAmt.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblApprovedAmt.setBounds(410, 254, 132, 26);
		contentPane.add(lblApprovedAmt);
		
		JLabel lblClaimedApproved = new JLabel("Claimed Approved");
		lblClaimedApproved.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblClaimedApproved.setBounds(410, 291, 132, 14);
		contentPane.add(lblClaimedApproved);
		
		cpi = new JTextField();
		cpi.setBounds(552, 42, 144, 20);
		contentPane.add(cpi);
		cpi.setColumns(10);
		
		ctn = new JTextField();
		ctn.setBounds(552, 67, 144, 20);
		contentPane.add(ctn);
		ctn.setColumns(10);
		
		crn = new JTextField();
		crn.setBounds(552, 158, 144, 20);
		contentPane.add(crn);
		crn.setColumns(10);
		
		cpd = new JTextField();
		cpd.setBounds(552, 193, 144, 20);
		contentPane.add(cpd);
		cpd.setColumns(10);
		
		ced = new JTextField();
		ced.setBounds(552, 229, 144, 20);
		contentPane.add(ced);
		ced.setColumns(10);
		
		ca = new JTextField();
		ca.setBounds(552, 260, 144, 20);
		contentPane.add(ca);
		ca.setColumns(10);
		
		cca = new JTextField();
		cca.setBounds(552, 291, 144, 20);
		contentPane.add(cca);
		cca.setColumns(10);
		
		String cvtype[]={"Sedan","MPV","SUV","Hatchback","Non-Gear","B_Gear(1)","B_Gear(2)"};
		JComboBox cvt = new JComboBox(cvtype);
		cvt.setBounds(552, 100, 144, 20);
		contentPane.add(cvt);
		
		cvn = new JTextField();
		cvn.setBounds(552, 127, 144, 20);
		contentPane.add(cvn);
		cvn.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String policyid=cpi.getText();
				String name=ctn.getText();
				String vtype=(String)cvt.getSelectedItem();
				String vno=cvn.getText();
				String rcno=crn.getText();
				String pd=cpd.getText();
				String epd=ced.getText();
				String amt=ca.getText();
				String cl=cca.getText();
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
				String query="INSERT INTO claim (policy_id,name,vtype,vehicle_no,rc_no,purchase_date,pexpiry,approved_amt,claim_approved) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1,policyid);
				ps.setString(2,name);
				ps.setString(3,vtype);
				ps.setString(4,vno);
				ps.setString(5,rcno);
				ps.setString(6,pd);
				ps.setString(7,epd);
				ps.setString(8,amt);
				ps.setString(9,cl);
				
				ps.execute();
				
				//System.out.println("Data inserted Succesfully");
				JOptionPane.showMessageDialog(null,"Data Inserted Successfully");
				con.close();
				}
				catch(Exception e4)
				{
					System.out.println(e4.getMessage());
					JOptionPane.showMessageDialog(null,"ERROR data not inserted");
				}
				
			}
		});
		btnInsert.setBounds(491, 388, 106, 23);
		contentPane.add(btnInsert);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				claimf cf=new claimf();
				cf.setVisible(true);
				setVisible(false);
			}
			
		});
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\project\\_british_car_gif2.gif"));
		lblNewLabel.setBounds(36, -23, 647, 463);
		contentPane.add(lblNewLabel);
	}
}
