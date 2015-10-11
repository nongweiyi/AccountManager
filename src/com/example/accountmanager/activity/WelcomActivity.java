package com.example.accountmanager.activity;

import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import com.example.accountmanager.R;
import com.example.accountmanager.R.layout;
import com.example.accountmanager.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class WelcomActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcom);
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				// 跳转到笑话主页
				Intent intent = new Intent(WelcomActivity.this, LoginActivity.class);
				startActivity(intent);
				WelcomActivity.this.finish();
			}
		};
		timer.schedule(timerTask, 2000);
	}

	

}
