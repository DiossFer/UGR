/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten.modelo;

/**
 *
 * @author fnand
 */
public class GameState {
    
    
    ///////////////////////////////////////////////////////////////////
    ///////////////////          Atributos          ///////////////////
    ///////////////////////////////////////////////////////////////////
    
    private String labyrinth;
    private String players;
    private String monsters;
    private int currentPlayer;
    private Boolean winner;
    private String log;
    
    ///////////////////////////////////////////////////////////////////
    /////////////////          Constructores          /////////////////
    ///////////////////////////////////////////////////////////////////
    
    public GameState() {
        
    }

    public GameState(String labyrinth, String players, String monsters, int currentPlayer, Boolean winner, String log) {
        this.setLabyrinth(labyrinth);
        this.setPlayers(players);
        this.setMonsters(monsters);
        this.setCurrentPlayer(currentPlayer);
        this.setWinner(winner);
        this.setLog(log);
    }
    
    

    ///////////////////////////////////////////////////////////////////
    //////////////////             Get's             //////////////////
    ///////////////////////////////////////////////////////////////////
    public String getLabyrinth() {    
        return labyrinth;
    }

    public String getPlayers() {
        return players;
    }

    public String getMonsters() {
        return monsters;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public Boolean getWinner() {
        return winner;
    }
    
    public String getLog() {
        return log;
    }

    ///////////////////////////////////////////////////////////////////
    //////////////////             Set's             //////////////////
    ///////////////////////////////////////////////////////////////////

    public void setLabyrinth(String labyrinth) {
        this.labyrinth = labyrinth;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    public void setMonsters(String monsters) {
        this.monsters = monsters;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }

    public void setLog(String log) {
        this.log = log;
    }
    
    
    
    ///////////////////////////////////////////////////////////////////
    //////////////////            Metodos            //////////////////
    ///////////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        String salida="     Game State: \n";
        salida+= "Labyrinth: "+"\n";
        salida+= this.getLabyrinth()+"\n";
        salida+= "Players: "+"\n";
        salida+= this.getPlayers()+"\n";
        salida+= "Monsters: "+"\n";
        salida+= this.getMonsters()+"\n";
        salida+= "Current Player: " + "Player #"+this.getCurrentPlayer()+ ", ";
        if (this.getWinner()){
            salida+="ganador.";
        }else{
            salida+="en juego";
        }
        salida+="\n Log: "+this.getLog()+"\n";
        
        return salida;
    }
    
    

    
    
}
