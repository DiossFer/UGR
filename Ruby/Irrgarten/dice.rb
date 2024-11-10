# frozen_string_literal: true
module Irrgarten
  class Dice

    @@MAX_USES = 5                #(número máximo de usos de armas y escudos)
    @@MAX_INTELLIGENCE = 10.0     #(valor máximo para la inteligencia de jugadores y monstruos)
    @@MAX_STRENGTH = 10.0         #(valor máximo para la fuerza de jugadores y monstruos)
    @@RESURRECT_PROB = 0.3        #(probabilidad de que un jugador sea resucitado en cada turno)
    @@WEAPONS_REWARD = 2         #(numero máximo de armas recibidas al ganar un combate)
    @@SHIELDS_REWARD = 3         #(numero máximo de escudos recibidos al ganar un combate)
    @@HEALTH_REWARD = 5          #(numero máximo de unidades de salud recibidas al ganar un combate)
    @@MAX_ATTACK = 3             #(máxima potencia de las armas)
    @@MAX_SHIELD = 2             #(máxima potencia de los escudos)
    @@generator = Random.new()

    def self.randomPos(max)
      pos = 0
      if (max==0)
        pos=0
      else
        pos = @@generator.rand(0 ... max)
      end


      return pos
    end

    def self.whoStarts(nplayers)
      player = 0

      player = @@generator.rand(0 ... nplayers)

      return player
    end


    def self.randomIntelligence()
      intelligence = 0.0

      intelligence = @@generator.rand(0 ... @@MAX_INTELLIGENCE)

      return intelligence
    end


    def self.randomStrength()
      strenghth = 0.0

      strenghth = @@generator.rand(0.0 ... @@MAX_STRENGTH)

      return strenghth
    end


    def self.resurrectPlayer()
      resurrect = false

      prob = 0.0
      prob = @@generator.rand(0.0 .. 1.0)

      if (prob<=@@RESURRECT_PROB)
        resurrect = true
      end

      return resurrect
    end



    def self.weaponsReward()
      reward = 0

      reward = @@generator.rand(0 ... @@WEAPONS_REWARD)

      return reward
    end


    def self.shieldsReward()
      reward = 0

      reward = @@generator.rand(0 ... @@SHIELDS_REWARD)

      return reward
    end


    def self.healthReward()
      reward = 0

      reward = @@generator.rand(0 ... @@HEALTH_REWARD)

      return reward
    end

    def self.weaponPower()
      attack = 0.0

      attack = @@generator.rand(0.0 ... @@MAX_ATTACK)

      return attack
    end

    def self.shieldPower()
      shield = 0.0

      shield = @@generator.rand(@@MAX_SHIELD)

      return shield
    end


    def self.usesLeft()
      uses = 0

      uses = @@generator.rand(0 ... @@MAX_USES)

      return uses
    end


    def self.intensity(competence)

      intensity = 0.0

      intensity = @@generator.rand(0.0 ... competence)

      return intensity

    end


    def self.discardElement(usesLeft)
      destroy=false

      if (usesLeft/@@MAX_USES>@@generator.rand(0.0 .. 1.0))
        destroy=true
      end

      return destroy
    end

  end
end