import java.time.*;

public class CaptGaz extends Capteur {

    public CaptGaz (Integer unId, String unNom, String unLieu) {
        super(unId, unNom, unLieu);
    }

    public void createEvent (LocalDate uneDate, String unLieu, Integer uneImportance, String unType) {
        EmissionGaz e = new EmissionGaz(uneDate, unLieu, uneImportance, unType);
        for (int i = 0; i < liste_ecouteurs_typeA.size(); i++) {
            liste_ecouteurs_typeA.get(i).onEvent(e);
        }
        for (int i = 0; i < liste_ecouteurs_typeB.size(); i++) {
            liste_ecouteurs_typeB.get(i).onEvent(e);
        }
    }

}