package ca.on.conestogac.mbproject;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ca.on.conestogac.mbproject.LoginRestister.sql.DatabaseHelper;
import ca.on.conestogac.mbproject.Model.User;

public class AccountCreateScreen extends AppCompatActivity {

    private final AppCompatActivity activity = AccountCreateScreen.this;
    private DatabaseHelper databaseHelper;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_create_screen);
        databaseHelper = new DatabaseHelper(activity);
        user = new User();
    }

    public void registerAttempt(View view){
        EditText userName = (EditText) findViewById(R.id.registerUserName);
        EditText password = (EditText) findViewById(R.id.registerPassword);
        userName.requestFocus();


        if (!databaseHelper.checkUser(userName.getText().toString().trim())) {

            user.setName(userName.getText().toString().trim());
            user.setPassword(password.getText().toString().trim());

            databaseHelper.addUser(user);

            Toast.makeText(this, "Registration Successful, welcome",
                    Toast.LENGTH_LONG).show();
            Intent loginIntent = new Intent(this, LoginScreen.class);
            startActivity(loginIntent);

        } else {
            AlertDialog.Builder loginError  = new AlertDialog.Builder(this);
            loginError.setMessage("Invalid username or password. Please try again");
            loginError.setTitle("Register Attempt");
            loginError.setPositiveButton("OK", null);
            loginError.setCancelable(true);
            loginError.create().show();
            password.setText("");
        }


    }
}
