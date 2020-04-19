package com.poker.templates;

public enum Figura 
{
	DWOJKA (2), TROJKA(3), CZWORKA(4), PIATKA(5), SZOSTKA(6), SIODEMKA(7), OSEMKA(8), DZIEWIATKA(9), DZIESIATKA(10), WALET(11), DAMA(12), KROL(13), AS(14);

	int wartosc;

	Figura(int wartosc)
	{
		this.wartosc = wartosc;
	}

	public int getWartosc() {return wartosc;}
	public void setWartosc(int wartosc) {this.wartosc = wartosc;}
}

