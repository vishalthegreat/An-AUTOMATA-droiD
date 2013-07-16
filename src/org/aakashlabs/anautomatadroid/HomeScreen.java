package org.aakashlabs.anautomatadroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings.TextSize;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreen extends Activity {

	private Button toa_button,basics_button,dfa_button,faq_button,about_us_button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
		toa_button=(Button)findViewById(R.id.toa_button);
	basics_button=(Button)findViewById(R.id.basics_button);
	dfa_button=(Button)findViewById(R.id.dfa_button);
	faq_button=(Button)findViewById(R.id.faq_button);
	about_us_button=(Button)findViewById(R.id.about_us_button);
	toa_button.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Intent explicitIntent=new Intent(HomeScreen.this, TOAScreen.class);
			startActivity(explicitIntent);
			
		}
	});
     basics_button.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Intent explicitIntent=new Intent(HomeScreen.this, BasicScreen.class);
			startActivity(explicitIntent);
			
		}
	});
     dfa_button.setOnClickListener(new OnClickListener() {
 		
 		@Override
 		public void onClick(View v) {
 			
 			Intent explicitIntent=new Intent(HomeScreen.this, DFAScreen.class);
 			startActivity(explicitIntent);
 			
 		}
 	});
	
     faq_button.setOnClickListener(new OnClickListener() {
  		
  		@Override
  		public void onClick(View v) {
  			
  			Intent explicitIntent=new Intent(HomeScreen.this, FAQScreen.class);
  			startActivity(explicitIntent);
  			
  		}
  	});
     
     about_us_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				AlertDialog.Builder alertBuilder=new Builder(HomeScreen.this);
				alertBuilder.setTitle("About Us");
				
				TextView content=new TextView(HomeScreen.this);
				content.setText(readContentFromAssests());
				content.setTextSize(TypedValue.COMPLEX_UNIT_PX,20);
				
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