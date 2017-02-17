package com.example.rahuldebmohalder.testapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Rahul Deb Mohalder on 17-02-2017.
 */

public class LoginActivity extends AppCompatActivity{
        private static final String TAG = "LoginActivity";
        private static final int REQUEST_SIGNUP = 0;

        @InjectView(R.id.input_email)
        EditText _userIDText;
        @InjectView(R.id.input_password) EditText _passwordText;
        @InjectView(R.id.btn_login)
        Button _loginButton;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            ButterKnife.inject(this);
            final String user_ID = _userIDText.getText().toString();
            final String password = _passwordText.getText().toString();

            _loginButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //login();
                    if(user_ID !="" && password !=""){
                        Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(mainIntent);
                    }else{
                        Toast.makeText(getBaseContext(), "Enter Correct Information", Toast.LENGTH_LONG).show();
                    }

                }
            });
        }

       /* public void login() {
            Log.d(TAG, "Login");

            if (!validate()) {
                //onLoginFailed();
                return;
            }

            _loginButton.setEnabled(false);

            final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this, R.style.AppTheme_Dark_Dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Authenticating...");
            progressDialog.show();

            String user_ID = _userIDText.getText().toString();
            String password = _passwordText.getText().toString();


            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            onLoginSuccess();
                            progressDialog.dismiss();
                        }
                    }, 3000);
        }


        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == REQUEST_SIGNUP) {
                if (resultCode == RESULT_OK) {

                    this.finish();
                }
            }
        }*/

        @Override
        public void onBackPressed() {
            moveTaskToBack(true);
        }

        public void onLoginSuccess() {
            _loginButton.setEnabled(true);
            finish();
        }

       /* public void onLoginFailed() {
            Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

            _loginButton.setEnabled(true);
        }*/

        /*public boolean validate() {
            boolean valid = true;

            String user_ID = _userIDText.getText().toString();
            String password = _passwordText.getText().toString();

            if (user_ID.isEmpty() || user_ID!="admin") {
                _userIDText.setError("enter a valid user id !!");
                valid = false;
            } else {
                _userIDText.setError(null);
            }

            if (password.isEmpty() || password!="admin") {
                _passwordText.setError("Enter correct password !!");
                valid = false;
            } else {
                _passwordText.setError(null);
            }

            return valid;
        }*/
}
