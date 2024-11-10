# frozen_string_literal: true
module Irrgarten

  class Monster

    @@INITIAL_HEALTH = 5

    def initialize (name, intelligence, strength)
      @name = name
      @intelligence = intelligence
      @strength = strength
      @health = @@INITIAL_HEALTH
      @row = 0
      @col = 0
    end


    def dead()
      dead=false
      if (@health<=0)
        dead=true
      end

      return dead
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


    def setPos(row, col)
      @col=col
      @row=row
    end


    def gotWounded()
          setHealth(@health-1)
    end


    def to_s()
      "Monster{INITIAL_HEALTH=#{@@INITIAL_HEALTH}, name=#{@name}, intelligence=#{@intelligence}, strength=#{@strength}, health=#{@health}, row=#{@row}, col=#{@col}}"
    end


  end
end