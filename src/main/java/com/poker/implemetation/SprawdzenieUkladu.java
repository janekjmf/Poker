package com.poker.implemetation;

import java.util.*;
import com.poker.templates.Figura;
import com.poker.templates.Kolor;
import com.poker.templates.Uklad;

public class SprawdzenieUkladu
{
	private static ArrayList<Karta> ukladKart;

	public static Uklad sprawdzUklad(ArrayList<Karta> ukladKart)
	{
		SprawdzenieUkladu.ukladKart = ukladKart;

		if (czyPokerKrolewski())
			return Uklad.POKER_KROLEWSKI;
		else if (czyPoker())
			return Uklad.POKER;
		else if(czyKareta())
			return Uklad.KARETA;
		else if(czyFull())
			return Uklad.FULL;
		else if(czyKolor())
			return Uklad.KOLOR;
		else if(czyStrit())
			return Uklad.STRIT;
		else if(czyTrojka())
			return Uklad.TROJKA;
		else if (czyDwiePary())
			return Uklad.DWIE_PARY;
		else if (czyPara())
			return Uklad.PARA;
		else
			return Uklad.WYSOKA_KARTA;
	}

	private static boolean czyPokerKrolewski()
	{
		boolean royalFlush;
		int tmp = 0;
		ArrayList<Figura> zbiorFigor = new ArrayList<>();

		ukladKart.forEach(e -> zbiorFigor.add(e.getFigura()));
		Collections.sort(zbiorFigor);

		for (int i = 0; i < zbiorFigor.size()-1; i++)
		{
			if (zbiorFigor.get(i).getWartosc() == zbiorFigor.get(i+1).getWartosc()-1)
				tmp++;
		}

		if ((tmp == 4 && zbiorFigor.size() == 5)&&(zbiorFigor.get(zbiorFigor.size()-1).getWartosc() == 14 && czyKolor()))
			royalFlush = true;
		else
			royalFlush = false;

		return royalFlush;
	}

	private static boolean czyPoker()
	{
		boolean flush;
		int tmp = 0;
		ArrayList<Figura> zbiorFigor = new ArrayList<>();

		ukladKart.forEach(e -> zbiorFigor.add(e.getFigura()));
		Collections.sort(zbiorFigor);

		for (int i = 0; i < zbiorFigor.size()-1; i++)
		{
			if (zbiorFigor.get(i).getWartosc() == zbiorFigor.get(i+1).getWartosc()-1)
				tmp++;
		}

		if ((tmp == 4 && zbiorFigor.size() == 5)&&(czyKolor()))
			flush = true;
		else
			flush = false;

		return flush;
	}

	private static boolean czyKareta()
	{
		boolean czyKareta = false;
		ArrayList<Figura> zbiorFigor = new ArrayList<>();
		ukladKart.forEach(e -> zbiorFigor.add(e.getFigura()));
		Collections.sort(zbiorFigor);

		Set<Kolor> zbiorKolorow = new TreeSet<Kolor>();
		ukladKart.forEach(e -> zbiorKolorow.add(e.getKolor()));

		Set<Figura> rodzajeFigor = new TreeSet<Figura>();
		ukladKart.forEach(e -> rodzajeFigor.add(e.getFigura()));

		ArrayList<Figura> pierwszaL = new ArrayList<Figura>();
		ArrayList<Figura> drugaL = new ArrayList<Figura>();

		if (rodzajeFigor.size() == 2 && zbiorKolorow.size() == 4)
		{
			for (int i = 0; i < zbiorFigor.size(); i ++)
			{
				Figura pierwsza = zbiorFigor.get(i);
				Figura druga = zbiorFigor.get(i);

				if ( pierwszaL.isEmpty())
					pierwszaL.add(pierwsza);
				else if (pierwsza == pierwszaL.get(0))
					pierwszaL.add(pierwsza);
				else if ( drugaL.isEmpty())
					drugaL.add(druga);
				else if (druga == drugaL.get(0))
					drugaL.add(druga);

			}
			if (pierwszaL.size() == 4 || drugaL.size() == 4)
				czyKareta = true;
		}

		return  czyKareta;
	}

	private static boolean czyFull()
	{
		Set<Figura> zbiorFigor = new TreeSet<Figura>();

		ukladKart.forEach(e -> zbiorFigor.add(e.getFigura()));

		return zbiorFigor.size() == 2;
	}

	private static boolean czyKolor()
	{
		Set<Kolor> zbiorKolorow = new TreeSet<Kolor>();

		ukladKart.forEach(e -> zbiorKolorow.add(e.getKolor()));

		return zbiorKolorow.size() == 1;
	}

	private static boolean czyStrit()
	{
		boolean czyPokolei;
		int tmp = 0;
		ArrayList<Figura> zbiorFigor = new ArrayList<>();

		ukladKart.forEach(e -> zbiorFigor.add(e.getFigura()));
		Collections.sort(zbiorFigor);

		for (int i = 0; i < zbiorFigor.size()-1; i++)
		{
			if (zbiorFigor.get(i).getWartosc() == zbiorFigor.get(i+1).getWartosc()-1)
				tmp++;
		}

		if (tmp == 4 && zbiorFigor.size() == 5)
			czyPokolei = true;
		else
			czyPokolei = false;

		return czyPokolei;
	}

	private static boolean czyTrojka()
	{
		boolean trojka = false;

		ArrayList<Figura> zbiorFigor = new ArrayList<>();
		ukladKart.forEach(e -> zbiorFigor.add(e.getFigura()));
		Collections.sort(zbiorFigor);

		Set<Figura> rodzajeFigor = new TreeSet<Figura>();
		ukladKart.forEach(e -> rodzajeFigor.add(e.getFigura()));

		ArrayList<Figura> pierwszaL = new ArrayList<Figura>();
		ArrayList<Figura> drugaL = new ArrayList<Figura>();
		ArrayList<Figura> trzeciaL = new ArrayList<Figura>();

		if (rodzajeFigor.size() == 3)
		{
			for (int i = 0; i < zbiorFigor.size(); i ++)
			{
				Figura pierwsza = zbiorFigor.get(i);
				Figura druga = zbiorFigor.get(i);
				Figura trzecia = zbiorFigor.get(i);

				if (pierwszaL.isEmpty())
					pierwszaL.add(pierwsza);
				else if (pierwsza == pierwszaL.get(0))
					pierwszaL.add(pierwsza);
				else if (drugaL.isEmpty())
					drugaL.add(druga);
				else if (druga == drugaL.get(0))
					drugaL.add(druga);
				else if (trzeciaL.isEmpty())
					trzeciaL.add(trzecia);
				else if (trzecia == trzeciaL.get(0))
					trzeciaL.add(trzecia);
			}
			if (pierwszaL.size() == 3 || drugaL.size() == 3 || trzeciaL.size() ==3)
				 trojka = true;
		}

		return trojka;
	}

	private static boolean czyDwiePary()
	{
		Set<Figura> zbiorFigor = new TreeSet<Figura>();

		ukladKart.forEach(e -> zbiorFigor.add(e.getFigura()));

		return zbiorFigor.size() == 3;
	}

	private static boolean czyPara()
	{
		Set<Figura> zbiorFigor = new TreeSet<Figura>();

		ukladKart.forEach(e -> zbiorFigor.add(e.getFigura()));

		return zbiorFigor.size() == 4;
	}
}
