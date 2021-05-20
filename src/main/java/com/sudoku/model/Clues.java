package com.sudoku.model;

public interface Clues {
    /** need a way to section the 3x3 squares that make up a puzzle to make checking for solved easier
     * among other things; maybe have board made up of board section [][] and check upon board construction
     * that a "square" puzzle is being passed through
     * ^throws off row/col stuff
     */

    /** Getter method for the number of cells horizontally in each row of the puzzle */
    int getWidth();

    /** Getter method for the number of cells vertically in each column of the puzzle
     * (prob dont need; height should be same as width since 3x3 squares and square board) */
    int getHeight();

    /** Getter method to retrieve the clue list for a given row of the puzzle */
    int[] getRowClues(int index);

    /** Getter method to retrieve the clue list for a given column of the puzzle */
    int[] getColClues(int index);


    int[][] getClues();

    boolean getCanOverwrite(int row, int col);

    /** Returns true if the cell at the given location is shaded
     * (prob dont need) */
    boolean isFilled(int row, int col);

    /**
     * Returns true if the cell at the given location is blank
     * (i.e. number in this cell == 0)
     * (still have row/col prob. maybe use mod ???)
     */
    boolean isSpace(int row, int col);

    /** Changes the number represented in the cell at the given location is */
    void toggleCellNumber(int row, int col, int num);

    /** Toggles whether the cell at the given location is a blank cell
     * (maybe toggles makes value in cell 0) */
    void toggleCellBlank(int row, int col);

    /** Clears the board by marking all the cells blank
     * (maybe don't use bc can make blank??) */
    void clear();

}
