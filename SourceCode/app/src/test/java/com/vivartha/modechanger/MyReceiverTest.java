package com.vivartha.modechanger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import org.junit.Test;

public class MyReceiverTest{
	
	@Test
	public void testOnReceive()
	{
		MyReceiver obj = new MyReceiver();
		Context context = new ContextWrapper(null);
		Intent intent = new Intent();
//		obj.onReceive(context, intent);
	}

}
