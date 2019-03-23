package com.android.mdw.demo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class ElServicio extends Service {

	private MediaPlayer player;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		Toast.makeText(this, R.string.creaserv, Toast.LENGTH_LONG).show();
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, R.string.finaserv, Toast.LENGTH_LONG).show();
		player.stop();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startid) {
		try {
			player.stop();
		}catch (Exception ex) {

		} finally {

		}
		Toast.makeText(this, R.string.iniserv, Toast.LENGTH_LONG).show();
		String accio = intent.getExtras().get("accio").toString();
		if (accio.equals("Iniciar cancion")){
			player = MediaPlayer.create(this, R.raw.elteuviatge);
		} else if (accio.equals("Iniciar sonido")){
			player = MediaPlayer.create(this, R.raw.train);
		}
		player.setLooping(true);
		player.start();
		return startid;		
	}


}
