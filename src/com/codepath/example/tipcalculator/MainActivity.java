package com.codepath.example.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	public EditText etBill;
	public Button btnCalculate;
    public TextView tvTip;
    public TextView tvTotal;
    public SeekBar sbTip;
	public TextView tvPercent;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etBill = (EditText) findViewById(R.id.etBill);
        tvPercent = (TextView) findViewById(R.id.tvPercent);
        tvTip  = (TextView) findViewById(R.id.tvTip);
        tvTotal  = (TextView) findViewById(R.id.tvTotal);
        sbTip  = (SeekBar) findViewById(R.id.sbTip);
        
        refreshDisplay();
        
        TextWatcher tw = new TextWatcher() {
            public void afterTextChanged(Editable s){
            	refreshDisplay();
            }
            public void  beforeTextChanged(CharSequence s, int start, int count, int after){
              // you can check for enter key here
            }
            public void  onTextChanged (CharSequence s, int start, int before,int count) {
            	
            } 
        };

        etBill.addTextChangedListener(tw);
        
        sbTip.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
			refreshDisplay();			
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stu
			}
        });      
    }
	
	
	private void refreshDisplay(){
		int progress = sbTip.getProgress() + 5;
		
		tvPercent.setText((progress)+"%");
		if(!(etBill.getText().toString().equals(""))){
	    	
	    	Double bill = Double.parseDouble(etBill.getText().toString());
			double tip = bill*progress/100;
	    	tvTip.setText(String.format("$%.2f", tip));
	    	double total = bill + tip;
	    	tvTotal.setText(String.format("$%.2f",total));
	    }	
	}





	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    

}
