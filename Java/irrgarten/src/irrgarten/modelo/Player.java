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
public class Player extends LabyrinthCharacter{
    
    ///////////////////////////////////////////////////////////////////
    ///////////////////          Atributos          ///////////////////
    ///////////////////////////////////////////////////////////////////
    
    private static final int MAX_WEAPONS = 2;
    private static final int MAX_SHIELDS = 3;
    private static final int INITIAL_HEALTH = 10;
    private static final int HITS2LOSE = 3;
    private char number;
    private int consecutiveHits;
    private ArrayList<Weapon> weapons;
    private ArrayList<Shield> shields;
    
    private WeaponCardDeck weaponCardDeck;
    private ShieldCardDeck shieldCardDeck;

    ///////////////////////////////////////////////////////////////////
    /////////////////          Constructores          /////////////////
    ///////////////////////////////////////////////////////////////////
    

    public Player(char number, float intelligence, float strengtg) {
        super("Player #"+number, intelligence, strengtg, INITIAL_HEALTH);
        this.number = number;
        this.consecutiveHits = 0;
        this.weapons = new ArrayList<>();
        this.shields = new ArrayList<>();
        this.weaponCardDeck = new WeaponCardDeck();
        this.shieldCardDeck = new ShieldCardDeck();
    }
    public Player(Player p) {
        super(p);
        this.number = p.number;
        this.consecutiveHits = p.consecutiveHits;
        this.weapons = p.weapons;
        this.shields = p.shields;
        this.shieldCardDeck = p.shieldCardDeck;
        this.weaponCardDeck = p.weaponCardDeck;
    }

    
    ///////////////////////////////////////////////////////////////////
    /////////////////////          Get's          /////////////////////
    ///////////////////////////////////////////////////////////////////


    public static int getMAX_WEAPONS() {
        return MAX_WEAPONS;
    }

    public static int getMAX_SHIELDS() {
        return MAX_SHIELDS;
    }

    public static int getINITIAL_HEALTH() {
        return INITIAL_HEALTH;
    }

    public static int getHITS2LOSE() {
        return HITS2LOSE;
    }

    

    public char getNumber() {
        return number;
    }


    public int getConsecutiveHits() {
        return consecutiveHits;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public ArrayList<Shield> getShields() {
        return shields;
    }
    
    ///////////////////////////////////////////////////////////////////
    /////////////////////          Set's          /////////////////////
    ///////////////////////////////////////////////////////////////////


    public void setNumber(char number) {
        this.number = number;
    }


    public void setConsecutiveHits(int consecutiveHits) {
        this.consecutiveHits = consecutiveHits;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public void setShields(ArrayList<Shield> shields) {
        this.shields = shields;
    }

    ///////////////////////////////////////////////////////////////////
    ////////////////////          Metodos          ////////////////////
    ///////////////////////////////////////////////////////////////////
    
    
    public void resurrect (){
        this.resetHits();
        this.getWeapons().clear();
        this.getShields().clear();
        this.setHealth(INITIAL_HEALTH);

        
    }
    
    public Directions move (Directions direction, ArrayList<Directions> validMoves){
        int size = validMoves.size();
        boolean contained = validMoves.contains(direction);
        if (size>0 && (!contained)){
            Directions firstElement = validMoves.get(0);
            return firstElement;
        }
        else{
            return direction;
        }
    }
    
    @Override
    public float attack (){
        float damage = sumWeapons();
        damage+=this.getStrength();
        return damage;
    }
    
    @Override
    public boolean defend(float receivedAttack){
        boolean lose = manageHit(receivedAttack);
        return lose;
    }
    
    public void receiveReward(){
        int wReward = Dice.weaponsReward();
        int sReward = Dice.shieldsReward();
        for (int i=1; i<=wReward; i++){
            Weapon wNew = (Weapon) weaponCardDeck.nextCard();
            receiveWeapon(wNew);
        }
        for (int i=1; i<=sReward; i++){
            Shield sNew = (Shield) shieldCardDeck.nextCard();
            receiveShield(sNew);
        }
    }
    
    
    public void receiveWeapon(Weapon w){
        for (int i=this.getWeapons().size()-1; i>0; i--){
            boolean discard = this.getWeapons().get(i).discard();
            if (discard){
                this.getWeapons().remove(this.getWeapons().get(i));
            }   
        }
        int size = this.getWeapons().size();
        if (size<MAX_WEAPONS){
            this.getWeapons().add(w);
        }
        
    }
    
    public void receiveShield(Shield s){
        for (int i=this.getShields().size()-1; i>0; i--){
            
            boolean discard = this.getShields().get(i).discard();
            if (discard){
                this.getShields().remove(this.getShields().get(i));
            }   
        }
        int size = this.getShields().size();
        if (size<MAX_WEAPONS){
            this.getShields().add(s);
        }
    }
    
    public Weapon newWeapon(float power, int uses){
        Weapon w = new Weapon(power, uses);
        return w;
    }
    
    public Shield newShield(float protection, int uses){
        Shield s = new Shield(protection, uses);
        return s;
    }
    
    protected float sumWeapons(){
        float damage=0.0f;
        for (Weapon w : this.getWeapons()){
            damage+=w.attack();
        }
        return damage;
        
    }
    
    protected float sumShields(){
        float resistence=0.0f;
        for (Shield s : this.getShields()){
            resistence+=s.protect();
        }
        return resistence;
    }
    
    protected float defensiveEnergy(){
        float defense=0.0f;
        defense += sumShields();
        defense += this.getIntelligence();
        return defense;
    }
    
    public boolean manageHit(float receivedAttack){
        float defense = defensiveEnergy();
        boolean lose;
        
        if (defense<receivedAttack){
            this.gotWounded();
            this.incConsecutiveHits();
        }
        else{
            this.resetHits();
        }
        if ((consecutiveHits==HITS2LOSE)||dead()){
            this.resetHits();
            lose=true;
        }
        else{
            lose=false;
        }
        return lose;
    }
    
    public void resetHits(){
        this.setConsecutiveHits(0);
    }
    
    
    
    public void incConsecutiveHits(){
        this.setConsecutiveHits(this.getConsecutiveHits()+1);
    }
    

    @Override
    public String toString() {
        return super.toString() + "Player{ consecutiveHits=" + consecutiveHits + ", weapons=" + weapons + ", shields=" + shields + '}';
    }
    
}
