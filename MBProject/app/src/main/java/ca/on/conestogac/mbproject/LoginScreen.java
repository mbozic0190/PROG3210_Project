package ca.on.conestogac.mbproject;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }


    public void loginAttempt(View view) {
        EditText userName = (EditText) findViewById(R.id.userName);
        EditText password = (EditText) findViewById(R.id.password);

        if (userName.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);
        } else {
            AlertDialog.Builder loginError  = new AlertDialog.Builder(this);
            loginError.setMessage("Wrong username or password. Please try again");
            loginError.setTitle("Login Attempt");
            loginError.setPositiveButton("OK", null);
            loginError.setCancelable(true);
            loginError.create().show();
            userName.setText("");
            password.setText("");

        }
    }
}
