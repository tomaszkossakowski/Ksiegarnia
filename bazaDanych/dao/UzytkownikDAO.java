package bazaDanych.dao;

import bazaDanych.encje.Uzytkownik;

import java.util.List;

public interface UzytkownikDAO {
	List<Uzytkownik> wszyscyUzytkownicy();

	boolean znajdzUzytkownika(String login, String haslo);

	Uzytkownik pobierzUzytkownika(String login, String haslo);

}
