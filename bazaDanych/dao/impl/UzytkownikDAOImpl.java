package bazaDanych.dao.impl;

import bazaDanych.Driver;
import bazaDanych.dao.UzytkownikDAO;
import bazaDanych.encje.Uzytkownik;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UzytkownikDAOImpl implements UzytkownikDAO {

	Driver driver = new Driver();

	@Override
	public List<Uzytkownik> wszyscyUzytkownicy() {
		List<Uzytkownik> listaUzywkonikow = new ArrayList<>();
		Connection myConn = driver.getDatabaseConnection();

		try {
			PreparedStatement prepStmt = myConn.prepareStatement("SELECT * from ksiegarnia.uzytkownik");

			ResultSet wynik = prepStmt.executeQuery();
			while (wynik.next()) {
				Uzytkownik uzytkownik = new Uzytkownik();
				uzytkownik.setImie(wynik.getString(2));
				uzytkownik.setNazwisko(wynik.getString(3));
				uzytkownik.setHaslo(wynik.getString(4));
				uzytkownik.setLogin(wynik.getString(5));

				listaUzywkonikow.add(uzytkownik);

				myConn.close();
				prepStmt.close();
			}

		} catch (SQLException e) {
			System.err.println("Blad przy dodawaniu");
			e.printStackTrace();

		}
		return listaUzywkonikow;
	}

	@Override
	public boolean znajdzUzytkownika(String login, String haslo) {
		Connection myConn = driver.getDatabaseConnection();
		boolean czyZalogowany = false;

		try {
			PreparedStatement prepStmt = myConn
					.prepareStatement("SELECT * from ksiegarnia.uzytkownik where login=? and haslo=?");
			prepStmt.setString(1, login);
			prepStmt.setString(2, haslo);

			ResultSet wynik = prepStmt.executeQuery();
			if (wynik.next()) {
				czyZalogowany = true;
			}
			myConn.close();
			wynik.close();

		} catch (SQLException e) {
			System.err.println("Blad przy dodawaniu");

		}
		return czyZalogowany;

	}

	@Override
	public Uzytkownik pobierzUzytkownika(String login, String haslo) {
		Connection connection = driver.getDatabaseConnection();
		Uzytkownik uzytkownik = null;
		try {
			PreparedStatement prepStmt = connection
					.prepareStatement("SELECT * from ksiegarnia.uzytkownik where login=? and haslo=?");
			prepStmt.setString(1, login);
			prepStmt.setString(2, haslo);

			ResultSet wynik = prepStmt.executeQuery();

			while (wynik.next()) {
				uzytkownik = new Uzytkownik();
				uzytkownik.setId(wynik.getInt(1));
				uzytkownik.setImie(wynik.getString(2));
				uzytkownik.setNazwisko(wynik.getString(3));
				uzytkownik.setLogin(wynik.getString(4));
				uzytkownik.setPesel(wynik.getInt(6));
				uzytkownik.setMail(wynik.getString(7));
				uzytkownik.setRola(wynik.getInt(8));
				uzytkownik.setTelefon(wynik.getInt(9));
				uzytkownik.setCzyAktywny(wynik.getInt(10));
			}
			connection.close();
			wynik.close();

		} catch (SQLException e) {
			System.err.println("Blad przy dodawaniu");

		}
		return uzytkownik;
	}

}
