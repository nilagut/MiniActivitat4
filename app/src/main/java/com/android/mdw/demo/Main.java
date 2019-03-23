package com.android.mdw.demo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
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


  }

  public void onClick(View src) {

    Intent in;

    switch (src.getId()) {
    case R.id.btnCancion:
      in = new Intent(this, ElReceptor.class);
      in.putExtra("accio", "Iniciar cancion");
      sendBroadcast(in);
      //startService(in);
      break;
      case R.id.btnSonido:
        in = new Intent(this, ElReceptor.class);
        in.putExtra("accio", "Iniciar sonido");
        sendBroadcast(in);
        //startService(in);
        break;
    case R.id.btnFin:
      in = new Intent(this, ElReceptor.class);
      in.putExtra("accio", "Detener");
      sendBroadcast(in);
      //stopService(in);
      break;
    }
  }
}