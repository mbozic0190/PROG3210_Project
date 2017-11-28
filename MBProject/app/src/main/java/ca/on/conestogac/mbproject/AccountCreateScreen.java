package ca.on.conestogac.mbproject;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import ca.on.conestogac.mbproject.Entities.User;
import ca.on.conestogac.mbproject.Database.AppDatabase;
import ca.on.conestogac.mbproject.DAOs.UserDao;

public class AccountCreateScreen extends AppCompatActivity {

    private UserDao userDao;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_create_screen);
        database = AppDatabase.getDatabase(getApplicationContext());
    }

    public void registerAttempt(View view){
        EditText userName = (EditText) findViewById(R.id.registerUserName);
        EditText password = (EditText) findViewById(R.id.registerPassword);
        userName.requestFocus();

        User userCreate = database.userDao().getUser(userName.getText().toString());

        if (userCreate == null) {

            User user = new User(userName.getText().toString().trim(), password.getText().toString().trim());
            database.userDao().addUser(user);

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
