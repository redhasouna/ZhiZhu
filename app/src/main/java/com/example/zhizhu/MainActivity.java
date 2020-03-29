package com.example.zhizhu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /** Pelaajien arvot*/
    public static final byte BLACK_PLAYER = BoardInfo.BLACK,
            WHITE_PLAYER = BoardInfo.WHITE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.Button_1);
        btn.setOnClickListener(this);


    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Button_1:
                String clicked = "The button is Clicked";
                        Toast.makeText(this, clicked, Toast.LENGTH_SHORT).show();
                Button btn = (Button) findViewById(R.id.Button_1);
                int[] color;
                color = new int[]{Color.DKGRAY,Color.CYAN,Color.YELLOW,Color.RED,Color.BLUE};
                int aryLen = color.length;
                Random random = new Random();
                int rNum = random.nextInt(aryLen);
                btn.setBackgroundColor(color[rNum]);
                break;
        }


    }
}
