import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Batiment Polytech = new Batiment("Polytech", "5 chemin de Bellevue, 74000 ANNECY");
        Batiment Mairie = new Batiment ("Mairie", "1 rue de la mairie, 74000 ANNECY");
        Batiment Maison = new Batiment ("Maison", "1 route de la maison, 74000 ANNECY");
        Batiment Entrepot = new Batiment("Entrepot", "1 rue de l'entrepot, 74000 ANNECY");
        Batiment Usine = new Batiment ("Usine", "1 avenue de l'usine, 74000 ANNECY");
        ArrayList<Batiment> liste_bat = new ArrayList<Batiment>();
        liste_bat.add(Polytech);
        liste_bat.add(Mairie);
        liste_bat.add(Maison);
        liste_bat.add(Entrepot);
        liste_bat.add(Usine);

        MoniteurA monoA = new MoniteurA("monoA");
        MoniteurB monoB = new MoniteurB("monoB");

        ArrayList<ListenerA> liste_mono_A = new ArrayList<ListenerA>();
        ArrayList<ListenerB> liste_mono_B = new ArrayList<ListenerB>();
        liste_mono_A.add(monoA);
        liste_mono_B.add(monoB);

        CaptGaz cg1 = new CaptGaz(1, "Gaz1", Polytech);
        CaptGaz cg2 = new CaptGaz(2, "Gaz2", Usine);
        CaptGaz cg3 = new CaptGaz(3, "Gaz3", Entrepot);
        CaptIncendie ci1 = new CaptIncendie(1, "Alarme incendie1", Maison);
        CaptIncendie ci2 = new CaptIncendie(2, "Alarme incendie2", Entrepot);
        CaptIncendie ci3 = new CaptIncendie(3, "Alarme incendie3", Mairie);
        CaptRadiation cr1 = new CaptRadiation(1, "detecteur radiation1", Usine);
        CaptRadiation cr2 = new CaptRadiation(2, "detecteur radiation2", Polytech);
        CaptRadiation cr3 = new CaptRadiation(2, "detecteur radiation3", Maison);

        ArrayList<CaptIncendie> liste_capteur_feu = new ArrayList<CaptIncendie>();
        ArrayList<CaptGaz> liste_capteur_gaz = new ArrayList<CaptGaz>();
        ArrayList<CaptRadiation> liste_capteur_radiation = new ArrayList<CaptRadiation>();
        liste_capteur_gaz.add(cg1);
        liste_capteur_gaz.add(cg2);
        liste_capteur_gaz.add(cg3);
        liste_capteur_feu.add(ci1);
        liste_capteur_feu.add(ci2);
        liste_capteur_feu.add(ci3);
        liste_capteur_radiation.add(cr1);
        liste_capteur_radiation.add(cr2);
        liste_capteur_radiation.add(cr3);

        IHMGenerationAlarme myIHM1 = new IHMGenerationAlarme(liste_mono_A, liste_mono_B, liste_capteur_feu, liste_capteur_gaz, liste_capteur_radiation, liste_bat);
    }
}

//UML LAB pour faire des uml en ligne. Gratuits pour etudiants.