package Interfaces;

import Exceptions.InvalidInputException;

public interface Personne {
    String getNom();
    void setNom(String nom) throws InvalidInputException;
    String getAdresse();
    void setAdresse(String adresse);
}
