package com.poker.templates;

public enum Uklad
{
	POKER_KROLEWSKI(1302540), POKER(1098240), KARETA(123552), FULL(54912), KOLOR(10200), STRIT(5108), TROJKA(3744), DWIE_PARY(624), PARA(36), WYSOKA_KARTA(4);

	long i;

	Uklad(long i)
	{
		this.i = i;
	}

	public long getI() {return i;}
	public void setI(long i) {this.i = i;}
}
