package srijon.cgpacalculator;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Gpa extends Activity {

	
	EditText temp;
	TableLayout TL;
	TableRow TR;
	boolean flag=false,check=true;
	TextView tv;
	ImageView ivw,add_sub,calculate,back;
	
	@Override
	protected void onCreate(Bundle g) {
		// TODO Auto-generated method stub
		super.onCreate(g);
		setContentView(R.layout.gpa);
		calculate=(ImageView)findViewById(R.id.calculate);
	    add_sub=(ImageView)findViewById(R.id.addsub);
	    back=(ImageView)findViewById(R.id.back_sub);
	    TL=(TableLayout)findViewById(R.id.gpa_tab);
        
	    init();
        back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	    add_sub.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TR=new TableRow(getBaseContext());
				
				
				
	        	tv = new TextView(getApplicationContext());
	        	tv.setText("Subject ->");
	        	tv.setTextColor(Color.BLACK);
	        	
	        	TR.addView(tv);
	        	
	        	temp = new EditText(getApplicationContext());
	        	temp.setText("");
	        	temp.setMaxWidth(20);
	        	temp.setMaxHeight(20);
	        	temp.setMaxLines(1);
	        	temp.setTextColor(Color.BLACK);
	        	TR.addView(temp);
	        	
	        	//credit
	        	temp = new EditText(getApplicationContext());
	        	temp.setText("");
	        	temp.setMaxWidth(20);
	        	temp.setMaxLines(1);
	        	temp.setMaxHeight(20);
	        	temp.setTextColor(Color.BLACK);
	        	TR.addView(temp);
				
	        	
	        	//image close button
	        	 ivw=new ImageView(getApplicationContext());
				 ivw.setImageDrawable(getResources().getDrawable(R.drawable.close));
				 ivw.setOnClickListener(new View.OnClickListener() {
					 @Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						TableRow getTr = ((TableRow)v.getParent()); 
					    TL.removeView(getTr);
					}
				});
				TR.addView(ivw);
				
				TL.addView(TR);	
			}
		});
        
        calculate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				flag=true;//to solve the input multi time input
				check=true;
				int totalRows = TL.getChildCount();
			    //Toast.makeText(getApplicationContext(), "Rows:"+totalRows,Toast.LENGTH_LONG).show();
				double cgpa = 0.00,totalcredit = 0.00;
				for(int i=0;i<totalRows;i++)
				{
					if(i>0) {
						TableRow row = (TableRow) TL.getChildAt(i);
					    EditText gpa = (EditText) row.getChildAt(1);
					    EditText credit = (EditText) row.getChildAt(2);
					    try{
					    	if(Double.parseDouble(gpa.getText().toString())>4||Double.parseDouble(gpa.getText().toString())<2)
					    	{check=false;}
					    	
					    	cgpa += Double.parseDouble(gpa.getText().toString())*Double.parseDouble(credit.getText().toString()); 
					    totalcredit +=Double.parseDouble(credit.getText().toString());
					    
					    }
					    catch(Exception e)
					    {
					    	flag=false;
					    	new AlertDialog.Builder(Gpa.this)
						    .setTitle("Invalid Input")
						    
						    .setMessage("You may have set characters or nothing as input.")
						    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
						        public void onClick(DialogInterface dialog, int which) { 
						            // continue with delete
						        	
						        }
						     })
						     .show();
					    	
					    	break;
					    	
					    }
					   
					}
				}
				
				cgpa = cgpa/totalcredit;
				if(cgpa>4||cgpa<2||check==false)
				{
					
					new AlertDialog.Builder(Gpa.this)
				    .setTitle("Invalid Input")						   
				    .setMessage("You may have set Incorrect GPA")
				    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
				        public void onClick(DialogInterface dialog, int which) { 
				            // continue with delete
				        }
				     })
				     .show();

				}
				else
				{	
					if(Double.compare(cgpa,Double.NaN)==0) 
					{
					} 
					else 
					{
					
						if(flag==true){
						new AlertDialog.Builder(Gpa.this)
					    .setTitle("CALCULATED GPA")
					    
					    .setMessage("GPA:"+cgpa)
					    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
					        public void onClick(DialogInterface dialog, int which) { 
					            // continue with delete
					        }
					     })
					     .show();}
						
					}
				}
			}
		});
        
        
	}

	private void init() {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++)
		   {
			   TR=new TableRow(getBaseContext());
			   
			   tv = new TextView(getApplicationContext());
			   tv.setText("Subject ->");
			   tv.setTextColor(Color.BLACK);
    	
			   TR.addView(tv);
    	
			   temp = new EditText(getApplicationContext());
			   temp.setText("");
			   temp.setMaxWidth(20);
			   temp.setMaxHeight(20);
			   temp.setMaxLines(1);
			   temp.setTextColor(Color.BLACK);
			   TR.addView(temp);
    	
			   //credit
			   temp = new EditText(getApplicationContext());
			   temp.setText("");
			   temp.setMaxWidth(20);
			   temp.setMaxHeight(20);
			   temp.setTextColor(Color.BLACK);
			   
			   TR.addView(temp);
			       	
			   //image close button
			   ivw=new ImageView(getApplicationContext());
			   ivw.setImageDrawable(getResources().getDrawable(R.drawable.close));
			   ivw.setOnClickListener(new View.OnClickListener() {
				   @Override
				   public void onClick(View v) {
					// TODO Auto-generated method stub
					TableRow getTr = ((TableRow)v.getParent()); 
				    TL.removeView(getTr);
				   }
			   });
			   TR.addView(ivw);
			
			   TL.addView(TR);
		   }
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
