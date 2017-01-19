package bazaDanych.encje;

public class Ksiazka {
	private int id;
	private String tytul;
	private String autor;
	private int iloscOgolna;
	private int dostepneSzt;

	public Ksiazka() {
	}

	public Ksiazka(String tytul, String autor) {
		this.tytul = tytul;
		this.autor = autor;
	}

	public int getId() {
		return id;
	}

	public String getTytul() {
		return tytul;
	}

	public String getAutor() {
		return autor;
	}

	public int getIloscOgolna() {
		return iloscOgolna;
	}

	public int getDostepneSzt() {
		return dostepneSzt;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setIloscOgolna(int iloscOgolna) {
		this.iloscOgolna = iloscOgolna;
	}

	public void setDostepneSzt(int dostepneSzt) {
		this.dostepneSzt = dostepneSzt;
	}

	@Override
	public String toString() {
		return autor + " " + tytul + " " + iloscOgolna + " " + dostepneSzt;
	}

}
