package DAO;

import Exceptions.InvalidInputException;
import models.Contrevenant;
import models.Infraction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InfractionDAO {
    private Connection connection;

    public InfractionDAO(Connection connection) {
        this.connection = connection;
    }
    // Ajouter une infraction
    public void ajouterInfraction(Infraction infraction) throws SQLException {
        String query = "INSERT INTO infractions (description, montantAmende) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, infraction.getDescription());
            stmt.setString(2, String.valueOf(infraction.getMontantAmende()));
            stmt.executeUpdate();
        }
    }
     //Lire une infraction par l'ID
     public Infraction getInfractionById(int id) throws SQLException, InvalidInputException {
        String query = "SELECT * FROM contrevenants WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Infraction(rs.getString("description"), rs.getDouble("montantAmende"));
            }
        }
        return null;
    }

    // Obtenir toutes les infractions

    public List<Infraction> getAllInfractions() throws SQLException, InvalidInputException {
        List<Infraction> infractions = new ArrayList<>();
        String query = "SELECT * FROM contrevenants";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())  {
                infractions.add(new Infraction(rs.getString("description"), rs.getDouble("montantAmende")));
            }
        }
        return infractions;
    }

    // Mettre a jour une infraction

    public void mettreAJourInfraction(Infraction infraction, int id) throws SQLException {
        String query = "UPDATE infractions SET description = ?, montantAmende = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, infraction.getDescription());
            stmt.setString(2, String.valueOf(infraction.getMontantAmende()));
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }

    // Supprimer une infraction



}
