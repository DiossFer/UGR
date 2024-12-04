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
abstract class CardDeck <T extends CombatElement>{
    
    private ArrayList<T> cardDeck;
    
    public CardDeck(){
        cardDeck = new ArrayList<>();
        this.addCards();
    }
    
    abstract void addCards();
    
    protected void addCard(T card){
        this.cardDeck.add(card);
    } 
    public T nextCard(){
        T aux = null;
        if (cardDeck.size()==0){
            addCards();
        }
        aux = this.cardDeck.get(0);
        this.cardDeck.remove(aux);
        return aux;
    }
    
}
