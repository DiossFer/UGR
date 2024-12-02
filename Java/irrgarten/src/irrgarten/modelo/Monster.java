/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten.modelo;

/**
 *
 * @author fnand
 */
public class Monster extends LabyrinthCharacter{
    
    ///////////////////////////////////////////////////////////////////
    ////////////////////          Metodos          ////////////////////
    ///////////////////////////////////////////////////////////////////
    private static final int INITIAL_HEALTH = 5;

    
    ///////////////////////////////////////////////////////////////////
    /////////////////          Constructores          /////////////////
    ///////////////////////////////////////////////////////////////////
    public Monster(String name, float intelligence, float strength) {
        super(name, intelligence, strength, INITIAL_HEALTH);
    }
    
    ///////////////////////////////////////////////////////////////////
    ////////////////////           Get's           ////////////////////
    ///////////////////////////////////////////////////////////////////

    
    ///////////////////////////////////////////////////////////////////
    ////////////////////           Set's           ////////////////////
    ///////////////////////////////////////////////////////////////////

    
    
    ///////////////////////////////////////////////////////////////////
    ////////////////////          Metodos          ////////////////////
    ///////////////////////////////////////////////////////////////////
    
    
    @Override
    public float attack(){
        float att = 0.0f;
        att = Dice.intensity(getStrength());
        return att;
    }
    
    @Override
    public boolean defend(float receivedAttack){
        boolean isDead = dead();
        if (!isDead){
            float defensiveEnergy = Dice.intensity(getIntelligence());
            if (defensiveEnergy<receivedAttack){
                gotWounded();
                isDead = dead();
            }
        }
        return isDead;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    

    
    
   
}
