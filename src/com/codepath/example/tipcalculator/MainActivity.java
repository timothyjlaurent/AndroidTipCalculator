package com.codepath.example.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
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
        
        
        sbTip.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				progress += 5;
				tvPercent.setText("Percent: "+progress+"%");
				if(!(etBill.getText().toString().equals(""))){
			    	
			    	Double bill = Double.parseDouble(etBill.getText().toString());
					double tip = bill*progress/100;
			    	tvTip.setText("Tip: "+progress+ "% :: $"+tip);
			    	tvTotal.setText("Total: "+bill+tip);
			    }				
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
        });
        
//        btnCalculate = (Button) findViewById(R.id.btnCalculate);
//        btnCalculate.setOnClickListener(new View.OnClickListener() {
//        	@Override
//        	public void onClick(View v) {
//        		// Fire when button is pressed
//        		Double bill = Double.parseDouble(etBill.getText().toString());
//        		
//        	}
//		});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
 
    

}
