package irrgarten.controller;

import irrgarten.modelo.Directions;
import irrgarten.modelo.Directions;
import irrgarten.modelo.Game;
import irrgarten.modelo.Game;
import irrgarten.UI.TextUI;
import irrgarten.modelo.*;


public class Controller {
    
    private Game game;
    private TextUI view;
    
    public Controller(Game game, TextUI view) {
        this.game = game;
        this.view = view;
    }
    
    public void play() {
        boolean endOfGame = false;
        while (!endOfGame) {
            view.showGame(game.getGameState()); 
            Directions direction = view.nextMove(); 
            endOfGame = game.nextStep(direction);
        }
      view.showGame(game.getGameState());        
    }
    
}
