package UzayOyunuKullaniciGirisli;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class theEndForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					theEndForm frame = new theEndForm();
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
	public theEndForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 304);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(250, 240, 230));
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		
		JLabel mesajKutusu = new JLabel("");
		mesajKutusu.setBounds(92, 87, 226, 43);
		contentPane.add(mesajKutusu);
		
		JLabel lblTebriklerKazandnz = new JLabel("Tebrikler Kazand\u0131n\u0131z");
		lblTebriklerKazandnz.setFont(new Font("Old English Text MT", Font.BOLD, 16));
		lblTebriklerKazandnz.setBounds(141, 33, 153, 14);
		contentPane.add(lblTebriklerKazandnz);
		
		JButton btnTekrarOyna = new JButton("Tekrar Oyna");
		btnTekrarOyna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OyunEkranii oyunekrani=new OyunEkranii("Uzay Oyunu");
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
				oyunekrani.getContentPane().add(oyun);
				
				
				oyunekrani.setVisible(true);
				
			}
		});
		btnTekrarOyna.setBackground(new Color(46, 139, 87));
		btnTekrarOyna.setFont(new Font("Snap ITC", Font.BOLD, 12));
		btnTekrarOyna.setBounds(141, 157, 153, 43);
		contentPane.add(btnTekrarOyna);
		
		JButton btnk = new JButton("\u00C7\u0131k\u0131\u015F");
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnk.setBackground(new Color(160, 82, 45));
		btnk.setForeground(new Color(255, 0, 0));
		btnk.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		btnk.setBounds(291, 212, 110, 23);
		contentPane.add(btnk);
		
		JButton btnListeyiGrntle = new JButton("Listeyi G\u00F6r\u00FCnt\u00FCle");
		btnListeyiGrntle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KayitEkrani ke=new KayitEkrani();
				DefaultListModel<String> model=new DefaultListModel<String>();
				model.addElement("selam ben deneme metini");
				ke.setVisible(true);
				setVisible(false);
				
			}
		});
		btnListeyiGrntle.setBackground(new Color(139, 69, 19));
		btnListeyiGrntle.setForeground(new Color(0, 0, 139));
		btnListeyiGrntle.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		btnListeyiGrntle.setBounds(10, 212, 130, 23);
		contentPane.add(btnListeyiGrntle);
		
		
		
	
	//	textField.setText(mesaj);
	}
}
