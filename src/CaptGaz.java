import java.time.*;

class CaptGaz extends Capteur {

    public CaptGaz (int unId, String unNom, String unLieu) {
        super(unId, unNom, unLieu);
    }

    public void createEvent (LocalDate uneDate, String unLieu, int uneImportance, String unType) {
        EmissionGaz e = new EmissionGaz(uneDate, unLieu, uneImportance, unType);
        for (int i = 0; i < liste_ecouteurs.size(); i++) {
            liste_ecouteurs.get(i).onEvent(e);
        }
    }

}