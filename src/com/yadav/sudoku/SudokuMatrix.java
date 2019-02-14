package com.yadav.sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Sudoku Matrix is a 9x9 matrix
 *
 * Validation Rules
 * 1. Value must be between 1 to 9 inclusive.
 * 1. Each row must contain a set of 9 values.
 * 1. Each column must contain a set of 9 values.
 * 1. Each region must contain a set of 9 values.
 *
 * A region is a sub matrix 3x3, there are 9 distinct non-overlapping regions.
 */
public class SudokuMatrix {

  int matrix[][] = new int[9][9];

  /**
   * Create a 9x9 Matrix using a list of string containing digits in range of [1-9].
   * @param list - List of string of digits.
   * @return
   *  true  - Matrix initialize with valid input
   *  false - Matrix not initialized.
   *
   */
  public boolean initialize(ArrayList<String> list) {

    if(list == null || list.size() != 9) {
      return false;
    }

    /**
     * Iterate String as character of digits,
     * convert into value and save to Matrix.
     */
    try {
      int row = 0;
      Iterator<String> it = list.iterator();

      // Iterate list, reading one string at a time.
      while(it.hasNext()) {
        String s = it.next();
        if(s.length() != 9) {
          return false;
        }

        // Iterate string as a character array of digits.
        int col = 0;
        for(char ch: s.toCharArray()) {
          int val = Character.getNumericValue(ch);
          // Validate values are in range.
          if(val < 1 || val > 9) {
            return false;
          }
          this.matrix[row][col++] = val;
        } // for

        ++row;
      } // while
    } catch (ArrayIndexOutOfBoundsException ex) {
      return false;
    }
    return true;
  }

  /**
   * Validate 9x9 Matrix is Sudoku valid.
   * @return
   *    true  - Valid Sudoku Matrix.
   *    false - Invalid Sudoku Matrix.
   */
  public boolean validateSudoku() {
    if(validateRows() == false) {
      return false;
    }
    if(validateColumns() == false) {
      return false;
    }
    if(validateRegions() == false) {
      return false;
    }
    return true;
  }
  /**
   * Check input is a set of 9 unique digits in the range of [1-9].
   * @param arr - Array of 9 digits.
   * @return
   *    true  - Valid no repeating digits.
   *    false - Invalid input set.
   */
  public boolean validateInput(int arr[]) {
    if(arr == null || arr.length != 9) {
      return false;
    }

    // Determine if digits are unique using a Set container.
    Set<Integer> set = new HashSet<Integer>();
    for(int i=0; i < arr.length; ++i) {
      if(set.add(arr[i]) == false) {
        return false;
      }
    } // for
    return true;
  }

  /**
   * Validate each row in the matrix for Sudoku.
   * @return
   *    true  - Rows are valid.
   *    false - Rows are invalid.
   */
  public boolean validateRows() {
    for(int r=0; r < 9; ++r) {
      if(validateInput(this.matrix[r]) == false) {
        return false;
      }
    } // for
    return true;
  }

  /**
   * Validate each column in the matrix for Sudoku.
   * @return
   *    true  - Columns are valid.
   *    false - Columns are invalid.
   */
  public boolean validateColumns() {
    int arr[] = new int[9];
    for(int col=0; col < 9; ++col) {
      int i=0;
      for(int row=0; row < 9; ++row) {
        arr[i++] = this.matrix[row][col];
      }
      if(validateInput(arr) == false) {
        return false;
      }
    } // for
    return true;
  }

  /**
   * Validate each region in the matrix for Sudoku.
   * @return
   *    true  - Regions are valid.
   *    false - Regions are invalid.
   */
  public boolean validateRegions() {
    int arr[] = new int[9];
    // Iterate over regions
    for(int rowPivot=0; rowPivot < 3; ++rowPivot) {
      for(int colPivot=0; colPivot < 3; ++colPivot) {
        int i=0;
        // Iterate over sub matrix 3x3
        for(int row=0; row < 3; ++row) {
          for(int col=0; col < 3; ++col) {
            arr[i++] = this.matrix[rowPivot*3+row][colPivot*3+col];
          }
        }
        if(validateInput(arr) == false) {
          return false;
        }
      }
    }
    return true;
  }

  void dump() {
    for(int row=0; row < 9; ++row) {
      for(int col=0; col < 9; ++col) {
        System.out.print(this.matrix[row][col]+" ");
      }
      System.out.println();
    }
  }

}
