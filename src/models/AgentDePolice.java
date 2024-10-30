package models;

import Exceptions.InvalidInputException;
import Interfaces.Personne;

public class AgentDePolice implements Personne {
    private int id;
    private String nom;
    private String matricule;
    private String poste;
    private String adresse;

    //Constructeur de la classe AgentDePolice

    public AgentDePolice(String nom, String matricule, String poste, String adresse) throws InvalidInputException{
        this.nom = (nom != null) ? nom : "Inconnu";
        this.matricule = matricule;
        this.poste = poste;
        this.adresse = adresse;
    }

// Getters et les setters
    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) throws InvalidInputException {
        if (!isValidName(nom)) {
            throw new InvalidInputException("Le nom ne doit contenir que des lettres :)");
        }
    }

    @Override
    public String getAdresse() {
        return adresse;
    }

    @Override
    public void setAdresse(String adress) {
        this.adresse = adress;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
