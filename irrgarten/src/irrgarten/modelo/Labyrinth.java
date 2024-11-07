/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten.modelo;

import java.util.ArrayList;

/**
 *
 * @author fnand
 */
public class Labyrinth {
    
    ///////////////////////////////////////////////////////////////////
    ///////////////////          Atributos          ///////////////////
    ///////////////////////////////////////////////////////////////////
    
    private final static char BLOCK_CHAR = 'X';
    private final static char EMPTY_CHAR = '-';
    private final static char MONSTER_CHAR = 'M';
    private final static char COMBAT_CHAR = 'C';
    private final static char EXIT_CHAR = 'E';
    private final static int ROW = 0;
    private final static int COL = 1;
    private int nRows;
    private int nCols;
    private int exitRow;
    private int exitCol;
    

    
    Monster [][] monstersTable;
    Player [][] playersTable;
    char [][] charTable;
    
    
    ///////////////////////////////////////////////////////////////////
    /////////////////          Constructores          /////////////////
    ///////////////////////////////////////////////////////////////////
    

    public Labyrinth(int nRows, int nCols, int exitRow, int exitCol) {
        
        if (nRows>=1 && nCols>=1){
        
            this.nRows = nRows;
            this.nCols = nCols;
            this.exitRow = exitRow;
            this.exitCol = exitCol;



            this.monstersTable = new Monster [nRows] [nCols];
            this.playersTable = new Player [nRows] [nCols];
            this.charTable = new char [nRows] [nCols];
            
            for (int i=0; i<nRows; i++){
                for (int j=0; j<nCols; j++){
                    charTable[i][j]=EMPTY_CHAR;
                }
            }
            
            
            this.charTable[exitRow][exitCol]=EXIT_CHAR;
        }
    }
    
    ///////////////////////////////////////////////////////////////////
    /////////////////////          Get's          /////////////////////
    ///////////////////////////////////////////////////////////////////
    
    public static char getBLOCK_CHAR() {
        return BLOCK_CHAR;
    }

    public static char getEMPTY_CHAR() {
        return EMPTY_CHAR;
    }

    public static char getMONSTER_CHAR() {
        return MONSTER_CHAR;
    }

    public static char getCOMBAT_CHAR() {
        return COMBAT_CHAR;
    }

    public static char getEXIT_CHAR() {
        return EXIT_CHAR;
    }

    public static int getROW() {
        return ROW;
    }

    public static int getCOL() {
        return COL;
    }

    public int getnRows() {
        return nRows;
    }

    public int getnCols() {
        return nCols;
    }

    public int getExitRow() {
        return exitRow;
    }

    public int getExitCol() {
        return exitCol;
    }


    
    ///////////////////////////////////////////////////////////////////
    /////////////////////          Set's          /////////////////////
    ///////////////////////////////////////////////////////////////////
    

    public void setnRows(int nRows) {
        this.nRows = nRows;
    }

    public void setnCols(int nCols) {
        this.nCols = nCols;
    }

    public void setExitRow(int exitRow) {
        this.exitRow = exitRow;
    }

    public void setExitCol(int exitCol) {
        this.exitCol = exitCol;
    }


    
    ///////////////////////////////////////////////////////////////////
    ////////////////////          Metodos          ////////////////////
    ///////////////////////////////////////////////////////////////////



    public void spreadPlayers(ArrayList<Player> players){
        
        for (Player p : players){
            int [] pos = randomEmptyPos();
            putPlayer2D(-1, -1, pos[0], pos[1], p);
        }
        
    }
    
    public boolean haveAWinner(){
        boolean win=false;
        if (this.playersTable[this.exitRow][this.exitCol]!=null){
            win = true;
        }
        return win;
    }

    @Override
    public String toString() {
        String s="\n";
        for (char[] cs : this.charTable){
            s+="| ";
            for (char c : cs){
                s+=" "+c+"";
            }
            s+=" |\n";
        }
        return s;
    }

    public void addMonster(int row, int col, Monster monster){
        if (posOK(row, col)){
            if (this.charTable[row][col]==EMPTY_CHAR){
                this.monstersTable[row][col] = monster;
                this.charTable[row][col] = MONSTER_CHAR;
                
                monster.setCol(col);
                monster.setRow(col);
            }
        }
    }
    public Monster putPlayer(Directions direction, Player player){
        
        int oldRow = player.getRow();
        int oldCol = player.getCol();
        
        int [] newPos = dir2Pos(oldRow, oldCol, direction);
        
        Monster m = putPlayer2D(oldRow, oldCol, newPos[0], newPos[1], player);
        
        return m;
    }
    public void addBlock(Orientation orientation, int startRow, int startCol, int length){
        int incRow;
        int incCol;

        if(orientation==Orientation.VERTICAL){
            incRow=1;
            incCol=0;
        }else{
            incRow=0;
            incCol=1;
        }
        int row = startRow;
        int col = startCol;
        
        while((posOK(row,col)) && (emptyPos(row,col)) && (length >0)){
            set(row, col, BLOCK_CHAR);
            length-=1;
            row+=incRow;
            col+=incCol;
        }
        
    }
    private void set (int row, int col, char c){
        this.charTable[row][col] = c;
    }
    
    public ArrayList<Directions> validMoves(int row, int col) {
        ArrayList<Directions> output = new ArrayList<>();
        if (canStepOn(row+1, col)){
            output.add(Directions.DOWN);
        }
        if (canStepOn(row-1, col)){
            output.add(Directions.UP);
        }
        if (canStepOn(row, col+1)){
            output.add(Directions.RIGHT);
        }
        if (canStepOn(row, col-1)){
            output.add(Directions.LEFT);
        }
        
        return output;
    }
    private boolean posOK(int row, int col){
        boolean ok=false;
        if (row<this.nRows && col<this.nCols && row>=0 && col>=0 ){
            ok=true;
        }
        return ok;
    }
    
    private boolean emptyPos(int row, int col){
        boolean empty=false;
        if (posOK(row, col)){
            if(this.charTable[row][col]==EMPTY_CHAR){
                empty=true;
            }
        }
        return empty;
    }
    
    private boolean monsterPos(int row, int col){
        boolean m=false;
        if (posOK(row, col)){
            if(this.charTable[row][col]==MONSTER_CHAR){
                m=true;
            }
        }
        return m;
    }
    private boolean exitPos(int row, int col){
        boolean e=false;
        if (posOK(row, col)){
            if(this.charTable[row][col]==EXIT_CHAR){
                e=true;
            }
        }
        return e;
    }
    private boolean combatPos(int row, int col){
        boolean c=false;
        if (posOK(row, col)){
            if(this.charTable[row][col]==COMBAT_CHAR){
                c=true;
            }
        }
        return c;
    }
    
    private boolean canStepOn(int row, int col){
        boolean step=false;
        if (posOK(row, col)){
            if(this.charTable[row][col]==EMPTY_CHAR){
                step=true;
            }
            else if (this.charTable[row][col]==MONSTER_CHAR){
                step=true;
            }
            else if (this.charTable[row][col]==EXIT_CHAR){
                step=true;
            }
        }
        return step;
    }
    private void updateOldPos(int row, int col){
        if (this.posOK(row, col)){  
            if(this.combatPos(row, col)){
                this.charTable[row][col]=MONSTER_CHAR;
            }
            else{
                this.charTable[row][col]=EMPTY_CHAR;
            }
        }
    }
    private int[] dir2Pos(int row, int col, Directions direction){
        int r=row, c=col;
        if (posOK(row, col)){
            
            if (direction==Directions.DOWN){
                r++;
            }
            else if (direction==Directions.UP){
                r--;
            }
            else if (direction==Directions.LEFT){
                c--;
            }
            else if (direction==Directions.RIGHT){
                c++;
            }
            
        }
        int [] pos = new int[2];
        pos[0]=r;
        pos[1]=c;
        return pos;
    }
    private int[] randomEmptyPos(){
        boolean fin=false;
        int r=0, c=0;
        
        while (!fin){
            
            r=Dice.randomPos(nRows);
            c=Dice.randomPos(nCols);
            
            if (this.emptyPos(r, c)){
                fin=true;
            }
        }
        int [] pos = new int[2];
        pos[0]=r;
        pos[1]=c;
        return pos;
        
    }
    private Monster putPlayer2D(int oldRow, int oldCol, int row, int col, Player player){
        Monster output = null;
        if (canStepOn(row, col)){
            if (posOK(oldRow, oldCol)){
                Player p = this.playersTable [oldRow][oldCol];
                if (player == p){
                    updateOldPos(oldRow, oldCol);
                    this.playersTable[oldRow][oldCol]=null;
                    
                }
            }
            
            boolean monsterPos = monsterPos(row, col);
            if (monsterPos){
                this.charTable[row][col]=COMBAT_CHAR;
                output = this.monstersTable[row][col];
            }else{
                this.charTable[row][col] = player.getNumber();
            }

            this.playersTable [row][col] = player;
            player.setPos(row, col);
        }
        
        
        
        return output;
    }
 
}
