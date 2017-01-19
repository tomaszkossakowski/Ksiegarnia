package bazaDanych.encje;

import javax.xml.crypto.Data;

public class Wypozyczalnia {
	private int id;
	private int idKsiazki;
	private int idUzytkownika;
	private Data dataWyp;
	private Data dataZwrotu;

	public void setId(int id) {
		this.id = id;
	}

	public void setIdKsiazki(int idKsiazki) {
		this.idKsiazki = idKsiazki;
	}

	public void setIdUzytkownika(int idUzytkownika) {
		this.idUzytkownika = idUzytkownika;
	}

	public void setDataWyp(Data dataWyp) {
		this.dataWyp = dataWyp;
	}

	public void setDataZwrotu(Data dataZwrotu) {
		this.dataZwrotu = dataZwrotu;
	}

	public int getId() {
		return id;
	}

	public int getIdKsiazki() {
		return idKsiazki;
	}

	public int getIdUzytkownika() {
		return idUzytkownika;
	}

	public Data getDataWzp() {
		return dataWyp;
	}

	public Data getDataZwrotu() {
		return dataZwrotu;
	}

}
