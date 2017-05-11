package com.arellomobile.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Date: 04.05.2017
 * Time: 9:48
 *
 * @author Savin Mikhail
 */
public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.bottomNavigationTextView).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				startActivity(new Intent(MainActivity.this, BottomNavigationActivity.class));
			}
		});
		findViewById(R.id.navigationDrawerTextView).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				startActivity(new Intent(MainActivity.this, NavigationDrawerActivity.class));
			}
		});
		findViewById(R.id.menuScreenTextView).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				startActivity(new Intent(MainActivity.this, MenuScreenActivity.class));
			}
		});
	}
}
