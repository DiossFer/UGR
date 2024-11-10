/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten.modelo;

/**
 *
 * @author fnand
 */
public class Shield {
    
    ///////////////////////////////////////////////////////////////////
    ///////////////////          Atributos          ///////////////////
    ///////////////////////////////////////////////////////////////////
    
    private float protection;
    
    private int uses;
    
    ///////////////////////////////////////////////////////////////////
    /////////////////          Constructores          /////////////////
    ///////////////////////////////////////////////////////////////////
    
    public Shield() {
        this.setProtection(0.0f);
        this.setUses(0);
    }
    
    public Shield(float protection, int uses) {
        this.setProtection(protection);
        this.setUses(uses);
    }

    ///////////////////////////////////////////////////////////////////
    //////////////////             Get's             //////////////////
    ///////////////////////////////////////////////////////////////////
    
    public float getProtection() {
        return protection;
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
    
    public void setProtection(float protection) {
        this.protection = protection;
    }
    
    
    ///////////////////////////////////////////////////////////////////
    //////////////////            Metodos            //////////////////
    ///////////////////////////////////////////////////////////////////
    
    public float protect (){
        float defense = 0.0f;
        
        if (this.getUses()>0){
            this.setUses(this.getUses()-1);
            defense = this.getProtection();
            
        }
        return defense;
    }

    public Boolean discard(){
        Boolean disc = false;
        disc = Dice.discardElement(this.getUses());
        return disc;
    }
    
    @Override
    public String toString() {
        return "S["+this.getProtection()+", "+this.getUses()+"]";
    }
    
    
}
