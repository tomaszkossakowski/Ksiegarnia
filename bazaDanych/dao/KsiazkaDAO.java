package bazaDanych.dao;

import bazaDanych.encje.Ksiazka;
import bazaDanych.encje.Uzytkownik;
import controller_widokow.UserAuth;

import java.util.List;

public interface KsiazkaDAO {

	List<Ksiazka> pokazWszystkieKsiazki();

	List<Ksiazka> pokazWypozyczoneKsiazki(Uzytkownik uzytkownik);

	Ksiazka pokazWybranaKsiazke(Ksiazka ksiazka);

	boolean dodajKsiazke(Ksiazka ksiazka);

	boolean wypozyczKsiazke(Uzytkownik uzytkownik, Ksiazka ksiazka);

	boolean oddajKsiazke(Ksiazka ksiazka);
}
