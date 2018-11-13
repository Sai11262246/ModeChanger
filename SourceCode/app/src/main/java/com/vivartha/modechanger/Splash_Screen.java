package com.vivartha.modechanger;

import android.content.Intent;
        import android.os.Bundle;
        import android.app.Activity;

/**
 * @author sai krsihna
 * This is a splash screen activity
  */
public class Splash_Screen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        final AppPreferences mAppPreferences = new AppPreferences(this);


        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                    if(mAppPreferences.getLoginState() == 0){
                        Intent intent = new Intent(getApplicationContext(),   LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }else if(mAppPreferences.getLoginState() == 1){
                        Intent intent = new Intent(getApplicationContext(),   PinPadActivity.class);
                        startActivity(intent);
                        finish();
                    }



                }
            }
        };
        timer.start();



    }

}
