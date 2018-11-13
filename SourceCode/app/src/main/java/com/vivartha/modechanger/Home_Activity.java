package com.vivartha.modechanger;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

/**
 * @author Vikas Chirumamilla
 * This Activity is mailnly used to create User Interface more understandable.
 * Here we used onCreate functionality to invoke the geenral flow of the class.
 * AppPreferences are used to to save the instance of the login.
 * Buttons are used to enable navigate between screens
 */

public class Home_Activity extends Activity {


    AppPreferences mAppPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        mAppPreferences = new AppPreferences(this);
        mAppPreferences.saveLoginStatte(1);

        Button btn = (Button) findViewById(R.id.au);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_Activity.this, about_us.class);
                startActivity(i);
            }
        });

        Button btn1 = (Button) findViewById(R.id.mc);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_Activity.this, MainActivity.class);
                startActivity(i);
            }
        });

        Button btn2 = (Button) findViewById(R.id.new_options);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_Activity.this, NewModesActivity.class);
                startActivity(i);
            }
        });

    }


}
