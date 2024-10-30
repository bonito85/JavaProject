package DAO;

import Exceptions.InvalidInputException;
import models.Contravention;
import models.Contrevenant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContraventionDAO {
    private Connection connection;

    public ContraventionDAO (Connection connection) {
        this.connection = connection;
    }

    //Ajouter une contravention

    public void ajouterContravention(Contravention contravention) throws SQLException {
        String query = "SELECT INTO contraventions (date, lieu, agentId, infractionId, contrevenantId) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, contravention.getDate());
            stmt.setString(2, contravention.getLieu());
            stmt.setString(3, String.valueOf(contravention.getAgentId()));
            stmt.setString(1, String.valueOf(contravention.getInfractionId()));
            stmt.setString(1, String.valueOf(contravention.getContrevenantId()));
            stmt.executeUpdate();
        }
    }
    // Lire les contraventions par l'id
    public Contravention getContraventionById(int id) throws SQLException, InvalidInputException {
        String query = "SELECT * FROM contraventions WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Contravention(rs.getString("date"), rs.getString("lieu"), rs.getInt("agentId"), rs.getInt("infractionId"), rs.getInt("contrevenantId"));
            }
        }
        return null;
    }

    //Obtenir toutes les contraventions

    public List<Contravention> getAllContraventions() throws SQLException, InvalidInputException {
        List<Contravention> contraventions = new ArrayList<>();
        String query = "SELECT * FROM contraventions";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())  {
                contraventions.add(new Contravention(rs.getString("date"), rs.getString("lieu"), rs.getInt("agentId"), rs.getInt("infractionId"), rs.getInt("contrevenantId")));
            }
        }
        return contraventions;
    }

    //Mettre a jour une contravention

    public void mettreAJourContravention(Contravention contravention, int id) throws SQLException {
        String query = "UPDATE contraventions SET date = ?, lieu = ?, agentId = ?, infractionId = ?, contrevenantId = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, contravention.getDate());
            stmt.setString(2, contravention.getLieu());
            stmt.setString(3, String.valueOf(contravention.getAgentId()));
            stmt.setString(4, String.valueOf(contravention.getInfractionId()));
            stmt.setString(5, String.valueOf(contravention.getContrevenantId()));
            stmt.setInt(6, id);
            stmt.executeUpdate();
        }
    }

    // Suprimer un agent une contravention

    public void supprimerContravention(int id) throws SQLException {
        String query = "DELETE FROM contraventions WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }


}
