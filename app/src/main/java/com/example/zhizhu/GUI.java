package com.example.zhizhu;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class GUI extends AppCompatActivity {
    public static final int BACKGROUND_COLOR =  Color.rgb(255, 220, 180);
    private GUIPlayer whitePlayer;
    private GUIPlayer blackPlayer;

    private GUIMillBoard guiBoard;
    private GUIControl control;
    private MillGame game;

    private Button continueStopButton;
    private Button undoButton;
    private Button redoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game_menu);
        Button newGameButton = findViewById(R.id.newGame);
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);
            }
        });
    }


    public void GUI(){
            //Players
            this.whitePlayer = new GUIPlayer("White Player", Color.BLACK, Color.WHITE, GUIPlayer.HUMAN);
            this.blackPlayer = new GUIPlayer("Black Player", Color.WHITE, Color.BLACK, GUIPlayer.CPU);


            setContentView(R.layout.new_game_menu);

            //Button newGameButton = findViewById(R.id.newGame);
            /*newGameButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    game = new MillGame();
                    guiBoard.setGame(game);
                    control.newGame(game, whitePlayer, blackPlayer);
                }
            });*/

            this.game = new MillGame();
            this.guiBoard = new GUIMillBoard(this.game);
            this.control = new GUIControl(this.guiBoard, this);
          //  newGameButton.setEnabled(true);

        }
    public void refreshButtons() {
        /*String undoLabel = "Undo move "+this.game.getTurnNumber() ;
        if ( !this.undoButton.getLabel().equals(undoLabel)) {
            this.undoButton.setLabel(undoLabel);
        }
        this.undoButton.setEnabled(this.game.undoIsPossible());

        String redoLabel = "Redo move "+this.game.getTurnNumber();
        if ( !this.redoButton.getLabel().equals(redoLabel)) {
            this.redoButton.setLabel(redoLabel);
        }
        this.redoButton.setEnabled(this.game.redoIsPossible());

        if (this.control.gameIsRunning()) {
            if ( !this.continueStopButton.getLabel().equals("Stop game") ) {
                this.continueStopButton.setLabel("Stop game");
            }
        }
        else {
            if ( !this.continueStopButton.getLabel().equals("Continue game") ) {
                this.continueStopButton.setLabel("Continue game");
            }
        }
        this.continueStopButton.setEnabled(true);
        super.validate();*/
        }
    }
