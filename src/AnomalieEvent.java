import java.time.*;

class AnomalieEvent {

    LocalDate date;
    String lieu;
    int importance;

    public AnomalieEvent (LocalDate uneDate, String unLieu, int uneImportance) {
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

    public void setImportance (int newImportance) {
        this.importance = newImportance;
    }

 

//Getters

    public LocalDate getDate (){
        return this.date;
    }

    public String getLieu (){
        return this.lieu;
    }

    public int getImportance (){
        return this.importance;
    }


}