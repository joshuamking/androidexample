package com.antechdevelopment.androidexample;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
	private static final String TAG = "The TAG :D";

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final TextView theLabel    = (TextView) findViewById(R.id.the_label);
		final Button   theButton   = (Button) findViewById(R.id.the_button);
		Switch         theSwitch   = (Switch) findViewById(R.id.the_switch);
		final SeekBar  theSeekBar  = (SeekBar) findViewById(R.id.the_seek_bar);
		EditText       theEditText = (EditText) findViewById(R.id.the_edit_text);

		theButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick (View v) {
				Log.v(TAG, "The Button was clicked");
				Log.d(TAG, "The Button was clicked");
				Log.i(TAG, "The Button was clicked");
				Log.w(TAG, "The Button was clicked");
				Log.e(TAG, "The Button was clicked");
				Snackbar.make(v, "The Snackbar - The Button was clicked", Snackbar.LENGTH_SHORT).show();
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
				//				theImageView.setRotation(progress * 10);
			}

			@Override
			public void onStartTrackingTouch (SeekBar seekBar) { }

			@Override
			public void onStopTrackingTouch (SeekBar seekBar) { }
		});

		theEditText.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged (CharSequence s, int start, int count, int after) { }

			@Override
			public void onTextChanged (CharSequence s, int start, int before, int count) {
				Snackbar.make(theSeekBar, s, Snackbar.LENGTH_SHORT).setAction("action", new View.OnClickListener() {
					@Override
					public void onClick (View v) {
						Toast.makeText(getApplicationContext(), "Snackbar!!!", Toast.LENGTH_LONG).show();
					}
				}).show();
			}

			@Override
			public void afterTextChanged (Editable s) { }
		});
	}

	@Override
	protected void onResume () {
		super.onResume();

		Toast.makeText(getApplicationContext(), "onResume!", Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onPause () {
		super.onPause();

		Toast.makeText(getApplicationContext(), "onPause!", Toast.LENGTH_LONG).show();
	}
}
