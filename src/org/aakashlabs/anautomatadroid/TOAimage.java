package org.aakashlabs.anautomatadroid;

import com.example.anautomatadroid.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class TOAimage extends Activity {
private ImageView iv;
private int pos;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
	iv=(ImageView)findViewById(R.id.imageView);
	
	getData();
		switch(pos)
		{
				case 0:
				iv.setImageDrawable(getResources()
						.getDrawable(R.drawable.a0));
				break;
				case 1:
					iv.setImageDrawable(getResources()
							.getDrawable(R.drawable.a1));
				break;
				case 2:
					iv.setImageDrawable(getResources()
							.getDrawable(R.drawable.a2));
				break;
				        case 3:
					iv.setImageDrawable(getResources()
							.getDrawable(R.drawable.a3));
				break;
				case 4:
					iv.setImageDrawable(getResources()
							.getDrawable(R.drawable.a4));
				break;

		}
	}
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
