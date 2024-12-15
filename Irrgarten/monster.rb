# frozen_string_literal: true
require_relative 'labyrinth_character'
module Irrgarten

  class Monster  < LabyrinthCharacter

    @@INITIAL_HEALTH = 5

    def initialize (name, intelligence, strength)
      super(name, intelligence, strength, @@INITIAL_HEALTH)
    end






    def attack()
        att = 0.0
        att = Dice.intensity(@strength)
        return att
    end


    def defend(receivedAttack)
        isDead = dead()
        if (!isDead)
          defensiveEnergy = Dice.intensity(@intelligence)
          if (defensiveEnergy<receivedAttack)
            gotWounded()
            isDead = dead()
          end
        end
        return isDead
    end

    def gotWounded()
          @health=(@health-1)
    end


    def to_s()
      "Monster{INITIAL_HEALTH=#{@@INITIAL_HEALTH}, name=#{@name}, intelligence=#{@intelligence}, strength=#{@strength}, health=#{@health}, row=#{@row}, col=#{@col}}"
    end


  end
end