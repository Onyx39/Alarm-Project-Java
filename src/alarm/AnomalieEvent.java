package alarm;
import java.time.*;

public class AnomalieEvent {

    LocalDate date;
    Batiment lieu;
    Integer importance;

    public AnomalieEvent (LocalDate uneDate, Batiment unLieu, Integer uneImportance) {
        date = uneDate;
        lieu = unLieu;
        importance = uneImportance;
    }


//Setters

    public void setDate (LocalDate newDate) {
        this.date = newDate;
    }

    public void setLieu (Batiment newLieu) {
        this.lieu = newLieu;
    }

    public void setImportance (Integer newImportance) {
        this.importance = newImportance;
    }

 

//Getters

    public LocalDate getDate (){
        return this.date;
    }

    public Batiment getLieu (){
        return this.lieu;
    }

    public Integer getImportance (){
        return this.importance;
    }



}