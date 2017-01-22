package controller_widokow;

import bazaDanych.dao.KsiazkaDAO;
import bazaDanych.dao.impl.KsiazkaDAOImpl;
import bazaDanych.encje.Ksiazka;
import bazaDanych.encje.Uzytkownik;

import java.util.ArrayList;
import java.util.List;

public class BibliotekaController {
	KsiazkaDAO ksiazkaDAO = new KsiazkaDAOImpl();
	List<Ksiazka> listaWszyskitchKsiazek, pokazWypozyczoneKsiazki;

	public BibliotekaController() {
		listaWszyskitchKsiazek = new ArrayList<>();
		listaWszyskitchKsiazek = ksiazkaDAO.pokazWszystkieKsiazki();

	}
	// public BibliotekaController(Uzytkownik uzytkownik)
	// {
	// listaWypozyczonychKsiazek = new ArrayList<>();
	// listaWypozyczonychKsiazek =
	// ksiazkaDAO.pokazWypozyczoneKsiazki(uzytkownik);
	// }

	public List<Ksiazka> getListaWszyskitchKsiazek() {
		listaWszyskitchKsiazek = ksiazkaDAO.pokazWszystkieKsiazki();
		return listaWszyskitchKsiazek;
	}

	public boolean dodajKsiazke(Ksiazka ksiazka) {
		boolean czyDOdanaKsiazka = false;
		if (ksiazkaDAO.dodajKsiazke(ksiazka)) {
			czyDOdanaKsiazka = true;
		}

		return czyDOdanaKsiazka;
	}

	public boolean wypozyczKsiazke(Uzytkownik uzytkownik, Ksiazka ksiazka) {
		boolean czyWypozyczona = false;
		if (ksiazkaDAO.wypozyczKsiazke(uzytkownik, ksiazka)) {
			czyWypozyczona = true;
		}
		return czyWypozyczona;

	}

	public List<Ksiazka> getListaWypozyczonychKsiazek(Uzytkownik uzytkownik) {
		List<Ksiazka> listaWypozyczonychKsiazek = new ArrayList<>();
		listaWypozyczonychKsiazek = ksiazkaDAO.pokazWypozyczoneKsiazki(uzytkownik);
		return listaWypozyczonychKsiazek;
	}
	
	public void oddajKsiazke(Ksiazka ksiazka)
	{
		ksiazkaDAO.oddajKsiazke(ksiazka);
	}
	
public List<Ksiazka>wyszukajKsiazke(String warunek ,String wartosc){
	List<Ksiazka> wyszukaneKsiazki = new ArrayList<>();
	wyszukaneKsiazki = ksiazkaDAO.wyszukajKsiazke(warunek , wartosc);
	return wyszukaneKsiazki;
}
	

}
