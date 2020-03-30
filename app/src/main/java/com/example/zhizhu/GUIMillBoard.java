package com.example.zhizhu;


import androidx.appcompat.app.AppCompatActivity;

public class GUIMillBoard extends AppCompatActivity {

    private int[][] squareCoordinates;
    private MillGame game;
    private byte selectedFromSquare;
    private byte selectedToSquare;
    private boolean highlightLegalSquares;
    private static final byte NONE = -1;

    public void setGame(MillGame game) {
        if (game == null) {
            throw new IllegalArgumentException("GUIMillBoard(MillGame): Parameter 'MillGame' can�'t be null.");
        }
        this.game = game;
    }
    public GUIMillBoard(MillGame game) {
        if (game == null) {
            throw new IllegalArgumentException("GUIMillBoard(MillGame): Parameter 'MillGame' can�'t be null.");
        }
        this.squareCoordinates = new int[24][2];

        this.game = game;
        this.selectedFromSquare = NONE;
        this.selectedToSquare = NONE;
        this.highlightLegalSquares = false;
    }
    public void clearSelectedFromSquare() {
        this.selectedFromSquare = NONE;
    }
    public void clearSelectedToSquare() {
        this.selectedToSquare = NONE;
    }
    public void setHighlightLegalSquares(boolean active) {
        this.highlightLegalSquares = active;
    }

    public void repaint() {
        setContentView(R.layout.new_game_menu);

    }
}
