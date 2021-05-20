package com.sudoku;



import static org.junit.jupiter.api.Assertions.*;

import com.sudoku.model.*;
import  org.junit.jupiter.api.Test;

import java.util.Arrays;


public class AppTest {

    // need to test for cluesCanOverwrite in constructor, or in a getter method

    @Test
    public void cluesConstructorValid() {
        int[] validClue1 = {0, 0, 0};
        int[] validClue2 = {1, 0, 0};
        int[] validClue3 = {0, 2, 6};

        int[][] clueArr1 = {
                validClue1,
                validClue2,
                validClue3
        };

        Clues clues1 = new CluesImpl(clueArr1);
        assertTrue(Arrays.deepEquals(clueArr1, clues1.getClues()));

    }

    @Test
    public void cluesConstructorInvalid() {
        int[] validClue1 = {0, 0, 0};
        int[] validClue2 = {1, 0, 0};
        int[] validClue3 = {0, 2, 6};
        int[] invalidClueL = {10, 9, 0};
        int[] invalidClueM = {0, -1, 1};
        int[] invalidClueR = {4, 5, 11};
        int[] invalidClue1 = {4, 5, 0, 0};

        int[][] clueArr1 = {
                invalidClueL,
                validClue2,
                validClue3
        };

        int[][] clueArr2 = {
                validClue1,
                invalidClueM,
                validClue3
        };

        int[][] clueArr3 = {
                validClue1,
                validClue2,
                invalidClueR
        };

        int[][] clueArr4 = {
                validClue1,
                validClue2,
                invalidClue1
        };

        assertThrows(IllegalArgumentException.class,() -> new CluesImpl(clueArr1));
        assertThrows(IllegalArgumentException.class,() -> new CluesImpl(clueArr2));
        assertThrows(IllegalArgumentException.class,() -> new CluesImpl(clueArr3));
        assertThrows(IllegalArgumentException.class,() -> new CluesImpl(clueArr4));
        assertThrows(IllegalArgumentException.class,() -> new CluesImpl(null));
    }

    @Test
    public void cluesGetRowClues() {

        int[][] clueArr1 = {
                new int[] {0, 0, 0},
                new int[] {1, 0, 0},
                new int[] {0, 2, 6}
        };

        Clues clues1 = new CluesImpl(clueArr1);
        assertTrue(Arrays.equals(clueArr1[0], clues1.getRowClues(0)));
        assertTrue(Arrays.equals(clueArr1[1], clues1.getRowClues(1)));
        assertTrue(Arrays.equals(clueArr1[2], clues1.getRowClues(2)));
        assertFalse(Arrays.equals(clueArr1[0], clues1.getRowClues(1)));
    }

    @Test
    public void cluesGetColClues() {
        int[][] clueArr1 = {
                new int[] {0, 0, 0},
                new int[] {1, 0, 0},
                new int[] {0, 2, 6}
        };

        int[] col0 = {0, 1, 0};
        int[] col1 = {0, 0, 2};
        int[] col2 = {0, 0, 6};

        Clues clues1 = new CluesImpl(clueArr1);
        assertTrue(Arrays.equals(col0, clues1.getColClues(0)));
        assertTrue(Arrays.equals(col1, clues1.getColClues(1)));
        assertTrue(Arrays.equals(col2, clues1.getColClues(2)));
        assertFalse(Arrays.equals(col0, clues1.getRowClues(0)));
    }


}
