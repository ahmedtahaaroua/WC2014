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

import tn.fallayaTeam.worldcupapp2014.entities.GroupInfo;

public class GroupInfoController {
	URL url;

	public GroupInfoController(URL url) {
		super();
		this.url = url;
	}
	

	public List<GroupInfo> getAllGroupInfo(){
		List<GroupInfo> a_retourner=new ArrayList<GroupInfo>();
	
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
			
			
			a_retourner = getGroupInfo(result);
	 
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		  }
		
	 return a_retourner;
	}


	static public List<GroupInfo> getGroupInfo(String result) {
		List<GroupInfo> to_return=new ArrayList<GroupInfo>();

		result="{\"Androidd\":["+result+"]}";
		System.out.println(result+"eee");
		try {
			JSONObject jsonObject=new JSONObject(result);
			JSONArray jsonArray = jsonObject.optJSONArray("Androidd");
			System.out.println("sqsss"+jsonArray.length());
			for(int i=0;i<jsonArray.length();i++){
			GroupInfo GroupInfo=new GroupInfo();
			GroupInfo.setCode(jsonArray.getJSONObject(i).get("sCode").toString());
			GroupInfo.setDescription(jsonArray.getJSONObject(i).get("sDescription").toString());
	
				to_return.add(GroupInfo);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return to_return;
	}
}
