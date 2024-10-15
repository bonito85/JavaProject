package models;

public class Paiement {
    private int id;
    private String datePaiement;
    private double montant;
    private boolean esPaye;

    //Constructeur de la classe Paiement

    public Paiement(String datePaiement, double montant, boolean esPaye) {
        this.datePaiement = datePaiement;
        this.montant = montant;
        this.esPaye = esPaye;
    }
    //Getters et les setters
    public boolean isEsPaye() {
        return esPaye;
    }
    public void setEsPaye(boolean esPaye) {
        this.esPaye = esPaye;
    }

    public String getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(String datePaiement) {
        this.datePaiement = datePaiement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}