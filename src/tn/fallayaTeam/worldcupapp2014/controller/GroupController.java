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

import android.R;
import android.util.Log;
import tn.fallayaTeam.worldcupapp2014.entities.Group;
import tn.fallayaTeam.worldcupapp2014.entities.GroupInfo;

public class GroupController {
	URL url;

	public GroupController(URL url) {
		super();
		this.url = url;
	}
	

	public List<Group> getAllGroup(){
		List<Group> a_retourner=new ArrayList<Group>();
	
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
			a_retourner = getAllGroup(result);
	 
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		  }
		
	 return a_retourner;
	}


	static public List<Group> getAllGroup( String result) {
		List<Group> to_return=new ArrayList<Group>();

		result="{\"Android\":"+result+"}";
		System.out.println(result+"eee");
		try {
			JSONObject jsonObject=new JSONObject(result);
			JSONArray jsonArray = jsonObject.optJSONArray("Android");
			System.out.println("sqsss"+jsonArray.length());
			for(int i=0;i<jsonArray.length();i++){
			Group Group=new Group();
			Log.i("aaaaa",jsonArray.getJSONObject(i).get("GroupInfo").toString());
			Group.setGroup(GroupInfoController.getGroupInfo(jsonArray.getJSONObject(i).get("GroupInfo").toString()).get(0));
			Group.setTeams(TeamController.getTeam(jsonArray.getJSONObject(i).get("TeamsInGroup").toString()));
			
			to_return.add(Group);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return to_return;
	}
}
