import DAO.ContrevenantDAO;
import Exceptions.InvalidInputException;
import models.Contrevenant;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(
                    "jbdc:mysql://127.0.0.1:3306/gestionnaire_contravention",
                    "root",
                    "mysql@123"
            );

            // Creation
            try {
                Contrevenant contrevenant = new Contrevenant("Michael", "Ouagadougou", "A0023");
                ContrevenantDAO contrevenantDAO = new ContrevenantDAO(connection);
                System.out.println("Le contrevenant a ete ajoutée avec success :)");

            } catch (InvalidInputException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
