package tn.fallayaTeam.worldcupapp2014.entities;

import java.util.List;

public class Group {
GroupInfo group;
List<Team> teams;

public GroupInfo getGroup() {
	return group;
}
public void setGroup(GroupInfo group) {
	this.group = group;
}
public List<Team> getTeams() {
	return teams;
}
public void setTeams(List<Team> teams) {
	this.teams = teams;
}
}
