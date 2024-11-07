/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten.modelo;

/**
 *
 * @author fnand
 */
public class Monster {
    
    ///////////////////////////////////////////////////////////////////
    ////////////////////          Metodos          ////////////////////
    ///////////////////////////////////////////////////////////////////
    private final int INITIAL_HEALTH = 5;
    private String name;
    private float intelligence;
    private float strength;
    private float health;
    private int row;
    private int col;

    
    ///////////////////////////////////////////////////////////////////
    /////////////////          Constructores          /////////////////
    ///////////////////////////////////////////////////////////////////
    public Monster(String name, float intelligence, float strength) {
        this.name = name;
        this.intelligence = intelligence;
        this.strength = strength;
        
        this.health = INITIAL_HEALTH;
        this.row = 0;
        this.col = 0;
        
    }
    
    ///////////////////////////////////////////////////////////////////
    ////////////////////           Get's           ////////////////////
    ///////////////////////////////////////////////////////////////////

    public int getINITIAL_HEALTH() {
        return INITIAL_HEALTH;
    }

    public String getName() {
        return name;
    }

    public float getIntelligence() {
        return intelligence;
    }

    public float getStrength() {
        return strength;
    }

    public float getHealth() {
        return health;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    ///////////////////////////////////////////////////////////////////
    ////////////////////           Set's           ////////////////////
    ///////////////////////////////////////////////////////////////////

    public void setName(String name) {
        this.name = name;
    }

    public void setIntelligence(float intelligence) {
        this.intelligence = intelligence;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
    
    ///////////////////////////////////////////////////////////////////
    ////////////////////          Metodos          ////////////////////
    ///////////////////////////////////////////////////////////////////
    
    public boolean dead(){
        boolean dead=false;
        if (this.getHealth()<=0){
            dead=true;
        }
        return dead;
    }
    
    public float attack(){
        float att = 0.0f;
        att = Dice.intensity(strength);
        return att;
    }
    
    public boolean defend(float receivedAttack){
        boolean isDead = dead();
        if (!isDead){
            float defensiveEnergy = Dice.intensity(intelligence);
            if (defensiveEnergy<receivedAttack){
                gotWounded();
                isDead = dead();
            }
        }
        return isDead;
    }
    
    public void setPos(int row, int col){
        this.setCol(col);
        this.setRow(row);
    }
    
    private void gotWounded(){
        this.setHealth(this.getHealth()-1);
    }

    @Override
    public String toString() {
        return "Monster{" + "INITIAL_HEALTH=" + INITIAL_HEALTH + ", name=" + name + ", intelligence=" + intelligence + ", strength=" + strength + ", health=" + health + ", row=" + row + ", col=" + col + '}';
    }


    
    
   
}
