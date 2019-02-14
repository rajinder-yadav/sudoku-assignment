package test.com.yadav.sudoku;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.yadav.sudoku.SudokuMatrix;

class SudokuMatrixTester {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
  }

  @BeforeEach
  void setUp() throws Exception {
  }

  @AfterEach
  void tearDown() throws Exception {
  }

  @Test
  void testInitializeValidInput() {
    ArrayList<String> list = new ArrayList<String>();

    String arr[] = {
        "534678912",
        "672195348",
        "198342567",
        "859761423",
        "426853791",
        "713924856",
        "961537284",
        "287419635",
        "345286179"
    };
    for(int i=0; i < arr.length; ++i) {
      list.add(arr[i]);
    }
    SudokuMatrix s = new SudokuMatrix();
    assertTrue(s.initialize(list));
  }

  @Test
  void testInitializeEmptyInput() {
    ArrayList<String> list = new ArrayList<String>();

    String arr[] = {};
    SudokuMatrix s = new SudokuMatrix();
    assertFalse(s.initialize(list));
  }

  @Test
  void testInitializeNullInput() {
    ArrayList<String> list = new ArrayList<String>();

    SudokuMatrix s = new SudokuMatrix();
    assertFalse(s.initialize(null));
  }

  @Test
  void testInitializeOversizedList() {
    ArrayList<String> list = new ArrayList<String>();

    String arr[] = {
        "534672198",
        "678195342",
        "912348567",
        "859426713",
        "761853924",
        "423791856",
        "961287345",
        "537419286",
        "284635179",
        "284635179"
    };
    for(int i=0; i < arr.length; ++i) {
      list.add(arr[i]);
    }
    SudokuMatrix s = new SudokuMatrix();
    assertFalse(s.initialize(list));
  }

  @Test
  void testInitializeUndersizedList() {
    ArrayList<String> list = new ArrayList<String>();

    String arr[] = {
        "534672198",
        "678195342",
        "912348567",
        "859426713",
        "761853924",
        "423791856",
        "961287345",
        "537419286"
    };
    for(int i=0; i < arr.length; ++i) {
      list.add(arr[i]);
    }
    SudokuMatrix s = new SudokuMatrix();
    assertFalse(s.initialize(list));
  }

  @Test
  void testInitializeOversizedLine() {
    ArrayList<String> list = new ArrayList<String>();

    String arr[] = {
        "5346721982",
        "678195342",
        "912348567",
        "859426713",
        "761853924",
        "423791856",
        "961287345",
        "537419286",
        "284635179"
    };
    for(int i=0; i < arr.length; ++i) {
      list.add(arr[i]);
    }
    SudokuMatrix s = new SudokuMatrix();
    assertFalse(s.initialize(list));
  }

  @Test
  void testInitializeUnersizedLine() {
    ArrayList<String> list = new ArrayList<String>();

    String arr[] = {
        "53467219",
        "678195342",
        "912348567",
        "859426713",
        "761853924",
        "423791856",
        "961287345",
        "537419286",
        "284635179"
    };
    for(int i=0; i < arr.length; ++i) {
      list.add(arr[i]);
    }
    SudokuMatrix s = new SudokuMatrix();
    assertFalse(s.initialize(list));
  }

  @Test
  void testValidInput() {
    SudokuMatrix s = new SudokuMatrix();
    final int arr[] = {1,2,3,4,5,6,7,8,9};
    assertTrue(s.validateInput(arr));
  }

  @Test
  void testDuplicateInput() {
    SudokuMatrix s = new SudokuMatrix();
    final int arr[] = {9,2,3,4,5,6,7,8,9};
    assertFalse(s.validateInput(arr));
  }

  @Test
  void testUndersizedInput() {
    SudokuMatrix s = new SudokuMatrix();
    final int arr[] = {1,2,3,4,5,6,7,8};
    assertFalse(s.validateInput(arr));
  }

  @Test
  void testOversizedInput() {
    SudokuMatrix s = new SudokuMatrix();
    final int arr[] = {1,2,3,4,5,6,7,8,9,1};
    assertFalse(s.validateInput(arr));
  }

  @Test
  void testEmptyInput() {
    SudokuMatrix s = new SudokuMatrix();
    final int arr[] = {};
    assertFalse(s.validateInput(arr));
  }

  @Test
  void testNullInput() {
    SudokuMatrix s = new SudokuMatrix();
    assertFalse(s.validateInput(null));
  }

  @Test
  void testInitializeValidateRows() {
    ArrayList<String> list = new ArrayList<String>();

    String arr[] = {
        "123456789",
        "123456789",
        "123456789",
        "123456789",
        "123456789",
        "123456789",
        "123456789",
        "123456789",
        "123456789"
    };
    for(int i=0; i < arr.length; ++i) {
      list.add(arr[i]);
    }
    SudokuMatrix s = new SudokuMatrix();
    assertTrue(s.initialize(list));
    assertTrue(s.validateRows());
  }

  @Test
  void testInitializeValidate1BadRow() {
    ArrayList<String> list = new ArrayList<String>();

    String arr[] = {
        "123456781",
        "123456789",
        "123456789",
        "123456789",
        "123456789",
        "123456789",
        "123456789",
        "123456789",
        "123456789"
    };
    for(int i=0; i < arr.length; ++i) {
      list.add(arr[i]);
    }
    SudokuMatrix s = new SudokuMatrix();
    assertTrue(s.initialize(list));
    assertFalse(s.validateRows());
  }

  @Test
  void testInitializeValidateColumns() {
    ArrayList<String> list = new ArrayList<String>();

    String arr[] = {
        "111111111",
        "222222222",
        "333333333",
        "444444444",
        "555555555",
        "666666666",
        "777777777",
        "888888888",
        "999999999"
    };
    for(int i=0; i < arr.length; ++i) {
      list.add(arr[i]);
    }
    SudokuMatrix s = new SudokuMatrix();
    assertTrue(s.initialize(list));
    assertTrue(s.validateColumns());
  }

  @Test
  void testInitializeValidate1BadColumn() {
    ArrayList<String> list = new ArrayList<String>();

    String arr[] = {
        "116111111",
        "222222222",
        "333333333",
        "444444444",
        "555555555",
        "666666666",
        "777777777",
        "888888888",
        "999999999"
    };
    for(int i=0; i < arr.length; ++i) {
      list.add(arr[i]);
    }
    SudokuMatrix s = new SudokuMatrix();
    assertTrue(s.initialize(list));
    assertFalse(s.validateColumns());
  }

  @Test
  void testInitializeValidRegions() {
    ArrayList<String> list = new ArrayList<String>();

    String arr[] = {
        "123123123",
        "456456456",
        "789789789",
        "123123123",
        "456456456",
        "789789789",
        "123123123",
        "456456456",
        "789789789"
    };
    for(int i=0; i < arr.length; ++i) {
      list.add(arr[i]);
    }
    SudokuMatrix s = new SudokuMatrix();
    assertTrue(s.initialize(list));
    assertTrue(s.validateRegions());
  }

  @Test
  void testInitializeValid1BadRegion() {
    ArrayList<String> list = new ArrayList<String>();

    String arr[] = {
        "123123123",
        "456456456",
        "789789789",
        "123123123",
        "456436456",
        "789789789",
        "123123123",
        "456456456",
        "789789789"
    };
    for(int i=0; i < arr.length; ++i) {
      list.add(arr[i]);
    }
    SudokuMatrix s = new SudokuMatrix();
    assertTrue(s.initialize(list));
    assertFalse(s.validateRegions());
  }

  @Test
  void testValidateGoodSudoku() {
    ArrayList<String> list = new ArrayList<String>();

    String arr[] = {
        "534678912",
        "672195348",
        "198342567",
        "859761423",
        "426853791",
        "713924856",
        "961537284",
        "287419635",
        "345286179"
    };
    for(int i=0; i < arr.length; ++i) {
      list.add(arr[i]);
    }
    SudokuMatrix s = new SudokuMatrix();
    assertTrue(s.initialize(list));
    assertTrue(s.validateColumns());
    assertTrue(s.validateRows());
    assertTrue(s.validateRegions());
    assertTrue(s.validateSudoku());
  }

  @Test
  void testValidateBadSudoku() {
    ArrayList<String> list = new ArrayList<String>();

    String arr[] = {
        "534678912",
        "672195348",
        "198342567",
        "859761423",
        "426853791",
        "713924856",
        "961537254",
        "287419635",
        "345286179"
    };
    for(int i=0; i < arr.length; ++i) {
      list.add(arr[i]);
    }
    SudokuMatrix s = new SudokuMatrix();
    assertTrue(s.initialize(list));
    assertFalse(s.validateSudoku());
  }

}
