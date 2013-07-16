package org.aakashlabs.anautomatadroid;

import java.util.Locale;

import com.example.anautomatadroid.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class FinalImageActivity extends Activity {

	ImageView iv;
	String image_code, image_category;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_final_image);

		iv = (ImageView) findViewById(R.id.imageView_final);
		setTitle("DFA Image");

		image_code = getIntent().getExtras().getString("IMAGE_CODE").toString();
		image_category = getIntent().getExtras().getString("CATEGORY");

		if (image_category.equalsIgnoreCase("REGULAR EXPRESSIONS")) {

			iv.setImageResource(findImageIdWithRE(image_code));
		} else {
			iv.setImageResource(findImageNamefromCode(image_code));
		}
	}

	private int findImageNamefromCode(String CODE) {

		String temp = CODE.substring(0, 1);

		CODE = CODE.replace(CODE.substring(0, 2), temp);
		Log.i(getClass().getSimpleName(), "----- IMAGE NAME IS" + CODE);
		String[] newFinalname = CODE.split(" ");
		String imagename = "";
		for (int i = 0; i < newFinalname.length; i++) {
			imagename += newFinalname[i].toLowerCase() + "_";
		}
		if (imagename.endsWith("_")) {
			imagename = imagename.substring(0, imagename.length() - 1);
		}
		Log.i(getClass().getSimpleName(),
				"----- IMAGE NAME IS after splitting " + imagename);

		Log.i(getClass().getSimpleName(), "------ FINAL IMAGE NAME IS"
				+ imagename);

		int image_ID = getResources().getIdentifier(imagename, "drawable",
				getPackageName());

		return image_ID;

	}

	private int findImageIdWithRE(String CODE) {

		// C (0+1)*(1+00)(0+1)*

		String temp = CODE.substring(0, 1);

		CODE = CODE.replace(CODE.substring(0, 2), temp).toLowerCase(Locale.getDefault());

		// space replaces with _.

		CODE = CODE.replace(" ", "_");
		// OP is c_(0+1)*(1+00)(0+1)*
		CODE = CODE.replace("(", "bs_");
		// OP is c_bs_0+1)*bs_1+00)*
		CODE = CODE.replace(")", "_be_");
		// OP is c_bs_0+1_be*bs_1+00_be*
		CODE = CODE.replace("+", "_p_");
		// OP is c_bs_0_a_1_be_*bs_1_a_00_be_*
		CODE = CODE.replace("*", "s_");
		// OP is c_bs_0_a_1_be_m_bs_1_a_00_be_m_

		if (CODE.endsWith("_")) {
			CODE = CODE.substring(0, CODE.length() - 1);

		}
		Log.i(getClass().getSimpleName(), "------ FINAL IMAGE NAME IS"
				+ CODE);
		int image_ID = getResources().getIdentifier(CODE, "drawable",
				getPackageName());

		return image_ID;

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
