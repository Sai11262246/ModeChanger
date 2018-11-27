package com.vivartha.modechanger;

import android.app.Application;

/**
 * created by Revanth
 * implements onCreate and instance classes.
 */

public class AppController extends Application {

	public static final String TAG = AppController.class.getSimpleName();



	private static AppController mInstance;

	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;
	}

	public static synchronized AppController getInstance() {
		return mInstance;
	}


}
