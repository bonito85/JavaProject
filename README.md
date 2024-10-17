# Système de Gestion des Contraventions Policières

## Description
Ce projet consiste à développer une application Java permettant de gérer les contraventions émises par la police. L'application facilite la gestion des informations sur les contrevenants, les agents de police, les types d'infractions, et le suivi des paiements des amendes.

## Objectifs Pédagogiques
- Utiliser des classes et interfaces pour modéliser les entités.
- Gérer des collections pour stocker les contraventions et les paiements.
- Implémenter des fonctionnalités de recherche et de filtrage.
- Créer une interface utilisateur pour interagir avec l'application.

## Modélisation des Entités
### 1. Contrevenant
Représente les personnes recevant des contraventions.
- **Attributs :**
  - Nom
  - Adresse
  - Numéro de permis de conduire

### 2. AgentDePolice
Représente les agents de police émettant des contraventions.
- **Attributs :**
  - Nom
  - Numéro de matricule
  - Poste de police

### 3. Infraction
Gère les types d'infractions.
- **Attributs :**
  - Description de l'infraction
  - Montant de l'amende

### 4. Contravention
Gère les contraventions émises.
- **Attributs :**
  - Date
  - Heure
  - Lieu
  - Agent de police
  - Infraction
  - Contrevenant

### 5. Paiement
Suit le paiement des amendes.
- **Attributs :**
  - Date du paiement
  - Montant payé
  - État de la contravention (payée ou non)

## Fonctionnalités Principales
1. **Gestion des Contraventions**
   - Ajouter, modifier et supprimer des contraventions.
   - Afficher la liste des contraventions et leurs détails.

2. **Suivi des Paiements**
   - Enregistrer les paiements et mettre à jour l'état des contraventions.
   - Consulter les contraventions non payées ou en retard.

3. **Recherche et Gestion des Contrevenants**
   - Rechercher des contrevenants par nom, numéro de permis ou adresse.
   - Afficher l'historique des contraventions et signaler les récidivistes.


4. **Gestion des Exceptions**
   - Gérer les erreurs potentielles avec des messages d'information appropriés.


## Installation
1. Clonez le dépôt :
   ```bash
   git clone https://github.com/bonito85/gestion-contraventions.git
   cd gestion-contraventions
