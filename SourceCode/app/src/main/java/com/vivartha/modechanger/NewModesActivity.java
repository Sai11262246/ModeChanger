package com.vivartha.modechanger;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * @author saikrishna
 * This class contains newly implemented features such as WIFI, Bluetooth.
 * Reads the keywords from the database and compares it with the received message.
 * Performs specified action, when both are equal.
 */

public class NewModesActivity extends Activity {



    String[] optionNames={
            "Volume Up",
            "Volume Down",
            "Wifi ON",
            "Wifi OFF",
            "Bluetooth ON",
            "Bluetooth OFF",
            "IMEI",
            "LOCATION"
    };

    int icons[] = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};


    EditText mEditText;
    Button new_options;
    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_modes_layouts);
        mEditText = findViewById(R.id.et_mode_val) ;
        new_options = findViewById(R.id.new_options);
        spin = (Spinner) findViewById(R.id.simpleSpinner);
        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),icons,optionNames);
        spin.setAdapter(customAdapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                String val = DataBaseHelper.getInstance().getValueByOptionName(optionNames[pos]);
                if(!val.isEmpty()){
                    mEditText.setText(val);
                }else{
                    mEditText.setText(optionNames[pos]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                String val = DataBaseHelper.getInstance().getValueByOptionName(optionNames[0]);
                if(!val.isEmpty()){
                    mEditText.setText(val);
                }else{
                    mEditText.setText(optionNames[0]);
                }
            }
        });

        new_options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper.getInstance().updateValueByOption(optionNames[spin.getSelectedItemPosition()],  mEditText.getText().toString());
            }
        });

    }




    public class CustomAdapter extends BaseAdapter {
        Context context;
        int icons[];
        String[] countryNames;
        LayoutInflater inflter;

        public CustomAdapter(Context applicationContext, int[] flags, String[] countryNames) {
            this.context = applicationContext;
            this.icons = flags;
            this.countryNames = countryNames;
            inflter = (LayoutInflater.from(applicationContext));
        }

        @Override
        public int getCount() {
            return icons.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = inflter.inflate(R.layout.layout_spinner_row, null);
            ImageView icon = (ImageView) view.findViewById(R.id.imageView);
            TextView names = (TextView) view.findViewById(R.id.textView);
            icon.setImageResource(icons[i]);
            names.setText(countryNames[i]);
            return view;
        }
    }

}
