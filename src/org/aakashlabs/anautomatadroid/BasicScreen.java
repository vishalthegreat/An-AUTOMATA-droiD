package org.aakashlabs.anautomatadroid;

import java.util.ArrayList;
import java.util.List;

import com.example.anautomatadroid.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import android.widget.TextView;

public class BasicScreen extends Activity {
	private ListView lv;
	private ArrayList<String> list = new ArrayList<String>();
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toascreen);
	     setTitle("BASICS");
		lv = (ListView) findViewById(R.id.listView);
		setDataToList();

		MyAdapter adapter = new MyAdapter(BasicScreen.this,
				android.R.layout.simple_list_item_activated_1, list);
		lv.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int pos, long id) {
				Intent intent;
		    	String p;
		        if(!validateData())
		        {
		    	
			    	switch(pos)
			    	{
						    	case 0:
						    	
						    	intent= new Intent(BasicScreen.this,Basicimage.class);
						        intent.setData(Uri.parse("b0"));
						        p=Integer.toString(pos);
						        intent.putExtra("p",p );
						        startActivity(intent);
						        break;
		        
						    	case 1:
							    	
							    intent= new Intent(BasicScreen.this,Basicimage.class);
							    intent.setData(Uri.parse("b1"));
							    p=Integer.toString(pos);
							    intent.putExtra("p",p );
							    startActivity(intent);
							    break;
						    	case 2:
			    	
						    	intent= new Intent(BasicScreen.this,Basicimage.class);
						    	intent.setData(Uri.parse("b2"));
						        p=Integer.toString(pos);
						        intent.putExtra("p",p );
						        startActivity(intent);
						        break;
						    	case 3:
	
								intent= new Intent(BasicScreen.this,Basicimage.class);
							    intent.setData(Uri.parse("b3"));
							    p=Integer.toString(pos);
							    intent.putExtra("p",p );
							    startActivity(intent);
							    break;
					    	    case 4:
				
								intent= new Intent(BasicScreen.this,Basicimage.class);
							    intent.setData(Uri.parse("b4"));
							    p=Integer.toString(pos);
							    intent.putExtra("p",p );
							    startActivity(intent);
							    break;
		    	                case 5:
		    		
								intent= new Intent(BasicScreen.this,Basicimage.class);
							    intent.setData(Uri.parse("b5"));
							    p=Integer.toString(pos);
							    intent.putExtra("p",p );
							    startActivity(intent);
							    break;
					    	    case 6:
					    		
								intent= new Intent(BasicScreen.this,Basicimage.class);
							    intent.setData(Uri.parse("b6"));
							    p=Integer.toString(pos);
							    intent.putExtra("p",p );
							    startActivity(intent);
							    break;
		    	                case 7:
		    		
								intent= new Intent(BasicScreen.this,Basicimage.class);
							    intent.setData(Uri.parse("b7"));
							    p=Integer.toString(pos);
							    intent.putExtra("p",p );
							    startActivity(intent);
							    break;
		    	                case 8:
		    		
								intent= new Intent(BasicScreen.this,Basicimage.class);
							    intent.setData(Uri.parse("b8"));
							    p=Integer.toString(pos);
							    intent.putExtra("p",p );
							    startActivity(intent);
							    break;
		    	                case 9:
		    		
								intent= new Intent(BasicScreen.this,Basicimage.class);
							    intent.setData(Uri.parse("b9"));
							    p=Integer.toString(pos);
							    intent.putExtra("p",p );
							    startActivity(intent);
							    break;
		    	                case 10:
		    		
								intent= new Intent(BasicScreen.this,Basicimage.class);
							    intent.setData(Uri.parse("b10"));
							    p=Integer.toString(pos);
							    intent.putExtra("p",p );
							    startActivity(intent);
							    break;
        				    	case 11:
		    		
								intent= new Intent(BasicScreen.this,Basicimage.class);
							    intent.setData(Uri.parse("b11"));
							    p=Integer.toString(pos);
							    intent.putExtra("p",p );
							    startActivity(intent);
							    break;
					         	case 12:
		    		
								intent= new Intent(BasicScreen.this,Basicimage.class);
							    intent.setData(Uri.parse("b12"));
							    p=Integer.toString(pos);
							    intent.putExtra("p",p );
							    startActivity(intent);
							    break;
					    	    case 13:
		    		
								intent= new Intent(BasicScreen.this,Basicimage.class);
							    intent.setData(Uri.parse("b13"));
							    p=Integer.toString(pos);
							    intent.putExtra("p",p );
							    startActivity(intent);
							    break;
					    	    case 14:
		    		
								intent= new Intent(BasicScreen.this,Basicimage.class);
							    intent.setData(Uri.parse("b14"));
							    p=Integer.toString(pos);
							    intent.putExtra("p",p );
							    startActivity(intent);
							    break;
			    		}
		        }
				
						
				    }    
		    private boolean validateData() {
				// TODO Auto-generated method stub
				return false;
			}
			private ArrayAdapter<String> getListAdapter() {
		        // TODO Auto-generated method stub
		        return null; 
		    }
		});
		    
				
			}

private void setDataToList() {

		list.add("THE CHOMSKY HIERARCHY");
		list.add("DFA & NFA");
		list.add("Mealy & Moore Machine");
		list.add("Regular Languages");
		list.add("Regular Expressions");

		list.add("Identities Of Regular Expressions");
		list.add("ARDEN'S Theorem");
		list.add("TOFL & CFL");
		list.add("Context Free Grammar");
		list.add("Ambiguity");
		list.add("Normal Forms");
		list.add("Push Down Automata");
		list.add("Turing Machine");

		list.add("Church Thesis");
		list.add("Post Correpondence Problem(PCP)");

	
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
