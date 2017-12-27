package ca.on.conestogac.mbproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class GameScreen extends AppCompatActivity {

    private Button player1;
    private Button player2;
    private Button player3;
    private Button player4;
    private Button player5;
    private Button player6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        String players = getIntent().getStringExtra("PLAYERS_NUMBER");
        String startLife = getIntent().getStringExtra("START_LIFE");

        player1 = (Button) findViewById(R.id.btnPlayer1);
        player2 = (Button) findViewById(R.id.btnPlayer2);
        player3 = (Button) findViewById(R.id.btnPlayer3);
        player4 = (Button) findViewById(R.id.btnPlayer4);
        player5 = (Button) findViewById(R.id.btnPlayer5);
        player6 = (Button) findViewById(R.id.btnPlayer6);

        if (Integer.valueOf(players) == 2){
            player1.setEnabled(true);
            player1.setText(startLife);
            player2.setEnabled(true);
            player2.setText(startLife);
            player3.setEnabled(false);
            player4.setEnabled(false);
            player5.setEnabled(false);
            player6.setEnabled(false);
        }
        else if (Integer.valueOf(players) == 3){
            player1.setEnabled(true);
            player1.setText(startLife);
            player2.setEnabled(true);
            player2.setText(startLife);
            player3.setEnabled(true);
            player3.setText(startLife);
            player4.setEnabled(false);
            player5.setEnabled(false);
            player6.setEnabled(false);
        }
        else if (Integer.valueOf(players) == 4){
            player1.setEnabled(true);
            player1.setText(startLife);
            player2.setEnabled(true);
            player2.setText(startLife);
            player3.setEnabled(true);
            player3.setText(startLife);
            player4.setEnabled(true);
            player4.setText(startLife);
            player5.setEnabled(false);
            player6.setEnabled(false);
        }
        else if (Integer.valueOf(players) == 5){
            player1.setEnabled(true);
            player1.setText(startLife);
            player2.setEnabled(true);
            player2.setText(startLife);
            player3.setEnabled(true);
            player3.setText(startLife);
            player4.setEnabled(true);
            player4.setText(startLife);
            player5.setEnabled(true);
            player5.setText(startLife);
            player6.setEnabled(false);
        }
        else if (Integer.valueOf(players) == 6){
            player1.setEnabled(true);
            player1.setText(startLife);
            player2.setEnabled(true);
            player2.setText(startLife);
            player3.setEnabled(true);
            player3.setText(startLife);
            player4.setEnabled(true);
            player4.setText(startLife);
            player5.setEnabled(true);
            player5.setText(startLife);
            player6.setEnabled(true);
            player6.setText(startLife);
        }
    }
}
