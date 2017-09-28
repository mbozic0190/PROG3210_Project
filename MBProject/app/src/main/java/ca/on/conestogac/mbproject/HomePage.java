package ca.on.conestogac.mbproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class HomePage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

        public void playMode(View view)
    {
        ToggleButton playerToggle = (ToggleButton) findViewById(R.id.playersToggle);
        if(playerToggle.isChecked())
                {
                    SeekBar playersBar = (SeekBar) findViewById(R.id.playersBar);
                    playersBar.setVisibility(View.VISIBLE);
                    playersBar.setProgress(0);

                    final TextView playersNumber = (TextView) findViewById(R.id.playersNumber);

                    playersBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
                    {
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
                        {
                            progress = progress + 2;
                            playersNumber.setText(String.valueOf(progress));
                        }
                        public void onStartTrackingTouch(SeekBar seekBar)
                        {

                        }
                        public void onStopTrackingTouch(SeekBar seekBar)
                        {

                        }
                    });
                }
                else
                {
                    SeekBar playersBar = (SeekBar) findViewById(R.id.playersBar);
                    playersBar.setVisibility(View.INVISIBLE);

                    TextView playersNumber = (TextView) findViewById(R.id.playersNumber);
                    playersNumber.setText("2");
                }
    }
}