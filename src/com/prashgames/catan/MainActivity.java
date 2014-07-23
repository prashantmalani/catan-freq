package com.prashgames.catan;

import java.util.Arrays;

import android.renderscript.Int3;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;
import android.util.Log;

public class MainActivity extends ActionBarActivity {

	private String TAG = "MainCatanActivity";
	private int MAX_DICE_OUTCOMES = 12;

	/*
	 * Array to store all the frequencies of each dice value. We don't really
	 * need an array of 13, but it makes it easier to index in.
	 */
	private int[] mfreqCounter = new int[MAX_DICE_OUTCOMES + 1];
	private static TextView mLast5NumsView;

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
		Arrays.fill(mfreqCounter, 0);
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
	 * Service all the clicks. Based on the button clicked, either update the
	 * array, or reset the array.
	 */
	public boolean serviceClick(View v) {
		int button = Integer.MAX_VALUE;
		boolean resetCalled = false;
		switch (v.getId()) {
		case R.id.button2:
			button = 2;
			break;
		case R.id.button3:
			button = 3;
			break;
		case R.id.button4:
			button = 4;
			break;
		case R.id.button5:
			button = 5;
			break;
		case R.id.button6:
			button = 6;
			break;
		case R.id.button7:
			button = 7;
			break;
		case R.id.button8:
			button = 8;
			break;
		case R.id.button9:
			button = 9;
			break;
		case R.id.button10:
			button = 10;
			break;
		case R.id.button11:
			button = 11;
			break;
		case R.id.button12:
			button = 12;
			break;
		case R.id.buttonReset:
			resetCalled = true;
			break;
		default:
			return true;
		}

		if (resetCalled == true) {
			Arrays.fill(mfreqCounter, 0);
		} else {
			mfreqCounter[button]++;
		}

		mLast5NumsView = (TextView) findViewById(R.id.last5Nums);
		mLast5NumsView.setText(Arrays.toString(mfreqCounter));
		return true;
	}
}
