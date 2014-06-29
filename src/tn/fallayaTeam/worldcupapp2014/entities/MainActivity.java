package tn.fallayaTeam.worldcupapp2014.entities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

import tn.fallayaTeam.worldcupapp2014.controller.StadeController;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.worldcupapp2014.R;

public class MainActivity extends Activity implements OnClickListener {
Button button;
public Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context=this;
		button=(Button)findViewById(R.id.button1);
		button.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.button1){
		Log.i("test", "test");
			new MyAsyncTask().execute();
		}
	}
		
	}
	class MyAsyncTask extends AsyncTask<String, Integer, Double>{
		
		
		@Override
		
		protected Double doInBackground(String... params) {
			// TODO Auto-generated method stub
			postData();
			return null;
		}

		protected void onPostExecute(Double result){
			
			
		}
		protected void onProgressUpdate(Integer... progress){
			
		}

		public void postData() {
			Log.i("aaaaaaaaaa","zzzzzzz");
			URL url=null;
			try {
				url = new URL("http://footballpool.dataaccess.eu/data/info.wso/AllStadiumInfo/JSON/debug");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			StadeController stadeController=new StadeController(url);
			List<Stade> stades=stadeController.getAllStade();
			for(Stade stade:stades){
				Log.i("aaaaaaaaaa",stade.getName());
			}
	}
}


