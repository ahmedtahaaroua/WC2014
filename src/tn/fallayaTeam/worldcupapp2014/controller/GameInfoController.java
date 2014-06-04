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
import tn.fallayaTeam.worldcupapp2014.entities.GameInfo;

public class GameInfoController {
	URL url;

	public GameInfoController(URL url) {
		super();
		this.url = url;
	}
	

	public List<GameInfo> getAllGameInfo(){
		List<GameInfo> a_retourner=new ArrayList<GameInfo>();
	
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
			result="{\"Android\":"+result+"}";
			System.out.println(result+"eee");
			try {
				JSONObject jsonObject=new JSONObject(result);
				JSONArray jsonArray = jsonObject.optJSONArray("Android");
				System.out.println("sqsss"+jsonArray.length());
				for(int i=0;i<jsonArray.length();i++){
				GameInfo GameInfo=new GameInfo();
				GameInfo.setId(Integer.parseInt(jsonArray.getJSONObject(i).get("iId").toString()));
				GameInfo.setDescription(jsonArray.getJSONObject(i).get("sDescription").toString());
				GameInfo.setDate(java.sql.Date.valueOf(jsonArray.getJSONObject(i).get("dPlayDate").toString()));	
				GameInfo.setStade(StadeController.getStadeFromGameInfo(jsonArray.getJSONObject(i).get("StadiumInfo").toString()).get(0));
				GameInfo.setTeam1(TeamController.getTeamFromGameInfo(jsonArray.getJSONObject(i).get("Team1").toString()).get(0));
				GameInfo.setTeam2(TeamController.getTeamFromGameInfo(jsonArray.getJSONObject(i).get("Team2").toString()).get(0));
				GameInfo.setResultat(jsonArray.getJSONObject(i).get("sResult").toString());
				GameInfo.setScore(jsonArray.getJSONObject(i).get("sScore").toString());
				GameInfo.setYellowCards(Integer.parseInt(jsonArray.getJSONObject(i).get("iYellowCards").toString()));
				GameInfo.setRedCards(Integer.parseInt(jsonArray.getJSONObject(i).get("iRedCards").toString()));
				GameInfo.setCards(GameCardController.getGameCardFromGameInfo(jsonArray.getJSONObject(i).get("Cards").toString()));
				GameInfo.setGoals(GoalController.getGoalFromGameInfo(jsonArray.getJSONObject(i).get("Goals").toString()));
				GameInfo.setChampion(Boolean.valueOf(jsonArray.getJSONObject(i).get("bChampion").toString()));

				//GameInfo.setUrlMap(jsonArray.getJSONObject(i).get("sGoogleMapsURL").toString());
					a_retourner.add(GameInfo);
				}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		  }
		
	 return a_retourner;
	}
}
