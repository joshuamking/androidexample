package com.antechdevelopment.androidexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Joshua King on 3/8/17.
 */
public class MyReceiver extends BroadcastReceiver {
	@Override public void onReceive (Context context, Intent intent) {
		Toast toast = Toast.makeText(context, "Receiver onReceive", Toast.LENGTH_SHORT);
		toast.show();

		Intent intent2 = new Intent(context, ScrollingActivity.class);
		intent.putExtra(ScrollingActivity.TEXT_VALUE_KEY, "textValue");
		context.startActivity(intent2);
	}
}
