package Menu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import MyRecommendationform.Recommendationform;
import Mycour.courseform;
import Myenrollform.Enrollform;
import Myratingform.Ratingform;
import userform.userform;
public class FormsMenu  extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu usermenu;
    private JMenu recommendationmenu;
    private JMenu coursemenu;
    private JMenu enrollmentmenu;
    private JMenu ratingmenu;
    private JMenu Logoutmenu;
    


	public FormsMenu() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem userItem;
    private JMenuItem recommendationItem;
    private JMenuItem courseItem;
    private JMenuItem enrollmentItem;
    private JMenuItem ratingItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public FormsMenu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        usermenu = new JMenu("user");
        recommendationmenu = new JMenu("recommendation");
        coursemenu= new JMenu("course");
        enrollmentmenu = new JMenu("enrollment ");
        ratingmenu = new JMenu("rating");
        Logoutmenu = new JMenu("Logout");
        		

        // Create menu items
        menuBar.add(usermenu);
        userItem = new JMenuItem("userform");
        userItem.addActionListener(this);
        
        menuBar.add(recommendationmenu);
        recommendationItem = new JMenuItem("Recommendationform");
        recommendationItem.addActionListener(this);
        
        menuBar.add(coursemenu);
        courseItem = new JMenuItem("courseform");
        courseItem.addActionListener(this);
        
        menuBar.add(enrollmentmenu);
        enrollmentItem = new JMenuItem("Enrollform");
        enrollmentItem.addActionListener(this);
        
        menuBar.add(ratingmenu);
        ratingItem = new JMenuItem("Ratingform");
        ratingItem.addActionListener(this);

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        usermenu.add(userItem);
        recommendationmenu.add(recommendationItem);
        coursemenu.add(courseItem);
        enrollmentmenu.add(enrollmentItem);
        ratingmenu.add(ratingItem);
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel with background image
        JPanel dashboardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the image
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\mahoro chany\\Desktop\\New folder\\Bluesky.jpg");
                // Draw the image
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };



        // Initialize dashboard panel
        JPanel dashboardPanel1 = new JPanel();
        dashboardPanel1.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel1.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel1);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == userItem) {
            new userform();
        
        } else if (e.getSource() ==recommendationItem) {
            new Recommendationform();
        
        } else if (e.getSource() == courseItem) {
            new courseform();
       
        } else if (e.getSource() == enrollmentItem) {
           new Enrollform();
        
        } else if (e.getSource() == ratingItem) {
           new Ratingform();
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormsMenu("TO PROJECT"));
    }
}






