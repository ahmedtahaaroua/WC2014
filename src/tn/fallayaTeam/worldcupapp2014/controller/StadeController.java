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

import tn.fallayaTeam.worldcupapp2014.entities.Stade;

public class StadeController {
	URL url;

	public StadeController(URL url) {
		super();
		this.url = url;
	}
	

	public List<Stade> getAllStade(){
		List<Stade> a_retourner=new ArrayList<Stade>();
	
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
				Stade Stade=new Stade();
				Stade.setName(jsonArray.getJSONObject(i).get("sStadiumName").toString());
				Stade.setCapacity(Integer.parseInt(jsonArray.getJSONObject(i).get("iSeatsCapacity").toString()));
				Stade.setCity(jsonArray.getJSONObject(i).get("sCityName").toString());	
				Stade.setUrlWiki(jsonArray.getJSONObject(i).get("sWikipediaURL").toString());
				Stade.setUrlMap(jsonArray.getJSONObject(i).get("sGoogleMapsURL").toString());
					a_retourner.add(Stade);
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
