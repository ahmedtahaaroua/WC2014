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

import tn.fallayaTeam.worldcupapp2014.entities.Goal;

public class GoalController {
	URL url;

	public GoalController(URL url) {
		super();
		this.url = url;
	}
	

	public List<Goal> getAllGoal(){
		List<Goal> a_retourner=new ArrayList<Goal>();
	
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
			a_retourner = getGoalFromGameInfo(result);
	 
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		  }
		
	 return a_retourner;
	}


	static public List<Goal> getGoalFromGameInfo( String result) {
		List<Goal> to_return=new ArrayList<Goal>();

		result="{\"Androidd\":["+result+"]}";
		System.out.println(result+"eee");
		try {
			JSONObject jsonObject=new JSONObject(result);
			JSONArray jsonArray = jsonObject.optJSONArray("Androidd");
			System.out.println("sqsss"+jsonArray.length());
			for(int i=0;i<jsonArray.length();i++){
			Goal Goal=new Goal();
			Goal.setDateGame(java.sql.Date.valueOf(jsonArray.getJSONObject(i).get("dGame").toString()));
			Goal.setMinute(Integer.parseInt(jsonArray.getJSONObject(i).get("iMinute").toString()));
			Goal.setPlayerName(jsonArray.getJSONObject(i).get("sPlayerName").toString());
			Goal.setTeamName(jsonArray.getJSONObject(i).get("sTeamName").toString());
			Goal.setTeamFlag(jsonArray.getJSONObject(i).get("sTeamFlag").toString());
			Goal.setTeamFlagLarge(jsonArray.getJSONObject(i).get("sTeamFlagLarge").toString());	
				to_return.add(Goal);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return to_return;
	}
}
