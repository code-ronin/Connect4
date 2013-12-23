package com.example.connect4;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.net.Uri;
import android.content.Intent;




	

public class Connect4 extends Activity {
	
	Button startbutton;
   
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect4);
        startbutton=(Button)findViewById(R.id.button2);
    

	startbutton.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			
			Intent boardIntent =new Intent(Connect4.this, Board.class);
			startActivity(boardIntent);
		}
	});
	}
	
	
	
	/*
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_connect4, menu);
        return true;
    }*/
    
}
    	
    	
    
    
    		
    	
    

