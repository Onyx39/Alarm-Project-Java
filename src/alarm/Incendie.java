package alarm;
import java.time.*;

public class Incendie extends AnomalieEvent {

    public Incendie(LocalDate uneDate, Batiment unLieu, Integer unNiveau) {
        super(uneDate, unLieu, unNiveau);
    }


}