package DAO;

import models.Contravention;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        }
    }
    // Lire les contraventions par l'id


}
