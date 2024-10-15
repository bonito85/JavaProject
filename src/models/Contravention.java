package models;

public class Contravention {
    private int id;
    private String date;
    private String lieu;
    private AgentDePolice agentId;
    private Infraction infractionId;
    private Contrevenant contrevenantId;


    //Constructeur de la classe Contrevenant
    public Contravention(String date, String lieu, AgentDePolice agent, Infraction infraction, Contrevenant contrevenant) {
        this.date = date;
        this.lieu = lieu;
        this.agentId = agent;
        this.infractionId= infractionId;
        this.contrevenantId = contrevenantId;
    }
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


    public AgentDePolice getAgentId() {
        return agentId;
    }

    public void setAgentId(AgentDePolice agentId) {
        this.agentId = agentId;
    }

    public Infraction getInfractionId() {
        return infractionId;
    }

    public void setInfractionId(Infraction infractionId) {
        this.infractionId = infractionId;
    }

    public Contrevenant getContrevenantId() {
        return contrevenantId;
    }

    public void setContrevenantId(Contrevenant contrevenantId) {
        this.contrevenantId = contrevenantId;
    }
}
