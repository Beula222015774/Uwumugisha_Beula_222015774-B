package Myenrollform;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Myenrollment.enrollment;

public class Enrollform implements ActionListener{
	JFrame frame;
	JLabel eid_lb=new JLabel("enrollmentid");
	JLabel cid_lb=new JLabel("courseid");
	JLabel edate_lb=new JLabel("enrollmentdate");
	JLabel Uid_lb=new JLabel("userid");
	JLabel gr_lb=new JLabel("grade");
	

	JTextField eid_txf=new JTextField();
	JTextField cid_txf=new JTextField();
	JTextField edate_txf=new JTextField();
	JTextField Uid_txf=new JTextField();
	JTextField gr_txf=new JTextField();
	

	//String []gender={"Male", "Female"};
	//JComboBox<String> genderBox = new JComboBox<>(gender);

	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public  Enrollform() {
		createForm();
		actionEvent();
		setFontforall();
		addComponentToFrame();
		setLocationandSize();
	}
	private void actionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_tbtn.addActionListener(this);
		delete_btn.addActionListener(this);
		//genderBox.addActionListener(this);
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("ENROLLMENT FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.RED);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		eid_lb.setBounds(10, 10, 130, 30);
		cid_lb.setBounds(10, 50, 150, 30);
		edate_lb.setBounds(10, 90, 150, 30);
		Uid_lb.setBounds(10, 110, 170, 50);
		gr_lb.setBounds(10, 130, 190, 70);
		
		//ContactNmbr_lb.setBounds(10, 210, 170, 30);
		//gender_lb.setBounds(10, 250, 100, 30);
		
		eid_txf.setBounds(200, 10, 170, 30);
		cid_txf.setBounds(200, 50, 170, 30);
		edate_txf.setBounds(200, 90, 170, 30);
		Uid_txf.setBounds(200, 130, 170, 30);
		gr_txf.setBounds(200, 170, 170, 30);
		
		//Email_txf.setBounds(200, 210, 170, 30);
		//genderBox.setBounds(200, 250, 170, 30);
		//Buttons CRUD
		insert_btn.setBounds(10,250, 100, 60);
		Read_btn.setBounds(120,250, 100, 60);
		update_tbtn.setBounds(230,250, 100, 60);
		delete_btn.setBounds(340,250, 100, 60);
		table.setBounds(500, 10, 600, 240);
		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		eid_lb.setFont(font);
		cid_lb.setFont(font);
		edate_lb.setFont(font);
		Uid_lb.setFont(font);
		gr_lb.setFont(font);
		//Email_lb.setFont(font);
		//genderBox.setFont(font);

		eid_txf.setFont(font);
		cid_txf.setFont(font);
		edate_txf.setFont(font);
		Uid_txf.setFont(font);
		gr_txf.setFont(font);
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(eid_lb);
		frame.add(cid_lb);
		frame.add(edate_lb);
		frame.add(Uid_lb);
		frame.add(gr_lb);
		
		frame.add(eid_txf);
		frame.add(cid_txf);
		frame.add(edate_txf);
		frame.add(Uid_txf);
		frame.add(gr_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		enrollment enr=new enrollment();
		if(e.getSource()==insert_btn) {
			enr.setCourseid(cid_txf.getText());
			enr.setEnrollmentdate(edate_txf.getText());
			enr.setUserid(Uid_txf.getText());
			enr.setGrade(gr_txf.getText());
			enr.insertData();
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("enrollmentid");
            model.addColumn("courseid");
            model.addColumn(" userid");
            model.addColumn("enrollmentdate");
            model.addColumn(" grade");
           
            ResultSet resultSet =enrollment.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4),resultSet.getString(5)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_tbtn) {
	    	int id=Integer.parseInt(eid_txf.getText());
	    	enr.setCourseid(cid_txf.getText());
			enr.setEnrollmentdate(edate_txf.getText());
			enr.setUserid(Uid_txf.getText());
			enr.setGrade(gr_txf.getText());
			
			enr.update(id);
	    }
	  else {
			int id=Integer.parseInt(eid_txf.getText());
			enr.delete(id);}

	  }		
		public static void main(String[] args) {
			Enrollform enr=new Enrollform();
			System.out.println(enr);
		
			
		}

	}
		

	
	
	
