/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten.modelo;

/**
 *
 * @author fnand
 */
public class Weapon extends CombatElement{
    
    ///////////////////////////////////////////////////////////////////
    ///////////////////          Atributos          ///////////////////
    ///////////////////////////////////////////////////////////////////
    
    
    
    ///////////////////////////////////////////////////////////////////
    /////////////////          Constructores          /////////////////
    ///////////////////////////////////////////////////////////////////
    
    
    
    public Weapon(float power, int uses) {
        super(power, uses);
    }

    ///////////////////////////////////////////////////////////////////
    //////////////////             Get's             //////////////////
    ///////////////////////////////////////////////////////////////////
    
    
    
    ///////////////////////////////////////////////////////////////////
    //////////////////             Set's             //////////////////
    ///////////////////////////////////////////////////////////////////
    
    
    
    ///////////////////////////////////////////////////////////////////
    //////////////////            Metodos            //////////////////
    ///////////////////////////////////////////////////////////////////
    
    public float attack (){
        return produceEffect();
    }

    
    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
}
