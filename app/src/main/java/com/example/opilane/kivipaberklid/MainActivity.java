package com.example.opilane.kivipaberklid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button rock,paper,scissors,end;
    ImageView humanView,computerView;
    TextView score;
    String humanChoice,computerChoice,result;
    Random r;
    int HumanScore,ComputerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rock = findViewById(R.id.rock);
        paper = findViewById(R.id.paper);
        scissors = findViewById(R.id.scissors);
        end = findViewById(R.id.end);
        score = findViewById(R.id.score);
        humanView = findViewById(R.id.human);
        computerView = findViewById(R.id.cpu);
        r = new Random();

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                humanChoice = "rock";
                calculate();
                humanView.setImageResource(R.drawable.rock);
                score.setText("human:" + Integer.toString(HumanScore) + " VS. Computer: " + Integer.toString(ComputerScore));
            }
        });
                paper.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        humanChoice = "paper";
                        calculate();
                        humanView.setImageResource(R.drawable.paper);
                        score.setText("human:" + Integer.toString(HumanScore) + " VS. Computer: " + Integer.toString(ComputerScore));
                    }
                });
                        scissors.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                humanChoice = "scissors";
                                calculate();
                                humanView.setImageResource(R.drawable.scissors);
                                score.setText("human:" + Integer.toString(HumanScore) + " VS. Computer: " + Integer.toString(ComputerScore));
                            }
                        });
                        end.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putInt("lastScore", HumanScore);
                                editor.apply();

                                Intent intent = new Intent(getApplicationContext(), ScoreActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });

    }
                        public void calculate() {
                            int computer = r.nextInt(3);
                            if (computer == 0) {
                                computerChoice = "rock";
                                computerView.setImageResource(R.drawable.rock);
                            }
                            else if (computer == 1){
                                computerChoice = "paper";
                                computerView.setImageResource(R.drawable.paper);
                            }
                            else if (computer == 2){
                                computerChoice = "scissors";
                                computerView.setImageResource(R.drawable.scissors);
                            }
                            if (humanChoice.equals("rock")&& computerChoice.equals("paper")){
                                result = "YOU LOSE! NOOB";
                                ComputerScore++;
                            }
                            else if (humanChoice.equals("rock")&& computerChoice.equals("scissors")){
                                result = "YOU WIN!";
                                HumanScore++;
                            }
                            else if (humanChoice.equals("paper")&& computerChoice.equals("scissors")) {
                                result = "YOU LOSE! NOOB";
                                ComputerScore++;
                            }
                            else if (humanChoice.equals("scissors")&& computerChoice.equals("scissors")) {
                                result = "ITS A TIE!";
                            }
                            else if (humanChoice.equals("paper")&& computerChoice.equals("paper")) {
                                result = "ITS A TIE!";
                            }
                            else if (humanChoice.equals("rock")&& computerChoice.equals("rock")) {
                                result = "ITS A TIE!";
                            }
                            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();

    }
}





