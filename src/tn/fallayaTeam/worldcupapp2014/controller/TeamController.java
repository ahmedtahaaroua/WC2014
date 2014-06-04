package tn.fallayaTeam.worldcupapp2014.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.text.format.DateFormat;
import tn.fallayaTeam.worldcupapp2014.entities.Team;

public class TeamController {
	URL url;

	public TeamController(URL url) {
		super();
		this.url = url;
	}
	

	public List<Team> getAllTeam(){
		List<Team> a_retourner=new ArrayList<Team>();
	
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
			a_retourner = getTeamFromGameInfo(result);
	 
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		  }
		
	 return a_retourner;
	}


	static public List<Team> getTeamFromGameInfo( String result) {
		List<Team> to_return=new ArrayList<Team>();

		result="{\"Androidd\":["+result+"]}";
		System.out.println(result+"eee");
		try {
			JSONObject jsonObject=new JSONObject(result);
			JSONArray jsonArray = jsonObject.optJSONArray("Androidd");
			System.out.println("sqsss"+jsonArray.length());
			for(int i=0;i<jsonArray.length();i++){
			Team Team=new Team();
			Team.setId(Integer.parseInt(jsonArray.getJSONObject(i).get("iId").toString()));
			Team.setName(jsonArray.getJSONObject(i).get("sName").toString());
			Team.setUrlMinFlag(jsonArray.getJSONObject(i).get("sCountryFlag").toString());
			Team.setUrlMaxFlag(jsonArray.getJSONObject(i).get("sCountryFlagLarge").toString());	
			Team.setUrlWiki(jsonArray.getJSONObject(i).get("sWikipediaURL").toString());
				to_return.add(Team);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return to_return;
	}
	static public List<Team> getTeam( String result) {
		List<Team> to_return=new ArrayList<Team>();

		result="{\"Android\":"+result+"}";
		System.out.println(result+"eee");
		try {
			JSONObject jsonObject=new JSONObject(result);
			JSONArray jsonArray = jsonObject.optJSONArray("Android");
			System.out.println("sqsss"+jsonArray.length());
			for(int i=0;i<jsonArray.length();i++){
			Team Team=new Team();
			Team.setId(Integer.parseInt(jsonArray.getJSONObject(i).get("iId").toString()));
			Team.setName(jsonArray.getJSONObject(i).get("sName").toString());
			Team.setUrlMinFlag(jsonArray.getJSONObject(i).get("sCountryFlag").toString());
			Team.setUrlMaxFlag(jsonArray.getJSONObject(i).get("sCountryFlagLarge").toString());	
			Team.setUrlWiki(jsonArray.getJSONObject(i).get("sWikipediaURL").toString());
				to_return.add(Team);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return to_return;
	}
}
