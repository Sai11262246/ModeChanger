package com.vivartha.modechanger;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

/**
 * created by sai krsihna.
 * This is an activity which displays how the application works.
 */


public class about_us extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        Button btn = (Button)findViewById(R.id.r5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(about_us.this, Home_Activity.class);
                startActivity(i);
            }
        });
    }

}
