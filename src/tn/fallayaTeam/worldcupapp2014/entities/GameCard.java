package tn.fallayaTeam.worldcupapp2014.entities;

import java.util.Date;

public class GameCard {
Date dateGame;
int minute;
String playerName;
Boolean yCard;
Boolean rCard;
String teamName;
String teamFlag;
String teamFlagLarge;
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
public String getTeamName() {
	return teamName;
}
public void setTeamName(String teamName) {
	this.teamName = teamName;
}
public String getTeamFlag() {
	return teamFlag;
}
public void setTeamFlag(String teamFlag) {
	this.teamFlag = teamFlag;
}
public String getTeamFlagLarge() {
	return teamFlagLarge;
}
public void setTeamFlagLarge(String teamFlagLarge) {
	this.teamFlagLarge = teamFlagLarge;
}


}
