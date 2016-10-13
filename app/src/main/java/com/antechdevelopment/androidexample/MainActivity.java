package com.antechdevelopment.androidexample;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final TextView theLabel   = (TextView) findViewById(R.id.the_label);
		final Button   theButton  = (Button) findViewById(R.id.the_button);
		Switch         theSwitch  = (Switch) findViewById(R.id.the_switch);
		final SeekBar  theSeekBar = (SeekBar) findViewById(R.id.the_seek_bar);

		theButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick (View v) {
				Snackbar.make(v, "The Snackbar - The Button was clicked", Snackbar.LENGTH_LONG).show();
				theSeekBar.setProgress(25);
			}
		});

		theSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged (CompoundButton buttonView, boolean isChecked) {
				String stateString;

				if (isChecked) {
					stateString = "On";
				}
				else {
					stateString = "Off";
				}

				String newText = "The Switch is " + stateString;

				theLabel.setText(newText);
			}
		});

		theSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged (SeekBar seekBar, int progress, boolean fromUser) {
				theButton.setElevation(progress);
			}

			@Override
			public void onStartTrackingTouch (SeekBar seekBar) { }

			@Override
			public void onStopTrackingTouch (SeekBar seekBar) { }
		});
	}
}
