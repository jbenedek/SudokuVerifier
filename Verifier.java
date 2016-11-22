//Jeremy Benedek
//github.com/jbenedek/SudokuVerifier
//
//This is Verifier.java. This class gets userInput and verifies puzzle.


import java.util.Scanner;
import java.util.Arrays;


public class Verifier{
  static Sudoku[] row = new Sudoku[9];
  static Sudoku[] col = new Sudoku[9]; 
  static Sudoku[] box = new Sudoku[9];

  static boolean colVerify = true;
  static boolean rowVerify = true;
  static boolean boxVerify = true;

  public static void main(String[] args){
    getInput();
    answer();
  }

  public static void answer(){
    if(verifyAll()){
      System.out.println("Sudoku is valid"); 
    }
    else{
      System.out.println("Sudoku is not valid");
    }
  } 

  //each column is represented as a sudoku elem, in array col[i]; where is the column 0-8 (left to right)
  public static boolean verifyColumns(){
    for(int i =0; i<=8; i++){
      col[i] = new Sudoku();
      for(int n=0; n<=8; n++){
	col[i].append( row[n].getElem(i) );
      }
      colVerify &= col[i].isValidElem();
    }
    return colVerify;
  }


  //Boxes labeled as: 0 1 2
  // 	      	      3 4 5
  //		      6 7 8 

  //each box is represented as a sudoku elem, in array box[b], where b is the label of the box.
  public static boolean verifyBox(){
    for(int b =0; b<=8; b++){ //boxes
      box[b]=new Sudoku();
      if(b==0 || b==3 || b==6){ //0,3,6 (FAR LEFT)
	for(int r=0; r<=2; r++){//row in the boxes
	  for(int e=0; e<=2; e++){ //element 
	    box[b].append(row[r+b].getElem(e));  
	  }
	}
      }
      if(b==1 || b==4 || b==7){ //1,4,7 (MIDDLE)
	for(int r=0; r<=2; r++){
	  for(int e=0; e<=2; e++){	
	    box[b].append(row[r+b-1].getElem(e+3));  
	  }
	}
      }
      if(b==2 || b==5 || b==8){ //2,5,8 (FAR RIGHT)
	for(int r=0; r<=2; r++){
	  for(int e=0; e<=2; e++){
	    box[b].append(row[r+b-2].getElem(e+6));  
	  }
	}
      }
      boxVerify &= box[b].isValidElem();
    }
    return boxVerify;
  }

  public static boolean verifyRows(){
    for(int i=0; i<=8; i++){
      rowVerify &= row[i].isValidElem();
    }
    return rowVerify;
  }

  public static boolean verifyAll(){
    return verifyRows() & verifyBox() & verifyColumns();
  }

  public static void getInput(){
    Scanner scanner = new Scanner(System.in);
    for(int i=0; i<=8; i++){//i is row number
      row[i] = new Sudoku();	
      for(int n=0; n<=8; n++){
	row[i].append(scanner.nextInt());
      }
    }  
  }
}
