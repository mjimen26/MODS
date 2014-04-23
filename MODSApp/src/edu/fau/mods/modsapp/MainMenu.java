package edu.fau.mods.modsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainMenu extends Activity {

	public String nfcData;
	
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
		
		Intent intent = getIntent();
	    if(intent.getAction().equals(NfcAdapter.ACTION_NDEF_DISCOVERED)) {
	        // Read the first record which contains the NFC data
	        Parcelable[] rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
	        NdefRecord record = ((NdefMessage)rawMsgs[0]).getRecords()[0];
	        nfcData = new String(record.getPayload());

	        // Display the data on the tag
	        Toast.makeText(this, nfcData, Toast.LENGTH_LONG).show();
	 
	        // Do other stuff with the data...
	        //Nested-If
	        
		}
	}	
}