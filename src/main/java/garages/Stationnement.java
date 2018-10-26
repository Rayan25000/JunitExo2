package garages;

import java.util.Date;

public class Stationnement {
    private final Voiture myCar;
    private final Garage myGarage;
    
    private final Date entree = new Date(); // Aujourd'hui
    private Date fin;

    public Stationnement(Voiture v, Garage g) {
        myCar = v;
        myGarage = g;
    }

    public Voiture getCar() {
        return myCar;
    }

    public Garage getGarage() {
        return myGarage;
    }

    public Date getEntree() {
        return entree;
    }

    public Date getFin() {
        return fin;
    }

    public void terminer() {
        fin = new Date();
    }

    public boolean estEnCours() {
        return (fin == null);
    }

}
