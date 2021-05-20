package com.sudoku.model;

public class BoardImpl implements Board {
    private Clues[][] _board;

    @Override
    public boolean isFilled(int row, int col) {
        int clueRow = row/3;
        int clueCol = col/3;
        return _board[clueRow][clueCol].isFilled(clueRow % 3, clueCol % 3);
    }

    @Override
    public boolean isSpace(int row, int col) {
        int clueRow = row/3;
        int clueCol = col/3;
        return _board[clueRow][clueCol].isSpace(clueRow % 3, clueCol % 3);
    }

    @Override
    public void toggleCellNumber(int row, int col, int num) {
        int clueRow = row/3;
        int clueCol = col/3;
        _board[clueRow][clueCol].toggleCellNumber(clueRow % 3, clueCol % 3, num);
    }

    @Override
    public void toggleCellBlank(int row, int col) {
        int clueRow = row/3;
        int clueCol = col/3;
        _board[clueRow][clueCol].toggleCellBlank(clueRow % 3, clueCol % 3);
    }

    @Override
    public void clear() {

    }
}
