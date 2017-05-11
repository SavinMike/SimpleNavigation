package com.arellomobile.menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Date: 04.05.2017
 * Time: 10:08
 *
 * @author Savin Mikhail
 */
public class SubMenuActivity extends AppCompatActivity {
	private static final String TAG = "SubMenuActivity";
	public static final String KEY_ID = TAG + "KEY_ID";

	public static void startActivity(Context context, int id) {
		Intent intent = new Intent(context, SubMenuActivity.class);
		intent.putExtra(KEY_ID, id);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(@Nullable final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub_menu);

		String text;
		switch (getIntent().getIntExtra(KEY_ID, -1)) {
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
		((TextView) findViewById(R.id.messageTextView)).setText(text);
	}
}
