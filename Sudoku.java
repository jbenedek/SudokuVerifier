//Jeremy Benedek
//github.com/jbenedek/SudokuVerifier
//
//This is Sudoku.java. This class handles the interworking of an element (group of 9 numbers, such as row/column/box).

import java.util.ArrayList;

public class Sudoku{
  ArrayList element = new ArrayList();

  public void append(int a){
    element.add(a);
  }

  public void printAll(){
    System.out.println(element);
  }

  //return true if the element contains each element
  public boolean isValidElem(){
    boolean valid = true; 

    for(int i = 1; i <=9; i++){
      valid &= hasNum(i); //Valid if valid and has every Number
    }
    return valid;
  }

  public boolean hasNum(int a){
    return -1 != element.indexOf(a); //indexOf returns -1 if number in not in the array
  }

  public int getElem(int a){
    return (int) element.get(a);
  }
}
