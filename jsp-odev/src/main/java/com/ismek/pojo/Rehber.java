package com.ismek.pojo;

import java.util.ArrayList;
import java.util.List;

public class Rehber {
	public static int sayac=0;
	private int id;
	private String isim;
	private String telefon;
	private int index;
	public static List<Rehber> rehberListesi = new ArrayList<Rehber>();

	public Rehber(int id, String isim, String telefon) {
		this.id = id;
		this.isim = isim;
		this.telefon = telefon;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public static List<Rehber> getRehberListesi() {
		return rehberListesi;
	}

	public static void setRehberListesi(List<Rehber> rehberListesi) {
		Rehber.rehberListesi = rehberListesi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
}
