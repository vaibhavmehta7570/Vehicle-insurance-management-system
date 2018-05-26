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
import java.sql.ResultSet;

import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;

public class claiminsertup extends JFrame {

	private JPanel contentPane;
	private JTextField cpi;
	private JTextField ca;
	private JTextField cca;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					claiminsertup frame = new claiminsertup();
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
	public claiminsertup() {
		setTitle("Insert/Update");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 461);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPolicyId = new JLabel("Policy ID");
		lblPolicyId.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblPolicyId.setBounds(410, 15, 132, 14);
		contentPane.add(lblPolicyId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblName.setBounds(410, 112, 132, 14);
		contentPane.add(lblName);
		
		JLabel lblVehicleType = new JLabel("Vehicle Type");
		lblVehicleType.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblVehicleType.setBounds(410, 145, 132, 14);
		contentPane.add(lblVehicleType);
		
		JLabel lblVehicleNo = new JLabel("Vehicle No");
		lblVehicleNo.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblVehicleNo.setBounds(410, 172, 132, 14);
		contentPane.add(lblVehicleNo);
		
		JLabel lblRcNo = new JLabel("RC no.");
		lblRcNo.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblRcNo.setBounds(410, 200, 132, 20);
		contentPane.add(lblRcNo);
		
		JLabel lblPurchaseDate = new JLabel("Purchase Date");
		lblPurchaseDate.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblPurchaseDate.setBounds(410, 238, 132, 14);
		contentPane.add(lblPurchaseDate);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date");
		lblExpiryDate.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblExpiryDate.setBounds(410, 274, 132, 14);
		contentPane.add(lblExpiryDate);
		
		JLabel lblApprovedAmt = new JLabel("Approved Amt");
		lblApprovedAmt.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblApprovedAmt.setBounds(410, 299, 132, 26);
		contentPane.add(lblApprovedAmt);
		
		JLabel lblClaimedApproved = new JLabel("Claimed Approved");
		lblClaimedApproved.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblClaimedApproved.setBounds(410, 336, 132, 14);
		contentPane.add(lblClaimedApproved);
		
		cpi = new JTextField();
		cpi.setBounds(552, 14, 144, 20);
		contentPane.add(cpi);
		cpi.setColumns(10);
		
		ca = new JTextField();
		ca.setBounds(552, 305, 144, 20);
		contentPane.add(ca);
		ca.setColumns(10);
		
		cca = new JTextField();
		cca.setBounds(552, 336, 144, 20);
		contentPane.add(cca);
		cca.setColumns(10);
		
		String policy_id;
		String name;
		String VehicleType;
		String Vehicle_No;
		String Rc_No;
		String Purchase_Date;
		String Policy_Expiry_Date;
		
		String cvtype[]={"Sedan","MPV","SUV","Hatchback","Non-Gear","B_Gear(1)","B_Gear(2)"};
		JLabel cvt = new JLabel("");
		cvt.setBounds(552, 147, 144, 14);
		contentPane.add(cvt);
		
		JLabel cn = new JLabel("");
		cn.setBounds(551, 114, 145, 14);
		contentPane.add(cn);
		
		
		JLabel cvn = new JLabel("");
		cvn.setBounds(552, 174, 144, 14);
		contentPane.add(cvn);
		
		JLabel crn = new JLabel("");
		crn.setBounds(552, 205, 144, 14);
		contentPane.add(crn);
		
		JLabel cpd = new JLabel("");
		cpd.setBounds(552, 240, 144, 14);
		contentPane.add(cpd);
		
		JLabel ced = new JLabel("");
		ced.setBounds(552, 274, 144, 14);
		contentPane.add(ced);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String policy_id=cpi.getText();
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
					
					String sql="select * from vehicle where policy_id= ?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1,policy_id);
					ResultSet rs=ps.executeQuery();
					
					int i=0;
					while(rs.next())
					{
						String name=rs.getString(2);
						
						String VehicleType=rs.getString(4);
						String Vehicle_No=rs.getString(5);
						String Rc_No=rs.getString(6);
						String Purchase_Date=rs.getString(7);
						String Policy_Expiry_Date=rs.getString(10);
							
						
						cn.setText(name);
						cvt.setText(VehicleType);
						cvn.setText(Vehicle_No);
						crn.setText(Rc_No);
						cpd.setText(Purchase_Date);
						ced.setText(Policy_Expiry_Date);
						
					}
				}
				catch(Exception e5)
				{
					System.out.println(e5.getMessage());
				}
					
			
			}
		});
		
		
		
		btnOk.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnOk.setBounds(607, 45, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnNewButton = new JButton("Insert");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String iid=cpi.getText();
				String n=cn.getText();
				String vvt=cvt.getText();
				String vvno=cvn.getText();
				String rrc=crn.getText();
				String ppd=cpd.getText();
				String ped=ced.getText();
				String amt=ca.getText();
				String cl=cca.getText();
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
				String query="INSERT INTO claim (policy_id,name,vtype,vehicle_no,rc_no,purchase_date,pexpiry,approved_amt,claim_approved) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1,iid);
				ps.setString(2,n);
				ps.setString(3,vvt);
				ps.setString(4,vvno);
				ps.setString(5,rrc);
				ps.setString(6,ppd);
				ps.setString(7,ped);
				ps.setString(8,amt);
				ps.setString(9,cl);
				
				ps.execute();
				
			
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
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton.setBounds(453, 390, 101, 23);
		contentPane.add(btnNewButton);
		
		
		
		JLabel label = new JLabel("-------------------------------------------------------------------------");
		label.setBounds(404, 87, 302, 14);
		contentPane.add(label);
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String policyid=cpi.getText();
				String name=cn.getText();
				
				String amt=ca.getText();
				String cl=cca.getText();
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
				//String query="INSERT INTO claim (policy_id,name,vtype,vehicle_no,rc_no,purchase_date,pexpiry,approved_amt,claim_approved) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				String query="update claim set name=?,approved_amt=?,claim_approved=? where policy_id=?";
				PreparedStatement ps = con.prepareStatement(query);
				
				
				ps.setString(1,name);
				ps.setString(2,amt);
				ps.setString(3,cl);
				ps.setString(4,policyid);
				ps.execute();
				
				//System.out.println("Data updated Succesfully");
				//if(name.equals(null))
				
					//JOptionPane.showMessageDialog(null,"Error Data Missing");
				
			if((name.equals("")||policyid.equals("")))
			{
					JOptionPane.showMessageDialog(null,"Error data not updated");
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Data Updated Sucessfully");
			}
					con.close();
				}
				catch(Exception e5)
				{
					System.out.println(e5.getMessage());
					JOptionPane.showMessageDialog(null,e5.getMessage());
				}
		
				
			}
			
		});
		btnUpdate.setBounds(582, 388, 101, 23);
		contentPane.add(btnUpdate);
		
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
