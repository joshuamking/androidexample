package com.antechdevelopment.androidexample;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
	private static final String TAG            = "The TAG :D";
	private static final String THE_SWITCH_KEY = "the_switch";

	@Override protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//		String textValue   = "This is a msg";

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Title of the dialog").setMessage("Message").show();

		//		Intent intent = new Intent(this, ScrollingActivity.class);
		//		intent.putExtra(ScrollingActivity.TEXT_VALUE_KEY, textValue);
		//		startActivity(intent);
		//		sendBroadcast(intent);
		//		startService(intent);

		//		Intent intent2 = new Intent(Intent.ACTION_SEND);
		//		intent2.putExtra(Intent.EXTRA_TEXT, textValue);
		//		intent2.setType("text/plain");
		//		Intent custom = Intent.createChooser(intent2, "Custom");
		//		startActivity(custom);

		final TextView theLabel    = (TextView) findViewById(R.id.the_label);
		final Button   theButton   = (Button) findViewById(R.id.the_button);
		Switch         theSwitch   = (Switch) findViewById(R.id.the_switch);
		final SeekBar  theSeekBar  = (SeekBar) findViewById(R.id.the_seek_bar);
		EditText       theEditText = (EditText) findViewById(R.id.the_edit_text);

		final SharedPreferences prefs         = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		boolean                 theSwitchIsOn = prefs.getBoolean(THE_SWITCH_KEY, false);
		theSwitch.setChecked(theSwitchIsOn);

		getLengthOfString(null);

		theButton.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick (View v) {
				Log.v(TAG, "The Button was clicked");
				Log.d(TAG, "The Button was clicked");
				Log.i(TAG, "The Button was clicked");
				Log.w(TAG, "The Button was clicked");
				Log.e(TAG, "The Button was clicked");
				Snackbar.make(v, "The Snackbar - The Button was clicked", Snackbar.LENGTH_SHORT).show();

				startActivity(new Intent(MainActivity.this, ScrollingActivity.class));
			}
		});

		theSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override public void onCheckedChanged (CompoundButton buttonView, boolean isChecked) {
				String stateString;

				if (isChecked) {
					stateString = "On";
				}
				else {
					stateString = "Off";
				}

				String newText = "The Switch is " + stateString;

				theLabel.setText(newText);

				SharedPreferences.Editor edit = prefs.edit();
				edit.putBoolean(THE_SWITCH_KEY, isChecked);
				edit.apply();
			}
		});

		SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
			@Override public void onProgressChanged (SeekBar seekBar, int progress, boolean fromUser) {
				theButton.setElevation(progress);
				//				theImageView.setRotation(progress * 10);
			}

			@Override public void onStartTrackingTouch (SeekBar seekBar) { }

			@Override public void onStopTrackingTouch (SeekBar seekBar) { }
		};

		theSeekBar.setOnSeekBarChangeListener(listener);

		theEditText.addTextChangedListener(new TextWatcher() {
			@Override public void beforeTextChanged (CharSequence s, int start, int count, int after) { }

			@Override public void onTextChanged (CharSequence s, int start, int before, int count) {
				Snackbar.make(theSeekBar, s, Snackbar.LENGTH_SHORT).setAction("action", new View.OnClickListener() {
					@Override public void onClick (View v) {
						Toast.makeText(getApplicationContext(), "Snackbar!!!", Toast.LENGTH_LONG).show();
					}
				}).show();
			}

			@Override public void afterTextChanged (Editable s) { }
		});
	}

	@Override protected void onResume () {
		super.onResume();

		Toast.makeText(getApplicationContext(), "onResume!", Toast.LENGTH_LONG).show();
	}

	@Override protected void onStop () {
		super.onStop();
	}

	@Override protected void onPause () {
		super.onPause();

		Toast.makeText(getApplicationContext(), "onPause!", Toast.LENGTH_LONG).show();
	}

	public int getLengthOfString (@NonNull String s) {
		return s.length();
	}
}
