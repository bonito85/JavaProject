package models;

public class Infraction {
    private int id;
    private String description;
    private double montantAmende;

    //Constructeur de la classe Infraction

    public Infraction(String description, double montantAmende) {
        this.description = description;
        this.montantAmende = montantAmende;
    }
    //Getters et les setters

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMontantAmende(double montantAmende) {
        this.montantAmende = montantAmende;
    }

    public double getMontantAmende() {
        return montantAmende;
    }
}
