package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;

public class claimf extends JFrame {

	private JPanel contentPane;
	private JTextField trp;
	private JTextField tf;
	String name,p_id,vtype,v_no,rc_no,p_date,ex_date,apd_amt,claimed;
	String[] colnames={"Policy_ID","Name","VehicleType","VehicleNo","RC_NO","Purchase_Date","Expiry_Date","Approved_Amt","Claim_Approved"};
	String ppid,namex,vtyp,vn,rn,pdt,edt,aamt,cld;
	JFrame frame3;
	JTable table3;
	PreparedStatement ps;
	ResultSet rs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					claimf frame = new claimf();
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
	public claimf() {
		setTitle("Claim Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRetriveAll = new JButton("Retrive Claims");
		btnRetriveAll.setBackground(SystemColor.menu);
		btnRetriveAll.setFont(new Font("Monospaced", Font.BOLD, 17));
		btnRetriveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Showing Table Data....");
				showTableData();
			}
				private void showTableData()
				{
					frame3=new JFrame("Claim Database");
					DefaultTableModel modelx=new DefaultTableModel();
					modelx.setColumnIdentifiers(colnames);
					table3=new JTable();
					table3.setModel(modelx);
					JScrollPane scroll=new JScrollPane(table3);
				try
				{

					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
					String sql="select * from claim";
					PreparedStatement ps=con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					int i=0;
					while(rs.next())
					{
						ppid=rs.getString(1);
						namex=rs.getString(2);
						vtyp=rs.getString(3);
						vn=rs.getString(4);
						rn=rs.getString(5);
						pdt=rs.getString(6);
						edt=rs.getString(7);
						aamt=rs.getString(8);
						cld=rs.getString(9);
						modelx.addRow(new Object[]{ppid,namex,vtyp,vn,rn,pdt,edt,aamt,cld});
						i++;
					}
					if(i<1)
					{
						JOptionPane.showMessageDialog(null,"No Record Found");
					}
					
					
				}
				catch(Exception b)
				{
					System.out.println(b.getMessage());
				}
				frame3.getContentPane().add(scroll);
				frame3.setVisible(true);
				frame3.setSize(1200,300);
				}
		});
		
		btnRetriveAll.setBounds(429, 24, 192, 23);
		contentPane.add(btnRetriveAll);
		
		JLabel lblRetriveByPolicy = new JLabel("Retrive by Policy ID");
		lblRetriveByPolicy.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblRetriveByPolicy.setBounds(383, 76, 173, 30);
		contentPane.add(lblRetriveByPolicy);
		
		trp = new JTextField();
		trp.setFont(new Font("Century Gothic", Font.BOLD, 12));
		trp.setBounds(611, 82, 76, 20);
		contentPane.add(trp);
		trp.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p_id=trp.getText();
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
					String query="select * from claim where policy_id=?";
					ps = con.prepareStatement(query);
					ps.setString(1,p_id);
					rs=ps.executeQuery();
					while(rs.next())
					{
						name=rs.getString(2);
						vtype=rs.getString(3);
						v_no=rs.getString(4);
						rc_no=rs.getString(5);
						p_date=rs.getString(6);
						ex_date=rs.getString(7);
						apd_amt=rs.getString(8);
						claimed=rs.getString(9);
					}
					con.close();
					
				}
				catch(Exception e7)
				{
					System.out.println(e7.getMessage());
				}
				tf.setText("NAME:"+name+"|| VTYPE:"+vtype+"|| VEHICLE_NO:"+v_no+"|| RC_NO:"+rc_no+"|| Purchase_Date:"+p_date+"|| Expiry_Date:"+ex_date+"|| Approved_Amt:"+apd_amt+"|| Claim_Approved:"+claimed);
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("Insert/Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				claiminsertup c=new claiminsertup();
				c.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Monospaced", Font.BOLD, 17));
		btnNewButton_2.setBackground(SystemColor.menu);
		btnNewButton_2.setBounds(657, 26, 173, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton.setBounds(726, 80, 114, 23);
		contentPane.add(btnNewButton);
		
		tf = new JTextField();
		tf.setFont(new Font("Century Gothic", Font.BOLD, 12));
		tf.setBounds(10, 198, 1026, 52);
		contentPane.add(tf);
		tf.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.setFont(new Font("Monospaced", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vehicle v=new vehicle();
				v.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(270, 24, 131, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\project\\comprehensive-guide-to-the-best-car-insurance-purchase.jpg"));
		lblNewLabel.setBounds(151, 0, 873, 271);
		contentPane.add(lblNewLabel);
	}
	
}
