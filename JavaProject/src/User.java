import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JScrollPane;
public class User extends JFrame {

	private JPanel contentPane;
	private JTextField Text;
	private JLabel erreur;
	private JLabel r;
	private JScrollPane scrollPane;
	private JLabel word;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
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
	public User() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dictionnaire","root","");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Text = new JTextField();
		Text.setBounds(71, 294, 254, 42);
		contentPane.add(Text);
		Text.setColumns(10);
		
		JButton btnNewButton = new JButton("Rechercher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Text.getText().equals("")) {
					erreur.setText("Champ est vide (Obligatoire !!!) ");
					r.setText("");
				}
				else {
					
					try {
						Manager M = new Manager(conn);
						/*ResultSet r= M.Recherche_etof(Text.getText());
						while(r.next()) {
							System.out.println(r.getString("Traduction"));
						}*/
						Dictionnaire etof = new Dictionnaire(M.Recherche_e(Text.getText()));
						
						Dictionnaire ftoe = new Dictionnaire(M.Recherche_f(Text.getText()));
						if(etof.getText()!=null) {
							r.setText(etof.getText());
							word.setText(Text.getText());
						}else if(ftoe.getText()!=null) {
							r.setText(ftoe.getText());
							word.setText(Text.getText());
						}else {
							r.setText("Mot "+'"'+Text.getText()+'"'+" non trouvé");
							
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(465, 279, 224, 71);
		contentPane.add(btnNewButton);
		
		 erreur = new JLabel("");
		erreur.setFont(new Font("Tahoma", Font.BOLD, 16));
		erreur.setForeground(Color.RED);
		erreur.setBounds(71, 367, 321, 42);
		contentPane.add(erreur);
		 
		 scrollPane = new JScrollPane();
		 scrollPane.setBounds(22, 10, 754, 169);
		 contentPane.add(scrollPane);
		
		 r = new JLabel("Chercher un mot en Francais ou / or searsh a word in English :");
		 r.setFont(new Font("Tahoma", Font.ITALIC, 18));
		 r.setForeground(Color.BLUE);
		 scrollPane.setViewportView(r);
		 
		 word = new JLabel("");
		 word.setForeground(new Color(60, 179, 113));
		 word.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		 word.setBounds(331, 189, 188, 58);
		 contentPane.add(word);
		 
		 JLabel lblNewLabel_1 = new JLabel("Mot");
		 lblNewLabel_1.setForeground(new Color(0, 0, 255));
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		 lblNewLabel_1.setBounds(168, 260, 125, 24);
		 contentPane.add(lblNewLabel_1);
		 
		 btnNewButton_1 = new JButton("<- Retour");
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		user_admin u = new user_admin();
				u.setVisible(true);
		 	}
		 });
		 btnNewButton_1.setBounds(605, 395, 140, 42);
		 contentPane.add(btnNewButton_1);
	}
}
