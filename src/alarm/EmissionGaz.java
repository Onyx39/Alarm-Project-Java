package alarm;
import java.time.*;

public class EmissionGaz extends AnomalieEvent {

    String type;

    public EmissionGaz(LocalDate uneDate, Batiment unLieu, Integer uneImportance, String unType) {
        super(uneDate, unLieu, uneImportance);
        this.type = unType;
    }

//Setters

    public void setType (String newType) {
        this.type = newType;
    }

//Getters 

    public String getType () {
        return this.type;
    }

}