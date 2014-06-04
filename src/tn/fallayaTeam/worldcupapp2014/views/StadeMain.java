package tn.fallayaTeam.worldcupapp2014.views;




import com.example.worldcupapp2014.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


public class StadeMain extends Activity {

	private ImageView iv;
	private ImageView iv1;
	private ImageButton iv2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stade);
		
		iv = (ImageView) findViewById(R.id.imageView1);
		final int[] imageArray = { R.drawable.g2, R.drawable.g1 };
		iv1 = (ImageView) findViewById(R.id.imageView2);
		final int[] imageArray1 = { R.drawable.e2, R.drawable.e1,
				R.drawable.equipe1 };
		iv2 = (ImageButton) findViewById(R.id.imageButton1);
		addListenerOnButton();
		final int[] imageArray2 = { R.drawable.stade2, R.drawable.stade3,
				R.drawable.stade4 };

		final Handler handler = new Handler();
		Runnable runnable = new Runnable() {
			int i = 0;

			@Override
			public void run() {
				iv.setImageResource(imageArray[i]);
				i++;
				if (i > imageArray.length - 1) {
					i = 0;
				}
				handler.postDelayed(this, 5000); // for interval...
			}
		};
		handler.postDelayed(runnable, 2000); // for initial delay..
		final Handler handler1 = new Handler();
		Runnable runnable1 = new Runnable() {

			int j = 0;

			@Override
			public void run() {
				iv1.setImageResource(imageArray1[j]);
				j++;
				if (j > imageArray1.length - 1) {
					j = 0;
				}
				handler1.postDelayed(this, 3000); // for interval...
			}
		};
		handler1.postDelayed(runnable1, 1000); // for initial delay..

		final Handler handler2 = new Handler();
		Runnable runnable2 = new Runnable() {

			int k = 0;

			@Override
			public void run() {
				iv2.setImageResource(imageArray2[k]);
				k++;
				if (k > imageArray2.length - 1) {
					k = 0;
				}
				handler2.postDelayed(this, 3000); // for interval...
			}
		};
		handler2.postDelayed(runnable2, 1000); // for initial delay..

		
		
		
		
	}
	public void addListenerOnButton() {
		 
 
		iv2.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
 
			   Toast.makeText(StadeMain.this,
				"ImageButton is clicked!", Toast.LENGTH_SHORT).show();
 
			}

			
 
		});
 
	}

}
