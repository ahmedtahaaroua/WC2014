package tn.fallayaTeam.worldcupapp2014.entities;

import java.util.List;

public class Team {
int id;
String name;
String urlMinFlag;
String urlMaxFlag;
String urlWiki;
String Coach;
int competed;
List<String> goalKeepers;
List<String> Defensers;
List<String> midFields;
List<String> forwards; 
public String getCoach() {
	return Coach;
}
public void setCoach(String coach) {
	Coach = coach;
}
public int getCompeted() {
	return competed;
}
public void setCompeted(int competed) {
	this.competed = competed;
}
public List<String> getGoalKeepers() {
	return goalKeepers;
}
public void setGoalKeepers(List<String> goalKeepers) {
	this.goalKeepers = goalKeepers;
}
public List<String> getDefensers() {
	return Defensers;
}
public void setDefensers(List<String> defensers) {
	Defensers = defensers;
}
public List<String> getMidFields() {
	return midFields;
}
public void setMidFields(List<String> midFields) {
	this.midFields = midFields;
}
public List<String> getForwards() {
	return forwards;
}
public void setForwards(List<String> forwards) {
	this.forwards = forwards;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUrlMinFlag() {
	return urlMinFlag;
}
public void setUrlMinFlag(String urlMinFlag) {
	this.urlMinFlag = urlMinFlag;
}
public String getUrlMaxFlag() {
	return urlMaxFlag;
}
public void setUrlMaxFlag(String urlMaxFlag) {
	this.urlMaxFlag = urlMaxFlag;
}
public String getUrlWiki() {
	return urlWiki;
}
public void setUrlWiki(String urlWiki) {
	this.urlWiki = urlWiki;
}
	
	
	
}
