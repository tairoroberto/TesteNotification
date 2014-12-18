package com.example.testenotification;

import android.support.v7.app.ActionBarActivity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Activity2 extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity2);
		
		/*//Instacia de notificationManager para cancelar a notificação que chamou a tela
		NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		manager.cancel(R.drawable.ic_launcher);*/
	}
	
}
