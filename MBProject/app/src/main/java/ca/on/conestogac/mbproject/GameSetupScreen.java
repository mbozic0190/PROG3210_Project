package ca.on.conestogac.mbproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class GameSetupScreen extends AppCompatActivity {

    private ToggleButton playerToggle;
    private SeekBar playersBar;
    private TextView playersNumber;

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
        }
        else
        {
            playersBar.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_setup_screen);
        playerToggle = (ToggleButton) findViewById(R.id.playersToggle);
        playersBar = (SeekBar) findViewById(R.id.playersBar);
        playersNumber = (TextView) findViewById(R.id.playersNumber);

        playersBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress = progress + 2;
                playersNumber.setText(String.valueOf(progress));
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
                    break;
            case R.id.radioCommander:
                if (checked)
                    StartLife.setText(String.valueOf(40));
                    break;
        }
    }
}
