package irrgarten.modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fnand
 */
abstract class CombatElement {
    public float power;
    
    public int uses;

    public CombatElement(float power, int uses) {
        this.power = power;
        this.uses = uses;
    }
    
    protected float produceEffect (){
        float efecto = 0.0f;
        
        if (uses>0){
            uses-=1;
            efecto = power;
            
        }
        return efecto;
    }
    public Boolean discard(){
        Boolean disc = false;
        disc = Dice.discardElement(uses);
        return disc;
    }

    @Override
    public String toString() {
        return "CombatElement{" + "power=" + power + ", uses=" + uses + '}';
    }
    
}
