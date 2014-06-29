package tn.fallayaTeam.worldcupapp2014.entities;

import java.util.Date;
import java.util.List;

public class GameInfo {
int id;
String description;
Date date;
String time;
Stade stade;
Team team1;
Team team2;
String resultat;
String score;
int yellowCards;
int redCards;
List<GameCard> cards;
List<Goal> goals;
boolean champion;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public Stade getStade() {
	return stade;
}
public void setStade(Stade stade) {
	this.stade = stade;
}
public Team getTeam1() {
	return team1;
}
public void setTeam1(Team team1) {
	this.team1 = team1;
}
public Team getTeam2() {
	return team2;
}
public void setTeam2(Team team2) {
	this.team2 = team2;
}
public String getResultat() {
	return resultat;
}
public void setResultat(String resultat) {
	this.resultat = resultat;
}
public String getScore() {
	return score;
}
public void setScore(String score) {
	this.score = score;
}
public int getYellowCards() {
	return yellowCards;
}
public void setYellowCards(int yellowCards) {
	this.yellowCards = yellowCards;
}
public int getRedCards() {
	return redCards;
}
public void setRedCards(int redCards) {
	this.redCards = redCards;
}

public List<GameCard> getCards() {
	return cards;
}
public void setCards(List<GameCard> cards) {
	this.cards = cards;
}
public List<Goal> getGoals() {
	return goals;
}
public void setGoals(List<Goal> goals) {
	this.goals = goals;
}
public boolean isChampion() {
	return champion;
}
public void setChampion(boolean champion) {
	this.champion = champion;
}

}
