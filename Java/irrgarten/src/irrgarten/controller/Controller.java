package irrgarten.controller;

import irrgarten.modelo.Directions;
import irrgarten.modelo.Directions;
import irrgarten.modelo.Game;
import irrgarten.modelo.Game;
import irrgarten.UI.TextUI;
import irrgarten.modelo.*;
import irrgarten.UI.GraphicalUI;

public class Controller {
    
    private Game game;
    private GraphicalUI view;
    
    public Controller(Game game, GraphicalUI view) {
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
