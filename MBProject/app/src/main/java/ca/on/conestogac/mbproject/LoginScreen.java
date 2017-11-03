package ca.on.conestogac.mbproject;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import ca.on.conestogac.mbproject.LoginRestister.sql.DatabaseHelper;


public class LoginScreen extends AppCompatActivity {

    private final AppCompatActivity activity = LoginScreen.this;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        databaseHelper = new DatabaseHelper(activity);
    }


    public void loginAttempt(View view) {
        EditText userName = (EditText) findViewById(R.id.userName);
        EditText password = (EditText) findViewById(R.id.password);
        userName.requestFocus();

        if (databaseHelper.checkUser(userName.getText().toString().trim()
                , password.getText().toString().trim())) {


            Toast.makeText(this, "Login Successful, welcome",
                    Toast.LENGTH_LONG).show();
            Intent accountsIntent = new Intent(this, GameSetupScreen.class);
            startActivity(accountsIntent);
        }
        else
        {
            AlertDialog.Builder loginError  = new AlertDialog.Builder(this);
            loginError.setMessage("Wrong username or password. Please try again");
            loginError.setTitle("Login Attempt");
            loginError.setPositiveButton("OK", null);
            loginError.setCancelable(true);
            loginError.create().show();
            password.setText("");
        }

    /*    if (userName.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            Toast.makeText(this, "Login Successful, welcome",
                    Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, GameSetupScreen.class);
            startActivity(intent);
        } else {
            AlertDialog.Builder loginError  = new AlertDialog.Builder(this);
            loginError.setMessage("Wrong username or password. Please try again");
            loginError.setTitle("Login Attempt");
            loginError.setPositiveButton("OK", null);
            loginError.setCancelable(true);
            loginError.create().show();
            password.setText("");

        }*/
    }

    public void registerNewUser(View view){
        Intent registerIntent = new Intent(this, AccountCreateScreen.class);
        startActivity(registerIntent);
    }
}
