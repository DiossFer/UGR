/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

import irrgarten.modelo.Game;
import irrgarten.UI.TextUI;
import irrgarten.controller.Controller;

/**
 *
 * @author fnand
 */
public class Main {
    
    public static void main(String[] args) {
        Controller c = new Controller(new Game(2), new TextUI());
        c.play();
    }
    
}

