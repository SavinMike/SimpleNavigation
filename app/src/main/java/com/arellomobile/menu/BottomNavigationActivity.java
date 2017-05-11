package com.arellomobile.menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class BottomNavigationActivity extends AppCompatActivity {
	private static final String TAG = "BottomNavigationActivity";
	public static final String KEY_ITEM_ID = TAG + "KEY_ITEM_ID";

	public static void startActivity(Context context, int itemId) {
		Intent intent = new Intent(context, BottomNavigationActivity.class);
		intent.putExtra(KEY_ITEM_ID, itemId);
		context.startActivity(intent);
	}

	private TextView mTextMessage;

	private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
			= new BottomNavigationView.OnNavigationItemSelectedListener() {

		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item) {
			int itemId = item.getItemId();
			showItem(itemId);
			return true;
		}

	};

	private void showItem(final int itemId) {
		String text;
		switch (itemId) {
			case R.id.navigation_quiz:
				text = getString(R.string.label_navigation_quiz);
				break;
			case R.id.navigation_image:
				text = getString(R.string.label_navigation_image);
				break;
			case R.id.navigation_tell_story:
				text = getString(R.string.label_navigation_tell_story);
				break;
			case R.id.navigation_explore:
				text = getString(R.string.label_navigation_explore);
				break;
			case R.id.navigation_settings:
				text = getString(R.string.label_navigation_settings);
				break;
			default:
				text = null;
		}
		setTitle(text);
		mTextMessage.setText(text);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bottom_navigation);

		mTextMessage = (TextView) findViewById(R.id.message);
		BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
		navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

		int menuItem = getIntent().getIntExtra(KEY_ITEM_ID, -1);
		if (menuItem != -1) {
			navigation.getMenu().findItem(menuItem).setChecked(true);
			showItem(menuItem);
		}
	}
}
