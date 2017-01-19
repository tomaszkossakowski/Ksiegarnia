package controller_widokow;

import bazaDanych.dao.UzytkownikDAO;
import bazaDanych.dao.impl.UzytkownikDAOImpl;
import bazaDanych.encje.Uzytkownik;

public class LogowanieController {
	UzytkownikDAO uzytkownikDAO = new UzytkownikDAOImpl();

	public boolean zaloguj(String haslo, String login) {
		boolean czyZalogowany = false;

		if (uzytkownikDAO.znajdzUzytkownika(login, haslo)) {
			czyZalogowany = true;
			UserAuth userAuth = null;
			userAuth.zalogowanyUzytkownik = new Uzytkownik();
			userAuth.zalogowanyUzytkownik = uzytkownikDAO.pobierzUzytkownika(login, haslo);

		}
		return czyZalogowany;
	}
}
