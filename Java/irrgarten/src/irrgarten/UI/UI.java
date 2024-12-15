
package irrgarten.UI;

import irrgarten.modelo.Directions;
import irrgarten.modelo.GameState;

public interface UI {
    
    public Directions nextMove(); 
    public void showGame(GameState gameState);
    
}
