package models;

public class Contravention {
    private int id;
    private String date;
    private String lieu;
    private AgentDePolice agent;
    private Infraction infraction;
    private Contrevenant contrevenant;


    //Constructeur de la classe Contrevenant
    public Contravention(String date, String lieu, AgentDePolice agent, Infraction infraction, Contrevenant contrevenant) {
        this.date = date;
        this.lieu = lieu;
        this.agent = agent;
        this.infraction = infraction;
        this.contrevenant = contrevenant;
    }
//Getters et Setters

    public AgentDePolice getAgent() {
        return agent;
    }

    public void setAgent(AgentDePolice agent) {
        this.agent = agent;
    }

    public Infraction getInfraction() {
        return infraction;
    }

    public void setInfraction(Infraction infraction) {
        this.infraction = infraction;
    }

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

    public Contrevenant getContrevenant() {
        return contrevenant;
    }

    public void setContrevenant(Contrevenant contrevenant) {
        this.contrevenant = contrevenant;
    }

    public int getId() {
        return id;
    }


}
