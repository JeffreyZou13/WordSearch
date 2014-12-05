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
    // If enough space to go forward, check forward; If result is false, Check Backwards
    // If not enough space to go foward, check backwards; enough space, then whats in spaces
    boolean canAddFor = true;
    if (s.length() <= wordGrid[row].length - col) //Checks if enough "space" for String going forward
      while (canAddFor == true)
        for (int i = col, int j = 0; i < s.length() + col - 1; i++, j++)//j is index of String
          if (wordGrid[row][i] != '-')
            if (wordGrid[row][i] != s.charAt(j))
              canAdd = false;
    if (canAddFor == true){ //If can add forward, won't check backwards
      for (int a = col, int b = 0; a <s.length() + col - 1; a++, j++)
        wordgrid[row][a] = s.charAt(b);
      return true;
    }
    else{ //Backwards Check
      
    }
  }
  
  public boolean addWordV(int row, int col, String s) {
    /*if (s.length > col.length) 
    //Basically this checks if it has enough room to put it ->return false if not
      return false;
      
    for (int i=row;i < s.length+row-1;i++)
      if (s.length-(row+i)>0 && wordGrid[row][col]==s.charAt(i)) { 
        wordGrid[row-i][col]=s.charAt(i);
        return true;
      }       
    return false;*/
    boolean canFitDown=true;
    if (s.length() <= col.length) //change this idk how to check for size
      while (canFitDown)
        for (int i = row, int j = 0; i<wordGrid[j].length; i++, j++)
          if (wordGrid[i][col] != "-")
            if (wordGrid[i][col] != s.charAt(j))
              canFitDown = false;
    
    if (canFitDown)
      for (int a = row, int b = 0; a<wordGrid[b].length; a++, b++)
        word[a][col] == s.charAt(b);
    
    //check for false
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
