package com.example.zhizhu;

public class MoveParser {

    private static final byte NONE = Move.NOWHERE;

    private GUIMillBoard guiBoard;
    private MillGame game;
    private boolean clickable;
    private GUIPlayer player;

    private byte selectedFrom,
            selectedTo,
            selectedRemove;

    public MoveParser(GUIMillBoard guiBoard) {
        this.game = null;
        this.guiBoard = guiBoard;
        //this.guiBoard.addObserver(this);
        this.player = null;
        this.clearSelections();

        this.clickable = false;
    }

    public void setGame(MillGame game) {
        this.game = game;
        this.clearSelections();
    }

    public void clearSelections() {
        this.selectedFrom = NONE;
        this.selectedTo = NONE;
        this.selectedRemove = NONE;

        this.guiBoard.clearSelectedFromSquare();
        this.guiBoard.clearSelectedToSquare();

        if (player != null) {
            this.player.setInfoText(this.getHelpText());
        }
    }
    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }
    private String getHelpText() {
        if (this.game.getGameState() == MillGame.PHASE_GAME_OVER) {
            if (this.game.getActivePlayer() == MillGame.WHITE_PLAYER) {
                return "Game is over. WHITE PLAYER WINS.";
            }
            else {
                return "Game is over. BLACK PLAYER WINS.";
            }
        }
        else if (this.game.getGameState() == MillGame.PHASE_BEGINNING) {
            if (this.selectedTo == NONE) {
                return "Click an empty square to place your piece on it.";
            }
            else {
                return "Click a piece your opponent owns in order to remove it."+
                        " Piece that is a part of mill can't be removed unless all"+
                        " opponent's pieces are in mills.";
            }
        }
        else {
            if (this.selectedFrom == NONE) {
                return "Click on the piece you want to move. You can only move your own pieces.";
            }
            else if (this.selectedTo == NONE) {
                return "Click an empty square to move your selected piece to it. If you have"+
                        " more than 3 pieces on the board, you can only move pieces to"+
                        " adjacent squares.";
            }
            else {
                return "Click a piece your opponent owns in order to remove it."+
                        " Piece that is a part of mill can't be removed unless all"+
                        " opponent's pieces are in mills.";
            }
        }
    }
    public void setPlayer(GUIPlayer player) throws IllegalArgumentException {
        if (player == null) {
            throw new IllegalArgumentException("Parameter 'GUIPlayer' can't be null!");
        }
        this.player = player;
    }
}
