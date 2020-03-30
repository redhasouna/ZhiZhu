package com.example.zhizhu;

import android.graphics.Color;
import android.os.Build;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class GUIPlayer extends AppCompatActivity {

    public static final int HUMAN = 0;
    public static final int CPU = 1;

    public static final int RANDOM = 0,
            ONE_SECOND = 1,
            THREE_SECONDS = 2,
            FIVE_SECONDS = 3,
            TEN_SECONDS = 4,
            THIRTY_SECONDS = 5,
            DEPTH_1 = 6,
            DEPTH_2 = 7,
            DEPTH_4 = 8,
            DEPTH_6 = 9,
            DEPTH_8 = 10,
            DEPTH_10 = 11,
            DEPTH_12 = 12;

    private static final int ACTIVE_INFOAREA_COLOR = Color.rgb(192, 255, 192);

    private TextView infoArea;
    private String hiddenInfoText = "";

    private Spinner playerChoice;
    private Spinner levelChoice;



    public GUIPlayer(String name,
                     int nameColor,
                     int background,
                     int defaultPlayer) throws IllegalArgumentException {
        if (name == null || nameColor == 0 || background == 0 ||
                defaultPlayer < HUMAN || defaultPlayer > CPU) {
            throw new IllegalArgumentException(
                    "No argument for GUIPlayer can be null." +
                            "DefaultPlayer:" + defaultPlayer + " must be 0 or 1.");

        }
    }
    public void setInfoText(String s) {
        //this.infoArea.setText(s);
        this.infoArea = findViewById(R.id.infoArea);
        this.infoArea.setText(s);
        this.hiddenInfoText = s;
    }
    public void setChoicesActive(boolean active) {
        this.playerChoice = findViewById(R.id.playerChoice);
        this.playerChoice.setEnabled(active);
        this.levelChoice = findViewById(R.id.levelChoice);
        this.levelChoice.setEnabled(active);
    }
    public int getPlayerChoice() {
        return this.playerChoice.getSelectedItemPosition();
    }
    public int getCPULevelChoice() throws IllegalStateException {
        if (this.getPlayerChoice() == HUMAN) {
            throw new IllegalStateException("Level choices are available only for CPU players.");
        }
        return this.levelChoice.getSelectedItemPosition();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setActive(boolean active) {
        if (active) {
            this.infoArea.setBackgroundColor(ACTIVE_INFOAREA_COLOR);
        }
        else {
//            this.infoArea.setBackground(PASSIVE_INFOAREA_COLOR);
            this.infoArea.setBackgroundColor(GUI.BACKGROUND_COLOR);
        }
//        this.infoArea.invalidate();
    }
}