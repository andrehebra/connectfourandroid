package com.example.connectfour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Options extends AppCompatActivity {
    private RadioButton easy;
    private RadioButton medium;
    private RadioButton hard;
    public static final String GAME_MODE = "com.example.connectfour.gameoptions";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_options);
        easy = (RadioButton)findViewById(R.id.easyButton);
        medium = (RadioButton)findViewById(R.id.mediumButton);
        hard = (RadioButton)findViewById(R.id.hardButton);
    }

    public void onLevelSelected(View view) {
        int difficulty;
        if(easy.isChecked()) {
            difficulty = R.string.easyMode;
        } else if(medium.isChecked()) {
            difficulty = R.string.mediumMode;
        } else if(hard.isChecked()) {
            difficulty = R.string.hardMode;
        } else {
            difficulty = R.string.easyMode;
        }

        Intent intent = new Intent();
        intent.putExtra(GAME_MODE, difficulty);
        setResult(RESULT_OK, intent);
        finish();
    }
}