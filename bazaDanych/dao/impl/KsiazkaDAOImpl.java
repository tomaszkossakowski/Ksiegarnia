package bazaDanych.dao.impl;

import bazaDanych.Driver;
import bazaDanych.dao.KsiazkaDAO;
import bazaDanych.encje.Ksiazka;
import bazaDanych.encje.Uzytkownik;
import controller_widokow.UserAuth;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KsiazkaDAOImpl implements KsiazkaDAO {

	Driver driver = new Driver();

	@Override
	public List<Ksiazka> pokazWszystkieKsiazki() {
		List<Ksiazka> listaKsiazek = new ArrayList<>();
		Connection myConn = driver.getDatabaseConnection();

		try {
			PreparedStatement prepStmt = myConn.prepareStatement("SELECT * from ksiegarnia.ksiazki");

			ResultSet wynik = prepStmt.executeQuery();
			while (wynik.next()) {
				Ksiazka ksiazka = new Ksiazka();
				ksiazka.setTytul(wynik.getString(2));
				ksiazka.setAutor(wynik.getString(3));
				ksiazka.setIloscOgolna(wynik.getInt(4));

				listaKsiazek.add(ksiazka);
			}

		} catch (SQLException e) {
			System.err.println("Blad przy dodawaniu");
			e.printStackTrace();

		}

		return listaKsiazek;
	}

	@Override
	public Ksiazka pokazWybranaKsiazke(Ksiazka ksiazka) {
		Connection connection = driver.getDatabaseConnection();
		Ksiazka wybranaKsiazka = null;
		try {
			String sql = "select from ksiegarnia.ksiazki k where k.autor = ? and k.tytul = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, ksiazka.getAutor());
			statement.setString(2, ksiazka.getTytul());

			ResultSet wynik = statement.executeQuery();

			if (wynik.next()) {
				wybranaKsiazka = new Ksiazka(wynik.getString(2), wynik.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wybranaKsiazka;
	}

	@Override
	public boolean dodajKsiazke(Ksiazka ksiazka) {
		Connection myConn = driver.getDatabaseConnection();
		boolean czyDodanaKs = false;

		try {
			PreparedStatement prepStmt = myConn.prepareStatement(
					"insert into ksiegarnia.ksiazki (tytul,autor,iloscOgolona,dostepneSzt) values ( ?, ?, ?,?);");
			prepStmt.setString(1, ksiazka.getTytul());
			prepStmt.setString(2, ksiazka.getAutor());
			prepStmt.setInt(3, ksiazka.getIloscOgolna());
			prepStmt.setInt(4, ksiazka.getIloscOgolna());
			prepStmt.execute();

			czyDodanaKs = true;
		} catch (Exception a) {
			a.printStackTrace();
			JOptionPane.showMessageDialog(null, "Poda³eœ z³e wartoœci");
		}

		return czyDodanaKs;
	}

	@Override
	public boolean wypozyczKsiazke(Uzytkownik uzytkownik, Ksiazka ksiazka) {
		Connection connection = driver.getDatabaseConnection();
		boolean czyKsiazaWypoczona = false;

		try {

			java.sql.Date data = new java.sql.Date(new Date().getTime());

			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO ksiegarnia.wypozyczalnia (idUzytkownika, idKsiazki , dataWyp, czyWypozyczona) VALUES (?,?,?,?)");
			statement.setInt(1, uzytkownik.getId());
			statement.setInt(2, ksiazka.getId());
			statement.setDate(3, data);
			statement.setInt(4, 1);

			statement.execute();
			czyKsiazaWypoczona = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return czyKsiazaWypoczona;
	}

	@Override
	public boolean oddajKsiazke(Ksiazka ksiazka) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Ksiazka> pokazWypozyczoneKsiazki(Uzytkownik uzytkownik) {
		{
			List<Ksiazka> listaWypozyczonychKsiazek = new ArrayList<>();
			Connection myConn = driver.getDatabaseConnection();
			try {

				PreparedStatement prepStmt = myConn
						.prepareStatement("SELECT k.tytul, k.autor FROM ksiegarnia.ksiazki k  "
								+ "LEFT JOIN ksiegarnia.wypozyczalnia w ON (k.Id = w.IdKsiazki) "
								+ "LEFT JOIN ksiegarnia.uzytkownik u ON (u.Id = w.idUzytkownika) "
								+ "WHERE u.login=? and w.czyWypozyczona=1");

				prepStmt.setString(1, uzytkownik.getLogin());
				ResultSet wynik = prepStmt.executeQuery();
				while (wynik.next()) {
					Ksiazka ksiazka = new Ksiazka();
					ksiazka.setTytul(wynik.getString(1));
					ksiazka.setAutor(wynik.getString(2));

					listaWypozyczonychKsiazek.add(ksiazka);
				}
			} catch (SQLException e) {
				System.err.println("Blad przy dodawaniu");
				e.printStackTrace();
			}
			return listaWypozyczonychKsiazek;

		}

	}

}
