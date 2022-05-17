package alarm;
import java.time.*;

public class CaptIncendie extends Capteur {

    public CaptIncendie (Integer unId, String unNom, Batiment unLieu) {
        super(unId, unNom, unLieu);
    }

    public void createEvent (LocalDate uneDate, Batiment unLieu, Integer uneImportance) {
        Incendie e = new Incendie(uneDate, unLieu, uneImportance);
        for (int i = 0; i < liste_ecouteurs_typeA.size(); i++) {
            liste_ecouteurs_typeA.get(i).onEvent(e);
        }
    }
}