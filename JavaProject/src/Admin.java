import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField mot;
	private JTextField traduction;
	private JLabel cv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Admin() throws SQLException {
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dictionnaire","root","");
		Manager m= new Manager(conn);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton insert_etof = new JButton("Inser English");
		insert_etof.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					m.Inserer_e(mot.getText(), traduction.getText());
					cv.setText("Insert succefulyy");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		insert_etof.setBounds(88, 57, 141, 21);
		contentPane.add(insert_etof);
		
		JButton delete_etof = new JButton("Delete English");
		delete_etof.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					m.Delete_e(mot.getText());
					cv.setText("Deleted succefully");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		delete_etof.setBounds(245, 57, 161, 21);
		contentPane.add(delete_etof);
		
		JButton Upadte_etof = new JButton("Upadte English");
		Upadte_etof.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					m.Modifier_e(mot.getText(), traduction.getText());
					cv.setText("Modified succefully");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Upadte_etof.setBounds(416, 57, 186, 21);
		contentPane.add(Upadte_etof);
		
		mot = new JTextField();
		mot.setBounds(150, 161, 150, 33);
		contentPane.add(mot);
		mot.setColumns(10);
		
		traduction = new JTextField();
		traduction.setBounds(383, 163, 219, 70);
		contentPane.add(traduction);
		traduction.setColumns(10);
		
		JButton insert_ftoe = new JButton("Insert Francais");
		insert_ftoe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					m.Inserer_f(mot.getText(), traduction.getText());
					cv.setText("Insert succefulyy");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		insert_ftoe.setBounds(88, 265, 141, 21);
		contentPane.add(insert_ftoe);
		
		JButton btnNewButton_1 = new JButton("Delete Francais");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					m.Delete_f(mot.getText());
					cv.setText("Deleted succefully");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(245, 265, 161, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update Francais");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					m.Modifier_f(mot.getText(), traduction.getText());
					cv.setText("Modified succefully");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(416, 265, 186, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Mot");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(204, 124, 72, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Traduction");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(435, 131, 108, 13);
		contentPane.add(lblNewLabel_1);
		
		 cv = new JLabel("");
		cv.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		cv.setForeground(new Color(50, 205, 50));
		cv.setBounds(148, 341, 330, 90);
		contentPane.add(cv);
		
		JButton btnNewButton = new JButton("<-Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_admin u = new user_admin();
				u.setVisible(true);
			}
		});
		btnNewButton.setBounds(488, 381, 122, 50);
		contentPane.add(btnNewButton);
	}
}
