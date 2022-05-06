import java.time.*;

public class EmissionGaz extends AnomalieEvent {

    String type;

    public EmissionGaz(LocalDate uneDate, String unLieu, int uneImportance, String unType) {
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