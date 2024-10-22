package com.example.connectfour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class GameOptions extends AppCompatActivity {
    private RadioButton easy;
    private RadioButton med;
    private RadioButton hard;
    public static final String GAME_MODE = "com.example.connectfour.gameoptions";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_options);

        easy = (RadioButton)findViewById(R.id.radio_easy);
        med = (RadioButton)findViewById(R.id.radio_medium);
        hard = (RadioButton)findViewById(R.id.radio_hard);
    }

    public void onLevelSelected(View view) {
        int levelId;

        if(easy.isChecked())
        {
            levelId = R.string.easyMode;
        }
        else if(med.isChecked())
        {
            levelId = R.string.mediumMode;
        }
        else if(hard.isChecked())
        {
            levelId = R.string.hardMode;
        }
        else
        {
            levelId = R.string.easyMode;
        }

        Intent intent = new Intent();
        intent.putExtra(GAME_MODE, levelId);
        setResult(RESULT_OK, intent);
        finish();
    }
}