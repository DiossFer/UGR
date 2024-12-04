/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten.modelo;

/**
 *
 * @author fnand
 */
public class WeaponCardDeck extends CardDeck<CombatElement>{

    public WeaponCardDeck() {
        super();
    }
    
    @Override
    public void addCards (){
        Weapon wAux = null;
        for (int i=0; i<10; i++){
            wAux = new Weapon(Dice.weaponPower(), Dice.usesLeft());
            this.addCard(wAux);
        }
    }
    
}

