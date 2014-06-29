package tn.fallayaTeam.worldcupapp2014.entities;

import java.util.Date;

public class Goal {
Date dateGame;
int minute;
String playerName;
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
public Team getTeam() {
	return team;
}
public void setTeam(Team team) {
	this.team = team;
}


}
