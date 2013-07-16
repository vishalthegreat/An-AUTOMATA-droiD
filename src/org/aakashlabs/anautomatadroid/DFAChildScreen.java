package org.aakashlabs.anautomatadroid;

import com.example.anautomatadroid.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DFAChildScreen extends Activity {

	String[] names;
	String ID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dfachild);
		 setTitle("Deterministic Finite Automata (DFA)");
		ListView lv = (ListView) findViewById(R.id.listView1);

		 ID = getIntent().getExtras().get("IMAGE_NAME").toString();

		if (ID.equalsIgnoreCase("Atleast & Atmost")) {
			names = getResources().getStringArray(R.array.DFA_Atleast_Array);
			lv.setAdapter(new MyAdapter(DFAChildScreen.this,
					android.R.layout.simple_selectable_list_item, names));
		}

		else if (ID.equalsIgnoreCase("Consecutive")) {
			names = getResources().getStringArray(R.array.DFA_Consecutive_Array);
			lv.setAdapter(new MyAdapter(DFAChildScreen.this,
					android.R.layout.simple_selectable_list_item, names));
		}
		else if (ID.equalsIgnoreCase("Divisible")) {
			names = getResources().getStringArray(R.array.DFA_Divisible_Array);
			lv.setAdapter(new MyAdapter(DFAChildScreen.this,
					android.R.layout.simple_selectable_list_item, names));
		}
		else if (ID.equalsIgnoreCase("Even & Odd")) {
			names = getResources().getStringArray(R.array.DFA_EvenOdd_Array);
			lv.setAdapter(new MyAdapter(DFAChildScreen.this,
					android.R.layout.simple_selectable_list_item, names));
		}
		else if (ID.equalsIgnoreCase("Exactly")) {
			names = getResources().getStringArray(R.array.DFA_Exactly_Array);
			lv.setAdapter(new MyAdapter(DFAChildScreen.this,
					android.R.layout.simple_selectable_list_item, names));
		}
		else if (ID.equalsIgnoreCase("Followed")) {
			names = getResources().getStringArray(R.array.DFA_Followed_Array);
			lv.setAdapter(new MyAdapter(DFAChildScreen.this,
					android.R.layout.simple_selectable_list_item, names));
		}
		else if (ID.equalsIgnoreCase("Language")) {
			names = getResources().getStringArray(R.array.DFA_Language_Array);
			lv.setAdapter(new MyAdapter(DFAChildScreen.this,
					android.R.layout.simple_selectable_list_item, names));
		}
		else if (ID.equalsIgnoreCase("Regular Expressions")) {
			names = getResources().getStringArray(R.array.DFA_RE_Array);
			lv.setAdapter(new MyAdapter(DFAChildScreen.this,
					android.R.layout.simple_selectable_list_item, names));
		}
		else if (ID.equalsIgnoreCase("MOD")) {
			names = getResources().getStringArray(R.array.DFA_MOD_Array);
			lv.setAdapter(new MyAdapter(DFAChildScreen.this,
					android.R.layout.simple_selectable_list_item, names));
		}
		else if (ID.equalsIgnoreCase("Starts with & Ends with")) {
			names = getResources().getStringArray(R.array.DFA_Starts_Ends_With_Array);
			lv.setAdapter(new MyAdapter(DFAChildScreen.this,
					android.R.layout.simple_selectable_list_item, names));
		}
		else if (ID.equalsIgnoreCase("Strings & Substrings")) {
			names = getResources().getStringArray(R.array.DFA_String_Substring_Array);
			lv.setAdapter(new MyAdapter(DFAChildScreen.this,
					android.R.layout.simple_selectable_list_item, names));
		}
		else if (ID.equalsIgnoreCase("Miscellaneous")) {
			names = getResources().getStringArray(R.array.DFA_Miscellaneous_Array);
			lv.setAdapter(new MyAdapter(DFAChildScreen.this,
					android.R.layout.simple_selectable_list_item, names));
		}
		
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos,
					long id) {
				int countOfChildren=((RelativeLayout)view).getChildCount();
				String data=((TextView)((RelativeLayout)view).getChildAt(1)).getText().toString();
				Intent finalIntent=new Intent(DFAChildScreen.this,FinalImageActivity.class);
				finalIntent.putExtra("CATEGORY", ID ); 
				finalIntent.putExtra("IMAGE_CODE",data);
				startActivity(finalIntent);
			}
		});
	}
	

	

	class MyAdapter extends ArrayAdapter<String> {
		String[] local_names;

		MyAdapter(Context context, int resource, String[] objects) {
			super(context, resource, objects);
			local_names = objects;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			if(convertView==null){
				LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView=inflater.inflate(R.layout.activity_dfa_image, parent, false);
			}
			TextView tv=(TextView)convertView.findViewById(R.id.item_name1);
			
			tv.setText(local_names[position]);
			
			
			
			
			
			return convertView;
		}

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
