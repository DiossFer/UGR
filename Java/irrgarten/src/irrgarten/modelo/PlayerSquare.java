/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten.modelo;

/**
 *
 * @author fnand
 */
public class PlayerSquare {

    ///////////////////////////////////////////////////////////////////
    ///////////////////          Atributos          ///////////////////
    ///////////////////////////////////////////////////////////////////
    
    private int row;
    private int col;
    private Player player;
    
    ///////////////////////////////////////////////////////////////////
    /////////////////          Constructores          /////////////////
    ///////////////////////////////////////////////////////////////////
    
    public PlayerSquare(int row, int col) {
        this.row = row;
        this.col = col;
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
    
    public Player getPlayer() {
        return player;
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

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    
}
