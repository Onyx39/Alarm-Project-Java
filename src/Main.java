//import java.time.*;

public class Main {

    public static void main(String[] args) {
        
        //EmissionGaz e = new EmissionGaz(LocalDate.of(2022, 5,6), "Polytech", 1, "CO2");
        //System.out.println(e.getClass());

        MoniteurA monoA = new MoniteurA("monoA");
        MoniteurB monoB = new MoniteurB("monoB");

        CaptGaz cg = new CaptGaz(1, "Bidule", "Polytech");
        CaptIncendie ci = new CaptIncendie(1, "Alarme incendie", "Mairie");
        CaptRadiation cr = new CaptRadiation(1, "detecteur radiation", "Mosanto");
        cg.addListener(monoA);
        cg.addListener(monoB);
        ci.addListener(monoA);
        ci.addListener(monoB);
        cr.addListener(monoA);
        cr.addListener(monoB);

        //cg.createEvent(LocalDate.of(2022, 5, 6), "Polytech", 1, "CO2");
        //ci.createEvent(LocalDate.of(2022, 5, 6), "Mairie", 1);
        //cr.createEvent(LocalDate.of(2022, 5, 6), "Polytech", 1, 50);


        IHM MyIHM = new IHM();
    }

}

//UML LAB pour faire des uml en ligne. Gratuits pour etudiants.