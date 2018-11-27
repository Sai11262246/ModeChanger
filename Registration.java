package com.vivartha.modechanger;
/**
 * Created by vikas
 * Allows user to register.
 */

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class Registration extends Activity {

    EditText et_name, et_password ,et_email, et_phonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        et_name = findViewById(R.id.et_name);
        et_password = findViewById(R.id.et_password);
        et_email = findViewById(R.id.et_email);
        et_phonenumber = findViewById(R.id.et_phonenumber);


        findViewById(R.id.submit1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Store values at the time of the login attempt.
                String email = et_email.getText().toString();
                String password = et_password.getText().toString();
                String name = et_name.getText().toString();
                String phone = et_phonenumber.getText().toString();

                // Check for a valid password, if the user entered one.
                if (!TextUtils.isEmpty(name) && !MyUtils.isNameValid(name)) {
                    et_name.setError("Name must be minimum 5 characters");
                    return;
                }


                // Check for a valid password, if the user entered one.
                if (!TextUtils.isEmpty(phone) && !MyUtils.isPhoneValid(phone)) {
                    et_phonenumber.setError("Please enter valid phone number");
                    return;
                }

                // Check for a valid password, if the user entered one.
                if (!TextUtils.isEmpty(password) && !MyUtils.isPasswordValid(password)) {
                    et_password.setError(getString(R.string.error_invalid_password));
                    return;
                }

                // Check for a valid email address.
                if (TextUtils.isEmpty(email)) {
                    et_email.setError(getString(R.string.error_field_required));
                   return;
                } else if (!isEmailValid(email)) {
                    et_email.setError(getString(R.string.error_invalid_email));
                   return;
                }

                DataBaseHelper.getInstance().inserNewUser(name, email, phone, password);
                finish();
            }
        });

    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }


}
