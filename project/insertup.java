package project;

import java.awt.BorderLayout;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class insertup extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField tn;
	private JTextField tm;
	private JTextField ta;
	private JTextField trc;
	private JTextField vpd;
	private JTextField pcd;
	private JTextField ped;
	private JTextField tvn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertup frame = new insertup();
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
	public insertup() {
		setTitle("Insert Policy ");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 473);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsertid = new JLabel("Policy_Id");
		lblInsertid.setForeground(Color.BLACK);
		lblInsertid.setBackground(SystemColor.desktop);
		lblInsertid.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblInsertid.setBounds(314, 66, 142, 14);
		contentPane.add(lblInsertid);
		
		id = new JTextField();
		id.setBounds(494, 66, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.BLACK);
		lblName.setBackground(SystemColor.desktop);
		lblName.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblName.setBounds(314, 97, 142, 14);
		contentPane.add(lblName);
		
		tn = new JTextField();
		tn.setBounds(494, 97, 86, 20);
		contentPane.add(tn);
		tn.setColumns(10);
		
		JLabel lblMobileno = new JLabel("Mobile_No");
		lblMobileno.setForeground(Color.BLACK);
		lblMobileno.setBackground(SystemColor.desktop);
		lblMobileno.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblMobileno.setBounds(314, 128, 142, 14);
		contentPane.add(lblMobileno);
		
		tm = new JTextField();
		tm.setBounds(494, 128, 86, 20);
		contentPane.add(tm);
		tm.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setBackground(SystemColor.desktop);
		lblAddress.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblAddress.setBounds(314, 161, 142, 14);
		contentPane.add(lblAddress);
		
		ta = new JTextField();
		ta.setBounds(494, 159, 86, 20);
		contentPane.add(ta);
		ta.setColumns(10);
		String veh[]={"Sedan","MPV","SUV","Hatchback","Non-Gear","B_Gear(1)","B_Gear(2)"};
		JComboBox vt = new JComboBox(veh);
		vt.setMaximumRowCount(7);
		vt.setBounds(494, 199, 86, 20);
		contentPane.add(vt);
	
		
		JLabel lblRcno = new JLabel("Rc_No");
		lblRcno.setForeground(Color.BLACK);
		lblRcno.setBackground(SystemColor.desktop);
		lblRcno.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblRcno.setBounds(314, 265, 142, 14);
		contentPane.add(lblRcno);
		
		trc = new JTextField();
		trc.setBounds(494, 265, 86, 20);
		contentPane.add(trc);
		trc.setColumns(10);
		
		
		JLabel lblVehiclePurchasedate = new JLabel("Vehicle Purchase_Date");
		lblVehiclePurchasedate.setForeground(Color.BLACK);
		lblVehiclePurchasedate.setBackground(SystemColor.desktop);
		lblVehiclePurchasedate.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblVehiclePurchasedate.setBounds(314, 296, 170, 14);
		contentPane.add(lblVehiclePurchasedate);
		
		vpd = new JTextField();
		vpd.setBounds(494, 296, 86, 20);
		contentPane.add(vpd);
		vpd.setColumns(10);
		
		JLabel lblPolicyCommencedate = new JLabel("Policy Commence_Date");
		lblPolicyCommencedate.setForeground(Color.BLACK);
		lblPolicyCommencedate.setBackground(SystemColor.desktop);
		lblPolicyCommencedate.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblPolicyCommencedate.setBounds(314, 323, 170, 14);
		contentPane.add(lblPolicyCommencedate);
		
		pcd = new JTextField();
		pcd.setBounds(494, 323, 86, 20);
		contentPane.add(pcd);
		pcd.setColumns(10);
		
		JLabel lblPolicyExpirydate = new JLabel("Policy Expiry_Date");
		lblPolicyExpirydate.setForeground(Color.BLACK);
		lblPolicyExpirydate.setBackground(SystemColor.desktop);
		lblPolicyExpirydate.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblPolicyExpirydate.setBounds(314, 358, 142, 14);
		contentPane.add(lblPolicyExpirydate);
		
		ped = new JTextField();
		ped.setBounds(494, 358, 86, 20);
		contentPane.add(ped);
		ped.setColumns(10);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.setBackground(SystemColor.control);
		btnInsert.setFont(new Font("Monospaced", Font.BOLD, 17));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String policyid=id.getText();
				String name=tn.getText();
				String mobno=tm.getText();
				String vtype=(String)vt.getSelectedItem();
				String vno=tvn.getText();
				String rc=trc.getText();
				String pdate=vpd.getText();
				String loc=ta.getText();
				String start=pcd.getText();
				String expire=ped.getText();
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
					String query = " insert into vehicle(policy_id,name,mobile_no,vtype,vehicle_no,rc_no,purchase_date,location,pcommence,pexpiry)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString (1,policyid);
					ps.setString (2,name);
					ps.setString(3,mobno);
					ps.setString(4,vtype);
					ps.setString(5,vno);
					ps.setString(6,rc);
					ps.setString(7,pdate);
					ps.setString(8,loc);
					ps.setString(9,start);
					ps.setString(10,expire);
					ps.execute();
					JOptionPane.showMessageDialog(null,"Data Inserted Successfully");
					con.close();
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}
				
			}
		});
		btnInsert.setBounds(379, 400, 105, 23);
		contentPane.add(btnInsert);
		
		JLabel lblVehicleNo = new JLabel("Vehicle No");
		lblVehicleNo.setForeground(Color.BLACK);
		lblVehicleNo.setBackground(SystemColor.desktop);
		lblVehicleNo.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblVehicleNo.setBounds(314, 229, 142, 20);
		contentPane.add(lblVehicleNo);
		
		tvn = new JTextField();
		tvn.setBounds(494, 232, 86, 20);
		contentPane.add(tvn);
		tvn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("VehicleType");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblNewLabel.setBounds(314, 195, 142, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("Home");
		btnBack.setFont(new Font("Monospaced", Font.BOLD, 17));
		btnBack.setBackground(SystemColor.control);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vehicle v=new vehicle();
				v.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(314, 11, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\project\\1682699-inline-slide-13-a-brief-cultural-history-of-the-volkswagen-beetle.jpg"));
		lblNewLabel_1.setBounds(-296, -30, 596, 464);
		contentPane.add(lblNewLabel_1);
	}
}
