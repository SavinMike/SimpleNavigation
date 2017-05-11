package com.arellomobile.menu;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class NavigationDrawerActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener {

	TextView mTextMessage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigation_drawer);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		mTextMessage = (TextView) findViewById(R.id.messageTextView);
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.addDrawerListener(toggle);
		toggle.syncState();

		final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);
		onNavigationItemSelected(navigationView.getMenu().getItem(0));
	}

	@Override
	public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}


	@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item) {

		String text;
		switch (item.getItemId()) {
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

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}
}
