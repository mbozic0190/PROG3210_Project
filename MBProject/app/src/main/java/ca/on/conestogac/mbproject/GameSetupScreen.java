package ca.on.conestogac.mbproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

import ca.on.conestogac.mbproject.Database.AppDatabase;

public class GameSetupScreen extends AppCompatActivity {

    private AppDatabase database;
    private ToggleButton playerToggle;
    private SeekBar playersBar;
    private TextView playersNumber;
    private Spinner commander1;
    private Spinner commander2;
    private Spinner commander3;
    private Spinner commander4;
    private Spinner commander5;
    private Spinner commander6;
    private RadioButton mode;
    private TextView textPlayer1;
    private TextView textPlayer2;
    private TextView textPlayer3;
    private TextView textPlayer4;
    private TextView textPlayer5;
    private TextView textPlayer6;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.

        savedInstanceState.putBoolean("playerToggle", playerToggle.isChecked());
        savedInstanceState.putString("playersNumber", playersNumber.getText().toString());

        // etc.

        super.onSaveInstanceState(savedInstanceState);
    }

//onRestoreInstanceState

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        playerToggle.setChecked(savedInstanceState.getBoolean("playerToggle",false));
        playersNumber.setText(savedInstanceState.getString("playersNumber"));

        if(playerToggle.isChecked())
        {
            playersBar.setVisibility(View.VISIBLE);
            if (mode.isChecked()){
                textPlayer1.setVisibility(View.VISIBLE);
                commander1.setVisibility(View.VISIBLE);
                textPlayer2.setVisibility(View.VISIBLE);
                commander2.setVisibility(View.VISIBLE);
                textPlayer3.setVisibility(View.VISIBLE);
                commander3.setVisibility(View.VISIBLE);
                textPlayer4.setVisibility(View.VISIBLE);
                commander4.setVisibility(View.VISIBLE);
                textPlayer5.setVisibility(View.VISIBLE);
                commander5.setVisibility(View.VISIBLE);
                textPlayer6.setVisibility(View.VISIBLE);
                commander6.setVisibility(View.VISIBLE);
            }
        }
        else
        {
            playersBar.setVisibility(View.INVISIBLE);
            if (mode.isChecked()){
                textPlayer1.setVisibility(View.VISIBLE);
                commander1.setVisibility(View.VISIBLE);
                textPlayer2.setVisibility(View.VISIBLE);
                commander2.setVisibility(View.VISIBLE);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_setup_screen);
        textPlayer1 = (TextView) findViewById(R.id.textPlayer1);
        textPlayer2 = (TextView) findViewById(R.id.textPlayer2);
        textPlayer3 = (TextView) findViewById(R.id.textPlayer3);
        textPlayer4 = (TextView) findViewById(R.id.textPlayer4);
        textPlayer5 = (TextView) findViewById(R.id.textPlayer5);
        textPlayer6 = (TextView) findViewById(R.id.textPlayer6);
        playerToggle = (ToggleButton) findViewById(R.id.playersToggle);
        playersBar = (SeekBar) findViewById(R.id.playersBar);
        playersNumber = (TextView) findViewById(R.id.playersNumber);
        mode = (RadioButton) findViewById(R.id.radioCommander);
        database = AppDatabase.getDatabase(getApplicationContext());
        loadSpinners();
        playersBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress = progress + 2;
                playersNumber.setText(String.valueOf(progress));
                if (progress == 2 && mode.isChecked()){
                    textPlayer3.setVisibility(View.INVISIBLE);
                    commander3.setVisibility(View.INVISIBLE);
                    textPlayer4.setVisibility(View.INVISIBLE);
                    commander4.setVisibility(View.INVISIBLE);
                    textPlayer5.setVisibility(View.INVISIBLE);
                    commander5.setVisibility(View.INVISIBLE);
                    textPlayer6.setVisibility(View.INVISIBLE);
                    commander6.setVisibility(View.INVISIBLE);
                }
                else if (progress == 3 && mode.isChecked()){
                    textPlayer3.setVisibility(View.VISIBLE);
                    commander3.setVisibility(View.VISIBLE);
                    textPlayer4.setVisibility(View.INVISIBLE);
                    commander4.setVisibility(View.INVISIBLE);
                    textPlayer5.setVisibility(View.INVISIBLE);
                    commander5.setVisibility(View.INVISIBLE);
                    textPlayer6.setVisibility(View.INVISIBLE);
                    commander6.setVisibility(View.INVISIBLE);
                }
                else if (progress == 4 && mode.isChecked()){
                    textPlayer3.setVisibility(View.VISIBLE);
                    commander3.setVisibility(View.VISIBLE);
                    textPlayer4.setVisibility(View.VISIBLE);
                    commander4.setVisibility(View.VISIBLE);
                    textPlayer5.setVisibility(View.INVISIBLE);
                    commander5.setVisibility(View.INVISIBLE);
                    textPlayer6.setVisibility(View.INVISIBLE);
                    commander6.setVisibility(View.INVISIBLE);
                }
                else if (progress == 5 && mode.isChecked()){
                    textPlayer3.setVisibility(View.VISIBLE);
                    commander3.setVisibility(View.VISIBLE);
                    textPlayer4.setVisibility(View.VISIBLE);
                    commander4.setVisibility(View.VISIBLE);
                    textPlayer5.setVisibility(View.VISIBLE);
                    commander5.setVisibility(View.VISIBLE);
                    textPlayer6.setVisibility(View.INVISIBLE);
                    commander6.setVisibility(View.INVISIBLE);
                }
                else if (progress == 6 && mode.isChecked()){
                    textPlayer3.setVisibility(View.VISIBLE);
                    commander3.setVisibility(View.VISIBLE);
                    textPlayer4.setVisibility(View.VISIBLE);
                    commander4.setVisibility(View.VISIBLE);
                    textPlayer5.setVisibility(View.VISIBLE);
                    commander5.setVisibility(View.VISIBLE);
                    textPlayer6.setVisibility(View.VISIBLE);
                    commander6.setVisibility(View.VISIBLE);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        }

    public void numberOfPlayers(View view) {

        if (playerToggle.isChecked()) {

            playersBar.setVisibility(View.VISIBLE);
            playersBar.setProgress(0);

        } else {
            playersBar.setVisibility(View.INVISIBLE);
            playersNumber.setText("2");
            if (mode.isChecked()){
                textPlayer3.setVisibility(View.INVISIBLE);
                commander3.setVisibility(View.INVISIBLE);
                textPlayer4.setVisibility(View.INVISIBLE);
                commander4.setVisibility(View.INVISIBLE);
                textPlayer5.setVisibility(View.INVISIBLE);
                commander5.setVisibility(View.INVISIBLE);
                textPlayer6.setVisibility(View.INVISIBLE);
                commander6.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void playMode(View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        EditText StartLife = (EditText) findViewById(R.id.startLifeTotal);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioStandard:
                if (checked)
                    StartLife.setText(String.valueOf(20));
                    textPlayer1.setVisibility(View.INVISIBLE);
                    commander1.setVisibility(View.INVISIBLE);
                    textPlayer2.setVisibility(View.INVISIBLE);
                    commander2.setVisibility(View.INVISIBLE);
                    textPlayer3.setVisibility(View.INVISIBLE);
                    commander3.setVisibility(View.INVISIBLE);
                    textPlayer4.setVisibility(View.INVISIBLE);
                    commander4.setVisibility(View.INVISIBLE);
                    textPlayer5.setVisibility(View.INVISIBLE);
                    commander5.setVisibility(View.INVISIBLE);
                    textPlayer6.setVisibility(View.INVISIBLE);
                    commander6.setVisibility(View.INVISIBLE);
                    break;
            case R.id.radioCommander:
                if (checked)
                    StartLife.setText(String.valueOf(40));
                    textPlayer1.setVisibility(View.VISIBLE);
                    commander1.setVisibility(View.VISIBLE);
                    textPlayer2.setVisibility(View.VISIBLE);
                    commander2.setVisibility(View.VISIBLE);
                if (Integer.valueOf(playersNumber.getText().toString()) == 2 && mode.isChecked()){
                    textPlayer3.setVisibility(View.INVISIBLE);
                    commander3.setVisibility(View.INVISIBLE);
                    textPlayer4.setVisibility(View.INVISIBLE);
                    commander4.setVisibility(View.INVISIBLE);
                    textPlayer5.setVisibility(View.INVISIBLE);
                    commander5.setVisibility(View.INVISIBLE);
                    textPlayer6.setVisibility(View.INVISIBLE);
                    commander6.setVisibility(View.INVISIBLE);
                }
                else if (Integer.valueOf(playersNumber.getText().toString()) == 3 && mode.isChecked()){
                    textPlayer3.setVisibility(View.VISIBLE);
                    commander3.setVisibility(View.VISIBLE);
                    textPlayer4.setVisibility(View.INVISIBLE);
                    commander4.setVisibility(View.INVISIBLE);
                    textPlayer5.setVisibility(View.INVISIBLE);
                    commander5.setVisibility(View.INVISIBLE);
                    textPlayer6.setVisibility(View.INVISIBLE);
                    commander6.setVisibility(View.INVISIBLE);
                }
                else if (Integer.valueOf(playersNumber.getText().toString()) == 4 && mode.isChecked()){
                    textPlayer3.setVisibility(View.VISIBLE);
                    commander3.setVisibility(View.VISIBLE);
                    textPlayer4.setVisibility(View.VISIBLE);
                    commander4.setVisibility(View.VISIBLE);
                    textPlayer5.setVisibility(View.INVISIBLE);
                    commander5.setVisibility(View.INVISIBLE);
                    textPlayer6.setVisibility(View.INVISIBLE);
                    commander6.setVisibility(View.INVISIBLE);
                }
                else if (Integer.valueOf(playersNumber.getText().toString()) == 5 && mode.isChecked()){
                    textPlayer3.setVisibility(View.VISIBLE);
                    commander3.setVisibility(View.VISIBLE);
                    textPlayer4.setVisibility(View.VISIBLE);
                    commander4.setVisibility(View.VISIBLE);
                    textPlayer5.setVisibility(View.VISIBLE);
                    commander5.setVisibility(View.VISIBLE);
                    textPlayer6.setVisibility(View.INVISIBLE);
                    commander6.setVisibility(View.INVISIBLE);
                }
                else if (Integer.valueOf(playersNumber.getText().toString()) == 6 && mode.isChecked()){
                    textPlayer3.setVisibility(View.VISIBLE);
                    commander3.setVisibility(View.VISIBLE);
                    textPlayer4.setVisibility(View.VISIBLE);
                    commander4.setVisibility(View.VISIBLE);
                    textPlayer5.setVisibility(View.VISIBLE);
                    commander5.setVisibility(View.VISIBLE);
                    textPlayer6.setVisibility(View.VISIBLE);
                    commander6.setVisibility(View.VISIBLE);
                }
                    break;
        }
    }

    public void loadSpinners(){
        commander1 = (Spinner) findViewById(R.id.commander1);
        commander2 = (Spinner) findViewById(R.id.commander2);
        commander3 = (Spinner) findViewById(R.id.commander3);
        commander4 = (Spinner) findViewById(R.id.commander4);
        commander5 = (Spinner) findViewById(R.id.commander5);
        commander6 = (Spinner) findViewById(R.id.commander6);

        List<String> commandList = database.commanderDao().getAllCommanders();

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, commandList);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        commander1.setAdapter(spinnerAdapter);
        commander2.setAdapter(spinnerAdapter);
        commander3.setAdapter(spinnerAdapter);
        commander4.setAdapter(spinnerAdapter);
        commander5.setAdapter(spinnerAdapter);
        commander6.setAdapter(spinnerAdapter);
    }
}
