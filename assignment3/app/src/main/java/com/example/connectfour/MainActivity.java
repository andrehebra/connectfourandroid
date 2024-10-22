package com.example.connectfour;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBoardClick(View view) {
        Intent intent = new Intent(this, Board.class);
        startActivity(intent);
    }

    public void onOptionsClick(View view) {
        Intent intent = new Intent(this, GameOptions.class);
        mModeResultLauncher.launch(intent);
    }

    ActivityResultLauncher<Intent> mModeResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            int level = data.getIntExtra(GameOptions.GAME_MODE, R.string.easyMode);

                            if (level == R.string.easyMode) {
                                Toast.makeText(getApplicationContext(), "Easy Mode", Toast.LENGTH_LONG).show();
                            }
                            else if (level == R.string.mediumMode) {
                                Toast.makeText(getApplicationContext(), "Medium Mode", Toast.LENGTH_LONG).show();
                            }
                            else if (level == R.string.hardMode) {
                                Toast.makeText(getApplicationContext(), "Hard Mode", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
            });
}