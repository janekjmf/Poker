package com.poker.apk;

import com.poker.implemetation.Talia;
import com.poker.implemetation.UkladKart;
import com.poker.templates.ITalia;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);

		long pktGracz1 = 0;
		long pktGracz2 = 0;
		long pktGracz3 = 0;
		long pktGracz4 = 0;
		long pktGracz5 = 0;

		boolean koniec = false;

		while (!koniec)
		{
			ITalia talia = new Talia("Talia");
			talia.nowaTalia();
			talia.tasuj();

			UkladKart gracz1 = talia.rozdajKarty(2);
			UkladKart gracz2 = talia.rozdajKarty(2);
			UkladKart gracz3 = talia.rozdajKarty(2);
			UkladKart gracz4 = talia.rozdajKarty(2);
			UkladKart gracz5 = talia.rozdajKarty(2);

			UkladKart naBlacie = talia.rozdajKarty(3);

			gracz1.ukladKart.addAll(naBlacie.ukladKart);
			gracz2.ukladKart.addAll(naBlacie.ukladKart);
			gracz3.ukladKart.addAll(naBlacie.ukladKart);
			gracz4.ukladKart.addAll(naBlacie.ukladKart);
			gracz5.ukladKart.addAll(naBlacie.ukladKart);

			pktGracz1 += gracz1.getPoints();
			pktGracz2 += gracz2.getPoints();
			pktGracz3 += gracz3.getPoints();
			pktGracz4 += gracz4.getPoints();
			pktGracz5 += gracz5.getPoints();

			System.out.print("Gracz 1 - "+pktGracz1+" pkt");
				gracz1.pokazUkladKart();
			System.out.print("Gracz 2 - "+pktGracz2+" pkt");
				gracz2.pokazUkladKart();
			System.out.print("Gracz 3 - "+pktGracz3+" pkt");
				gracz3.pokazUkladKart();
			System.out.print("Gracz 4 - "+pktGracz4+" pkt");
				gracz4.pokazUkladKart();
			System.out.print("Gracz 5 - "+pktGracz5+" pkt");
				gracz5.pokazUkladKart();

			System.out.println("=====================================");
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("koniec"))
				koniec = true;
		}
		scanner.close();
	}
}
