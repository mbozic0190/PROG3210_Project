package ca.on.conestogac.mbproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.List;

import ca.on.conestogac.mbproject.Database.AppDatabase;
import ca.on.conestogac.mbproject.Entities.Commander;
import ca.on.conestogac.mbproject.Entities.User;


public class LoginScreen extends AppCompatActivity {

    private User user;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startService(new Intent(this, MusicService.class));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        database = AppDatabase.getDatabase(getApplicationContext());
        new DownloadImageTask((ImageView) findViewById(R.id.imgMTG))
                .execute("https://seeklogo.com/images/M/magic-the-gathering-logo-121CFC67AF-seeklogo.com.png");


        // cleanup for testing some initial data
        //database.userDao().removeAllUsers();
        //database.commanderDao().removeAllCommader();
        // add some data
        List<User> users = database.userDao().getAllUser();
        if (users.size()==0) {
            database.userDao().addUser(new User("admin", "admin"));
            database.userDao().addUser(new User("mirko", "mirko"));
            user = database.userDao().getAllUser().get(0);
        }
        List<String> commanders = database.commanderDao().getAllCommanders();
        if (commanders.size()==0) {
            database.commanderDao().addCommander(new Commander("Progenitus"));
            database.commanderDao().addCommander(new Commander("Mirko Vosk, Mind Drinker"));
        }
    }

    protected void onDestroy() {
        //stop service and stop music
        stopService(new Intent(this, MusicService.class));
        super.onDestroy();
    }

    public void loginAttempt(View view) {
        EditText userName = (EditText) findViewById(R.id.userName);
        EditText password = (EditText) findViewById(R.id.password);
        userName.requestFocus();

        User userLogin = database.userDao().getUser(userName.getText().toString());

        if (userName.getText().toString().equals(userLogin.name) && password.getText().toString().equals(userLogin.password)) {
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

        }
    }

    public void registerNewUser(View view){
        Intent registerIntent = new Intent(this, AccountCreateScreen.class);
        startActivity(registerIntent);
    }

    public void aboutPage(View view){
        Intent aboutIntent = new Intent(this, AboutScreen.class);
        startActivity(aboutIntent);
    }
}

class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;

    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mtgIcon = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mtgIcon = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mtgIcon;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }
}