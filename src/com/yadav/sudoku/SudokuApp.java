package com.yadav.sudoku;

import java.io.IOException;

public class SudokuApp {

  public static void main(String[] args) {
    SudokuFileReader reader;
    try {
      // reader = new SudokuFileReader("/home/yadav/eclipse-workspace/sudoku-validator/src/sudoku.input.txt");
      reader = new SudokuFileReader(args[0]);

      SudokuMatrix m = new SudokuMatrix();
      if(m.initialize(reader.getList())) {
        System.out.println("Input file read successfully.");
      } else {
        System.out.println("Input file failed validation.");
        return;
      }

      if(m.validateRows()) {
        System.out.println("Rows are valid.");
      } else {
        System.out.println("Rows failed validation.");
        return;
      }

      if(m.validateColumns()) {
        System.out.println("Columns are valid.");
      } else {
        System.out.println("Columns failed validation.");
        return;
      }

      if(m.validateRegions()) {
        System.out.println("Regions are valid.");
      } else {
        System.out.println("Regions failed validation.");
        return;
      }

      if(m.validateSudoku()) {
        System.out.println("Sudoku is valid.");
      } else {
        System.out.println("Sudoku failed validation.");
      }
    } catch (IOException e) {
      System.out.println("Error reading input file.");
    }

  }

}
