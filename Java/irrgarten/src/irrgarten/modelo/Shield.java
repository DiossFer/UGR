/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten.modelo;

/**
 *
 * @author fnand
 */
public class Shield extends CombatElement{
    
    ///////////////////////////////////////////////////////////////////
    ///////////////////          Atributos          ///////////////////
    ///////////////////////////////////////////////////////////////////
    
    
    ///////////////////////////////////////////////////////////////////
    /////////////////          Constructores          /////////////////
    ///////////////////////////////////////////////////////////////////
    
    
    public Shield(float protection, int uses) {
        super(protection, uses);
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
    
    public float protect (){
        return produceEffect();
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
    
}
