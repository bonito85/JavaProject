package models;

public class Paiement {
    private int id;
    private String datePaiement;
    private double montant;
    private boolean esPaye;
    private Contravention contraventionId;

    //Constructeur de la classe Paiement

    public Paiement(String datePaiement, double montant, boolean esPaye, Contravention contraventionId) {
        this.datePaiement = datePaiement;
        this.montant = montant;
        this.contraventionId = contraventionId;
        this.esPaye = esPaye;
    }

    public Paiement(String date, double montantPaiement, int contraventionId) {
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

    public Contravention getContraventionId() {
        return contraventionId;
    }

    public void setContraventionId(Contravention contraventionId) {
        this.contraventionId = contraventionId;
    }
}
