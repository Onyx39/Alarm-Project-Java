import java.time.*;

public class EmissionRadiation extends AnomalieEvent {

    public int niveau_radiation;

    public EmissionRadiation(LocalDate uneDate, String unLieu, int uneImportance, int unNiveauRadiation) {
        super(uneDate, unLieu, uneImportance);
        this.niveau_radiation = uneImportance;
        this.niveau_radiation = unNiveauRadiation;
    }

}