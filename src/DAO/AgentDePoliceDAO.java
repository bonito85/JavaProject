package DAO;

import Exceptions.InvalidInputException;
import models.AgentDePolice;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AgentDePoliceDAO {
    private Connection connection;

    public AgentDePoliceDAO(Connection connection) {
        this.connection = connection;
    }

    // Ajouter un agent de Police

    public void ajouterAgent(AgentDePolice agent) throws SQLException {
        String query = "INSERT INTO agents (nom, matricule, poste, adresse) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, agent.getNom());
            stmt.setString(2, agent.getMatricule());
            stmt.setString(3, agent.getPoste());
            stmt.setString(4, agent.getAdresse());
            stmt.executeUpdate();
        }
    }

    // Lire les informations les informations des agents par l'ID

    public AgentDePolice getAgentById(int id) throws SQLException, InvalidInputException {
        String query = "SELECT * FROM agents WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new AgentDePolice(rs.getString("nom"), rs.getString("matricule"), rs.getString("poste"), rs.getString("adresse"));

            }
        }
        return null;
    }

    // Obtenir tous les agents de Police

    public List<AgentDePolice> getAllAgents() throws SQLException, InvalidInputException {
        List<AgentDePolice> agents = new ArrayList<>();
        String query = "SELECT * FROM agents";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                agents.add(new AgentDePolice(rs.getString("nom"), rs.getString("matricule"), rs.getString("poste"), rs.getString("adresse") ));
            }
        }
        return agents;
    }

    // Mettre a jour les agents de police

    public void mettreAJourAgent(AgentDePolice agent, int id) throws SQLException{
        String query = "UPDATE agents SET nom = ?, matricule = ?, poste = ?, adresse = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, agent.getNom());
            stmt.setString(2, agent.getMatricule());
            stmt.setString(3, agent.getPoste());
            stmt.setString(4, agent.getAdresse());
            stmt.executeUpdate();
        }
    }

    //Supprimer un agent de Police

    public void supprimerAgentDePolice(int id) throws SQLException {
        String query = "DELETE FROM agents WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }


}
