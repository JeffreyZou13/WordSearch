import java.util.*;

public class WordSearch{
  private char[][] wordGrid;
  private ArrayList <String> hidden;
  private ArrayList <String> possible; //Optional
  
  //Default Constructor
  public WordSearch() {
    //Sets the grid to 10x10
    wordGrid = new char[10][10];
    for (int i=0;i<wordGrid.length;i++) 
      for (int j=0;j<wordGrid[i].length;j++) 
        wordGrid[i][j] ='-';
  }
  
  public WordSearch (int rows, int cols) {
    wordGrid = new char[rows][cols];
    for (int i=0;i<wordGrid.length;i++) 
      for (int j=0;j<wordGrid[i].length;j++) 
        wordGrid[i][j]='-';
  }
  
  public String toString() {
    String grid = "";
    for (int i = 0; i < wordGrid.length; i++) {
      for (int j = 0; j < wordGrid[i].length; j++) {
        grid += (wordGrid[i][j] + " ");
      }
      grid += "\n";
    }
    grid += ("\n" + "Words in Grid:");
    /*for (int k = 0 ; k < hidden.size(); k++) {
      grid += (hidden.get(k) + "\n");
    }
*/
    return grid;
  }
  
  public boolean addWordH(int row, int col, String s) {
    // If enough space to go forward, check forward; If result is false, Check Backwards
    // If not enough space to go foward, check backwards; enough space, then whats in spaces
    if (row < 0 || col < 0 || row >= wordGrid.length || col > wordGrid[0].length ) // does not allow un-reasonable indexes
      return false;
    boolean canAddFor = true;
    if (s.length() <= (wordGrid[row].length - col) ) //Checks if enough "space" for String going forward
      while (canAddFor == true)
        for (int i = col, j = 0; i < (s.length() + col - 1); i++, j++)//j is index of String
          if (wordGrid[row][i] != '-')
            if (wordGrid[row][i] != s.charAt(j))
              canAddFor = false;
    else
      canAddFor = false;
    if (canAddFor == true){ //If can add forward, won't check backwards
      for (int a = col, b = 0; a <s.length() + col - 1; a++, b++)
        wordGrid[row][a] = s.charAt(b);
      return true;
    }
    
    else{ //Backwards Check
      boolean canAddBack = true;
      if(s.length() <= (col + 1) ) // Length Check
        for (int x = col, y = 0; x >= (col + 1 - s.length()); x--, y++) //Index of Element goes Backwards until it hits Last Char
          if (wordGrid[row][x] != '-')
            if (wordGrid[row][x] != s.charAt(y)){
              canAddBack = false;
              return false;
            }
      else
        return false;
      if (canAddBack = true)
        for (int m = col, n = (col + 1 - s.length()); m >= 0; m--, n++){
          wordGrid[row][m] = s.charAt(n);
          return true;
        }
    }
    return false;
  }
/*
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
    //Check avaiable spaces vertically and horizontally if each >= s.length()
    //Can only add if true for both axis
    if (row < 0 || row >= wordGrid.length || col < 0 || col >= wordGrid.length ) // Unreasonable Indexes
      return false;
    boolean canAddFor = true;
    if ( (wordGrid.length - row) >= s.length() && (wordGrid[row].length - col) >= s.length() ) //Checks availabe forward space
      for (int i = row, j = col, k = 0; j < (s.length() - 1 + col); i++, j++, k++) // Checks spaces for value; restriction by checking horizontal length 
        if (wordGrid[i][j] != '-' && wordGrid[i][j] != s.charAt(k))
          canAddFor = false;
    else
      canAddFor = false;
    if (canAddFor == true) {
      for (int a = row, b = col, c = 0; b < (s.length() - 1 + col); a++, b++, c++)
        wordGrid[a][b] = s.charAt(c);
      return true;
    }
    
    else { 
      boolean canAddBack = true;
      if ( (row + 1 >= s.length()) && (col + 1 >= s.length()) ) //Checks available backwards space
        for(int x = col, y = row, z = 0; x >= (col - s.length() + 1); x--, y--, z++)
          if( wordGrid[x][y] != '-' && wordGrid[x][y] != s.charAt(z))
            return false;
      else 
        return false;
        if (canAddBack == true) {
            for(int f = col, o = row, g = 0; f >= (col - s.length() + 1); f--, o--, g++)
              wordGrid[f][o] = s.charAt(g);
            return true;
        }
    }
    return false;
  }
  */
  public void fillGrid() {
    Random r = new Random();
    for (int i=0;i<wordGrid.length;i++) 
      for (int j=0;j<wordGrid[i].length;j++)
        if (wordGrid[i][j] == ('-')) {
          char[] alphabet ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	  char c = alphabet[r.nextInt(26)];
          wordGrid[i][j] = c;
        }
  }
  
  public static void main(String[] args){
    WordSearch ws = new WordSearch();
       /* 
        //working horizontal words
        ws.addWordH(0, 0, "hello");
        ws.addWordH(2, 4, "batman");
        ws.addWordH(5, 1, "apple");

        //Horizontal index error checking
        ws.addWordH(-2, 4, "joker");
        ws.addWordH(10, 4, "unicorn");  
        ws.addWordH(3, -1, "cowboys");
        ws.addWordH(5, 8, "dogs");

        //horizontal collision checking
        ws.addWordH(5, 3, "plow");
        ws.addWordH(2, 0, "neato");
        
        working vertical words
        ws.addWordV(1, 0, "nice");
        ws.addWordV(4, 9, "yankee");
        ws.addWordV(4, 4, "old");
        
        //Verical index error checking
        ws.addWordV(-2, 4, "joker");
        ws.addWordV(7, 4, "unicorn");   
        ws.addWordV(3, -1, "cowboys");
        ws.addWordV(5, 20, "dogs");
        
        //vertical collision checking
        ws.addWordV(0, 4, "ores");
        ws.addWordV(4, 9, "goober");
	
       
        //working diagonal words
        ws.addWordD(7, 0,  "cat");
        ws.addWordD(0, 0, "home");
        ws.addWordD(0, 3, "loam");
        //Diagonal index error checking
        ws.addWordD(-2, 0,  "cat");
        ws.addWordD(3, -1,  "whelm");
        ws.addWordD(7, 7,  "after");    

        //Diagonal collision checking
        ws.addWordD(0, 4, "ores");
        ws.addWordD(4, 4, "oats");
*/

        System.out.println(ws);
        
        //ws.fillGrid();
        System.out.println(ws);
  }
}
