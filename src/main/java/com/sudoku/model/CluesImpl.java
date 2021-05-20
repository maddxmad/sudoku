package com.sudoku.model;

public class CluesImpl implements Clues {
    private int[][] _clues;
    private final boolean[][] _clueCanOverwrite;

    public CluesImpl(int[][] clues) {
        if ((clues == null) || (clues.length != 3)) {
            throw new IllegalArgumentException("invalid clue");
        } else {
            _clueCanOverwrite = new boolean[3][3];
            for (int i = 0; i < clues.length; i++) {
                for (int j = 0; j < clues[i].length; j++) {
                    if ((clues[i][j] < 0) || (clues[i][j] > 9) || (clues[i].length != 3)) {
                        throw new IllegalArgumentException("clue value is invalid");
                    }
                    _clueCanOverwrite[i][j] = (clues[i][j] == 0);
                }
            }
        }
        _clues = clues;
    }

    @Override
    public int getWidth() {
        return 3;
    }

    @Override
    public int getHeight() {
        return 3;
    }

    @Override
    public int[] getRowClues(int index) {
        return _clues[index].clone();
    }

    @Override
    public int[] getColClues(int index) {
        int[] col = new int[3];
        for (int i = 0; i < 3; i++) {
            col[i] = _clues[i][index];
        }
        return col;
    }

    public int[][] getClues() {
        return _clues.clone();
    }

    @Override
    public boolean getCanOverwrite(int row, int col) {
        return _clueCanOverwrite[row][col];
    }

    @Override
    public boolean isFilled(int row, int col) {
        return false;
    }

    @Override
    public boolean isSpace(int row, int col) {
        return false;
    }

    @Override
    public void toggleCellNumber(int row, int col, int num) {

    }

    @Override
    public void toggleCellBlank(int row, int col) {

    }

    // maybe not make it a button option and just use it to clear when changing puzzle???
    @Override
    public void clear() {

    }
}
