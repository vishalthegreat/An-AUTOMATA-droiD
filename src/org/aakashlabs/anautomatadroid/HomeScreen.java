package org.aakashlabs.anautomatadroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.example.anautomatadroid.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreen extends Activity {

	private Button b1,b2,b3,b4,b5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
	b1=(Button)findViewById(R.id.toa_button);
	b2=(Button)findViewById(R.id.basics_button);
	b3=(Button)findViewById(R.id.dfa_button);
	b4=(Button)findViewById(R.id.faq_button);
	b5=(Button)findViewById(R.id.about_us_button);
	b1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Intent explicitIntent=new Intent(HomeScreen.this, TOAScreen.class);
			startActivity(explicitIntent);
			
		}
	});
     b2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Intent explicitIntent=new Intent(HomeScreen.this, BasicScreen.class);
			startActivity(explicitIntent);
			
		}
	});
     b3.setOnClickListener(new OnClickListener() {
 		
 		@Override
 		public void onClick(View v) {
 			
 			Intent explicitIntent=new Intent(HomeScreen.this, DFAScreen.class);
 			startActivity(explicitIntent);
 			
 		}
 	});
	
     b4.setOnClickListener(new OnClickListener() {
  		
  		@Override
  		public void onClick(View v) {
  			
  			Intent explicitIntent=new Intent(HomeScreen.this, FAQScreen.class);
  			startActivity(explicitIntent);
  			
  		}
  	});
     Button showDialog;
     showDialog=(Button)findViewById(R.id.about_us_button);
		showDialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				AlertDialog.Builder alertBuilder=new Builder(HomeScreen.this);
				alertBuilder.setTitle("About Us");
				
				TextView content=new TextView(HomeScreen.this);
				content.setText(readContentFromAssests());
				
				alertBuilder.setView(content);
			
				
				alertBuilder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						
					}
				});
				
				alertBuilder.show();
			}
			
			
		});
	}

	
	private String readContentFromAssests(){
		String data="";
		StringBuilder sb=new StringBuilder();
		try {
			InputStream is=getResources().getAssets().open("about_us.txt");
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			
			
			while((data=br.readLine())!=null){
				sb.append(data);
			}
			br.close();
			is.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return sb.toString();
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