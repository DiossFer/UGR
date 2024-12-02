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
public class Game {
    
    
    ///////////////////////////////////////////////////////////////////
    ///////////////////          Atributos          ///////////////////
    ///////////////////////////////////////////////////////////////////
    
    static final int MAX_ROUNDS = 10;
    int currentPlayerlndex;
    String log;
    Player currentPlayer;
    ArrayList<Player> players;
    Labyrinth labyrinth;
    ArrayList<Monster> monsters;
    
    ///////////////////////////////////////////////////////////////////
    /////////////////          Constructores          /////////////////
    ///////////////////////////////////////////////////////////////////
    
    public Game(int nplayers) {
        
        this.players = new ArrayList<>();
        for (int i=0; i<nplayers; i++){
            Player p = new Player(Integer.toString(i).charAt(0), Dice.randomIntelligence(), Dice.randomStrength());
            players.add(p);
        }
        this.currentPlayerlndex = Dice.whoStarts(nplayers);
        this.currentPlayer = players.get(currentPlayerlndex);
        this.monsters = new ArrayList<>();
        int auxCol=5, auxRow = 5;
        this.labyrinth = new Labyrinth (auxRow, auxCol, Dice.randomPos(auxCol), Dice.randomPos(auxRow));
        this.configureLabyrinth();
        this.labyrinth.spreadPlayers(this.players);
        this.log = "";

        
    }
    
    ///////////////////////////////////////////////////////////////////
    //////////////////             Get's             //////////////////
    ///////////////////////////////////////////////////////////////////
    
    public static int getMAX_ROUNDS() {
        return MAX_ROUNDS;
    }

    public int getCurrentPlayerlndex() {
        return currentPlayerlndex;
    }

    public String getLog() {
        return log;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Labyrinth getLabyrinth() {
        return labyrinth;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }
    
    ///////////////////////////////////////////////////////////////////
    //////////////////             Set's             //////////////////
    ///////////////////////////////////////////////////////////////////
    
    public void setCurrentPlayerlndex(int currentPlayerlndex) {
        this.currentPlayerlndex = currentPlayerlndex;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setLabyrinth(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }
    
    ///////////////////////////////////////////////////////////////////
    //////////////////            Metodos            //////////////////
    ///////////////////////////////////////////////////////////////////
    
    
    public boolean finished(){
        return labyrinth.haveAWinner();
    }
    public boolean nextStep(Directions preferredDirection){
        log="";
        boolean dead = currentPlayer.dead();
        if (!dead){
            
            Directions direction = actualDirection(preferredDirection);
            
            if (direction!=preferredDirection){
                logPlayerNoOrders();
            }

            Monster monster = labyrinth.putPlayer(direction, currentPlayer);

            if (monster==null){
                logNoMonster();
            }
            else{
                GameCharacter winner = combat(monster);
                manageReward(winner);
            }
            
        }else{
            manageResurrection();
        }
        boolean endGame = finished();

        if (!endGame){
            nextPlayer();
        }
        
        return endGame;
    }
    public GameState getGameState(){
                
        String auxLabyrint = this.getLabyrinth().toString(); 
        
        String auxPlayers = "";
        
        for (int i = 0; i<this.getPlayers().size(); i++){
            auxPlayers+="  "+this.getPlayers().get(i).toString()+"\n";
        }
        
        String auxMonsters = "";
        for (int i = 0; i<this.getMonsters().size(); i++){
            auxMonsters+="  "+this.getMonsters().get(i).toString()+"\n";
        }
        
        int auxCurrentPlayer = this.getCurrentPlayerlndex();
        
        Boolean auxWinner = this.finished();
        
        String auxLog = this.getLog();

        GameState gs = new GameState(auxLabyrint, auxPlayers, auxMonsters, auxCurrentPlayer, auxWinner, auxLog);

        return gs;
    } 
    private void configureLabyrinth(){
        
        
        for (int i=0; i<4; i++){
            Monster mAux = new Monster("Monster#"+i, Dice.randomIntelligence(), Dice.randomStrength());
            this.monsters.add(mAux);
        }

        this.labyrinth.addMonster(2, 0, this.monsters.get(0));
        this.labyrinth.addMonster(2, 2, this.monsters.get(1));
        this.labyrinth.addMonster(3, 4, this.monsters.get(2));
        this.labyrinth.addMonster(4, 2, this.monsters.get(3));
        
        
        this.labyrinth.addBlock(Orientation.VERTICAL, 0, 2, 2);
        this.labyrinth.addBlock(Orientation.HORIZONTAL, 0, 3, 1);
        this.labyrinth.addBlock(Orientation.HORIZONTAL, 3, 0, 1);

    }   
    private void nextPlayer(){

        if (currentPlayerlndex==players.size()-1){
            currentPlayerlndex=0;
        }else{
            currentPlayerlndex++;
        }
        currentPlayer = players.get(currentPlayerlndex);
    }
    private Directions actualDirection(Directions preferredDirection){
        
        int currentRow = this.currentPlayer.getRow();
        int currentCol = this.currentPlayer.getCol();
        
        ArrayList<Directions> validMoves = labyrinth.validMoves(currentRow, currentCol);
        Directions output = currentPlayer.move(preferredDirection, validMoves);
        
        
        return output;
    }
    private GameCharacter combat(Monster monster){
        int rounds = 0;
        float monsterAttack = 0.0f;
        GameCharacter winner = GameCharacter.PLAYER;
        float playerAttack = currentPlayer.attack();
        boolean lose = monster.defend(playerAttack);
        
        while ((!lose) && (rounds<MAX_ROUNDS)){
            winner=GameCharacter.MONSTER;
            rounds++;
            monsterAttack = monster.attack();
            lose = currentPlayer.defend(monsterAttack);
            if (!lose){
                playerAttack = currentPlayer.attack();
                winner = GameCharacter.PLAYER;
                lose=monster.defend(playerAttack);
            }
        }
        logRounds(rounds, MAX_ROUNDS);
        return winner;
    }
    
    private void manageReward(GameCharacter winner){
        if (winner==GameCharacter.PLAYER){
            currentPlayer.receiveReward();
            logPlayerWon();
        }
        else{
            logMonsterWon();
        }
    }
    
    private void manageResurrection(){
        boolean resurrect = Dice.resurrectPlayer();
        if (resurrect){
            currentPlayer.resurrect();
            
            currentPlayer=new FuzzyPlayer(currentPlayer);
            players.set(currentPlayerlndex, currentPlayer);
            
            logResurrected();
            
        }else{
            logPlayerSkipTurn();
        }
    }
    
    private void logPlayerWon(){
        this.setLog(this.getLog()+"El jugador "+this.getCurrentPlayer()+"ha ganado el combate"+"\n");
    }
    private void logMonsterWon(){
        this.setLog(this.getLog()+"El monstruo ha ganado el combate"+"\n");
    }
    private void logResurrected(){
        this.setLog(this.getLog()+"El jugador "+this.getCurrentPlayer()+"ha ganado resucitado"+"\n");
    }
    private void logPlayerSkipTurn(){
        this.setLog(this.getLog()+"El jugador "+this.getCurrentPlayer()+"ha perdido el turno por estar muerto"+"\n");
    }
    private void logPlayerNoOrders(){
        this.setLog(this.getLog()+"El jugador "+this.getCurrentPlayer()+"no pudo cumplir con las indicaciones"+"\n");
    }
    private void logNoMonster(){
        this.setLog(this.getLog()+"El jugador "+this.getCurrentPlayer()+"ha entrado a una casilla vacia"+"\n");
    }
    private void logRounds(int rounds, int max){
        this.setLog(this.getLog()+"Se ha producido "+rounds+" de "+max+" rondas de combate"+"\n");
    }

}
