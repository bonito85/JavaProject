package DAO;
import Exceptions.InvalidInputException;
import models.Contrevenant;
import java.sql.*;
import  java.util.ArrayList;
import java.util.List;

public class ContrevenantDAO {
    private Connection connection;

    public ContrevenantDAO(Connection connection) {
        this.connection = connection;
    }

    //Fonction pour ajouter un contrevenant

    public void ajouterContrevenant(Contrevenant contrevenant) throws  SQLException {
        String query = "INSERT INTO contrevenants (nom, adresse, numeroPermis) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            //Verification du nom NULL
            String nom = contrevenant.getNom();
            if(nom == null) {
                nom = "Inconnu"; // Valeur par defaut pour le nom
            }
            stmt.setString(1, contrevenant.getNom());
            stmt.setString(2, contrevenant.getAdresse());
            stmt.setString(3, contrevenant.getNumeroPermis());
            stmt.executeUpdate();
        }
    }

    // Chercher un contrevenant par ID

    public Contrevenant getContrevenantById(int id) throws SQLException, InvalidInputException {
        String query = "SELECT * FROM contrevenants WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Contrevenant(rs.getString("nom"), rs.getString("adresse"), rs.getString("numerPermis"));
            }
        }
        return null;
    }

    // Fonction pour obtenir tous les contrevenants

    public List<Contrevenant> getAllContrevenants() throws SQLException, InvalidInputException {
        List<Contrevenant> contrevenants = new ArrayList<>();
        String query = "SELECT * FROM contrevenants";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())  {
                contrevenants.add(new Contrevenant(rs.getString("nom"), rs.getString("adresse"), rs.getString("numeroPermis")));
            }
        }
        return contrevenants;
    }

    //Mettre a jour un contrevenant

    public void mettreAJourContrevenant(Contrevenant contrevenant, int id) throws SQLException {
        String query = "UPDATE contrevenants SET nom = ?, adresse = ?, numeroPermis = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, contrevenant.getNom());
            stmt.setString(2, contrevenant.getAdresse());
            stmt.setString(3, contrevenant.getNumeroPermis());
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    //Supprimer un contrevenant

    public void supprimerContrevenant(int id) throws SQLException {
        String query = "DELETE FROM contrevenants WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}
