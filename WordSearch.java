public class WordSearch {
  char[][] wordGrid;
  ArrayList <String> hidden;
  ArrayList <String> possible; //Optional
  
  //Default Constructor
  public WordSearch {
    //Sets the grid to 10x10
    wordGrid = new char[10][10];
  }
  
  public WordSearch (int rows, int cols) {
    wordGrid = new char[rows][cols];
  }
}
