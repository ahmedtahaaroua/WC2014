package tn.fallayaTeam.worldcupapp2014.entities;

import java.util.List;

public class Group {
String nom;
List<Team> teams;
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public List<Team> getTeams() {
	return teams;
}
public void setTeams(List<Team> teams) {
	this.teams = teams;
}
}
