package edu.fau.mods.modsapp;

// test comment
import java.util.Arrays;

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
		event.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(context, Schedule.class);
				startActivity(i);
			}

		});

		Intent intent = getIntent();
		if (intent.getAction().equals(NfcAdapter.ACTION_NDEF_DISCOVERED)) {
			// Read the first record which contains the NFC data
			Parcelable[] rawMsgs = intent
					.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
			NdefRecord record = ((NdefMessage) rawMsgs[0]).getRecords()[0];
			nfcData = new String(record.getPayload());
			String[] parts = nfcData.split("/");
			String[] actions = Arrays.copyOfRange(parts, 3, parts.length);

			// uncomment for testing in order to see the string read from the
			// tag
			String testString = "";
			for (String str : actions) {

				testString += str;
			}
			Toast.makeText(this, testString, Toast.LENGTH_SHORT).show();

			// parse URI from RFID tag
			if (actions[0].equals("ecoscapes")) {
				intent = new Intent();
				intent.setAction("mods.ecoscapes.AQUARIUM_INTENT");
				intent.putExtra("screenToLaunch", actions[1]);
				sendBroadcast(intent);
			}
		}
	}
}