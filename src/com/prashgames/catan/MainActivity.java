package com.prashgames.catan;

import java.util.Arrays;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.util.Log;

public class MainActivity extends ActionBarActivity {

	private String TAG = "MainCatanActivity";
	private int MAX_DICE_OUTCOMES = 12;

	/*
	 * Array to store all the frequencies of each dice value.
	 * We don't really need an array of 13, but it makes it easier to index in.
	 */
	private int[] freqCounter = new int[MAX_DICE_OUTCOMES + 1];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Log.e(TAG, "onCreate() called!");
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}

		// Initialize array to 0
		Arrays.fill(freqCounter, 0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	@Override
	protected void onPause() {
		Log.e(TAG, "onPause() called!");
		super.onPause();
	}

	@Override
	protected void onResume() {
		Log.e(TAG, "onResume() called!");
		super.onResume();
	}

	/*
	 * Service all the clicks. Based on the button clicked, either update the array,
	 * or reset the array.
	 */
	public void serviceClick(View v) {
	}

}
