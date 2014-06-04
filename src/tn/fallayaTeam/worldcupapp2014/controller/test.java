package tn.fallayaTeam.worldcupapp2014.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import tn.fallayaTeam.worldcupapp2014.entities.GameInfo;
import tn.fallayaTeam.worldcupapp2014.entities.Stade;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		URL url=null;
		try {
			url = new URL("http://footballpool.dataaccess.eu/data/info.wso/AllStadiumInfo");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//StadeController stadeController=new StadeController(url);
		GameInfoController gameController=new GameInfoController(url);

		//List<Stade> stades=stadeController.getAllStade();
		List<GameInfo> stades= gameController.getAllGameInfo();
		for(GameInfo stade:stades){
			System.out.println(stade.getTeam1().getName());
		}

	}

}
