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
		
		//focusu jframe den cektýk
		ekran.setFocusable(false);
		ekran.setSize(800,600);
		ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		ekran.add(oyun);
		
		ekran.setVisible(true);
		
		
		
	
	}

}
