package edu.fau.mods.modsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity {

	Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);

		Button flr = (Button) findViewById(R.id.flr_btn);
		flr.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(context, FloorMap.class);
				startActivity(i);
			}

		});
		
		Button event = (Button) findViewById(R.id.sched_btn);
		event.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(context, Schedule.class);
				startActivity(i);
			}
			
		});
	}
}
