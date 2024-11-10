/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten.modelo;

/**
 *
 * @author fnand
 */
public class LabyrinthSquare {

    ///////////////////////////////////////////////////////////////////
    ///////////////////          Atributos          ///////////////////
    ///////////////////////////////////////////////////////////////////
    
    int row;
    int col;
    char content;
    
    
    ///////////////////////////////////////////////////////////////////
    /////////////////          Constructores          /////////////////
    ///////////////////////////////////////////////////////////////////
    
    public LabyrinthSquare(int row, int col, char content) {
        this.row = row;
        this.col = col;
        this.content = content;
    }
    
    ///////////////////////////////////////////////////////////////////
    /////////////////////          Get's          /////////////////////
    ///////////////////////////////////////////////////////////////////

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    public char getContent(){
        return content;
    }
    
    ///////////////////////////////////////////////////////////////////
    /////////////////////          Set's          /////////////////////
    ///////////////////////////////////////////////////////////////////
    
    public void setRow(int row) {
        this.row = row;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public void setContent (char content) {
        this.content = content;
    }
}
