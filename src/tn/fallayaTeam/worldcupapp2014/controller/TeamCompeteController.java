package tn.fallayaTeam.worldcupapp2014.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tn.fallayaTeam.worldcupapp2014.entities.Coach;
import tn.fallayaTeam.worldcupapp2014.entities.TeamCompete;


public class TeamCompeteController {
	URL url;

	public TeamCompeteController(URL url) {
		super();
		this.url = url;
	}
	

	public List<TeamCompete> getAllTeamCompete(){
		List<TeamCompete> a_retourner=new ArrayList<TeamCompete>();
	
		try {
			 
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			conn.setRequestProperty("Accept", "application/json");
	 
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
	 
			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
	 
			String output;
			String result="";
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				result+=output;
				System.out.println(output);
			}
			
			conn.disconnect();
			
			
			a_retourner = getTeamCompete(result);
	 
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		  }
		
	 return a_retourner;
	}


	static public List<TeamCompete> getTeamCompete(String result) {
		List<TeamCompete> to_return=new ArrayList<TeamCompete>();

		result="{\"Androidd\":["+result+"]}";
		System.out.println(result+"eee");
		try {
			JSONObject jsonObject=new JSONObject(result);
			JSONArray jsonArray = jsonObject.optJSONArray("Androidd");
			System.out.println("sqsss"+jsonArray.length());
			for(int i=0;i<jsonArray.length();i++){
			TeamCompete tCompete = new TeamCompete();
			tCompete.setCompeted(Integer.parseInt(jsonArray.getJSONObject(i).get("iCompeted").toString()));
			tCompete.setWon(Integer.parseInt(jsonArray.getJSONObject(i).get("iWon").toString()));
			tCompete.setCoach(CoachController.getCoach(jsonArray.getJSONObject(i).get("CoachInfo").toString()).get(0));
			
			
				to_return.add(tCompete);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return to_return;
	}
}
