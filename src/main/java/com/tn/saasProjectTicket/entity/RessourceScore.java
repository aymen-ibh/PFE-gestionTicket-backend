package com.tn.saasProjectTicket.entity;

public class RessourceScore {
	
	private Ressource ressource;
    private int score;

    public RessourceScore(Ressource ressource, int score) {
        this.ressource = ressource;
        this.score = score;
    }

    public Ressource getRessource() {
        return ressource;
    }

    public int getScore() {
        return score;
    }
}
