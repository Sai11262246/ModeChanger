package com.vivartha.modechanger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    AudioManager am;
    SharedPreferences preferences;
    String ring,vibrate,silent,voluming;
    private final String DEFAULT="";
    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();
        am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        preferences = context.getSharedPreferences("modes", Context.MODE_PRIVATE);
        ring = preferences.getString("ring_key", DEFAULT);
        vibrate = preferences.getString("vibrate_key", DEFAULT);
        silent = preferences.getString("silent_key", DEFAULT);
        voluming = preferences.getString("volume_up", DEFAULT);


        // Reading SMS

        try {
            if (bundle != null) {
                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage currentMessage = SmsMessage
                            .createFromPdu((byte[]) pdusObj[i]);
                    String actual_message = currentMessage.getDisplayMessageBody();
                    String message = getFirstWord(actual_message);
                    int status = changeMode(message);
                    switch (status) {
                        case 1:
                            Toast.makeText(context, "RING_MODE", Toast.LENGTH_LONG).show();
                            break;
                        case 2:
                            Toast.makeText(context, "SILENT_MODE", Toast.LENGTH_LONG).show();
                            break;
                        case 3:
                            Toast.makeText(context, "VIBRATE_MODE", Toast.LENGTH_LONG).show();
                            break;
                        case 4:
                            Toast.makeText(context, "VOLUME_UP", Toast.LENGTH_LONG).show();
                        default:
                            break;
                    }
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        // Change Mode
    }
    private String getFirstWord(String text) {
        if (text.indexOf(' ') > -1) {
            return text.substring(0, text.indexOf(' '));
        } else {
            return text;
        }
    }
    private int changeMode(String receivedMessage) {
        if (receivedMessage.equalsIgnoreCase(ring)) {
            am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            return 1;
        } else if (receivedMessage.equalsIgnoreCase(silent)) {
            am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            return 2;
        } else if(receivedMessage.equalsIgnoreCase(vibrate)){
            am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            return 3;
        }
        else if(receivedMessage.equalsIgnoreCase(voluming)){
            am.setStreamVolume(AudioManager.STREAM_MUSIC,
                    am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
                    0);
            //am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),0);
            return 4;
        }
        return 0;
    }
}
