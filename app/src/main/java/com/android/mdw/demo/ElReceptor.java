package com.android.mdw.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ElReceptor extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        String action = (String) intent.getExtras().get("accio");
        int state =(Integer) intent.getExtras().get("state");

        Intent in = new Intent(context, ElServicio.class);
        in.putExtra("accio", action);
        Intent i;

        switch (state){
            case 1:
                Toast.makeText(context, "auricularsON", Toast.LENGTH_LONG).show();
                i = new Intent(context,ElServicio.class);
                context.startService(i);
                break;

            case 0:
                Toast.makeText(context, "auricularsOFF", Toast.LENGTH_LONG).show();
                i = new Intent(context,ElServicio.class);
                context.stopService(i);
                break;

            default:


        if (action.equals("Detener")) {
            context.stopService(in);
        }
                else if (action.equals("Iniciar cancion")) {
                    Toast.makeText(context, R.string.bcstcancion, Toast.LENGTH_LONG).show();

                } else if (action.equals("Iniciar sonido")) {
                    Toast.makeText(context, R.string.bcstsonido, Toast.LENGTH_LONG).show();
                }

                context.startService(in);
            }

    }

}
