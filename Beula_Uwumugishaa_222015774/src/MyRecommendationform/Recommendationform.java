package MyRecommendationform;

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

import MyRecommendation.Recommendation;
import Myratingform.Ratingform;

public class Recommendationform implements ActionListener {

	JFrame frame;
	JLabel rid_lb=new JLabel("recommendationid");
	JLabel rcid_lb=new JLabel("recommendedcourseid");
	JLabel Uid_lb=new JLabel("userid");
	
	

	JTextField rid_txf=new JTextField();
	JTextField rcid_txf=new JTextField();
	JTextField Uid_txf=new JTextField();
	
	

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
	public  Recommendationform() {
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
		frame.setTitle("RECOMMENDATION FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		rid_lb.setBounds(10, 10, 130, 30);
		rcid_lb.setBounds(10, 50, 150, 30);
		Uid_lb.setBounds(10, 110, 170, 50);
		
		
		//ContactNmbr_lb.setBounds(10, 210, 170, 30);
		//gender_lb.setBounds(10, 250, 100, 30);
		
		rid_txf.setBounds(200, 10, 170, 30);
		rcid_txf.setBounds(200, 50, 170, 30);
		Uid_txf.setBounds(200, 90, 170, 30);
		
		
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

		rid_lb.setFont(font);
		rcid_lb.setFont(font);
		Uid_lb.setFont(font);
		
		//Email_lb.setFont(font);
		//genderBox.setFont(font);

		rid_txf.setFont(font);
		rcid_txf.setFont(font);
		Uid_txf.setFont(font);
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(rid_lb);
		frame.add(rcid_lb);
		frame.add(Uid_lb);
		
		
		frame.add(rid_txf);
		frame.add(rcid_txf);
		frame.add(Uid_txf);
		
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Recommendation rec=new Recommendation();
		if(e.getSource()==insert_btn) {
			rec.setRecommendedcourseid(rcid_txf.getText());
			rec.setUserid (Uid_txf.getText());
			rec.insertData();
			
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("recommendedcourseid");
            model.addColumn("userid");
         
           
            ResultSet resultSet =Recommendation.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_tbtn) {
	    	int id=Integer.parseInt(rid_txf.getText());
	    	rec.setRecommendedcourseid(rcid_txf.getText());
			rec.setUserid(Uid_txf.getText());
			
			
			rec.update(id);
	    }
	  else {
			int id=Integer.parseInt(rid_txf.getText());
			rec.delete(id);}

	  }		
		public static void main(String[] args) {
			Recommendationform rec=new Recommendationform();
			System.out.println(rec);
		
			
		}

	}	

