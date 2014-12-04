import java.util.*;

public class WordSearch {
  private char[][] wordGrid;
  private ArrayList <String> hidden;
  private ArrayList <String> possible; //Optional
  
  //Default Constructor
  public WordSearch {
    //Sets the grid to 10x10
    wordGrid = new char[10][10];
    for (int i=0;i<wordGrid.length;i++) {
      for (int j=0;j<wordGrid[i].length;j++) {
        wordGrid[i][j]="-";
  }
  
  public WordSearch (int rows, int cols) {
    wordGrid = new char[rows][cols];
    for (int i=0;i<wordGrid.length;i++) {
      for (int j=0;j<wordGrid[i].length;j++) {
        wordGrid[i][j]="-";
  }
  
  public String toString() {
    for (int i = 0; i < wordGrid.length; i++) {
      for (int j = 0; j < wordGrid[i].length; j++) {
        wordGrid[i][j] += (i * wordGrid[i].length) + j;
        System.out.print(wordGrid[i][j] + " ");
      }
      System.out.print("\n");
    }
    System.out.println(Words in Grid:);
    for (int k = 0 ; k < hidden.size(); k++) {
      System.out.pritnln(hidden.get(k));
    }
  }
  
  public boolean addWordH(int row, int col, String s) {
    for (int i=0;i<wordGrid.length;i++) {
      for (int j=0;j<wordGrid[i].length;j++) {
        if (s.length() <= wordGrid[i].length-j) {
          
          return true;
        }
      }
    }
  }
  
  public boolean addWordV(int row, int col, String s) {
    if (s.length > col.length) 
    //Basically this checks if it has enough room to put it ->return false if not
      return false;
      
    for (int i=row;i < s.length+row-1;i++)
      if (s.length-(row+i)>0 && wordGrid[row][col]==s.charAt(i)) { 
        wordGrid[row-i][col]=s.charAt(i);
        return true;
      }       
    return false;
  }
  
  public boolean addWordD(int row, int col, String s) {
  }
  
  public void fillGrid() {
    Random r = new Random();
    for (int i=0;i<wordGrid.length;i++) 
      for (int j=0;j<wordGrid[i].length;j++)
        if (wordGrid[i][j].equal("-")) {
          char c = (char) (r.nextInt(26)+ 'a');
          wordGrid[i][j] = c;
        }
  }
}
