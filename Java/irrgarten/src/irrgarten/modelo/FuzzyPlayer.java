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
public class FuzzyPlayer extends Player{

    public FuzzyPlayer(Player p) {
        super(p);
    }
    
    
    @Override
    public Directions move (Directions direction, ArrayList<Directions> validMoves){
        int size = validMoves.size();
        boolean contained = validMoves.contains(direction);
        if (size>0 && (!contained)){
            Directions firstElement = validMoves.get(0);
            return firstElement;
        }
        else{
            return Dice.nextStep(direction, validMoves, getIntelligence());
        }
    }
    
    @Override
    public float attack (){
        float damage = sumWeapons();
        damage+=Dice.intensity(this.getStrength());
        return damage;
    }

    @Override
    protected float defensiveEnergy (){
        float defense=0.0f;
        defense += sumShields();
        defense+=Dice.intensity(this.getIntelligence());
        return defense;
    }
    
    @Override
    public String toString() {
        return "Fuzzy"+super.toString();
    }
    
}
