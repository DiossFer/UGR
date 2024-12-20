# frozen_string_literal: true
require_relative 'labyrinth_character'
module Irrgarten

  class Player < LabyrinthCharacter
    attr_accessor :number, :intelligence, :strength, :name, :row, :col, :consecutiveHits, :weapons, :shields
    @@MAX_WEAPONS = 2
    @@MAX_SHIELDS = 3
    @@INITIAL_HEALTH = 10
    @@HITS2LOSE = 3

    def initialize(number, intelligence, strength)
      super("Player #"+number.to_s, intelligence, strength, @@INITIAL_HEALTH)
      @consecutiveHits = 0
      @weapons = Array.new
      @shields = Array.new
      @number = number
    end

    def newCopia(other)
      newP = super(other)

      @consecutiveHits = other.consecutiveHits
      @weapons = other.weapons
      @shields = other.shields
      @number = other.number
      newP

    end



    def resurrect ()
      resetHits()
      @weapons.clear
      @shields.clear
      @health=@@INITIAL_HEALTH
    end





    def move (direction, validMoves)

        size = validMoves.size()
        contained = validMoves.include?(direction)
        if (size>0 && (!contained))
          firstElement = validMoves[0]
          return firstElement

        else
          return direction
        end
    end


    def attack ()
          damage = sumWeapons()
          damage += @strength
          return damage
    end

    def defend(receivedAttack)
      lose = manageHit(receivedAttack)
      return lose
    end


    def receiveReward()
          wReward = Dice.weaponsReward()
          sReward = Dice.shieldsReward()
          for i in 1..wReward
            wNew = Weapon.new(Dice.weaponPower, Dice.usesLeft)
            receiveWeapon(wNew)
          end
          for i in 1..sReward
            sNew = Shield.new(Dice.shieldPower, Dice.usesLeft)
            receiveShield(sNew)
          end
    end




    def receiveWeapon(w)
      for i in (@weapons.size - 1).downto(1)
        discard = @weapons[i].discard()
        if (discard)
          @weapons.remove(@weapons[i])
        end

      end

      size = @weapons.size()

      if (size<@@MAX_WEAPONS)
        @weapons << w
      end

    end



    def receiveShield(s)
      for i in (@shields.size - 1).downto(1)
        discard = @shields[i].discard()
        if (discard)
          @shields.remove(@shields[i])
        end

      end

      size = @shields.size()

      if (size<@@MAX_SHIELDS)
        @shields << s
      end
    end


    def newWeapon(power, uses)
      w = Weapon.new(power, uses)
      return w
    end

    def newShield(protection, uses)
      s = Shield.new(protection, uses)
      return s
    end


    def sumWeapons()
      damage=0.0
      @weapons.each do |weapon|
        damage += weapon.attack()
      end
      return damage
    end



    def sumShields()
      resistence=0.0
      @shields.each do |shield|
        resistence += shield.protect()
      end
      return resistence
    end


    def defensiveEnergy()
      defense = 0.0
      defense += sumShields()
      defense += @intelligence
      return defense
    end

    def manageHit(receivedAttack)
      defense = defensiveEnergy()
      lose = false

      if (defense<receivedAttack)
        gotWounded()
        incConsecutiveHits()

      else
        resetHits()
      end

      if ((consecutiveHits==@@HITS2LOSE)||dead())
        resetHits()
        lose=true
      else
        lose=false
      end

      return lose
    end



    def resetHits()
      @consecutiveHits=0
    end



    def gotWounded()
      @health=@health-1.0
    end


    def incConsecutiveHits()
      @consecutiveHits+=1
    end

    def to_s
      "Player{name=#{@name}, number=#{@number}, intelligence=#{@intelligence}, strength=#{@strength}, health=#{@health}, row=#{@row}, col=#{@col}, consecutiveHits=#{@consecutiveHits}, weapons=#{@weapons}, shields=#{@shields}}"
    end

  end

end
