import java.time.*;

public class EmissionRadiation extends AnomalieEvent {

    public Integer niveau_radiation;

    public EmissionRadiation(LocalDate uneDate, String unLieu, Integer uneImportance, Integer unNiveauRadiation) {
        super(uneDate, unLieu, uneImportance);
        this.niveau_radiation = uneImportance;
        this.niveau_radiation = unNiveauRadiation;
    }

}