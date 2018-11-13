package com.vivartha.modechanger;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author Revanth
 * In this activity we created the shared prefernces where we can store the instances of the keywods
 * here we used different predefined functionalities to validate the keyword.
 */

public class MainActivity extends Activity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private final String DEFAULT="";
    EditText r,v,s;
    Button save;
    String ring,vibrate,silent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bind the fields
        r=(EditText)findViewById(R.id.editText1);
        v=(EditText)findViewById(R.id.editText2);
        s=(EditText)findViewById(R.id.editText3);
        //vu=(EditText)findViewById(R.id.editText4);
        save = (Button)findViewById(R.id.button1);
        //check for the shared preferences;
        preferences = getSharedPreferences("modes", MODE_PRIVATE);
        ring = preferences.getString("ring_key", DEFAULT);
        vibrate = preferences.getString("vibrate_key", DEFAULT);
        silent = preferences.getString("silent_key", DEFAULT);
        //volumeup = preferences.getString("volume_up", DEFAULT);

        //This will set the keyword for RINGER MODE as ring if it is not configured by user
        if(ring.equals(DEFAULT))
        {
            editor = preferences.edit();
            editor.putString("ring_key", "ring");
            editor.commit();
            ring = preferences.getString("ring_key", DEFAULT);
        }

        //This will set the keyword for VIBRATE MODE as vibrate if it is not configured by user
        if(vibrate.equals(DEFAULT))
        {
            editor = preferences.edit();
            editor.putString("vibrate_key", "vibrate");
            editor.commit();
            vibrate = preferences.getString("vibrate_key", DEFAULT);
        }

        //This will set the keyword for SILENT MODE as silent if it is not configured by user
        if(silent.equals(DEFAULT))
        {
            editor = preferences.edit();
            editor.putString("silent_key", "silent");
            editor.commit();
            silent = preferences.getString("silent_key", DEFAULT);
        }

        /*if(ring.equals(DEFAULT)||vibrate.equals(DEFAULT)||silent.equals(DEFAULT)||volumeup.equals(DEFAULT)){
            editor = preferences.edit();
            editor.putString("ring_key", "ring");
            editor.putString("vibrate_key", "vibrate");
            editor.putString("silent_key", "silent");
            editor.putString("volume_key", "volumeup");
            editor.commit();
            ring = preferences.getString("ring_key", DEFAULT);
            vibrate = preferences.getString("vibrate_key", DEFAULT);
            silent = preferences.getString("silent_key", DEFAULT);
            volumeup = preferences.getString("volumeup_key", DEFAULT);
        }*/

        //Setting keyword values to GUI layout
        r.setText(ring);
        v.setText(vibrate);
        s.setText(silent);
        //vu.setText(volumeup);
        save.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String temp_ring = r.getText().toString().trim();
                String temp_vibrate = v.getText().toString().trim();
                String temp_silent = s.getText().toString().trim();
                //String temp_volumeup = vu.getText().toString().trim();
                editor = preferences.edit();
                editor.putString("ring_key", temp_ring);
                editor.putString("vibrate_key", temp_vibrate);
                editor.putString("silent_key", temp_silent);
                //editor.putString("volumeup_key", temp_volumeup);
                editor.commit();
                Toast.makeText(getApplicationContext(), "SAVED!", Toast.LENGTH_SHORT).show();
            }
        });

        //Action to GoBack from edit screen to home screen
        Button btn = (Button) findViewById(R.id.btn_goback);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Home_Activity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

