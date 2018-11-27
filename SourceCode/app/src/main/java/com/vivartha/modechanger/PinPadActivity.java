package com.vivartha.modechanger;
/**
 * created by revanth.
 * allows user to create pin for easy login and also checks when he enters the pin.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PinPadActivity extends Activity implements View.OnClickListener {
    EditText e1,e2,e3,e4;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,back;
    TextView mpinpad_lable;
    AppPreferences mAppPreferences;

    boolean confirm_pin_required = false;
    String pin1 = "";
    String pin2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_pad);

        mpinpad_lable = findViewById(R.id.pinpad_lable);
        mAppPreferences = new AppPreferences(this);

        if(mAppPreferences.getPinPadState() == 0){
            confirm_pin_required = true;
        }


        e1=findViewById(R.id.editpin1);
        e2=findViewById(R.id.editpin2);
        e3=findViewById(R.id.editpin3);
        e4=findViewById(R.id.editpin4);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        b5=findViewById(R.id.button5);
        b6=findViewById(R.id.button6);
        b7=findViewById(R.id.button7);
        b8=findViewById(R.id.button8);
        b9=findViewById(R.id.button9);
        b0=findViewById(R.id.button0);
        back=findViewById(R.id.buttonback);

        back.setOnClickListener(this);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);


        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                setTextinEditBox("1");
                break;
            case R.id.button2:
                setTextinEditBox("2");
                break;
            case R.id.button3:
                setTextinEditBox("3");
                break;
            case R.id.button4:
                setTextinEditBox("4");
                break;
            case R.id.button5:
                setTextinEditBox("5");
                break;
            case R.id.button6:
                setTextinEditBox("6");
                break;
            case R.id.button7:
                setTextinEditBox("7");
                break;
            case R.id.button8:
                setTextinEditBox("8");
                break;
            case R.id.button9:
                setTextinEditBox("9");
                break;
            case R.id.button0:
                setTextinEditBox("0");
                break;
            case R.id.buttonback:
                back();
                break;
        }
    }


    public void setTextinEditBox(String val){

        if(!e1.getText().toString().isEmpty() && !e2.getText().toString().isEmpty()
                && !e3.getText().toString().isEmpty() && !e4.getText().toString().isEmpty()){
            return;
        }


        if(e1.getText().toString().isEmpty()){
            e1.setText(val);
        }else if(e2.getText().toString().isEmpty()) {
            e2.setText(val);
        }else if(e3.getText().toString().isEmpty()){
            e3.setText(val);
        }else{
            e4.setText(val);

            if(confirm_pin_required){
                mpinpad_lable.setText("Confirm 4 Digit PIN");
                pin1 = e1.getText().toString()+e2.getText().toString()+e3.getText().toString()+e4.getText().toString();
                confirm_pin_required = false;
                e1.setText("");
                e2.setText("");
                e3.setText("");
                e4.setText("");
            }else{
                pin2 = e1.getText().toString()+e2.getText().toString()+e3.getText().toString()+e4.getText().toString();
                if(pin1.isEmpty()){
                    // reqular login
                    if(pin2.equals(mAppPreferences.getPin())){
                        startActivity(new Intent(PinPadActivity.this, Home_Activity.class));
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(), "Wrong Pin Entered.", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    // pin setupp
                    if(pin1.equals(pin2)){
                        mAppPreferences.savePin(pin1);
                        mAppPreferences.savePinPadState(1);
                        startActivity(new Intent(PinPadActivity.this, Home_Activity.class));
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(), "Wrong Pin Entered.", Toast.LENGTH_SHORT).show();
                    }
                }

            }


        }
    }
    public  void back()
    {
        if (e1.getText().toString().isEmpty()&&e2.getText().toString().isEmpty()
                &&e3.getText().toString().isEmpty()&&e4.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Enter 4 digit Password", Toast.LENGTH_SHORT).show();
        }
        if (!e4.getText().toString().isEmpty())
        {
            e4.setText("");
        }
        else if (e4.getText().toString().isEmpty()&&!e3.getText().toString().isEmpty())
        {
            e3.setText("");
        }
        else if(e3.getText().toString().isEmpty()&&!e2.getText().toString().isEmpty())
        {
            e2.setText("");
        }
        else if(e2.getText().toString().isEmpty()&&!e1.getText().toString().isEmpty())
        {
            e1.setText("");
        }

    }
}
