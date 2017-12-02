package ca.on.conestogac.mbproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }


    public void loginReturn(View view){
        Intent returnIntent = new Intent(this, LoginScreen.class);
        startActivity(returnIntent);
    }
}
