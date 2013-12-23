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
import android.graphics.Canvas;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.widget.ImageView;
import android.widget.*;
import android.graphics.drawable.*;
import android.widget.EditText;



public class Board extends Activity {
	
	static {
		System.loadLibrary("Source1");
	}
	
	
	Button col1, col2, col3, col4, col5, col6, col7;
	EditText colchoose;
	Paint paint;
	int column;
	ImageView imageview2, imageview1;
	ImageView imageviewc1r1,imageviewc1r2,imageviewc1r3,imageviewc1r4,imageviewc1r5,imageviewc1r6;
	ImageView imageviewc2r1,imageviewc2r2,imageviewc2r3,imageviewc2r4,imageviewc2r5,imageviewc2r6;
	ImageView imageviewc3r1,imageviewc3r2,imageviewc3r3,imageviewc3r4,imageviewc3r5,imageviewc3r6;
	ImageView imageviewc4r1,imageviewc4r2,imageviewc4r3,imageviewc4r4,imageviewc4r5,imageviewc4r6;
	ImageView imageviewc5r1,imageviewc5r2,imageviewc5r3,imageviewc5r4,imageviewc5r5,imageviewc5r6;
	ImageView imageviewc6r1,imageviewc6r2,imageviewc6r3,imageviewc6r4,imageviewc6r5,imageviewc6r6;
	ImageView imageviewc7r1,imageviewc7r2,imageviewc7r3,imageviewc7r4,imageviewc7r5,imageviewc7r6;
	
	ImageView imageturn;
	
	int turn=0;
	int count=0, count2=0, count3=0, count4=0, count5=0, count6=0, count7=0;
	Button resetbutton;
	String userIP="00";
	String check="no";
	//StringBuilder played= new StringBuilder(42);
	String played;
	//public native String getWin();
	//public native String setUserInput(String juserInput);
	//public native String setGameBoard(String jboard);
	
	String [][] gboard = new String[7][6];
	
	
	
   /*private void init(){
	   paint=new Paint();
	   paint.setColor(Color.BLUE);
	   paint.setStrokeWidth(10);
	   paint.setStyle(Paint.Style.STROKE);
   }*/
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect4_board);
        Intent intname=getIntent();
        Canvas canvas;
        
        
       // colchoose=(EditText)findViewById(R.id.colchoose);
       
        imageturn=(ImageView)findViewById(R.id.imageturn);
        
col1=(Button)findViewById(R.id.col1);
        
        col1.setBackgroundColor(Color.TRANSPARENT);
        
col2=(Button)findViewById(R.id.col2);
        
        col2.setBackgroundColor(Color.TRANSPARENT);
        
col3=(Button)findViewById(R.id.col3);
        
        col3.setBackgroundColor(Color.TRANSPARENT);
        
col4=(Button)findViewById(R.id.col4);
        
        col4.setBackgroundColor(Color.TRANSPARENT);
        
col5=(Button)findViewById(R.id.col5);
        
        col5.setBackgroundColor(Color.TRANSPARENT);
        
col6=(Button)findViewById(R.id.col6);
        
        col6.setBackgroundColor(Color.TRANSPARENT);
        
col7=(Button)findViewById(R.id.col7);
        
        col7.setBackgroundColor(Color.TRANSPARENT);
        
        
 resetbutton=(Button)findViewById(R.id.resetbutton);
    /////
 	//
 	// GAME Loop
 	//
 	/////
 
 	//while(check=="no"){
 		
 		/*
 		for(int i=1;i<8;i++)
 		{
 			for(int j=0; j<6;j++)
 			{
 				played.concat(gboard[i-1][j]);
 			}
 		}
 		
 		
 		
 		 String passme = played.toString();
         setUserInput(userIP);
         setGameBoard(passme);
 		 check = getWin();
 		*/
 	
        col1.setOnClickListener(new OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			count+=1;
    			turn+=1;
    			if (count==1){
    			if(turn%2==0){
        			imageviewc1r1=(ImageView)findViewById(R.id.imageViewc1r1);
        			imageviewc1r1.setImageResource(R.drawable.token);
        			imageviewc1r1.setVisibility(1);
        			imageturn.setImageResource(R.drawable.token2);
        			userIP="00";
        			gboard[0][0]="0";
        			}
        			else{
        				imageviewc1r1=(ImageView)findViewById(R.id.imageViewc1r1);
            			imageviewc1r1.setImageResource(R.drawable.token2);
            			imageviewc1r1.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token);
            			userIP="00";
            			gboard[0][0]="1";
        			}
    			
    			}
    			
    			if (count==2){
    				if(turn%2==0){
            			imageviewc1r2=(ImageView)findViewById(R.id.imageViewc1r2);
            			imageviewc1r2.setImageResource(R.drawable.token);
            			imageviewc1r2.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="01";
            			gboard[0][1]="0";
            			
            			}
            			else{
            				imageviewc1r2=(ImageView)findViewById(R.id.imageViewc1r2);
                			imageviewc1r2.setImageResource(R.drawable.token2);
                			imageviewc1r2.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="01";
                			gboard[0][1]="1";
            			}
        			
    			}
    			
    			if (count==3){
    				if(turn%2==0){
            			imageviewc1r3=(ImageView)findViewById(R.id.imageViewc1r3);
            			imageviewc1r3.setImageResource(R.drawable.token);
            			imageviewc1r3.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="02";
            			gboard[0][2]="0";
            			}
            			else{
            				imageviewc1r3=(ImageView)findViewById(R.id.imageViewc1r3);
                			imageviewc1r3.setImageResource(R.drawable.token2);
                			imageviewc1r3.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="02";
                			gboard[0][2]="1";
            			}
        			
    			}
    			
    			
    			if (count==4){
    				if(turn%2==0){
            			imageviewc1r4=(ImageView)findViewById(R.id.imageViewc1r4);
            			imageviewc1r4.setImageResource(R.drawable.token);
            			imageviewc1r4.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="03";
            			gboard[0][3]="0";
            			}
            			else{
            				imageviewc1r4=(ImageView)findViewById(R.id.imageViewc1r4);
                			imageviewc1r4.setImageResource(R.drawable.token2);
                			imageviewc1r4.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="03";
                			gboard[0][3]="1";
            			}
        			
    			}
    			
    			if (count==5){
    				if(turn%2==0){
            			imageviewc1r5=(ImageView)findViewById(R.id.imageViewc1r5);
            			imageviewc1r5.setImageResource(R.drawable.token);
            			imageviewc1r5.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="04";
            			gboard[0][4]="0";
            			}
            			else{
            				imageviewc1r5=(ImageView)findViewById(R.id.imageViewc1r5);
                			imageviewc1r5.setImageResource(R.drawable.token2);
                			imageviewc1r5.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="04";
                			gboard[0][4]="1";
            			}
        			
    			}
    			
    			if (count==6){
    				if(turn%2==0){
            			imageviewc1r6=(ImageView)findViewById(R.id.imageViewc1r6);
            			imageviewc1r6.setImageResource(R.drawable.token);
            			imageviewc1r6.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="05";
            			gboard[0][5]="0";
            			}
            			else{
            				imageviewc1r6=(ImageView)findViewById(R.id.imageViewc1r6);
                			imageviewc1r6.setImageResource(R.drawable.token2);
                			imageviewc1r6.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="05";
                			gboard[0][5]="1";
            			}
        			
    			}
    			column=1;
    			
    		}
    	});
        
        col2.setOnClickListener(new OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			count2+=1;
    			turn+=1;
    			if (count2==1){
    			if(turn%2==0){
        			imageviewc2r1=(ImageView)findViewById(R.id.imageViewc2r1);
        			imageviewc2r1.setImageResource(R.drawable.token);
        			imageviewc2r1.setVisibility(1);
        			imageturn.setImageResource(R.drawable.token2);
        			userIP="10";
        			gboard[1][0]="0";
        			}
        			else{
        				imageviewc2r1=(ImageView)findViewById(R.id.imageViewc2r1);
            			imageviewc2r1.setImageResource(R.drawable.token2);
            			imageviewc2r1.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token);
            			userIP="10";
            			gboard[1][0]="1";
        			}
    			
    			}
    			
    			if (count2==2){
    				if(turn%2==0){
            			imageviewc2r2=(ImageView)findViewById(R.id.imageViewc2r2);
            			imageviewc2r2.setImageResource(R.drawable.token);
            			imageviewc2r2.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="11";
            			gboard[1][1]="0";
            			}
            			else{
            				imageviewc2r2=(ImageView)findViewById(R.id.imageViewc2r2);
                			imageviewc2r2.setImageResource(R.drawable.token2);
                			imageviewc2r2.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="11";
                			gboard[1][1]="1";
            			}
        			
    			}
    			
    			if (count2==3){
    				if(turn%2==0){
            			imageviewc2r3=(ImageView)findViewById(R.id.imageViewc2r3);
            			imageviewc2r3.setImageResource(R.drawable.token);
            			imageviewc2r3.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="12";
            			gboard[1][2]="0";
            			}
            			else{
            				imageviewc2r3=(ImageView)findViewById(R.id.imageViewc2r3);
                			imageviewc2r3.setImageResource(R.drawable.token2);
                			imageviewc2r3.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="12";
                			gboard[1][2]="1";
            			}
        			
    			}
    			
    			
    			if (count2==4){
    				if(turn%2==0){
            			imageviewc2r4=(ImageView)findViewById(R.id.imageViewc2r4);
            			imageviewc2r4.setImageResource(R.drawable.token);
            			imageviewc2r4.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="13";
            			gboard[1][3]="0";
            			}
            			else{
            				imageviewc2r4=(ImageView)findViewById(R.id.imageViewc2r4);
                			imageviewc2r4.setImageResource(R.drawable.token2);
                			imageviewc2r4.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="13";
                			gboard[1][3]="1";
            			}
        			
    			}
    			
    			if (count2==5){
    				if(turn%2==0){
            			imageviewc2r5=(ImageView)findViewById(R.id.imageViewc2r5);
            			imageviewc2r5.setImageResource(R.drawable.token);
            			imageviewc2r5.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="14";
            			gboard[1][4]="0";
            			}
            			else{
            				imageviewc2r5=(ImageView)findViewById(R.id.imageViewc2r5);
                			imageviewc2r5.setImageResource(R.drawable.token2);
                			imageviewc2r5.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="14";
                			gboard[1][4]="1";
            			}
        			
    			}
    			
    			if (count2==6){
    				if(turn%2==0){
            			imageviewc2r6=(ImageView)findViewById(R.id.imageViewc2r6);
            			imageviewc2r6.setImageResource(R.drawable.token);
            			imageviewc2r6.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="15";
            			gboard[1][5]="0";
            			}
            			else{
            				imageviewc2r6=(ImageView)findViewById(R.id.imageViewc2r6);
                			imageviewc2r6.setImageResource(R.drawable.token2);
                			imageviewc2r6.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="15";
                			gboard[1][5]="1";
            			}
        			
    			}
    			column=2;
    		}
    	});
        
        col3.setOnClickListener(new OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			count3+=1;
    			turn+=1;
    			if (count3==1){
    			if(turn%2==0){
        			imageviewc3r1=(ImageView)findViewById(R.id.imageViewc3r1);
        			imageviewc3r1.setImageResource(R.drawable.token);
        			imageviewc3r1.setVisibility(1);
        			imageturn.setImageResource(R.drawable.token2);
        			userIP="20";
        			gboard[2][0]="0";
        			}
        			else{
        				imageviewc3r1=(ImageView)findViewById(R.id.imageViewc3r1);
            			imageviewc3r1.setImageResource(R.drawable.token2);
            			imageviewc3r1.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token);
            			userIP="20";
            			gboard[2][0]="1";
        			}
    			
    			}
    			
    			if (count3==2){
    				if(turn%2==0){
            			imageviewc3r2=(ImageView)findViewById(R.id.imageViewc3r2);
            			imageviewc3r2.setImageResource(R.drawable.token);
            			imageviewc3r2.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="21";
            			gboard[2][1]="0";
            			}
            			else{
            				imageviewc3r2=(ImageView)findViewById(R.id.imageViewc3r2);
                			imageviewc3r2.setImageResource(R.drawable.token2);
                			imageviewc3r2.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="21";
                			gboard[2][1]="1";
            			}
        			
    			}
    			
    			if (count3==3){
    				if(turn%2==0){
            			imageviewc3r3=(ImageView)findViewById(R.id.imageViewc3r3);
            			imageviewc3r3.setImageResource(R.drawable.token);
            			imageviewc3r3.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="22";
            			gboard[2][2]="0";
            			}
            			else{
            				imageviewc3r3=(ImageView)findViewById(R.id.imageViewc3r3);
                			imageviewc3r3.setImageResource(R.drawable.token2);
                			imageviewc3r3.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="22";
                			gboard[2][2]="1";
            			}
        			
    			}
    			
    			
    			if (count3==4){
    				if(turn%2==0){
            			imageviewc3r4=(ImageView)findViewById(R.id.imageViewc3r4);
            			imageviewc3r4.setImageResource(R.drawable.token);
            			imageviewc3r4.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="23";
            			gboard[2][3]="0";
            			}
            			else{
            				imageviewc3r4=(ImageView)findViewById(R.id.imageViewc3r4);
                			imageviewc3r4.setImageResource(R.drawable.token2);
                			imageviewc3r4.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="23";
                			gboard[2][3]="1";
            			}
        			
    			}
    			
    			if (count3==5){
    				if(turn%2==0){
            			imageviewc3r5=(ImageView)findViewById(R.id.imageViewc3r5);
            			imageviewc3r5.setImageResource(R.drawable.token);
            			imageviewc3r5.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="24";
            			gboard[2][4]="0";
            			}
            			else{
            				imageviewc3r5=(ImageView)findViewById(R.id.imageViewc3r5);
                			imageviewc3r5.setImageResource(R.drawable.token2);
                			imageviewc3r5.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="24";
                			gboard[2][4]="1";
            			}
        			
    			}
    			
    			if (count3==6){
    				if(turn%2==0){
            			imageviewc3r6=(ImageView)findViewById(R.id.imageViewc3r6);
            			imageviewc3r6.setImageResource(R.drawable.token);
            			imageviewc3r6.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="25";
            			gboard[2][5]="0";
            			}
            			else{
            				imageviewc3r6=(ImageView)findViewById(R.id.imageViewc3r6);
                			imageviewc3r6.setImageResource(R.drawable.token2);
                			imageviewc3r6.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="25";
                			gboard[2][5]="1";
            			}
        			
    			}
    			
  
    			
    			column=3;
    		}
    	});
        
        col4.setOnClickListener(new OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			count4+=1;
    			turn+=1;
    			if (count4==1){
    			if(turn%2==0){
        			imageviewc4r1=(ImageView)findViewById(R.id.imageViewc4r1);
        			imageviewc4r1.setImageResource(R.drawable.token);
        			imageviewc4r1.setVisibility(1);
        			imageturn.setImageResource(R.drawable.token2);
        			userIP="30";
        			gboard[3][0]="0";
        			}
        			else{
        				imageviewc4r1=(ImageView)findViewById(R.id.imageViewc4r1);
            			imageviewc4r1.setImageResource(R.drawable.token2);
            			imageviewc4r1.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token);
            			userIP="30";
            			gboard[3][0]="1";
        			}
    			
    			}
    			
    			if (count4==2){
    				if(turn%2==0){
            			imageviewc4r2=(ImageView)findViewById(R.id.imageViewc4r2);
            			imageviewc4r2.setImageResource(R.drawable.token);
            			imageviewc4r2.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="31";
            			gboard[3][1]="0";
            			}
            			else{
            				imageviewc4r2=(ImageView)findViewById(R.id.imageViewc4r2);
                			imageviewc4r2.setImageResource(R.drawable.token2);
                			imageviewc4r2.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="31";
                			gboard[3][1]="1";
            			}
        			
    			}
    			
    			if (count4==3){
    				if(turn%2==0){
            			imageviewc4r3=(ImageView)findViewById(R.id.imageViewc4r3);
            			imageviewc4r3.setImageResource(R.drawable.token);
            			imageviewc4r3.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="32";
            			gboard[3][2]="0";
            			}
            			else{
            				imageviewc4r3=(ImageView)findViewById(R.id.imageViewc4r3);
                			imageviewc4r3.setImageResource(R.drawable.token2);
                			imageviewc4r3.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="32";
                			gboard[3][2]="1";
            			}
        			
    			}
    			
    			
    			if (count4==4){
    				if(turn%2==0){
            			imageviewc4r4=(ImageView)findViewById(R.id.imageViewc4r4);
            			imageviewc4r4.setImageResource(R.drawable.token);
            			imageviewc4r4.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="33";
            			gboard[3][3]="0";
            			}
            			else{
            				imageviewc4r4=(ImageView)findViewById(R.id.imageViewc4r4);
                			imageviewc4r4.setImageResource(R.drawable.token2);
                			imageviewc4r4.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="33";
                			gboard[3][3]="1";
            			}
        			
    			}
    			
    			if (count4==5){
    				if(turn%2==0){
            			imageviewc4r5=(ImageView)findViewById(R.id.imageViewc4r5);
            			imageviewc4r5.setImageResource(R.drawable.token);
            			imageviewc4r5.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="34";
            			gboard[2][4]="0";
            			}
            			else{
            				imageviewc4r5=(ImageView)findViewById(R.id.imageViewc4r5);
                			imageviewc4r5.setImageResource(R.drawable.token2);
                			imageviewc4r5.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="34";
                			gboard[3][4]="1";
            			}
        			
    			}
    			
    			if (count4==6){
    				if(turn%2==0){
            			imageviewc4r6=(ImageView)findViewById(R.id.imageViewc4r6);
            			imageviewc4r6.setImageResource(R.drawable.token);
            			imageviewc4r6.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="35";
            			gboard[3][5]="0";
            			}
            			else{
            				imageviewc4r6=(ImageView)findViewById(R.id.imageViewc4r6);
                			imageviewc4r6.setImageResource(R.drawable.token2);
                			imageviewc4r6.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="35";
                			gboard[3][5]="1";
            			}
        			
    			}
    			
  
    			column=4;
    		}
    	});
        
        col5.setOnClickListener(new OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			count5+=1;
    			turn+=1;
    			if (count5==1){
    			if(turn%2==0){
        			imageviewc5r1=(ImageView)findViewById(R.id.imageViewc5r1);
        			imageviewc5r1.setImageResource(R.drawable.token);
        			imageviewc5r1.setVisibility(1);
        			imageturn.setImageResource(R.drawable.token2);
        			userIP="40";
        			gboard[4][0]="0";
        			}
        			else{
        				imageviewc5r1=(ImageView)findViewById(R.id.imageViewc5r1);
            			imageviewc5r1.setImageResource(R.drawable.token2);
            			imageviewc5r1.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token);
            			userIP="40";
            			gboard[4][0]="1";
        			}
    			
    			}
    			
    			if (count5==2){
    				if(turn%2==0){
            			imageviewc5r2=(ImageView)findViewById(R.id.imageViewc5r2);
            			imageviewc5r2.setImageResource(R.drawable.token);
            			imageviewc5r2.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="41";
            			gboard[4][1]="0";
            			}
            			else{
            				imageviewc5r2=(ImageView)findViewById(R.id.imageViewc5r2);
                			imageviewc5r2.setImageResource(R.drawable.token2);
                			imageviewc5r2.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="41";
                			gboard[4][1]="1";
            			}
        			
    			}
    			
    			if (count5==3){
    				if(turn%2==0){
            			imageviewc5r3=(ImageView)findViewById(R.id.imageViewc5r3);
            			imageviewc5r3.setImageResource(R.drawable.token);
            			imageviewc5r3.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="42";
            			gboard[4][2]="0";
            			}
            			else{
            				imageviewc5r3=(ImageView)findViewById(R.id.imageViewc5r3);
                			imageviewc5r3.setImageResource(R.drawable.token2);
                			imageviewc5r3.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="42";
                			gboard[4][2]="1";
            			}
        			
    			}
    			
    			
    			if (count5==4){
    				if(turn%2==0){
            			imageviewc5r4=(ImageView)findViewById(R.id.imageViewc5r4);
            			imageviewc5r4.setImageResource(R.drawable.token);
            			imageviewc5r4.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="43";
            			gboard[4][3]="0";
            			}
            			else{
            				imageviewc5r4=(ImageView)findViewById(R.id.imageViewc5r4);
                			imageviewc5r4.setImageResource(R.drawable.token2);
                			imageviewc5r4.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="43";
                			gboard[4][3]="1";
            			}
        			
    			}
    			
    			if (count5==5){
    				if(turn%2==0){
            			imageviewc5r5=(ImageView)findViewById(R.id.imageViewc5r5);
            			imageviewc5r5.setImageResource(R.drawable.token);
            			imageviewc5r5.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="44";
            			gboard[4][4]="0";
            			}
            			else{
            				imageviewc5r5=(ImageView)findViewById(R.id.imageViewc5r5);
                			imageviewc5r5.setImageResource(R.drawable.token2);
                			imageviewc5r5.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="44";
                			gboard[4][4]="1";
            			}
        			
    			}
    			
    			if (count5==6){
    				if(turn%2==0){
            			imageviewc5r6=(ImageView)findViewById(R.id.imageViewc5r6);
            			imageviewc5r6.setImageResource(R.drawable.token);
            			imageviewc5r6.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="45";
            			gboard[4][5]="0";
            			}
            			else{
            				imageviewc5r6=(ImageView)findViewById(R.id.imageViewc5r6);
                			imageviewc5r6.setImageResource(R.drawable.token2);
                			imageviewc5r6.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="45";
                			gboard[4][5]="1";
            			}
        			
    			}
    			column=5;
    		}
    	});
        
        col6.setOnClickListener(new OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			count6+=1;
    			turn+=1;
    			if (count6==1){
    			if(turn%2==0){
        			imageviewc6r1=(ImageView)findViewById(R.id.imageViewc6r1);
        			imageviewc6r1.setImageResource(R.drawable.token);
        			imageviewc6r1.setVisibility(1);
        			imageturn.setImageResource(R.drawable.token2);
        			userIP="50";
        			gboard[5][0]="0";
        			}
        			else{
        				imageviewc6r1=(ImageView)findViewById(R.id.imageViewc6r1);
            			imageviewc6r1.setImageResource(R.drawable.token2);
            			imageviewc6r1.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token);
            			userIP="50";
            			gboard[5][0]="1";
        			}
    			
    			}
    			
    			if (count6==2){
    				if(turn%2==0){
            			imageviewc6r2=(ImageView)findViewById(R.id.imageViewc6r2);
            			imageviewc6r2.setImageResource(R.drawable.token);
            			imageviewc6r2.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="51";
            			gboard[5][1]="0";
            			}
            			else{
            				imageviewc6r2=(ImageView)findViewById(R.id.imageViewc6r2);
                			imageviewc6r2.setImageResource(R.drawable.token2);
                			imageviewc6r2.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="51";
                			gboard[5][1]="1";
            			}
        			
    			}
    			
    			if (count6==3){
    				if(turn%2==0){
            			imageviewc6r3=(ImageView)findViewById(R.id.imageViewc6r3);
            			imageviewc6r3.setImageResource(R.drawable.token);
            			imageviewc6r3.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="52";
            			gboard[5][2]="0";
            			}
            			else{
            				imageviewc6r3=(ImageView)findViewById(R.id.imageViewc6r3);
                			imageviewc6r3.setImageResource(R.drawable.token2);
                			imageviewc6r3.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="52";
                			gboard[5][2]="1";
            			}
        			
    			}
    			
    			
    			if (count6==4){
    				if(turn%2==0){
            			imageviewc6r4=(ImageView)findViewById(R.id.imageViewc6r4);
            			imageviewc6r4.setImageResource(R.drawable.token);
            			imageviewc6r4.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="53";
            			gboard[5][3]="0";
            			}
            			else{
            				imageviewc6r4=(ImageView)findViewById(R.id.imageViewc6r4);
                			imageviewc6r4.setImageResource(R.drawable.token2);
                			imageviewc6r4.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="53";
                			gboard[5][3]="1";
            			}
        			
    			}
    			
    			if (count6==5){
    				if(turn%2==0){
            			imageviewc6r5=(ImageView)findViewById(R.id.imageViewc6r5);
            			imageviewc6r5.setImageResource(R.drawable.token);
            			imageviewc6r5.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="54";
            			gboard[5][4]="0";
            			}
            			else{
            				imageviewc6r5=(ImageView)findViewById(R.id.imageViewc6r5);
                			imageviewc6r5.setImageResource(R.drawable.token2);
                			imageviewc6r5.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="54";
                			gboard[5][4]="1";
            			}
        			
    			}
    			
    			if (count6==6){
    				if(turn%2==0){
            			imageviewc6r6=(ImageView)findViewById(R.id.imageViewc6r6);
            			imageviewc6r6.setImageResource(R.drawable.token);
            			imageviewc6r6.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="55";
            			gboard[5][5]="0";
            			}
            			else{
            				imageviewc6r6=(ImageView)findViewById(R.id.imageViewc6r6);
                			imageviewc6r6.setImageResource(R.drawable.token2);
                			imageviewc6r6.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="55";
                			gboard[5][5]="1";
            			}
        			
    			}
    			column=6;
    		}
    	});
        
        col7.setOnClickListener(new OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			count7+=1;
    			turn+=1;
    			if (count7==1){
    			if(turn%2==0){
        			imageviewc7r1=(ImageView)findViewById(R.id.imageViewc7r1);
        			imageviewc7r1.setImageResource(R.drawable.token);
        			imageviewc7r1.setVisibility(1);
        			imageturn.setImageResource(R.drawable.token2);
        			userIP="60";
        			gboard[6][0]="0";
        			}
        			else{
        				imageviewc7r1=(ImageView)findViewById(R.id.imageViewc7r1);
            			imageviewc7r1.setImageResource(R.drawable.token2);
            			imageviewc7r1.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token);
            			userIP="60";
            			gboard[6][0]="1";
        			}
    			
    			}
    			
    			if (count7==2){
    				if(turn%2==0){
            			imageviewc7r2=(ImageView)findViewById(R.id.imageViewc7r2);
            			imageviewc7r2.setImageResource(R.drawable.token);
            			imageviewc7r2.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="61";
            			gboard[6][1]="0";
            			}
            			else{
            				imageviewc7r2=(ImageView)findViewById(R.id.imageViewc7r2);
                			imageviewc7r2.setImageResource(R.drawable.token2);
                			imageviewc7r2.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="61";
                			gboard[6][1]="1";
            			}
        			
    			}
    			
    			if (count7==3){
    				if(turn%2==0){
            			imageviewc7r3=(ImageView)findViewById(R.id.imageViewc7r3);
            			imageviewc7r3.setImageResource(R.drawable.token);
            			imageviewc7r3.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="62";
            			gboard[6][2]="0";
            			}
            			else{
            				imageviewc6r3=(ImageView)findViewById(R.id.imageViewc7r3);
                			imageviewc6r3.setImageResource(R.drawable.token2);
                			imageviewc6r3.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="62";
                			gboard[6][2]="1";
            			}
        			
    			}
    			
    			
    			if (count7==4){
    				if(turn%2==0){
            			imageviewc7r4=(ImageView)findViewById(R.id.imageViewc7r4);
            			imageviewc7r4.setImageResource(R.drawable.token);
            			imageviewc7r4.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="63";
            			gboard[6][3]="0";
            			}
            			else{
            				imageviewc7r4=(ImageView)findViewById(R.id.imageViewc7r4);
                			imageviewc7r4.setImageResource(R.drawable.token2);
                			imageviewc7r4.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="63";
                			gboard[6][3]="1";
            			}
        			
    			}
    			
    			if (count7==5){
    				if(turn%2==0){
            			imageviewc7r5=(ImageView)findViewById(R.id.imageViewc7r5);
            			imageviewc7r5.setImageResource(R.drawable.token);
            			imageviewc7r5.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="64";
            			gboard[6][4]="0";
            			}
            			else{
            				imageviewc7r5=(ImageView)findViewById(R.id.imageViewc7r5);
                			imageviewc7r5.setImageResource(R.drawable.token2);
                			imageviewc7r5.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="64";
                			gboard[6][4]="1";
            			}
        			
    			}
    			
    			if (count7==6){
    				if(turn%2==0){
            			imageviewc7r6=(ImageView)findViewById(R.id.imageViewc7r6);
            			imageviewc7r6.setImageResource(R.drawable.token);
            			imageviewc7r6.setVisibility(1);
            			imageturn.setImageResource(R.drawable.token2);
            			userIP="65";
            			gboard[6][5]="0";
            			}
            			else{
            				imageviewc7r6=(ImageView)findViewById(R.id.imageViewc7r6);
                			imageviewc7r6.setImageResource(R.drawable.token2);
                			imageviewc7r6.setVisibility(1);
                			imageturn.setImageResource(R.drawable.token);
                			userIP="65";
                			gboard[6][5]="1";
            			}
        			
    			}
    			column=7;
    		
    			
    			
    			
    		}
    	});
        
        resetbutton.setOnClickListener(new OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			Intent boardIntent =new Intent(Board.this, Board.class);
    			startActivity(boardIntent);
    			
    		}
    	});
	}
}//}
	
	
    

	
		
	
	
	/*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_connect4_board, menu);
        return true;
    }
    */
//}
//}
    	
    	
    
    
    		
    	
    

