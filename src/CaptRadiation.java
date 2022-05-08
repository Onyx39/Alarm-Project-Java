import java.time.*;

public class CaptRadiation extends Capteur {

    public CaptRadiation (Integer unId, String unNom, String unLieu) {
        super(unId, unNom, unLieu);
    }

    public void createEvent (LocalDate uneDate, String unLieu, Integer uneImportace, Integer unNiveauRadiation) {
        EmissionRadiation e = new EmissionRadiation(uneDate, unLieu, uneImportace, unNiveauRadiation);
        for (int i = 0; i < liste_ecouteurs_typeB.size(); i++) {
            liste_ecouteurs_typeB.get(i).onEvent(e);
        }
    }
}