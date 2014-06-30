package tn.fallayaTeam.worldcupapp2014.views;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.example.worldcupapp2014.R;

public class Stades extends Activity {

	private String[] imageIDs = {
			"http://lh5.ggpht.com/_mrb7w4gF8Ds/TCpetKSqM1I/AAAAAAAAD2c/Qef6Gsqf12Y/s144-c/_DSC4374%20copy.jpg",
			"http://lh5.ggpht.com/_Z6tbBnE-swM/TB0CryLkiLI/AAAAAAAAVSo/n6B78hsDUz4/s144-c/_DSC3454.jpg",
			"http://lh3.ggpht.com/_GEnSvSHk4iE/TDSfmyCfn0I/AAAAAAAAF8Y/cqmhEoxbwys/s144-c/_MG_3675.jpg",
			"http://lh6.ggpht.com/_Nsxc889y6hY/TBp7jfx-cgI/AAAAAAAAHAg/Rr7jX44r2Gc/s144-c/IMGP9775a.jpg" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stades);

		Gallery gallery = (Gallery) findViewById(R.id.gallery1);

		gallery.setAdapter(new ImageAdapter(this));
		gallery.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View v, int position,
					long id) {
				new MyAsyncTask().execute(String.valueOf(position));
			}
		});
	}
		class MyAsyncTask extends AsyncTask<String, Integer, Double> {
			@Override
			protected Double doInBackground(String... params) {
				// TODO Auto-generated method stub
				postData(params[0]);
				return null;
			}

			protected void onPostExecute(Double result) {

			}

			protected void onProgressUpdate(Integer... progress) {
			}

			public void postData(String position1) {
				// Toast.makeText(getBaseContext(), "pic" + (position + 1) +
				// " selected", Toast.LENGTH_SHORT).show();
				// ---display the images selected---
				
				int position=Integer.parseInt(position1);
				ImageView imageView = (ImageView) findViewById(R.id.imageview1);
				URL url = null;
				try {
					url = new URL(imageIDs[position]);
					Bitmap bmp = null;
					try {
						bmp = BitmapFactory.decodeStream(url.openConnection()
								.getInputStream());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					imageView.setImageBitmap(bmp);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				
			}
		}
	

	public class ImageAdapter extends BaseAdapter {
		private Context context;
		public  int itemBackground;

		public ImageAdapter(Context c) {
			context = c;
			// ---setting the style---
			TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);
			itemBackground = a.getResourceId(
					R.styleable.Gallery1_android_galleryItemBackground, 0);
			a.recycle();
		}

		// ---returns the number of images---
		public int getCount() {
			return imageIDs.length;
		}

		// ---returns the ID of an item---
		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		// ---returns an ImageView view---
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView = new ImageView(context);
			// imageView.setImageResource(imageIDs[position]);
			
	
				
				
				new DownloadImageTask(imageView).execute(imageIDs[position]);
				imageView.setBackgroundResource(itemBackground);

		System.out.println();
			return imageView;
		}
	}
	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

	    private ImageView bmImage;

	    public DownloadImageTask(ImageView bmImage) {
	        this.bmImage = bmImage;
	    }

	    protected void onPreExecute() {

	    }

	    protected Bitmap doInBackground(String... urls) {
	        String urldisplay = urls[0];
	        Bitmap mIcon11 = null;
	        try {
	            InputStream in = new java.net.URL(urldisplay).openStream();
	            mIcon11 = BitmapFactory.decodeStream(in);
	        } catch (Exception e) {
	            Log.e("Error", "image download error");
	            Log.e("Error", e.getMessage());
	            e.printStackTrace();
	        }
	        return mIcon11;
	    }

	    protected void onPostExecute(Bitmap result) {
	        //set image of your imageview
	        bmImage.setImageBitmap(result);
	        bmImage.setScaleType(ImageView.ScaleType.FIT_XY);
	        bmImage.setLayoutParams(new Gallery.LayoutParams(150, 120));
//	        bmImage.setBackgroundResource(itemBackground);
	        //close
	    }
	}
}