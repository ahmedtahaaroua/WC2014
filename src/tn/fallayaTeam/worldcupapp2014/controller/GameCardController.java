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

import tn.fallayaTeam.worldcupapp2014.entities.GameCard;

public class GameCardController {
	URL url;

	public GameCardController(URL url) {
		super();
		this.url = url;
	}
	

	public List<GameCard> getAllGameCard(){
		List<GameCard> a_retourner=new ArrayList<GameCard>();
	
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
			a_retourner = getGameCardFromGameInfo(result);
	 
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		  }
		
	 return a_retourner;
	}


	static public List<GameCard> getGameCardFromGameInfo( String result) {
		List<GameCard> to_return=new ArrayList<GameCard>();

		result="{\"Androidd\":["+result+"]}";
		System.out.println(result+"eee");
		try {
			JSONObject jsonObject=new JSONObject(result);
			JSONArray jsonArray = jsonObject.optJSONArray("Androidd");
			System.out.println("sqsss"+jsonArray.length());
			for(int i=0;i<jsonArray.length();i++){
			GameCard GameCard=new GameCard();
			GameCard.setDateGame(java.sql.Date.valueOf(jsonArray.getJSONObject(i).get("dGame").toString()));
			GameCard.setMinute(Integer.parseInt(jsonArray.getJSONObject(i).get("iMinute").toString()));
			GameCard.setPlayerName(jsonArray.getJSONObject(i).get("sPlayerName").toString());
			GameCard.setyCard(Boolean.valueOf(jsonArray.getJSONObject(i).get("bYellowCard").toString()));
			GameCard.setrCard(Boolean.valueOf(jsonArray.getJSONObject(i).get("bRedCard").toString()));	
			GameCard.setTeamName(jsonArray.getJSONObject(i).get("sTeamName").toString());
			GameCard.setTeamFlag(jsonArray.getJSONObject(i).get("sTeamFlag").toString());
			GameCard.setTeamFlagLarge(jsonArray.getJSONObject(i).get("sTeamFlagLarge").toString());	
			to_return.add(GameCard);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return to_return;
	}
}
