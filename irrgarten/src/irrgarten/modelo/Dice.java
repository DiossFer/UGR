/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten.modelo;

import java.util.Random;

/**
 *
 * @author fnand
 */
public class Dice {
    
    ///////////////////////////////////////////////////////////////////
    ///////////////////          Atributos          ///////////////////
    ///////////////////////////////////////////////////////////////////
    
    static private final int MAX_USES = 5;               //(número máximo de usos de armas y escudos)
    static private final float MAX_INTELLIGENCE = 10.0f; //(valor máximo para la inteligencia de jugadores y monstruos)
    static private final float MAX_STRENGTH = 10.0f;     //(valor máximo para la fuerza de jugadores y monstruos)
    static private final float RESURRECT_PROB = 0.3f;    //(probabilidad de que un jugador sea resucitado en cada turno)
    static private final int WEAPONS_REWARD = 2;         //(numero máximo de armas recibidas al ganar un combate)
    static private final int SHIELDS_REWARD = 3;         //(numero máximo de escudos recibidos al ganar un combate)
    static private final int HEALTH_REWARD = 5;          //(numero máximo de unidades de salud recibidas al ganar un combate)
    static private final int MAX_ATTACK = 3;             //(máxima potencia de las armas)
    static private final int MAX_SHIELD = 2;             //(máxima potencia de los escudos)
    static private Random generator = new Random();
    
    ///////////////////////////////////////////////////////////////////
    /////////////////          Constructores          /////////////////
    ///////////////////////////////////////////////////////////////////
    
    

    ///////////////////////////////////////////////////////////////////
    //////////////////             Get's             //////////////////
    ///////////////////////////////////////////////////////////////////
    
    
    
    ///////////////////////////////////////////////////////////////////
    //////////////////             Set's             //////////////////
    ///////////////////////////////////////////////////////////////////
    
    
    
    
    ///////////////////////////////////////////////////////////////////
    //////////////////            Metodos            //////////////////
    ///////////////////////////////////////////////////////////////////
    
    public static int randomPos(int max){ // devuelve un número de fila o columna aleatoria siendo el valor del parámetro el número de filas o columnas del tablero. La fila y la columna de menor valor tienen como índice el número cero.
        int pos = 0;
        pos = generator.nextInt(0, max);
        return pos; 
    }
    public static int whoStarts(int nplayers){     //devuelve el índice del jugador que comenzará la partida. El parámetro representa el número de jugadores en la partida. Los jugadores se numeran comenzando con el número 0.
        int player = 0;
       
        player = generator.nextInt(0, nplayers);
        
        return player; 
    }

    public static float randomIntelligence(){ //devuelve un valor aleatorio de inteligencia del intervalo [0, MAX_INTELLIGENCE[
        float intelligence = 0.0f;
       
        intelligence = generator.nextFloat((float)MAX_INTELLIGENCE);
        
        return intelligence;  
    }
    
    public static float randomStrength(){ // devuelve una valor aleatorio de fuerza del intervalo [0,MAX_STRENGTH[
        float strenghth = 0.0f;
       
        strenghth = generator.nextFloat((float)MAX_STRENGTH);
        
        return strenghth;         
    }
    
    public static Boolean resurrectPlayer(){// indica si un jugador muerto debe ser resucitado o no.
        Boolean resurrect = false;
        
        float prob = 0.0f;
        prob = generator.nextFloat();
        
        if (prob<=RESURRECT_PROB){
            resurrect = true;
        }
        
        return resurrect;
    }

    public static int weaponsReward(){// indica la cantidad de armas que recibirá el jugador por ganar el combate.Será un número aleatorio desde 0 (inclusive) que nunca debe superar el máximo indicado en ladefinición de los atributos de clase. Es decir, el número aleatorio debe estar en el intervalo cerrado[0,WEAPONS_REWARD].
        int reward = 0;
       
        reward = generator.nextInt(0, WEAPONS_REWARD+1);
        
        return reward; 
    }
    
    public static int shieldsReward(){ //indica la cantidad de escudos que recibirá el jugador por ganar el combate.Será un número aleatorio desde 0 (inclusive) que nunca debe superar el máximo indicado en ladefinición de los atributos de clase.
        int reward = 0;
       
        reward = generator.nextInt(0, SHIELDS_REWARD+1);
        
        return reward; 
    }
    
    public static int healthReward(){ // indica la cantidad de unidades de salud que recibirá el jugador por ganar elcombate. Será un número aleatorio desde 0 (inclusive) que nunca debe superar el máximo indicadoen la definición de los atributos de clase.
        int reward = 0;
       
        reward = generator.nextInt(0, HEALTH_REWARD+1);
        
        return reward; 
    }
    public static float weaponPower(){ //devuelve un valor aleatorio en el intervalo [0, MAX_ATTACK[
        float attack = 0.0f;
       
        attack = generator.nextFloat((float)MAX_ATTACK);
        
        return attack; 
    }
    public static float shieldPower(){ //devuelve un valor aleatorio en el intervalo [0, MAX_SHIELD[
        float shield = 0.0f;
       
        shield = generator.nextFloat((float)MAX_SHIELD);
        
        return shield; 
    }
    
    public static int usesLeft(){ //devuelve el número de usos que se asignará a un arma o escudo. Será un númeroaleatorio desde 0 (inclusive) que nunca debe superar el máximo indicado en la definición de losatributos de clase.
        int uses = 0;
       
        uses = generator.nextInt(MAX_USES);
        
        return uses; 
    }
    
    public static float intensity(float competence){ //devuelve la cantidad de competencia aplicada. Será un valor aleatorio del intervalo [0, competence[
        
        float intensity = 0.0f;
       
        intensity = generator.nextFloat((float)competence);
        
        return intensity; 
    }
    
    public static boolean discardElement(int usesLeft){ // este método devuelve true con una probabilidad inversamente proporcional a lo cercano que esté el parámetro del número máximo de usos que puede tener un arma o escudo. Como casos extremos, si el número de usos es el máximo devolverá false y si es 0 devolverá true. Es decir, las armas o escudos con más usos posibles es menosprobable que sean descartados.Aunque algunos de los métodos indicados tienen una implementación idéntica, se ha decido tenermétodos distintos para que su nombre refleje claramente su función y para permitir en un futuro quedecisiones aleatorias distintas dejen de tener la misma implementación aunque inicialmente sí seimplementen igual.
        Boolean destroy=false;
        if ((float)usesLeft/MAX_USES>generator.nextFloat()){
            destroy=true;
        }
        return destroy;
    }
    
}
