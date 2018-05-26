package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.SystemColor;
import java.awt.Color;

public class vehicle extends JFrame {
	
	

	private JPanel contentPane;
	JFrame frame2;
	JTable table2;
	String[] columnNames2={"Policy_id","Name","Mobile_No","VehicleType","Vehicle_No","Rc_No","Purchase_Date","Address","Policy_start_Date","Policy Expiry_Date"};
			String policy_id,name,Mobile_No,VehicleType,Vehicle_No,Rc_No,Purchase_Date,Address,Policy_start_Date,Policy_Expiry_Date;
	JTable table;
	JFrame	frame1;
	String columnnames[] ={"Vehicle_Type","Ins_Value","Ins_Price","Valid_For"};
	String Vehicle_Type;
	String Ins_Value;
	Float Ins_Price;
	String Vaid_For;
	
	private JPanel contentPane3;
	JFrame frame3;
	JTable table3;
	String[] columnNames3={"age_of_vehicle","rate_of_depreciation"};

	String age_of_vehicle,rate_of_depreciation;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vehicle frame = new vehicle();
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
	public vehicle() {
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 419);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		JButton btnInsertupdate = new JButton("Insert");
		btnInsertupdate.setBackground(SystemColor.control);
		btnInsertupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertup iu=new insertup();
				iu.setVisible(true);
				setVisible(false);
			}
		});
		btnInsertupdate.setFont(new Font("Modern No. 20", Font.PLAIN, 16));
		btnInsertupdate.setBounds(145, 84, 211, 38);
		contentPane.add(btnInsertupdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(SystemColor.control);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				delete del=new delete();
				del.setVisible(true);
				setVisible(false);
			}
		});
		btnDelete.setFont(new Font("Modern No. 20", Font.PLAIN, 16));
		btnDelete.setBounds(145, 184, 211, 38);
		contentPane.add(btnDelete);
		
		JButton btnRetrieve = new JButton("Retrieve");
		btnRetrieve.setBackground(SystemColor.control);
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Showing Table Data....");
				showTableData1();
			}
			private void showTableData1()
			{
				frame1=new JFrame("Dtabase Search Result");
				DefaultTableModel model2=new DefaultTableModel();
				model2.setColumnIdentifiers(columnNames2);
				table2=new JTable();
				table2.setModel(model2);
				JScrollPane scroll=new JScrollPane(table2);
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
					
					String sql="select * from vehicle";
					
					PreparedStatement ps=con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					int i=0;
					while(rs.next())
					{
						policy_id=rs.getString(1);
								name=rs.getString(2);
								Mobile_No=rs.getString(3);
								VehicleType=rs.getString(4);
								Vehicle_No=rs.getString(5);
								Rc_No=rs.getString(6);
								Purchase_Date=rs.getString(7);
								Address=rs.getString(8);
								Policy_start_Date=rs.getString(9);
								Policy_Expiry_Date=rs.getString(10);
						model2.addRow(new Object[]{policy_id,name,Mobile_No,VehicleType,Vehicle_No,Rc_No,Purchase_Date,Address,Policy_start_Date,Policy_Expiry_Date});
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
					frame1.getContentPane().add(scroll);
					frame1.setVisible(true);
					frame1.setSize(1200,300);
				
			}
				
				
				
		});
		btnRetrieve.setFont(new Font("Modern No. 20", Font.PLAIN, 16));
		btnRetrieve.setBounds(145, 233, 211, 38);
		contentPane.add(btnRetrieve);
		
		JButton btnClaim = new JButton("Claim");
		btnClaim.setBackground(SystemColor.control);
		btnClaim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				claimf cf=new claimf();
				cf.setVisible(true);
				setVisible(false);
			}
		});
		btnClaim.setFont(new Font("Modern No. 20", Font.PLAIN, 16));
		btnClaim.setBounds(145, 282, 211, 38);
		contentPane.add(btnClaim);
		
		JButton btnPolicies = new JButton("Policies");
		btnPolicies.setBackground(SystemColor.control);
		btnPolicies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Showing Policy Data....");
				showTableData();
				
			}
			private void showTableData()
			{
				frame1=new JFrame("Dtabase Search Result");
				DefaultTableModel model=new DefaultTableModel();
				model.setColumnIdentifiers(columnnames);
				table=new JTable();
				table.setModel(model);
				JScrollPane scroll=new JScrollPane(table);
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
					
					String sql="select * from vpolicy";
					
					PreparedStatement ps=con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();

					int i=0;
					while(rs.next())
					{
						Vehicle_Type=rs.getString(1);
						Ins_Value=rs.getString(2);
						Ins_Price=rs.getFloat(3);
						Vaid_For=rs.getString(4);
						model.addRow(new Object[]{Vehicle_Type,Ins_Value,Ins_Price,Vaid_For});
						i++;
					}
					if(i<1)
					{
						System.out.println("no Record found");
					
					}
					else
					{
						System.out.println("Record Found");
					}
					
			}
				catch (Exception e1)
				{
					System.out.println("cannot connect with the Database");
				}
				frame1.getContentPane().add(scroll);
				frame1.setVisible(true);
				frame1.setSize(400,300);
			}
		});
		btnPolicies.setFont(new Font("Modern No. 20", Font.PLAIN, 16));
		btnPolicies.setBounds(145, 35, 211, 38);
		contentPane.add(btnPolicies);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.control);
		btnBack.setFont(new Font("Modern No. 20", Font.PLAIN, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home h=new home();
				setVisible(false);
				h.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(24, 11, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnTermscondtions = new JButton("Terms & Condtions*");
		btnTermscondtions.setBackground(SystemColor.control);
		btnTermscondtions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) {
				System.out.println("Showing Table Data....");
				showTableData3();
			}
			private void showTableData3()
			{
				frame3=new JFrame("Dtabase Search Result");
				DefaultTableModel model3=new DefaultTableModel();
				model3.setColumnIdentifiers(columnNames3);
				table3=new JTable();
				table3.setModel(model3);
				JScrollPane scroll=new JScrollPane(table3);
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
					
					String sql="SELECT * FROM `terms&condition`";
					
					PreparedStatement ps=con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					int i=0;
					while(rs.next())
					{
						age_of_vehicle=rs.getString(1);
						rate_of_depreciation=rs.getString(2);
						model3.addRow(new Object[]{age_of_vehicle,rate_of_depreciation});
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
					frame3.getContentPane().add(scroll);
					frame3.setVisible(true);
					frame3.setSize(400,300);
				
			}
		});
		
	
		btnTermscondtions.setFont(new Font("Modern No. 20", Font.PLAIN, 16));
		btnTermscondtions.setBounds(145, 331, 211, 38);
		contentPane.add(btnTermscondtions);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setFont(new Font("Modern No. 20", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateinsert ab =new updateinsert();
				ab.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(145, 133, 211, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\project\\c4d155a40c42411054aeed11953f7add--classic-motorcycle-classic-bikes.jpg"));
		lblNewLabel.setBounds(-14, 0, 257, 464);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\project\\c4d155a40c42411054aeed11953f7add--classic-motorcycle-classic-bikes.jpg"));
		lblNewLabel_1.setBounds(317, 24, 354, 413);
		contentPane.add(lblNewLabel_1);
			
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home hom=new home();
				hom.setVisible(true);
			}
		});
		
	}
}
