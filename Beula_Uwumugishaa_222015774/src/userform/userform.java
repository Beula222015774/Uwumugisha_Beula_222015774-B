package userform;

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
import Myobject.User;



public class userform implements ActionListener{

	
		JFrame frame;
		JLabel Uid_lb=new JLabel("userid");
		JLabel Uname_lb=new JLabel("username");
		JLabel genlb=new JLabel("gender");
		JLabel eml_lb=new JLabel("email");

		JTextField Uid_txf=new JTextField();
		JTextField Uname_txf=new JTextField();
		JTextField gentxf=new JTextField();
		JTextField eml_txf=new JTextField();

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
		public userform() {
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
			frame.setTitle("USER FORM");
			frame.setBounds(0, 0, w/2, h/2);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.LIGHT_GRAY);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			}

		private void setLocationandSize() {
			Uid_lb.setBounds(10, 10, 130, 30);
			Uname_lb.setBounds(10, 50, 150, 30);
			genlb.setBounds(10, 130, 100, 30);
			eml_lb.setBounds(10, 170, 100, 30);
			//ContactNmbr_lb.setBounds(10, 210, 170, 30);
			//gender_lb.setBounds(10, 250, 100, 30);
			
			Uid_txf.setBounds(200, 10, 170, 30);
			Uname_txf.setBounds(200, 50, 170, 30);
			gentxf.setBounds(200, 130, 170, 30);
			eml_txf.setBounds(200, 170, 170, 30);
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

			Uid_lb.setFont(font);
			Uname_lb.setFont(font);
			genlb.setFont(font);
			eml_lb.setFont(font);
			//Email_lb.setFont(font);
			//genderBox.setFont(font);

			Uid_txf.setFont(font);
			Uname_txf.setFont(font);
			gentxf.setFont(font);
			eml_txf.setFont(font);
		
			//Buttons CRUD
			Font fonti = new Font("Courier New", Font.BOLD, 15);

			insert_btn.setFont(fonti);
			Read_btn.setFont(fonti);
			update_tbtn.setFont(fonti);
			delete_btn.setFont(fonti);

		}
		private void addComponentToFrame() {
			frame.add(Uid_lb);
			frame.add(Uname_lb);
			frame.add(genlb);
			frame.add(eml_lb);
			
			frame.add(Uid_txf);
			frame.add(Uname_txf);
			frame.add(gentxf);
			frame.add(eml_txf);
			
			//Buttons CRUD
			frame.add(insert_btn);
			frame.add(Read_btn);
			frame.add(update_tbtn);
			frame.add(delete_btn);
			frame.add(table);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
		 User use=new User();
			if(e.getSource()==insert_btn) {
				use.setUsername(Uname_txf.getText());
				use.setGender(gentxf.getText());
				use.setEmail(eml_txf.getText());
				use.insertData();
				
				
			}else if (e.getSource() == Read_btn) {
				model.setColumnCount(0);
				model.setRowCount(1);
				model.addColumn("userid");
	            model.addColumn("username");
	            model.addColumn("gender");
	            model.addColumn("email");
	            
	           
	            ResultSet resultSet =User.viewData();
	            if (resultSet != null) {
	                try {
	                    while (resultSet.next()) {
	                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
	                                resultSet.getString(3), resultSet.getString(4)});
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        }
		    else if (e.getSource()==update_tbtn) {
		    	int id=Integer.parseInt(Uid_txf.getText());
		    	use.setUsername(Uname_txf.getText());
				use.setEmail(eml_txf.getText());
				use.setGender(gentxf.getText());
				
				
				use.update(id);
		    }
		  else {
				int id=Integer.parseInt(Uid_txf.getText());
				use.delete(id);}

		  }		
			public static void main(String[] args) {
				userform use=new userform();
				System.out.println(use);
			
				
			}

		}