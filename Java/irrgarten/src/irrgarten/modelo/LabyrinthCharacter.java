package irrgarten.modelo;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fnand
 */
abstract class LabyrinthCharacter {
    private String name;
    private float intelligence;
    private float strength;
    private float health;
    private int row;
    private int col;
    
    public LabyrinthCharacter(String name, float intelligence, float strength, float health){
        this.intelligence = intelligence;
        this.strength = strength;
        this.health = health;
        this.name = name;
        this.row = 0;
        this.col = 0;

    }
    public LabyrinthCharacter(LabyrinthCharacter other){
        this.intelligence = other.intelligence;
        this.strength = other.strength;
        this.health = other.health;
        this.name = other.name;
        this.row = other.row;
        this.col = other.col;
    }
    
    

    public boolean dead(){
        boolean dead=false;
        if (this.getHealth()<=0){
            dead=true;
        }
        return dead;
    }
    


    public void setPos(int row, int col) {
        this.setCol(col);
        this.setRow(row);
    }
    

    protected void gotWounded(){
        this.setHealth(this.getHealth()-1.0f);
    }

    abstract float attack();
    
    abstract boolean defend(float attack);
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected float getIntelligence() {
        return intelligence;
    }
    public void setStrength(float strength){
        this.strength = strength;
    }
    public void setIntelligence(float intelligence) {
        this.intelligence = intelligence;
    }

    protected float getStrength() {
        return strength;
    }

    

    protected float getHealth() {
        return health;
    }

    protected void setHealth(float health) {
        this.health = health;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return "LabyrinthCharacter{" + "name=" + name + ", intelligence=" + intelligence + ", strength=" + strength + ", health=" + health + ", row=" + row + ", col=" + col + '}';
    }
    
    
}
