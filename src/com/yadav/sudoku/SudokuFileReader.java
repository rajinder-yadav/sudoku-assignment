package com.yadav.sudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class SudokuFileReader {

  ArrayList<String> lineBuffer = new ArrayList<String>();

  SudokuFileReader(String file) throws IOException {
    String line;
    BufferedReader br = null;

    try {
      br = new BufferedReader(new FileReader(file));
      do {
        line = br.readLine();
        if(line != null && line.isEmpty() != true) {
          lineBuffer.add(line);
        }
      } while(line != null);
    }
    catch(IOException ex) {
      System.out.println("File read error.");
      throw ex;
    }
    finally {
      if(br != null) {
        br.close();
      }
    }
    // Validate 9 lines of input were read.
    if(this.lineBuffer.size() != 9) {
      throw new Error("Input file not in expected format.");
    }
  }

  public ArrayList<String> getList() {
    return this.lineBuffer;
  }

  void dump() {
    Iterator<String> it = this.lineBuffer.iterator();
    while(it.hasNext()) {
      System.out.println(it.next());
    }
  }

}
