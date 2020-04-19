package com.poker.implemetation;

import java.util.ArrayList;
import com.poker.templates.IUkladKart;

public class UkladKart implements IUkladKart
{
	public ArrayList<Karta> ukladKart;

	public UkladKart() {
		this.ukladKart = new ArrayList<Karta>();
	}

	@Override
	public void dobierz(Karta k) {
		ukladKart.add(k);
	}

	@Override
	public Karta odrzuc() {
		return null;
	}

	@Override
	public void pokazUkladKart()
	{
		System.out.println();
		for(Karta k : ukladKart)
			System.out.print(k+"\t");
		System.out.println("\t"+ SprawdzenieUkladu.sprawdzUklad(ukladKart));
		System.out.println();
	}

	public long getPoints()
	{
		return SprawdzenieUkladu.sprawdzUklad(ukladKart).getI();
	}
}
