/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten.modelo;

/**
 *
 * @author fnand
 */
public class MonsterSquare {
    
    ///////////////////////////////////////////////////////////////////
    ///////////////////          Atributos          ///////////////////
    ///////////////////////////////////////////////////////////////////
    
    private int row;
    private int col;
    private Monster monster;
    
    ///////////////////////////////////////////////////////////////////
    /////////////////          Constructores          /////////////////
    ///////////////////////////////////////////////////////////////////
    
    public MonsterSquare(int row, int col) {
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
    
    public Monster getMonster() {
        return monster;
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


    public void setMonster(Monster monster) {
        this.monster = monster;
    }
    
    
    
}
