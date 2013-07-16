package org.aakashlabs.anautomatadroid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class Basicimage extends Activity {
private ImageView iv;
private int pos;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
	iv=(ImageView)findViewById(R.id.imageView);
	setTitle("BASICS");
	getData();
		switch(pos)
		{
				case 0:
				iv.setImageDrawable(getResources()
						.getDrawable(R.drawable.b0));
				break;
				case 1:
					iv.setImageDrawable(getResources()
							.getDrawable(R.drawable.b1));
				break;
				case 2:
					iv.setImageDrawable(getResources()
							.getDrawable(R.drawable.b2));
				break;
				        case 3:
					iv.setImageDrawable(getResources()
							.getDrawable(R.drawable.b3));
				break;
				case 4:
					iv.setImageDrawable(getResources()
							.getDrawable(R.drawable.b4));
				break;
				

				case 5:
				iv.setImageDrawable(getResources()
						.getDrawable(R.drawable.b5));
				break;
				
				case 6:
					iv.setImageDrawable(getResources()
							.getDrawable(R.drawable.b6));
				break;
				case 7:
					iv.setImageDrawable(getResources()
							.getDrawable(R.drawable.b7));
				break;
				case 8:
					iv.setImageDrawable(getResources()
							.getDrawable(R.drawable.b8));
				break;
				

				case 9:
					iv.setImageDrawable(getResources()
						.getDrawable(R.drawable.b9));
				break;
				case 10:
					iv.setImageDrawable(getResources()
							.getDrawable(R.drawable.b10));
				break;
				case 11:
					iv.setImageDrawable(getResources()
							.getDrawable(R.drawable.b11));
				break;
				case 12:
					iv.setImageDrawable(getResources()
							.getDrawable(R.drawable.b12));
				break;
				case 13:
					iv.setImageDrawable(getResources()
							.getDrawable(R.drawable.b13));
				break;
				

				case 14:
				iv.setImageDrawable(getResources()
						.getDrawable(R.drawable.b14));
				break;
				
		}
	}
	@SuppressLint("NewApi")
	private void getData(){
		String ps=getIntent().getStringExtra("p");
		this.pos=Integer.parseInt(ps);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	getMenuInflater().inflate(R.menu.main_menu, menu);
		
		return true;
	} 
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	
		switch (item.getItemId()) {
		
				case R.id.itemShare:
			Intent shareIntent = new Intent();
			shareIntent.setAction(android.content.Intent.ACTION_SEND_MULTIPLE);
			shareIntent.setType("text/plain");
			String content="Hey!!! I am using 'An AUTOMATA droiD', Really!!! A Boon to solve the mystery of 'AUTOMATA'.";
			shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "I m using Automata Droid");
			shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, content);
			startActivity(Intent.createChooser(shareIntent, "Share via "));
			
			break;
		
		default:
			break;
		}
		return true;
	}
	

	
}
