import java.time.*;

class CaptRadiation extends Capteur {

    public CaptRadiation (int unId, String unNom, String unLieu) {
        super(unId, unNom, unLieu);
    }

    public void createEvent (LocalDate uneDate, String unLieu, int uneImportace, int unNiveauRadiation) {
        EmissionRadiation e = new EmissionRadiation(uneDate, unLieu, uneImportace, unNiveauRadiation);
        for (int i = 0; i < liste_ecouteurs.size(); i++) {
            liste_ecouteurs.get(i).onEvent(e);
        }
    }
}