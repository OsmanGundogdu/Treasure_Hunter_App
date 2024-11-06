package Prolab2_1;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.JPanel;
public class Arayuz extends JPanel implements ActionListener, KeyListener {
	ImageIcon dag = new ImageIcon("C:\\Users\\osman1\\Desktop\\Prolab\\Prolab - II\\prolab2 - 1\\dag.jpg");
	ImageIcon dag_kis = new ImageIcon("C:\\Users\\osman1\\Desktop\\Prolab\\Prolab - II\\prolab2 - 1\\dag_kis.jpg");
	ImageIcon kaya = new ImageIcon("C:\\Users\\osman1\\Desktop\\Prolab\\Prolab - II\\prolab2 - 1\\kaya.jpg");
	ImageIcon kaya_kis = new ImageIcon("C:\\Users\\osman1\\Desktop\\Prolab\\Prolab - II\\prolab2 - 1\\kaya_kis.jpg");
	ImageIcon agac = new ImageIcon("C:\\Users\\osman1\\Desktop\\Prolab\\Prolab - II\\prolab2 - 1\\agac.jpg");
	ImageIcon agac_kis = new ImageIcon("C:\\Users\\osman1\\Desktop\\Prolab\\Prolab - II\\prolab2 - 1\\agac_kis.jpg");
	ImageIcon duvar = new ImageIcon("C:\\Users\\osman1\\Desktop\\Prolab\\Prolab - II\\prolab2 - 1\\duvar.jpg");
	ImageIcon duvar_kis = new ImageIcon("C:\\Users\\osman1\\Desktop\\Prolab\\Prolab - II\\prolab2 - 1\\duvar_kis.jpg");
	ImageIcon arka_plan_yaz = new ImageIcon("C:\\Users\\osman1\\Desktop\\Prolab\\Prolab - II\\prolab2 - 1\\yaz3.png");
	ImageIcon arka_plan_kis = new ImageIcon("C:\\Users\\osman1\\Desktop\\Prolab\\Prolab - II\\prolab2 - 1\\kis3.png");
	ImageIcon altin_sandik = new ImageIcon("C:\\Users\\osman1\\Desktop\\Prolab\\Prolab - II\\prolab2 - 1\\altin_sandik.jpg");
	ImageIcon gumus_sandik = new ImageIcon("C:\\Users\\osman1\\Desktop\\Prolab\\Prolab - II\\prolab2 - 1\\gumus_sandik.jpg");
	ImageIcon zumrut_sandik = new ImageIcon("C:\\Users\\osman1\\Desktop\\Prolab\\Prolab - II\\prolab2 - 1\\zumrut_sandik.jpg");
	ImageIcon bakir_sandik = new ImageIcon("C:\\Users\\osman1\\Desktop\\Prolab\\Prolab - II\\prolab2 - 1\\bakir_sandik.jpg");
	ImageIcon kus = new ImageIcon("C:\\Users\\osman1\\Desktop\\Prolab\\Prolab - II\\prolab2 - 1\\kus.jpeg");
	ImageIcon ari = new ImageIcon("C:\\Users\\osman1\\Desktop\\Prolab\\Prolab - II\\prolab2 - 1\\ari.jpg");
	Karakter karakter;
	ArrayList<Sabit> sabitler = new ArrayList<>();
	ArrayList<Dinamik> dinamikler = new ArrayList<>();
	Timer oyunDongusu;
	int karoBoyutu = 10;
	int genislik;
	int yukseklik;
	int hizX = 0;
	int hizY = 0;
	public Arayuz (int genislik, int yukseklik, int karoBoyutu)
	{
		this.genislik = genislik;
		this.yukseklik = yukseklik;
		this.karoBoyutu = karoBoyutu;
	}

	Random random = new Random();
	int a = random.nextInt(2) + 1;

	public Arayuz (int genislik, int yukseklik) {

		this.genislik = genislik;
		this.yukseklik = yukseklik;
		this.setPreferredSize(new Dimension(this.genislik, this.yukseklik));
		this.setDoubleBuffered(true);
		setBackground(Color.black);
		addKeyListener(this);
		setFocusable(true);

		karakter = new Karakter(random.nextInt(100), random.nextInt(80), 1, "Mario",1,1);

		for (int i = 0; i < 3; i++) // Dag
			sabitler.add(new Sabit(3));
		for (int i = 0; i < 6; i++) // Agac
			sabitler.add(new Sabit(1));
		for (int i = 0; i < 5; i++) // Kaya
			sabitler.add(new Sabit(2));
		for (int i = 0; i < 6; i++) // Duvar
			sabitler.add(new Sabit(4));
		for (int i = 0; i < 6; i++) // Altin
			sabitler.add(new Sabit(5));
		for (int i = 0; i < 6; i++) // Gumus
			sabitler.add(new Sabit(6));
		for (int i = 0; i < 6; i++) // Zumrut
			sabitler.add(new Sabit(7));
		for (int i = 0; i < 6; i++) // Bakir
			sabitler.add(new Sabit(8));
		for (int i = 1; i <= a; i++) // ari
			dinamikler.add(new Dinamik(1));
		for (int i = 1; i <= (3 - a); i++)
			dinamikler.add(new Dinamik(2));

		if (karakter_baslangic_collision(karakter, sabitler))
			karakter = new Karakter(random.nextInt(100), random.nextInt(80), 1, "Mario",1,1);

		oyunDongusu = new Timer(100, this);
		oyunDongusu.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(arka_plan_kis.getImage(), 0, 0, 500, 800, null);
		g.drawImage(arka_plan_yaz.getImage(), 500, 0, 500, 800, null);
		draw(g);
	}
	public void draw(Graphics g) {
		for(int i = 0; i < genislik/karoBoyutu; i++) {
			g.drawLine(i*karoBoyutu, 0, i*karoBoyutu, yukseklik);
			g.drawLine(0, i*karoBoyutu, genislik, i*karoBoyutu);
		}

		g.setColor(Color.red);
		g.fillRect(karakter.getX()*karoBoyutu, karakter.getY()*karoBoyutu, karoBoyutu, karoBoyutu);

		int b;

		for (int i = 0; i < 40; i++) {
			ust_uste_gelme_collision();
			if (i >= 0 && i < 3)
			{
				if (sabitler.get(i).x*karoBoyutu >= (500 - karoBoyutu*7))
					g.drawImage(dag.getImage(),sabitler.get(i).x * karoBoyutu, sabitler.get(i).y * karoBoyutu, sabitler.get(i).width * karoBoyutu, sabitler.get(i).height * karoBoyutu, null);
				else
					g.drawImage(dag_kis.getImage(),sabitler.get(i).x * karoBoyutu, sabitler.get(i).y * karoBoyutu, sabitler.get(i).width * karoBoyutu, sabitler.get(i).height * karoBoyutu, null);
			}
			else if (i > 2 && i < 9)
			{
				if (sabitler.get(i).x*karoBoyutu >= (500 - karoBoyutu*2))
					g.drawImage(agac.getImage(),sabitler.get(i).x * karoBoyutu, sabitler.get(i).y * karoBoyutu, sabitler.get(i).width * karoBoyutu, sabitler.get(i).height * karoBoyutu, null);
				else
					g.drawImage(agac_kis.getImage(),sabitler.get(i).x * karoBoyutu, sabitler.get(i).y * karoBoyutu, sabitler.get(i).width * karoBoyutu, sabitler.get(i).height * karoBoyutu, null);
			}
			else if (i > 8 && i < 14)
			{
				if (sabitler.get(i).x*karoBoyutu >= (500 - karoBoyutu*1))
					g.drawImage(kaya.getImage(),sabitler.get(i).x * karoBoyutu, sabitler.get(i).y * karoBoyutu, sabitler.get(i).width * karoBoyutu, sabitler.get(i).height * karoBoyutu, null);
				else
					g.drawImage(kaya_kis.getImage(),sabitler.get(i).x * karoBoyutu, sabitler.get(i).y * karoBoyutu, sabitler.get(i).width * karoBoyutu, sabitler.get(i).height * karoBoyutu, null);
			}
			else if (i > 13 && i < 20)
			{
				if (sabitler.get(i).x*karoBoyutu >= (500 - karoBoyutu*5))
					g.drawImage(duvar.getImage(),(sabitler.get(i).x + 1) * karoBoyutu, (sabitler.get(i).y  + 1) * karoBoyutu, (sabitler.get(i).width - 2) * karoBoyutu, (sabitler.get(i).height - 2) * karoBoyutu, null);
				else
					g.drawImage(duvar_kis.getImage(),(sabitler.get(i).x + 1) * karoBoyutu, (sabitler.get(i).y  + 1)* karoBoyutu, (sabitler.get(i).width - 2) * karoBoyutu, (sabitler.get(i).height - 2) * karoBoyutu, null);
			}
			else if (i > 19 && i < 25)
			{
				if (sandik_toplama_collision(karakter, sabitler.get(i)) && !sabitler.get(i).collected) {
					String toplanan_sandik = "altin sandik toplandi" + "( " + sabitler.get(i).x + " , " + sabitler.get(i).y + " ) konumunda bulundu.";
					System.out.println(toplanan_sandik);
					sabitler.get(i).collected = true;
					g.setColor(Color.BLACK);
					g.setFont(new Font("Arial", Font.BOLD, 14));
					g.drawString(toplanan_sandik, 620, 15);
				}
				else
					if (!sabitler.get(i).collected)
						g.drawImage(altin_sandik.getImage(),sabitler.get(i).x * karoBoyutu, sabitler.get(i).y * karoBoyutu, sabitler.get(i).width * karoBoyutu, sabitler.get(i).height * karoBoyutu, null);
			}
			else if (i > 24 && i < 30)
			{
				if (sandik_toplama_collision(karakter, sabitler.get(i)) && !sabitler.get(i).collected) {
					String toplanan_sandik = "gumus sandik toplandi" + "( " + sabitler.get(i).x + " , " + sabitler.get(i).y + " ) konumunda bulundu.";
					System.out.println(toplanan_sandik);
					sabitler.get(i).collected = true;
					g.setColor(Color.BLACK);
					g.setFont(new Font("Arial", Font.BOLD, 14));
					g.drawString(toplanan_sandik, 620, 15);
				}
				else
					if (!sabitler.get(i).collected)
						g.drawImage(gumus_sandik.getImage(),sabitler.get(i).x * karoBoyutu, sabitler.get(i).y * karoBoyutu, sabitler.get(i).width * karoBoyutu, sabitler.get(i).height * karoBoyutu, null);
			}
			else if (i > 29 && i < 35)
			{
				if (sandik_toplama_collision(karakter, sabitler.get(i)) && !sabitler.get(i).collected) {
					String toplanan_sandik =  "zumrut sandik toplandi" + "( " + sabitler.get(i).x + " , " + sabitler.get(i).y + " ) konumunda bulundu.";
					System.out.println(toplanan_sandik);
					sabitler.get(i).collected = true;
					g.setColor(Color.BLACK);
					g.setFont(new Font("Arial", Font.BOLD, 14));
					g.drawString(toplanan_sandik, 620, 15);
				}
				else
					if (!sabitler.get(i).collected)
						g.drawImage(zumrut_sandik.getImage(),sabitler.get(i).x * karoBoyutu, sabitler.get(i).y * karoBoyutu, sabitler.get(i).width * karoBoyutu, sabitler.get(i).height * karoBoyutu, null);
			}
			else if (i > 34 && i < 40) {
				if (sandik_toplama_collision(karakter, sabitler.get(i)) && !sabitler.get(i).collected) {
					String toplanan_sandik = "bakir sandik toplandi" + "( " + sabitler.get(i).x + " , " + sabitler.get(i).y + " ) konumunda bulundu.";
					System.out.println(toplanan_sandik);
					sabitler.get(i).collected = true;
					g.setColor(Color.BLACK);
					g.setFont(new Font("Arial", Font.BOLD, 14));
					g.drawString(toplanan_sandik, 620, 15);
				}
				else
					if (!sabitler.get(i).collected)
						g.drawImage(bakir_sandik.getImage(), sabitler.get(i).x * karoBoyutu, sabitler.get(i).y * karoBoyutu, sabitler.get(i).width * karoBoyutu, sabitler.get(i).height * karoBoyutu, null);
			}
		}
		for (int i = 0; i < 3; i++)
		{
			dinamikler_collision(dinamikler,sabitler);
			b = i +1;
			if (b <= a)
				g.drawImage(ari.getImage(), dinamikler.get(i).x * karoBoyutu, dinamikler.get(i).y * karoBoyutu, dinamikler.get(i).width * karoBoyutu, dinamikler.get(i).height * karoBoyutu, null);
			else
				g.drawImage(kus.getImage(), dinamikler.get(i).x * karoBoyutu, dinamikler.get(i).y * karoBoyutu, dinamikler.get(i).width * karoBoyutu, dinamikler.get(i).height * karoBoyutu, null);
		}
	}
	public boolean karakter_baslangic_collision(Karakter karakter, ArrayList<Sabit> sabitler) {
		boolean carpisma_var_mi = false;
		for (int i = 1; i < 40; i++)
		{
			carpisma_var_mi = ((karakter.getX() >= sabitler.get(i).x && karakter.getX() <= sabitler.get(i).x + sabitler.get(i).width) && (karakter.getY() >= sabitler.get(i).y && karakter.getY() <= sabitler.get(i).y + sabitler.get(i).height));
			return carpisma_var_mi;
		}
		return false;

	}
	public void dinamikler_collision(ArrayList<Dinamik> dinamikler, ArrayList<Sabit> sabitler) {
		boolean carpisma_var_mi = false;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 40; j++)
			{
				carpisma_var_mi = ((dinamikler.get(i).x >= sabitler.get(j).x -1 && dinamikler.get(i).x <= sabitler.get(j).x + sabitler.get(j).width) && (dinamikler.get(i).y >= sabitler.get(j).y - 1 && dinamikler.get(i).y <= sabitler.get(j).y + sabitler.get(j).height));
				if (carpisma_var_mi)
					dinamikler.set(i, new Dinamik(1));
			}
		}
	}
	int x = 3;
	private void ust_uste_gelme_collision() {
		for (int i = 0; i < 40; i++)
		{
			for (int j = i + 1; j < 40; j++)
			{
				if (sabitler.get(i).intersects(sabitler.get(j)))
				{
					if (j < 9 && j > 2)
						x = 1;
					else if (j > 8 && j < 14)
						x = 2;
					else if (j > 13 && j < 20)
						x = 4;
					else if (j > 19 && j < 25)
						x = 5;
					else if (j > 24 && j < 30)
						x = 6;
					else if (j > 29 && j < 35)
						x = 7;
					else if (j > 34 && j < 40)
						x = 8;
					sabitler.set(j, new Sabit(x));
					ust_uste_gelme_collision();
				}
			}
		}
	}

	public boolean karakter_engele_carpma_collision(Karakter karakter, ArrayList<Sabit> sabitler, int newX, int newY) {
		for (int i = 0; i < 20; i++) {
			if (sandik_toplama_collision(new Karakter(newX, newY,1 ,"Mario",karakter.getWidth(), karakter.getHeight()), sabitler.get(i))) {
				return false;
			}
		}
		return false;
	}

	public boolean sandik_toplama_collision(Karakter karakter, Sabit sabit) {
		return 	 ((karakter.getX() >= sabit.x && karakter.getX() <= sabit.x + 1) && (karakter.getY() >= sabit.y && karakter.getY() <= sabit.y + 1));
	}

	public void hedef_belirle() {
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Sabit enYakinSandik = null;
		double enKisaMesafe = Double.MAX_VALUE;

		for (int i = 20; i < 40; i++) {
			Sabit sandik = sabitler.get(i);
			double mesafe = Math.sqrt(Math.pow(karakter.getX() - sandik.x, 2) + Math.pow(karakter.getY() - sandik.y, 2));
			if (!sandik.collected && mesafe < enKisaMesafe) {
				enKisaMesafe = mesafe;
				enYakinSandik = sandik;
			}
		}

		if (enYakinSandik != null) {
			if (karakter.getX() < enYakinSandik.x) {
				hizX = 1;
			} else if (karakter.getX() > enYakinSandik.x) {
				hizX = -1;
			} else {
				hizX = 0;
			}

			if (karakter.getY() < enYakinSandik.y) {
				hizY = 1;
			} else if (karakter.getY() > enYakinSandik.y) {
				hizY = -1;
			} else {
				hizY = 0;
			}
		}
		// ekranin yukarisi kontrol
		if (karakter.getY() - 1 >= 0) {
			karakter.setY(karakter.getY() - 1);
		}
		// ekranin asagisi kontrol
		if (karakter.getY() + 1 < yukseklik / karoBoyutu) {
			karakter.setY(karakter.getY() + 1);
		}
		// ekranin sagi kontrol
		if (karakter.getX() + 1 < genislik / karoBoyutu) {
			karakter.setX(karakter.getX() + 1);
		}
		// ekranin solu kontrol
		if (karakter.getX() - 1 >= 0) {
			karakter.setX(karakter.getX() - 1);
		}
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void hareketEt() {
		if (!karakter_engele_carpma_collision(karakter, sabitler, karakter.getX() + hizX, karakter.getY())) {
			karakter.setX(karakter.getX() + hizX);
		}
		if (!karakter_engele_carpma_collision(karakter, sabitler, karakter.getX(), karakter.getY() + hizY)) {
			karakter.setY(karakter.getY() + hizY);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void actionPerformed(ActionEvent e) {
		hedef_belirle();
		hareketEt();
		repaint();
	}
}