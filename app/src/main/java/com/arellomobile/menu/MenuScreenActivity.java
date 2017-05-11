package com.arellomobile.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Date: 04.05.2017
 * Time: 9:54
 *
 * @author Savin Mikhail
 */
public class MenuScreenActivity extends AppCompatActivity implements View.OnClickListener {

	@Override
	protected void onCreate(@Nullable final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_screen);

		findViewById(R.id.navigation_quiz).setOnClickListener(this);
		findViewById(R.id.navigation_image).setOnClickListener(this);
		findViewById(R.id.navigation_tell_story).setOnClickListener(this);
		findViewById(R.id.navigation_explore).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		getMenuInflater().inflate(R.menu.navigation_drawer, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		switch (item.getItemId()) {
			case R.id.navigation_settings:
				BottomNavigationActivity.startActivity(this, R.id.navigation_settings);
				return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(final View v) {
		BottomNavigationActivity.startActivity(this, v.getId());
	}
}
