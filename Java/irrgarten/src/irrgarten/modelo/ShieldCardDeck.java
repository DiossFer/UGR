/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten.modelo;

/**
 *
 * @author fnand
 */
public class ShieldCardDeck extends CardDeck<CombatElement>{

    public ShieldCardDeck() {
        super();
    }
    
    @Override
    public void addCards (){
        Shield wAux = null;
        for (int i=0; i<10; i++){
            wAux = new Shield(Dice.shieldPower(), Dice.usesLeft());
            this.addCard(wAux);
        }
    }
    
}

