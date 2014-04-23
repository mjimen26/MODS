package edu.fau.mods.modsapp;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EcoscapeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ecoscape);
	}

	public void launchAquarium(View v) {

		final Intent intent = new Intent();

		intent.setAction("mods.ecoscapes.AQUARIUM_INTENT");
		sendBroadcast(intent);

	}
}
