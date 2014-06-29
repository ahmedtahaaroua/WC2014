package tn.fallayaTeam.worldcupapp2014.entities;

import java.util.Date;

public class GameCard {
Date dateGame;
int minute;
String playerName;
Boolean yCard;
Boolean rCard;
Team team;
public Date getDateGame() {
	return dateGame;
}
public void setDateGame(Date dateGame) {
	this.dateGame = dateGame;
}
public int getMinute() {
	return minute;
}
public void setMinute(int minute) {
	this.minute = minute;
}
public String getPlayerName() {
	return playerName;
}
public void setPlayerName(String playerName) {
	this.playerName = playerName;
}
public Boolean getyCard() {
	return yCard;
}
public void setyCard(Boolean yCard) {
	this.yCard = yCard;
}
public Boolean getrCard() {
	return rCard;
}
public void setrCard(Boolean rCard) {
	this.rCard = rCard;
}
public Team getTeam() {
	return team;
}
public void setTeam(Team team) {
	this.team = team;
}

}
