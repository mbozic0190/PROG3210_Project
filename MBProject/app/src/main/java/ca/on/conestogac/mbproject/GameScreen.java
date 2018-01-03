package ca.on.conestogac.mbproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    private Button player1;
    private Button player2;
    private Button player3;
    private Button player4;
    private Button player5;
    private Button player6;
    private TextView txtLifeActive;
    private int activePlayer;
    private int adjustedLife;

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
        txtLifeActive = (TextView) findViewById(R.id.txtLifePoints);

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
    public void playerOneActive(View view){
        activePlayer = 1;
        txtLifeActive.setText(player1.getText());
    }
    public void playerTwoActive(View view){
        activePlayer = 2;
        txtLifeActive.setText(player2.getText());
    }
    public void playerThreeActive(View view){
        activePlayer = 3;
        txtLifeActive.setText(player3.getText());
    }
    public void playerFourActive(View view){
        activePlayer = 4;
        txtLifeActive.setText(player4.getText());
    }
    public void playerFiveActive(View view){
        activePlayer = 5;
        txtLifeActive.setText(player5.getText());
    }
    public void playerSixActive(View view){
        activePlayer = 6;
        txtLifeActive.setText(player6.getText());
    }
    public void loseTen(View view){
        adjustedLife = Integer.valueOf(txtLifeActive.getText().toString())-10;

        if (adjustedLife < 0){
            adjustedLife = 0;
        }
        txtLifeActive.setText(String.valueOf(adjustedLife));
        if (activePlayer == 1){
            player1.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 2){
            player2.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 3){
            player3.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 4){
            player4.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 5){
            player5.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 6){
            player6.setText(String.valueOf(adjustedLife));
        }
    }

    public void loseOne(View view){
        adjustedLife = Integer.valueOf(txtLifeActive.getText().toString())-1;

        if (adjustedLife < 0){
            adjustedLife = 0;
        }
        txtLifeActive.setText(String.valueOf(adjustedLife));
        if (activePlayer == 1){
            player1.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 2){
            player2.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 3){
            player3.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 4){
            player4.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 5){
            player5.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 6){
            player6.setText(String.valueOf(adjustedLife));
        }
    }

    public void gainOne(View view){
        adjustedLife = Integer.valueOf(txtLifeActive.getText().toString())+1;
        txtLifeActive.setText(String.valueOf(adjustedLife));
        if (activePlayer == 1){
            player1.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 2){
            player2.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 3){
            player3.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 4){
            player4.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 5){
            player5.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 6){
            player6.setText(String.valueOf(adjustedLife));
        }
    }

    public void gainTen(View view){
        adjustedLife = Integer.valueOf(txtLifeActive.getText().toString())+10;
        txtLifeActive.setText(String.valueOf(adjustedLife));
        if (activePlayer == 1){
            player1.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 2){
            player2.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 3){
            player3.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 4){
            player4.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 5){
            player5.setText(String.valueOf(adjustedLife));
        }
        else if (activePlayer == 6){
            player6.setText(String.valueOf(adjustedLife));
        }
    }
    public void rules (View view) {
        String urlString="https://mtg.gamepedia.com/Comprehensive_rules";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setPackage("com.android.chrome");
        startActivity(intent);
    }

    public void endGame (View view){
        Intent intent = new Intent(this, GameSetupScreen.class);
        startActivity(intent);
    }
}
