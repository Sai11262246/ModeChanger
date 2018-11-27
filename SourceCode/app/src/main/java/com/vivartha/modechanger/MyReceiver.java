package com.vivartha.modechanger;
/**
 * created by sai teja.
 * It runs in the background as a service.
 * It waits for the user to request for changing the mode.
 * once the user requests then, it checks the keyword and then it changes as per the request.
 */

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.telephony.gsm.SmsManager;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    AudioManager am;
    SharedPreferences preferences;
    String ring, vibrate, silent, voluming;
    private final String DEFAULT = "";

    @SuppressWarnings("deprecation")
    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();
        am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
//        preferences = context.getSharedPreferences("modes", Context.MODE_PRIVATE);
//        ring = preferences.getString("ring_key", DEFAULT);
//        vibrate = preferences.getString("vibrate_key", DEFAULT);
//        silent = preferences.getString("silent_key", DEFAULT);
//        voluming = preferences.getString("volume_up", DEFAULT);


        // Reading sms

        try {
            if (bundle != null) {
                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String actual_message = currentMessage.getDisplayMessageBody();
                    String sender = currentMessage.getOriginatingAddress();

                    Log.e("Receiver", "sender : "+ sender);

                    String message = getFirstWord(actual_message);
                    int status = changeMode(message, actual_message, context, currentMessage.getOriginatingAddress());
//                    switch (status) {
//                        case 1:
//                            Toast.makeText(context, "RING_MODE", Toast.LENGTH_LONG).show();
//                            break;
//                        case 2:
//                            Toast.makeText(context, "SILENT_MODE", Toast.LENGTH_LONG).show();
//                            break;
//                        case 3:
//                            Toast.makeText(context, "VIBRATE_MODE", Toast.LENGTH_LONG).show();
//                            break;
//                        case 4:
//                            Toast.makeText(context, "VOLUME_UP", Toast.LENGTH_LONG).show();
//                        default:
//                            break;
//                    }
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

    @SuppressWarnings("deprecation")
    private int changeMode(String receivedMessage, String actual_msg, Context context, String msg_number) {
//        if (receivedMessage.equalsIgnoreCase(ring)) {
//            am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
//            return 1;
//        } else if (receivedMessage.equalsIgnoreCase(silent)) {
//            am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
//            return 2;
//        } else if (receivedMessage.equalsIgnoreCase(vibrate)) {
//            am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
//            return 3;
//        } else if (receivedMessage.equalsIgnoreCase(voluming)) {
//            am.setStreamVolume(AudioManager.STREAM_MUSIC,
//                    am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
//                    0);
//            //am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),0);
//            return 4;
//        } else {
            // New Changes
            String option = DataBaseHelper.getInstance().getOptionNameByValue(actual_msg);
            if (option.isEmpty()) {
                return 0;
            } else {

                String messageBody = "";
                switch (option) {
                    // String[] optionNames={"Volume Up", "Volume Down","Wifi ON","Wifi OFF",
                    // "Data ON","Data OFF","Bluetooth ON","Bluetooth OFF", "IMEI"};

                    case "Ring": am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                        messageBody = "Phone Changed to Ring";
                        break;

                    case "Vibrate": am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                        messageBody = "Phone Changed to Vibrate";
                        break;

                    case "Silent": am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                        messageBody = "Phone Changed to Silent";
                        break;

                    case "Volume Up":
                        AudioManager audioManagerUp = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
                        audioManagerUp.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
                        messageBody = "Volume increased";
                        break;
                    case "Volume Down":
                        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
                        audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
                        messageBody = "Volume decreased";
                        break;
                    case "Wifi ON":
                        WifiManager wifiManager_on = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                        wifiManager_on.setWifiEnabled(true);
                        messageBody = "Wifi Enabled";
                        break;
                    case "Wifi OFF":
                        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                        wifiManager.setWifiEnabled(false);
                        messageBody = "Wifi Disabled";
                        break;
                    case "Bluetooth ON":
                        BluetoothAdapter adapterON = BluetoothAdapter.getDefaultAdapter();
                        adapterON.enable();
                        messageBody = "Bluetooth Enabled";
                        break;
                    case "Bluetooth OFF":
                        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
                        adapter.disable();
                        messageBody = "Bluetooth Disabled";
                        break;
                    case "IMEI":
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return 0;
                        }else{
                            String imei = telephonyManager.getDeviceId();
                            if (imei != null && imei.isEmpty()) {
                                imei = android.os.Build.SERIAL;
                            }
                            messageBody = "IMEI Requested";
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(msg_number, null, imei, null, null);


                            //smsManager.sendTextMessage(number, null, text, null, null);
                        }
                        break;
                    case "Location":
                        GPSTracker gpsTracker = new GPSTracker(context);
                        Log.e("Location", "lat"+gpsTracker.getLatitude());
                        Log.e("Location", "lon"+gpsTracker.getLongitude());
                        messageBody = "Location Requested";
                        SmsManager smsManager = SmsManager.getDefault();
                        String geoUrl = "http://maps.google.com/maps?q=loc:" + gpsTracker.getLatitude() + "," + gpsTracker.getLongitude();
                        smsManager.sendTextMessage(msg_number, null, geoUrl, null, null);
                        break;
                }

                if(!messageBody.isEmpty()){
                    DataBaseHelper.getInstance().insertActLog(messageBody, option);
                }
            }
//        }
        return 0;
    }
}
