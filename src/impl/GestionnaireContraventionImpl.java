package impl;
import models.Contravention;
import Interfaces.GestionnaireContravention;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireContraventionImpl implements GestionnaireContravention {
    private  List<Contravention> contraventions;

    public GestionnaireContraventionImpl() {
        this.contraventions = new ArrayList<>();
    }

    @Override
    public void ajouterContravention(Contravention contravention) {
        contraventions.add(contravention);
    }

    @Override
    public void supprimerContravention(int id) {
        contraventions.removeIf(contravention -> contravention.getId() == id);
    }

    @Override
    public List<Contravention> rechercherContraventionParContrevenant(int contrevenantId) {
       List<Contravention> resultats = new ArrayList<>();
       for (Contravention contravention : contraventions) {
           if (contravention.getContrevenant().getId() == contrevenantId) {
               resultats.add(contravention);
           }
       }
       return resultats;

    }

    @Override
    public List<Contravention> listerToutesLesContraventions() {
        return contraventions;
    }
}
