package com.example.testenotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void gerarNotificacao(View vew) {
		//Instacia de notification
		NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		
		//Pega a intent Pendente que foi enviada
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this,Activity2.class), 0);
		
		//Constroi builder para criar incone, texto e etc.
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		
		//seta o TickerText, texto que aparece e some
		builder.setTicker("Ticker teste notification");
		builder.setContentTitle("Titulo com notification");
		builder.setContentText("Descrição da notificação");
		builder.setSmallIcon(R.drawable.ic_launcher); //icone pequeno
		builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher)); //icone grande
		
		//Adiciona a intent Pendente para ser enviar		
		builder.setContentIntent(pendingIntent);
		
		/*//Cria um texto maior para a descrição, com um style, textos grandes Ex:lista de usuarios de notificação
		NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle();
		String[] descricao = new String[]{"Descrição 1","Descrição 2","Descrição 3","Descrição 4"};
		for (int i = 0; i < descricao.length; i++) {
			style.addLine(descricao[i]);
		}
		//adiciona as descrições ao builder
		builder.setStyle(style);*/
		
		//coloca o builder na notificação em si
		Notification notification = builder.build();
		
		//coloca a vibração
		notification.vibrate = new long[]{150,300,150,600};
		
		//Flag para cancelar notificação automaticamente de pois de acabar
		notification.flags = Notification.FLAG_AUTO_CANCEL;
		manager.notify(R.drawable.ic_launcher, notification);
		
		//adiciona o toque
		try {
			Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
			Ringtone toque = RingtoneManager.getRingtone(this, som);
			toque.play();
		} catch (Exception e) {
			// TODO: handle exception
		}
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
}
