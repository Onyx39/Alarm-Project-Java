package alarm;
import java.time.*;

public class EmissionRadiation extends AnomalieEvent {

    public Integer niveau_radiation;

    public EmissionRadiation(LocalDate uneDate, Batiment unLieu, Integer uneImportance, Integer unNiveauRadiation) {
        super(uneDate, unLieu, uneImportance);
        this.niveau_radiation = uneImportance;
        this.niveau_radiation = unNiveauRadiation;
    }

    public Integer getNiveau_radiation() {
        return niveau_radiation;
    }

    public void setNiveau_radiation(Integer niveau_radiation) {
        this.niveau_radiation = niveau_radiation;
    }

}