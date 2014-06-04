package tn.fallayaTeam.worldcupapp2014.entities;

import java.util.Date;

public class Goal {
Date dateGame;
int minute;
String playerName;
String teamName;
String teamFlag;
String teamFlagLarge;


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



}
