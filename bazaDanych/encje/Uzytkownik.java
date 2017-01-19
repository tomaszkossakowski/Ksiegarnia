package bazaDanych.encje;

public class Uzytkownik {

	private int id;
	private String imie;
	private String nazwisko;
	private String login;
	private String haslo;
	private int pesel;
	private String mail;
	private int rola;
	private int telefon;
	private int czyAktywny;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public int getPesel() {
		return pesel;
	}

	public void setPesel(int pesel) {
		this.pesel = pesel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getRola() {
		return rola;
	}

	public void setRola(int rola) {
		this.rola = rola;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public int getCzyAktywny() {
		return czyAktywny;
	}

	public void setCzyAktywny(int czyAktywny) {
		this.czyAktywny = czyAktywny;
	}

	public String toString() {
		return id + " " + imie + " " + nazwisko + " " + login + " " + pesel + " " + mail + " " + telefon;

	}

}
