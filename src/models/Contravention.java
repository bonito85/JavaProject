package models;

public class Contravention {
    private int id;
    private String date;
    private String lieu;
    private AgentDePolice agent ;
    private Infraction infraction;
    private Contrevenant contrevenant;
    private int agentId;
    private int infractionId;
    private int contrevenantId;


    //Constructeur de la classe Contrevenant
   /* public Contravention(String date, String lieu, AgentDePolice agent, Infraction infraction, Contrevenant contrevenant) {
        this.date = date;
        this.lieu = lieu;
        this.agent = agent;
        this.infraction = infraction;
        this.contrevenant = contrevenant ;
    }*/

    public Contravention(String date, String lieu, int agentId, int infractionId, int contrevenatId) {
        this.date = date;
        this.lieu = lieu;
        this.agentId = agentId;
        this.infractionId = infractionId;
        this.contrevenantId = contrevenatId;
    }

    //--------------------------------------------------------------------------------

    /*
    * Getters et les setters pour le second constructeur

    * */

    public void setId(int id) {
        this.id = id;
    }


    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public void setInfractionId(int infractionId) {
        this.infractionId = infractionId;
    }

    public int getInfractionId() {
        return infractionId;
    }

    public int getContrevenantId() {
        return contrevenantId;
    }

    public void setContrevenantId(int contrevenantId) {
        this.contrevenantId = contrevenantId;
    }
    //------------------------------------------------------------------------------------


//Getters et Setters


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getId() {
        return id;
    }


    public AgentDePolice getAgent() {
        return agent;
    }

    public void setAgentId(AgentDePolice agent) {
        this.agent = agent;
    }

    public Infraction getInfraction() {
        return infraction;
    }

    public void setInfractionId(Infraction infraction) {

        this.infraction = infraction;
    }

    public Contrevenant getContrevenant() {
        return contrevenant;
    }

    public void setContrevenant(Contrevenant contrevenant) {
        this.contrevenant = contrevenant;
    }

}
