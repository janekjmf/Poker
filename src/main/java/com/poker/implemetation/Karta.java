package com.poker.implemetation;

import com.poker.templates.Figura;
import com.poker.templates.IKarta;
import com.poker.templates.Kolor;

public class Karta implements IKarta
{
	private Figura figura;
	private Kolor kolor;
	
	public Karta(Figura figura, Kolor kolor) 
	{
		this.figura = figura;
		this.kolor = kolor;
	}

	@Override
	public String toString() 
	{
		String output = "";

		if (kolor.equals(Kolor.Kier))
			output += "♥";
		else if (kolor.equals(Kolor.Pik))
			output += "♠";
		else if (kolor.equals(Kolor.Karo))
			output += "♦";
		else if (kolor.equals(Kolor.Trefl))
			output += "♣";

		if (figura.equals(Figura.DWOJKA))
			output += "2";
		if (figura.equals(Figura.TROJKA))
			output += "3";
		if (figura.equals(Figura.CZWORKA))
			output += "4";
		if (figura.equals(Figura.PIATKA))
			output += "5";
		if (figura.equals(Figura.SZOSTKA))
			output += "6";
		if (figura.equals(Figura.SIODEMKA))
			output += "7";
		if (figura.equals(Figura.OSEMKA))
			output += "8";
		if (figura.equals(Figura.DZIEWIATKA))
			output += "9";
		if (figura.equals(Figura.DZIESIATKA))
			output += "10";
		if (figura.equals(Figura.WALET))
			output += "J";
		if (figura.equals(Figura.DAMA))
			output += "Q";
		if (figura.equals(Figura.KROL))
			output += "K";
		if (figura.equals(Figura.AS))
			output += "A";


		return  output;
	}

	@Override
	public Kolor getKolor() 
	{
		return kolor;
	}
	
	@Override
	public Figura getFigura() 
	{
		return figura;
	}
}