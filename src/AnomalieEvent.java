import java.time.*;

public class AnomalieEvent {

    LocalDate date;
    String lieu;
    Integer importance;

    public AnomalieEvent (LocalDate uneDate, String unLieu, Integer uneImportance) {
        date = uneDate;
        lieu = unLieu;
        importance = uneImportance;
    }


//Setters

    public void setDate (LocalDate newDate) {
        this.date = newDate;
    }

    public void setLieu (String newLieu) {
        this.lieu = newLieu;
    }

    public void setImportance (Integer newImportance) {
        this.importance = newImportance;
    }

 

//Getters

    public LocalDate getDate (){
        return this.date;
    }

    public String getLieu (){
        return this.lieu;
    }

    public Integer getImportance (){
        return this.importance;
    }


}