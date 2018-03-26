package UzayOyunuKullaniciGirisli;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
class  User{
	

	private  String kullaniciAdi;
	 private String parola;
	
	public User(String kullaniciAdi, String parola) {
		super();
		this.kullaniciAdi = kullaniciAdi;
		this.parola = parola;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}
}
public class AnaEkran extends JFrame {
	private static ArrayList<User> userList=new ArrayList<User>();
	

	public static ArrayList<User> getUserList() {
		return userList;
	}

	public static void setUserList(ArrayList<User> userList) {
		AnaEkran.userList = userList;
	}

	private JPanel contentPane;
	private JTextField kullaniciAdiTextField;
	private JPasswordField ParolaTextField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaEkran frame = new AnaEkran();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AnaEkran() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(Color.DARK_GRAY);
		registerPanel.setBounds(0, 271, 584, 127);
		contentPane.add(registerPanel);
		registerPanel.setLayout(null);
		
		JButton registerbutton = new JButton("  Register");
		registerbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterEkrani registerEkrani=new RegisterEkrani();
				registerEkrani.setVisible(true);
						
			}
		});
		registerbutton.setBounds(122, 42, 89, 23);
		registerPanel.add(registerbutton);
		
		JButton loginButton = new JButton(" Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kullaniciAdi=kullaniciAdiTextField.getText(); // BURADA TEXTFÝELD ALANINA GÝRÝLEN DEGER LERÝ ALIYORUZ
				String parola=new String (ParolaTextField.getText());
				
				if(userList.size()==0) {
					JOptionPane.showMessageDialog(AnaEkran.this,"Hiçbir kullanýcý bulunmamaktadýr.");
				}else {
					for(User user:userList) {
					
						if(user.getKullaniciAdi().equals(kullaniciAdi)&&user.getParola().equals(parola)) {
							String ref1=kullaniciAdi;
							String ref2=parola;
							
							int i=JOptionPane.showConfirmDialog(AnaEkran.this, "Hoþgeldiniz..." +kullaniciAdi);
							if(i==JOptionPane.OK_OPTION) {
								OyunEkranii oyunekrani=new OyunEkranii("Uzay Oyunuuuu");
								oyunekrani.setResizable(false);
								oyunekrani.setVisible(true);
								
								//focusu jframe den cektýk
								oyunekrani.setFocusable(false);
								oyunekrani.setSize(800,600);
								oyunekrani.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								Oyun oyun=new Oyun();
								
								//klavye iþlemlerini anlamasý için odagý ayarlar
								oyun.requestFocus();
								
								//klayve iþlemlerini anlar implementasyon
								oyun.addKeyListener(oyun);
								
								//artýk focusu jpanele verdýk
								oyun.setFocusable(true);
								
								//klavye iþlemlerini anlamasý için gerekli method
								oyun.setFocusTraversalKeysEnabled(false);
								
								//jpanel ekrana eklenir
								oyunekrani.add(oyun);
								
								oyunekrani.setVisible(true);
								
					//			singleton pattern
								
							}else if(i==JOptionPane.NO_OPTION) {
								System.exit(0);
							}else System.exit(0);
						//	JOptionPane.showMessageDialog(AnaEkran.this, "Hoþgeldiniz..." +kullaniciAdi);
							
							
							
							return ;
						} 
						else if(user.getKullaniciAdi().equals(kullaniciAdi)){
								JOptionPane.showMessageDialog(AnaEkran.this, "Þifreyi tekrar giriniz.");
							}
						}
					}JOptionPane.showMessageDialog(AnaEkran.this, "Böyle bir kullanýcý bulunamamýþtýr.");
				}
				
				
				
			
		});
		loginButton.setBounds(339, 42, 89, 23);
		registerPanel.add(loginButton);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(Color.LIGHT_GRAY);
		loginPanel.setBounds(0, 0, 584, 268);
		contentPane.add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel lblParola = new JLabel("Parola:");
		lblParola.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblParola.setBounds(86, 96, 106, 19);
		loginPanel.add(lblParola);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131:");
		lblKullancAd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblKullancAd.setBounds(86, 51, 106, 19);
		loginPanel.add(lblKullancAd);
		
		kullaniciAdiTextField = new JTextField();
		kullaniciAdiTextField.setBounds(259, 52, 179, 20);
		loginPanel.add(kullaniciAdiTextField);
		kullaniciAdiTextField.setColumns(10);
		
		ParolaTextField = new JPasswordField();
		ParolaTextField.setBounds(259, 96, 179, 19);
		loginPanel.add(ParolaTextField);
	}
}
