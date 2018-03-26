package UzayOyunuKullaniciGirisli;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class RegisterEkrani extends JFrame {

	private JPanel contentPane;
	private JTextField kullanici_Adi;
	private JTextField parola_Alani;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterEkrani frame = new RegisterEkrani();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterEkrani() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel register_Panel = new JPanel();
		register_Panel.setBackground(SystemColor.activeCaption);
		register_Panel.setBounds(-10, 0, 636, 419);
		contentPane.add(register_Panel);
		register_Panel.setLayout(null);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131:");
		lblKullancAd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblKullancAd.setBounds(117, 230, 123, 21);
		register_Panel.add(lblKullancAd);
		
		JLabel lblParola = new JLabel("Parola:");
		lblParola.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblParola.setBounds(117, 286, 123, 21);
		register_Panel.add(lblParola);
		
		kullanici_Adi = new JTextField();
		kullanici_Adi.setBounds(257, 232, 157, 21);
		register_Panel.add(kullanici_Adi);
		kullanici_Adi.setColumns(10);
		
		parola_Alani = new JTextField();
		parola_Alani.setColumns(10);
		parola_Alani.setBounds(257, 288, 157, 21);
		register_Panel.add(parola_Alani);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kullaniciAdi=kullanici_Adi.getText();
				String parola=parola_Alani.getText();
				
				ArrayList<User> user_list=AnaEkran.getUserList();
				user_list.add(new User(kullaniciAdi, parola));
				setVisible(false);
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnRegister.setBounds(325, 354, 89, 23);
		register_Panel.add(btnRegister);
		
		JLabel lblAd = new JLabel("Ad:");
		lblAd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAd.setBounds(117, 66, 46, 14);
		register_Panel.add(lblAd);
		
		textField = new JTextField();
		textField.setBounds(257, 65, 157, 20);
		register_Panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblSoyad = new JLabel("Soyad:");
		lblSoyad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblSoyad.setBounds(117, 119, 89, 14);
		register_Panel.add(lblSoyad);
		
		textField_1 = new JTextField();
		textField_1.setBounds(257, 118, 157, 20);
		register_Panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEnSevdiinizRenk = new JLabel("En Sevdi\u011Finiz Renk:");
		lblEnSevdiinizRenk.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblEnSevdiinizRenk.setBounds(117, 177, 134, 14);
		register_Panel.add(lblEnSevdiinizRenk);
		
		textField_2 = new JTextField();
		textField_2.setBounds(257, 176, 157, 20);
		register_Panel.add(textField_2);
		textField_2.setColumns(10);
	}
}
