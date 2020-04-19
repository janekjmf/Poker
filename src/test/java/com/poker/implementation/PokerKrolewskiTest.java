package com.poker.implementation;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import com.poker.implemetation.SprawdzenieUkladu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.poker.implemetation.Karta;
import com.poker.templates.Figura;
import com.poker.templates.Kolor;
import com.poker.templates.Uklad;

@RunWith(Parameterized.class)
public class PokerKrolewskiTest
{
    private ArrayList<Karta> ukladKart;
    private Uklad odpowiedz;
    private static int numerTestu;

    public PokerKrolewskiTest(List<Karta> ukladKart, Uklad odpowiedz)
    {
        super();
        this.ukladKart = new ArrayList<Karta>(ukladKart);
        this.odpowiedz = odpowiedz;
    }

    @Parameterized.Parameters
    public static Collection tests()
    {

        Object[][] tests = {
                {Arrays.asList(new Karta(Figura.DZIESIATKA, Kolor.Kier),
                        new Karta(Figura.WALET, Kolor.Kier),
                        new Karta(Figura.DAMA, Kolor.Kier),
                        new Karta(Figura.KROL, Kolor.Kier),
                        new Karta(Figura.AS, Kolor.Kier)), Uklad.POKER_KROLEWSKI
                },
                {Arrays.asList(new Karta(Figura.DZIESIATKA, Kolor.Pik),
                        new Karta(Figura.WALET, Kolor.Pik),
                        new Karta(Figura.DAMA, Kolor.Pik),
                        new Karta(Figura.KROL, Kolor.Pik),
                        new Karta(Figura.AS, Kolor.Pik)), Uklad.POKER_KROLEWSKI
                },
                {Arrays.asList(new Karta(Figura.DZIESIATKA, Kolor.Trefl),
                        new Karta(Figura.WALET, Kolor.Trefl),
                        new Karta(Figura.DAMA, Kolor.Trefl),
                        new Karta(Figura.KROL, Kolor.Trefl),
                        new Karta(Figura.AS, Kolor.Trefl)), Uklad.POKER_KROLEWSKI
                },
                {Arrays.asList(new Karta(Figura.DZIESIATKA, Kolor.Karo),
                        new Karta(Figura.WALET, Kolor.Karo),
                        new Karta(Figura.DAMA, Kolor.Karo),
                        new Karta(Figura.KROL, Kolor.Karo),
                        new Karta(Figura.AS, Kolor.Karo)), Uklad.POKER_KROLEWSKI
                },
        };
        return Arrays.asList(tests);
    }

    @Test
    public void testSparametryzowany()
    {
        System.out.println("Numer Testu: " + ++numerTestu);
        assertTrue(SprawdzenieUkladu.sprawdzUklad(ukladKart)==odpowiedz);
    }
}
