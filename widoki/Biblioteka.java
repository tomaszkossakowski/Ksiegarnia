package widoki;

import bazaDanych.dao.KsiazkaDAO;
import bazaDanych.dao.impl.KsiazkaDAOImpl;
import bazaDanych.encje.Ksiazka;
import bazaDanych.encje.Uzytkownik;
import controller_widokow.BibliotekaController;
import controller_widokow.UserAuth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Biblioteka extends JFrame {
	private JButton dodaj, wyszukaj, wypozycz, oddaj, mojeKsiazki;
	private JTextField dodajTytulPole, dodajAutorPole, dodajIloscPole, wyszukajKsUzPole;
	private JLabel dodajT, autorL, iloscL, wyszukajKsiazWysz;
	private JComboBox combo;

	DefaultListModel<Ksiazka> modelListyWszystkichKsiazek, modelListyWypozyczonychKsiazek, DefaultListModel;
	JList<Ksiazka> listaWszyskichKsiazek, listaKsiazekDoOddania, testowa;
	BibliotekaController bibliotekaController;
	List<Ksiazka> listaWszystkichKsiazek, listaWypozyczonychKsiazek, test;
	KsiazkaDAO ksiazkaDAO;
	UserAuth uzytkownik;

	public Biblioteka() {
		super("Biblioteka");
		ksiazkaDAO = new KsiazkaDAOImpl();
		Ksiazka ksi = new Ksiazka();
		bibliotekaController = new BibliotekaController();

		initListaWszstkichKsiazek();

		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();

		panel1.setBorder(BorderFactory.createTitledBorder("Dodaj ksiazke"));

		panel1.setSize(100, 200);
		panel1.setLayout(null);
		panel1.setBounds(70, 200, 220, 230);

		modelListyWszystkichKsiazek = new DefaultListModel<>();

		dodajModelWszyskichKsiazek();

		listaWszyskichKsiazek = new JList<>(modelListyWszystkichKsiazek);

//		List<Ksiazka> listaWypozyczonychKsiazek = new ArrayList<>();
//		listaWypozyczonychKsiazek = bibliotekaController.getListaWypozyczonychKsiazek(UserAuth.zalogowanyUzytkownik);
//		DefaultListModel<Ksiazka> lista = new DefaultListModel<>();
//
//		for (Ksiazka k : listaWypozyczonychKsiazek) {
//			lista.addElement(k);
//		}
//
//		JList<Ksiazka> listaWypozyczonych = new JList<>(lista);
//		listaWypozyczonych = new JList<>(lista);

		dodaj = new JButton("dodaj");
		dodaj.setBounds(70, 180, 90, 30);

		dodajTytulPole = new JTextField();
		dodajTytulPole.setBounds(70, 60, 100, 20);

		dodajAutorPole = new JTextField();
		dodajAutorPole.setBounds(dodajTytulPole.getBounds().x, 100, 100, 20);

		dodajIloscPole = new JTextField();
		dodajIloscPole.setBounds(dodajTytulPole.getBounds().x, 140, 100, 20);

		dodajT = new JLabel("tytul");
		dodajT.setBounds(30, dodajTytulPole.getBounds().y, 100, 20);

		autorL = new JLabel("autor");
		autorL.setBounds(dodajT.getBounds().x, dodajAutorPole.getBounds().y, 100, 20);

		iloscL = new JLabel("iloœæ");
		iloscL.setBounds(dodajT.getBounds().x, dodajIloscPole.getBounds().y, 100, 20);

		panel1.add(dodaj);
		panel1.add(dodajTytulPole);
		panel1.add(dodajAutorPole);
		panel1.add(dodajIloscPole);
		panel1.add(dodajT);
		panel1.add(autorL);
		panel1.add(iloscL);
		add(panel1);

		panel2.setBorder(BorderFactory.createTitledBorder("Wyszukaj ksiazke"));

		panel2.setLayout(null);
		panel2.setSize(100, 200);
		panel2.setBounds(340, 20, 330, 300);

		wyszukaj = new JButton("Wyszukaj");
		wyszukaj.setBounds(25, 250, 100, 20);

		wypozycz = new JButton("Wypozycz");
		wypozycz.setBounds(200, wyszukaj.getBounds().y, 100, 20);

		listaWszyskichKsiazek.setBounds(25, 80, 280, 150);

		wyszukajKsUzPole = new JTextField();
		wyszukajKsUzPole.setBounds(110, 40, 100, 20);

		wyszukajKsiazWysz = new JLabel("Wyszukaj");
		wyszukajKsiazWysz.setBounds(30, wyszukajKsUzPole.getBounds().y, 100, 20);

		combo = new JComboBox();
		combo.addItem("imie");
		combo.addItem("nazwisko");
		combo.addItem("autor");
		combo.setBounds(220, wyszukajKsUzPole.getBounds().y, 70, 20);

		panel2.add(wyszukaj);
		panel2.add(wypozycz);
		panel2.add(listaWszyskichKsiazek);
		panel2.add(wyszukajKsUzPole);
		panel2.add(wyszukajKsiazWysz);
		panel2.add(combo);

		add(panel2);

		panel3.setBorder(BorderFactory.createTitledBorder("Oddaj ksi¹¿kê"));
		panel3.setLayout(null);
		panel3.setSize(100, 100);
		panel3.setBounds(340, 340, 330, 220);

		listaKsiazekDoOddania = new JList<>(modelListyWszystkichKsiazek);

		oddaj = new JButton("Oddaj");
		oddaj.setBounds(190, 180, 100, 20);
		mojeKsiazki = new JButton("Moje Ksi¹¿ki");
		mojeKsiazki.setBounds(25, oddaj.getBounds().y, 130, 20);

//		listaWypozyczonych.setBounds(listaWszyskichKsiazek.getBounds().x, 30, 280, 130);

		panel3.add(oddaj);
		panel3.add(mojeKsiazki);
//		panel3.add(listaWypozyczonych);
		add(panel3);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setResizable(false);
		setLayout(null);
		setSize(700, 600);
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

		dodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ksi.setTytul(dodajTytulPole.getText());
				ksi.setAutor(dodajAutorPole.getText());
				ksi.setIloscOgolna(Integer.parseInt(dodajIloscPole.getText()));

				if (bibliotekaController.dodajKsiazke(ksi)) {
					JOptionPane.showMessageDialog(null, "Ksiazka dodana do biblioteki!");
					wyczyscOknoDodawaniaKsiazek();
					initListaWszstkichKsiazek();
					odswiesWszystkieKsiazki();
				} else {
					JOptionPane.showMessageDialog(null, "Coœ posz³o nie tak :(");
				}
			}
		});

		wypozycz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (bibliotekaController.wypozyczKsiazke(UserAuth.zalogowanyUzytkownik,
						listaWszyskichKsiazek.getSelectedValue())) {
					// odswiesWypozyczoneKsiazki();
				} else {
					JOptionPane.showMessageDialog(null, "Coœ posz³o nie tak :(");
				}

			}
		});

		mojeKsiazki.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		oddaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		wyszukaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

	}

	public void initListaWszstkichKsiazek() {
		listaWszystkichKsiazek = new ArrayList<>();
		listaWszystkichKsiazek = bibliotekaController.getListaWszyskitchKsiazek();
	}

	public void odswiesWszystkieKsiazki() {
		listaWszystkichKsiazek = bibliotekaController.getListaWszyskitchKsiazek();
		modelListyWszystkichKsiazek.removeAllElements();
		dodajModelWszyskichKsiazek();
	}

	public void dodajModelWszyskichKsiazek() {
		for (Ksiazka k : listaWszystkichKsiazek) {
			modelListyWszystkichKsiazek.addElement(k);

		}
	}

	// public void odswiesWypozyczoneKsiazki()
	// {
	// listaWypozyczonychKsiazek =
	// bibliotekaController.getListaWypozyczonychKsiazek(UserAuth.zalogowanyUzytkownik);
	// modelListyWypozyczonychKsiazek.removeAllElements();
	// dodajModelWypozyczonychKsiazek();
	// }
	//
	// public void dodajModelWypozyczonychKsiazek()
	// {
	// for (Ksiazka k : listaWypozyczonychKsiazek)
	// {
	// modelListyWypozyczonychKsiazek.addElement(k);
	//
	// }
	// }

	public void wyczyscOknoDodawaniaKsiazek() {
		dodajAutorPole.setText("");
		dodajIloscPole.setText("");
		dodajTytulPole.setText("");
	}

}