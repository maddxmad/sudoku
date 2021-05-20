package com.sudoku.model;

public interface Board {
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
