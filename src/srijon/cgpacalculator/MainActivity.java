package srijon.cgpacalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		ImageView go_gpa=(ImageView)findViewById(R.id.gpa);
		go_gpa.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent i= new Intent(v.getContext(),Gpa.class);
			startActivityForResult(i,0);
			}
		});
			
		ImageView go_cgpa=(ImageView)findViewById(R.id.cgpa);
		go_cgpa.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(v.getContext(),Cgpa.class);
				startActivityForResult(i,0);
					
			}
		});
		ImageView go_help=(ImageView)findViewById(R.id.help_btn);
		go_help.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(v.getContext(),help.class);
				startActivityForResult(i,0);
			}
		});
		
		ImageView go_exit=(ImageView)findViewById(R.id.exit);
		go_exit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				the_end();
			}
		});
	
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void the_end()
	{
		finish();
	}
	
}
