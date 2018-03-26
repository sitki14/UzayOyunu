package UzayOyunuKullaniciGirisli;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;

public class KayitEkrani extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> model=new DefaultListModel<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KayitEkrani frame = new KayitEkrani();
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
	public KayitEkrani() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 454);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList siralamaListesi = new JList();
		siralamaListesi.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		siralamaListesi.setBounds(10, 111, 494, 279);
		contentPane.add(siralamaListesi);
		
		JButton btnOyunaBala = new JButton("Oyuna Ba\u015Fla");
		btnOyunaBala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				oyunekrani.getContentPane().add(oyun);
				
				oyunekrani.setVisible(true);
				
				
			}
		});
		btnOyunaBala.setBounds(27, 51, 135, 23);
		contentPane.add(btnOyunaBala);
		
		JButton btnNewButton = new JButton("\u00C7IKI\u015E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(338, 51, 145, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Listeyi G\u00FCncelle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s="merhaba";
				AnaEkran a=new AnaEkran();
				
				
				siralamaListesi.setModel(model);
				model.addElement(s);
			}
		});
		btnNewButton_1.setBounds(159, 11, 179, 36);
		contentPane.add(btnNewButton_1);
	}
}
