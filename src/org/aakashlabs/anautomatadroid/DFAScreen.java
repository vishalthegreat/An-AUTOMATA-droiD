package org.aakashlabs.anautomatadroid;

import java.util.ArrayList;
import java.util.List;

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

public class DFAScreen extends Activity {
	private ListView lv;
	private ArrayList<String> list = new ArrayList<String>();
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toascreen);
	     setTitle("DFA Categories");
		lv = (ListView) findViewById(R.id.listView);
		setDataToList();

		MyAdapter adapter = new MyAdapter(DFAScreen.this,
				android.R.layout.simple_list_item_activated_1,list);
		lv.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int postion, long id) {

				int countOfChildren=((RelativeLayout)view).getChildCount();
				String data=((TextView)((RelativeLayout)view).getChildAt(1)).getText().toString();
				
				Intent childList=new Intent(DFAScreen.this, DFAChildScreen.class);
				
				childList.putExtra("IMAGE_NAME",data);
				startActivity(childList);
				
				}
		});

	}
		    
				
			

private void setDataToList() {

	list.add("Atleast & Atmost");
	list.add("Consecutive");
	list.add("Divisible");
	list.add("Even & Odd");
    list.add("Exactly");
	list.add("Followed");
	list.add("Language");
	list.add("Regular Expressions");
	list.add("MOD");
	list.add("Starts with & Ends with");
	list.add("Strings & Substrings");
	list.add("Miscellaneous");


	
	}

	private class MyAdapter extends ArrayAdapter<String> {

		List<String> data = new ArrayList<String>();

		public MyAdapter(Context context, int resource, List<String> objects) {
			super(context, resource, objects);
			data = objects;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			if (convertView == null) {
				LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflater.inflate(R.layout.activity_toaimage, parent,
						false);

			}

			TextView tv = (TextView) convertView.findViewById(R.id.item_name);
			tv.setText(data.get(position));

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
