package DAO;

import Exceptions.InvalidInputException;
import models.Contravention;
import models.Paiement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaiementDAO {
    private Connection connection;

    public PaiementDAO (Connection connection) {
        this.connection = connection;
    }

    //Ajouter un paiement

    public void ajouterPaiement(Paiement paiement) throws SQLException {
        String query = "SELECT INTO paiements (montant, datePaiement, contraventionId, infractionId) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(paiement.getMontant()));
            stmt.setString(2, paiement.getDatePaiement());
            stmt.setString(3, String.valueOf(paiement.getContraventionId()));
            stmt.executeUpdate();

        }
    }
    // Lire les paiements par l'id
    public Paiement getPaiementById(int id) throws SQLException, InvalidInputException {
        String query = "SELECT * FROM paiements WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Paiement(rs.getString("date"), rs.getDouble("montantPaiement"), rs.getInt("contraventionId"));
            }
        }
        return null;
    }

    //Obtenir toutes les contraventions

    public List<Paiement> getAllPaiements() throws SQLException, InvalidInputException {
        List<Paiement> paiements = new ArrayList<>();
        String query = "SELECT * FROM paiements";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())  {
                paiements.add(new Paiement(rs.getString("date"), rs.getDouble("montantPaiement"), rs.getInt("contraventionId")));
            }
        }
        return paiements;
    }

    //Mettre a jour un paiement

    public void mettreAJourPaiement(Paiement paiement, int id) throws SQLException {
        String query = "UPDATE paiements SET date = ?, montantPaiement = ?, contraventionId = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, paiement.getDatePaiement());
            stmt.setString(2, String.valueOf(paiement.getMontant()));
            stmt.setString(3, String.valueOf(paiement.getContraventionId()));
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    // Suprimer un paiement

    public void supprimerPaiement(int id) throws SQLException {
        String query = "DELETE FROM paiements WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
