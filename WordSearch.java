import java.util.*;

public class WordSearch {
  private char[][] wordGrid;
  private ArrayList <String> hidden;
  private ArrayList <String> possible; //Optional
  
  //Default Constructor
  public WordSearch {
    //Sets the grid to 10x10
    wordGrid = new char[10][10];
  }
  
  public WordSearch (int rows, int cols) {
    wordGrid = new char[rows][cols];
  }
  
  public boolean addWordH(int row, int col, String s) {
    for (int i=0;i<wordGrid.length;i++) {
      for (int j=0;j<wordGrid[i].length;j++) {
        if (s.length() <= wordGrid[i].length-j) {
          //check character if any & add if no characters
          //also check reverse
          return true;
        }
      }
    }
  }
  
  public boolean addWordV(int row, int col, String s) {
    for (int i=0;i<wordGrid.length;i++) {
      for (int j=0;j<wordGrid[i];j++) {
        if (s.length<=wordGrid.length-i) {
          //do same thing as the horizontal thingy
          return true;
        }
      }
    }
  }
  
  public boolean addWordD(int row, int col, String s) {
  }
  
  public void fillGrid() {
    Random r = new Random();
    for (int i=0;i<wordGrid.length;i++) 
      for (int j=0;j<wordGrid[i].length;j++)
        if (wordGrid[i][j].equal("\u0000")) {
          char c = (char) (r.nextInt(26)+ 'a');
          wordGrid[i][j] = c;
        }
  }
}
