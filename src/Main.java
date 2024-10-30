import DAO.*;
import Exceptions.InvalidInputException;
import models.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static String URL = "jdbc:mysql://127.0.0.1:3306/gestionnaire_contravention";
    public static String USER = "root";
    public static String PASSWORD = "mysql@123";

    //---------------------------------------------------------
            /*
            * Partie principale
            * */
    //----------------------------------------------------------
    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connexion a la base de donnée avec succes :=)");

            // Creations des DAO
            AgentDePoliceDAO agentDePoliceDAO = new AgentDePoliceDAO(connection);
            ContrevenantDAO contrevenantDAO = new ContrevenantDAO(connection);
            InfractionDAO infractionDAO = new InfractionDAO(connection);
            ContraventionDAO contraventionDAO = new ContraventionDAO(connection);
            PaiementDAO paiementDAO = new PaiementDAO(connection);


            //------------------------------------------
                  /**
                   * Ajout d'agents de Police
                   * */
            AgentDePolice agent = new AgentDePolice("Delamoi", "P0025B5", "Commissariat Central", "Ouagadougou1");
            agentDePoliceDAO.ajouterAgent(agent);
            //-------------------------------------------

            //------------------------------------------
            /**
             * Ajout d'un contrevenant
             * */
            Contrevenant contrevenant = new Contrevenant("Tynkai","Ouagadougou1", "P010203");
            contrevenantDAO.ajouterContrevenant(contrevenant);
            //-------------------------------------------

            //------------------------------------------
            /**
             * Ajout d'une infraction
             * */
            Infraction infraction = new Infraction("Stationnement Interdit", 3600);
            infractionDAO.ajouterInfraction(infraction);
            //-------------------------------------------

            //------------------------------------------
            /**
             * Ajout d'une contravention
             * */
            Contravention contravention = new Contravention("12-05-20023", "Ouagadougou", agent.getId(), infraction.getId(), contrevenant.getId());
            contraventionDAO.ajouterContravention(contravention);
            //-------------------------------------------

            //------------------------------------------
            /**
             * Ajout d'un moyen de paiement
             * */
            Paiement paiement = new Paiement("12-02-2023", 150, contravention.getId());
            paiementDAO.ajouterPaiement(paiement);
            //-------------------------------------------



        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion a la base de donnée : " + e.getMessage());
        } catch (InvalidInputException e) {
            throw new RuntimeException(e);
        }

    }
}
