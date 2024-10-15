package Interfaces;

import models.Contravention;

import java.util.List;

public interface GestionnaireContravention {
    void ajouterContravention(Contravention contravention);
    void supprimerContravention(int id);
    List<Contravention> rechercherContraventionParContrevenant(int contrevenantId);
    List<Contravention> listerToutesLesContraventions();
}
