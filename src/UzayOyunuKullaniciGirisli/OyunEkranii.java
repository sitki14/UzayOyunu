package UzayOyunuKullaniciGirisli;


import java.awt.HeadlessException;
import javax.swing.JFrame;

public class OyunEkranii extends JFrame{
	public OyunEkranii(String title) {
		super(title);
	}

	public static void main(String[] args) {
		OyunEkranii ekran=new OyunEkranii("Uzay Oyunu");
		ekran.setResizable(false);
		ekran.setVisible(true);
		
		//focusu jframe den cekt�k
		ekran.setFocusable(false);
		ekran.setSize(800,600);
		ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Oyun oyun=new Oyun();
		
		//klavye i�lemlerini anlamas� i�in odag� ayarlar
		oyun.requestFocus();
		
		//klayve i�lemlerini anlar implementasyon
		oyun.addKeyListener(oyun);
		
		//art�k focusu jpanele verd�k
		oyun.setFocusable(true);
		
		//klavye i�lemlerini anlamas� i�in gerekli method
		oyun.setFocusTraversalKeysEnabled(false);
		
		//jpanel ekrana eklenir
		ekran.add(oyun);
		
		ekran.setVisible(true);
		
		
		
	
	}

}
