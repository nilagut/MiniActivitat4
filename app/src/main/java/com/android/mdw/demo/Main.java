package com.android.mdw.demo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity implements OnClickListener {


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    Button btnCancion = (Button) findViewById(R.id.btnCancion);
    Button btnSonido = (Button) findViewById(R.id.btnSonido);
    Button btnFin = (Button) findViewById(R.id.btnFin);

    btnCancion.setOnClickListener(this);
    btnSonido.setOnClickListener(this);
    btnFin.setOnClickListener(this);

    IntentFilter filter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
    ElReceptor receiver = new ElReceptor();
    this.registerReceiver(receiver,filter);


  }

  public void onClick(View src) {

    Intent in;

    switch (src.getId()) {
    case R.id.btnCancion:
      in = new Intent(this, ElReceptor.class); //ElServicio.class en cas del servei (A)
      in.putExtra("accio", "Iniciar cancion");
      sendBroadcast(in);
      //startService(in); //(A)
      break;
      case R.id.btnSonido:
        in = new Intent(this, ElReceptor.class); //ElServicio.class en cas del servei (A)
        in.putExtra("accio", "Iniciar sonido");
        sendBroadcast(in);
        //startService(in); //(A)
        break;
    case R.id.btnFin:
      in = new Intent(this, ElReceptor.class); //ElServicio.class en cas del servei (A)
      in.putExtra("accio", "Detener");
      sendBroadcast(in);
      //stopService(in); //(A)
      break;
    }
  }


}
