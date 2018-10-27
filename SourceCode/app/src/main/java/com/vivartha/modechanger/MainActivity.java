package com.vivartha.modechanger;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private final String DEFAULT="";
    EditText r,v,s,vu;
    Button save;
    String ring,vibrate,silent,volumeup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bind the fields
        r=(EditText)findViewById(R.id.editText1);
        v=(EditText)findViewById(R.id.editText2);
        s=(EditText)findViewById(R.id.editText3);
        vu=(EditText)findViewById(R.id.editText4);
        save = (Button)findViewById(R.id.button1);
        //check for the shared preferences;
        preferences = getSharedPreferences("modes", MODE_PRIVATE);
        ring = preferences.getString("ring_key", DEFAULT);
        vibrate = preferences.getString("vibrate_key", DEFAULT);
        silent = preferences.getString("silent_key", DEFAULT);
        volumeup = preferences.getString("volume_up", DEFAULT);
        if(ring.equals(DEFAULT)||vibrate.equals(DEFAULT)||silent.equals(DEFAULT)||volumeup.equals(DEFAULT)){
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
        }
        r.setText(ring);
        v.setText(vibrate);
        s.setText(silent);
        vu.setText(volumeup);
        save.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String temp_ring = r.getText().toString().trim();
                String temp_vibrate = v.getText().toString().trim();
                String temp_silent = s.getText().toString().trim();
                String temp_volumeup = vu.getText().toString().trim();
                editor = preferences.edit();
                editor.putString("ring_key", temp_ring);
                editor.putString("vibrate_key", temp_vibrate);
                editor.putString("silent_key", temp_silent);
                editor.putString("volumeup_key", temp_volumeup);
                editor.commit();
                Toast.makeText(getApplicationContext(), "SAVED!", Toast.LENGTH_SHORT).show();
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

