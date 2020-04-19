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
public class ParaTest
{
    private ArrayList<Karta> ukladKart;
    private Uklad odpowiedz;
    private static int numerTestu;

    public ParaTest(List<Karta> ukladKart, Uklad odpowiedz)
    {
        super();
        this.ukladKart = new ArrayList<Karta>(ukladKart);
        this.odpowiedz = odpowiedz;
    }

    @Parameterized.Parameters
    public static Collection tests()
    {

        Object[][] tests = {
                {Arrays.asList(new Karta(Figura.CZWORKA, Kolor.Kier),
                        new Karta(Figura.CZWORKA, Kolor.Pik),
                        new Karta(Figura.DZIESIATKA, Kolor.Karo),
                        new Karta(Figura.DAMA, Kolor.Trefl),
                        new Karta(Figura.WALET, Kolor.Kier)), Uklad.PARA
                },
                {Arrays.asList(new Karta(Figura.PIATKA, Kolor.Karo),
                        new Karta(Figura.CZWORKA, Kolor.Pik),
                        new Karta(Figura.OSEMKA, Kolor.Kier),
                        new Karta(Figura.AS, Kolor.Trefl),
                        new Karta(Figura.AS, Kolor.Kier)), Uklad.PARA
                },
                {Arrays.asList(new Karta(Figura.DWOJKA, Kolor.Kier),
                        new Karta(Figura.DZIESIATKA, Kolor.Karo),
                        new Karta(Figura.PIATKA, Kolor.Pik),
                        new Karta(Figura.SIODEMKA, Kolor.Kier),
                        new Karta(Figura.DWOJKA, Kolor.Trefl)), Uklad.PARA
                },
                {Arrays.asList(new Karta(Figura.DAMA, Kolor.Kier),
                        new Karta(Figura.AS, Kolor.Pik),
                        new Karta(Figura.CZWORKA, Kolor.Karo),
                        new Karta(Figura.SZOSTKA, Kolor.Trefl),
                        new Karta(Figura.SZOSTKA, Kolor.Kier)), Uklad.PARA
                },
                {Arrays.asList(new Karta(Figura.AS, Kolor.Pik),
                        new Karta(Figura.KROL, Kolor.Pik),
                        new Karta(Figura.DAMA, Kolor.Pik),
                        new Karta(Figura.WALET, Kolor.Pik),
                        new Karta(Figura.AS, Kolor.Trefl)), Uklad.PARA
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
