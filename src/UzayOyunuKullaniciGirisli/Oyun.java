package UzayOyunuKullaniciGirisli;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

class Ates{
	private int x; //bu atesin x ve y koordinatý olacak her action perdomed calýstýgýnda top ilerler
	private int y;
	public Ates(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	}

public class Oyun extends JPanel implements KeyListener ,ActionListener{
	AnaEkran anaekran=new AnaEkran();
	
	Timer timer=new Timer(5, this); // timer 2 tane deger bekliyo 1. kac saniyede 1 calýsýyor 2. deger 
	private int gecenSure=0;
	private int harcananAtes=0;
	private BufferedImage image;
	private ArrayList<Ates> atesler=new ArrayList<Ates>(); 
	
	//ATESLER YUKARI DOGRU GIDECEKLER HER TÝME CALISTIGINDA 1 ÝLERÝ GÖTÜRMEK GEREKECEK 
	private int atesdirY=1;
	
	//BU DA SAGA VE SOLA GÝTMEYÝ SAGLAYACAK
	private int topX=0;
	
	// BU DA TOPX E EKLENEREK YANAL HAREKET SAGLAYACAK sagda belli býr limite carptýgýnda sola yönelecek
	private int topdirX=2;
	
	//UZAY GEMÝSÝ ALT SAGDAN BASLATILMASI SAGLANACAK
	private int uzayGemisiX=0;
	//private int uzayGemisiY=490;
	private int ref=490;
	private int dirref=5;
	//KLAVYE DE  SAGA BAILDIGINDA UZAY GEMÝSÝ YANAL HAREKET YAPACAK UZAYGEMÝSÝX E EKLENECEK 
	private int dirUzayX=20; 
	
	
	public boolean kontrolEt() {
		//bizim atesýmýz topa carparsa true doncecek 
		for(Ates ates:atesler) { 
			//iki tane rectangle olusturup koordýnat ve boyut olarak ates ve top un degerlerini veririrz 
			//zaten intersect fonksiyonu kesiþmesini true veya false olarak kontrol eder.
			if(new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle(topX, 0, 20, 20))) {// 1 carpýsma olursa true olur ve if in içine girer
				return true;
			}
		}
		return false;
	}
	 public Oyun() {
		try {
			image =ImageIO.read(new FileImageInputStream(new File("uzayGemisi.png")));
		} catch (IOException e) {
			
			System.out.println("uzay gemisi bulunamadý");
		}
		setBackground(Color.yellow);
		//oyun cons u basladýktan sonra týmer ý baslatmak ýstýyoruz
		timer.start();
		//timer baþladýðýnda her 5 ms de 1 action perfomed kendilipinden calýsacak ve iþlemlerimizi yapacak
		
	}
	@Override
	public void repaint() {
		// painti tekrar cagýrýr sekýllerý tekrar olusturur.
		super.repaint();

	}
	public void paint(Graphics g) {
		gecenSure+=5;
		super.paint(g);
		g.setColor(Color.green); //topun rengi
		g.fillOval(topX, 0, 20, 20); //topun þekli her harekette güncellenecek 
		
			g.drawImage(image, uzayGemisiX, ref,image.getWidth()/10,image.getHeight()/10,Oyun.this);//uzay gemisi olusturuldu
			
			for(Ates ates:atesler) {//ates frame den cýkýnca yaný y koordinatý (-) olmussa atesi atesler listesýnden silmemýz gerekir
				if(ates.getY()<0) {
					atesler.remove(ates);
				}
		}
			
			g.setColor(Color.BLACK);//atesler býrden fazla oldugu ýcýn for ýle cýzeriz
			for(Ates ates:atesler){
				g.fillOval(ates.getX(),ates.getY(), 5, 5);
			}
			
			if(kontrolEt()) {
				timer.stop();
				
				
				String mesaj="Tebrikler Dostum  Kazandýn...\n"
						+ "Haracanan Ateþ: "+harcananAtes+
						"\nGeçen Süre : " +gecenSure/1000.0+" sn";
				
				
			
				theEndForm end=new theEndForm();
				
				end.setVisible(true);
				
				
				
				
		//		JOptionPane.showMessageDialog(this, mesaj);
		//		JOptionPane.showConfirmDialog(this, mesaj);
				
				
				
			}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for(Ates ates:atesler) {	//action perfomed her calýstýogýnda y koordinatý 1 artýrýrýz
			ates.setY(ates.getY()-atesdirY); //atesin yukarý dogru cýkmasýný saglamak için
		}
		
		 //hedefteki topun sag ve sol olarak yanal hareket etmeýný 
		//saglar ve top ekran boyutunun sonuna gelmýsse orada geri doner ve sonsuz býr donguye gýrer.
		topX+=topdirX;
		if(topX>=750) {
			topdirX=-topdirX;
		}
		if(topX<=0) {
			topdirX=-topdirX;
		}
	
		repaint();
		//her action perfomed calýstýgýnda repaint ýn de calýsmasý gerekir repaint calýstýogý zamand paint'i otomatýk olarak calýstýrýr
		
		
		
		
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c=e.getKeyCode();// bu bize sol veya sag a basýlýnca deger donecek
		if(c==KeyEvent.VK_A) {
			//SOLA BASILINCA 20 BIRIM SOLA GÝDECEÐÝZ
			if(uzayGemisiX<=0){
				uzayGemisiX=0;
			}else {
				uzayGemisiX-=dirUzayX;
			}
		}else if(c==KeyEvent.VK_D ) {
			System.out.println("merhaba");
			if(uzayGemisiX>=750) {
				uzayGemisiX=750;
			}else {
				uzayGemisiX+=dirUzayX;
			}
		}
		else if(c==KeyEvent.VK_W) {
			ref-=dirref;
		}else if(c==KeyEvent.VK_S) {
			ref+=dirref;
		}
		else if(c==KeyEvent.VK_CONTROL) {
			//ates olusturmamsýz gerelkiyor
			atesler.add(new Ates(uzayGemisiX+15, ref));
			harcananAtes++; //her ctrl ye basýldýgýnda harcanan ates sayýsý artar
			
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	
	
	
}
