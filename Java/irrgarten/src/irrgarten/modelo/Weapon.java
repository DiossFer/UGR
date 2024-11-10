/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten.modelo;

/**
 *
 * @author fnand
 */
public class Weapon {
    
    ///////////////////////////////////////////////////////////////////
    ///////////////////          Atributos          ///////////////////
    ///////////////////////////////////////////////////////////////////
    
    private float power;
    
    private int uses;
    
    ///////////////////////////////////////////////////////////////////
    /////////////////          Constructores          /////////////////
    ///////////////////////////////////////////////////////////////////
    
    public Weapon() {
        this.setPower(0.0f);
        this.setUses(0);
    }
    
    public Weapon(float power, int uses) {
        this.setPower(power);
        this.setUses(uses);
    }

    ///////////////////////////////////////////////////////////////////
    //////////////////             Get's             //////////////////
    ///////////////////////////////////////////////////////////////////
    
    public float getPower() {
        return power;
    }

    public int getUses() {
        return uses;
    }
    
    ///////////////////////////////////////////////////////////////////
    //////////////////             Set's             //////////////////
    ///////////////////////////////////////////////////////////////////
    
    public void setUses(int uses) {
        this.uses = uses;
    }
    
    public void setPower(float power) {
        this.power = power;
    }
    
    
    ///////////////////////////////////////////////////////////////////
    //////////////////            Metodos            //////////////////
    ///////////////////////////////////////////////////////////////////
    
    public float attack (){
        float damage = 0.0f;
        
        if (this.getUses()>0){
            this.setUses(this.getUses()-1);
            damage = this.getPower();
            
        }
        return damage;
    }

    public Boolean discard(){
        Boolean disc = false;
        disc = Dice.discardElement(this.getUses());
        return disc;
    }
    
    @Override
    public String toString() {
        return "W["+this.getPower()+", "+this.getUses()+"]";
    }
    
    
}
