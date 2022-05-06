import java.time.*;

public class CaptIncendie extends Capteur {

    public CaptIncendie (int unId, String unNom, String unLieu) {
        super(unId, unNom, unLieu);
    }

    public void createEvent (LocalDate uneDate, String unLieu, int uneImportance) {
        Incendie e = new Incendie(uneDate, unLieu, uneImportance);
        for (int i = 0; i < liste_ecouteurs.size(); i++) {
            liste_ecouteurs.get(i).onEvent(e);
        }
    }
}