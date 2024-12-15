# frozen_string_literal: true
require_relative 'player'
module Irrgarten
  class FuzzyPlayer < Player

    def initialize (p)
      newCopia(p)
    end

    def move (direction, validMoves)
      size = validMoves.size()
      contained = validMoves.include?(direction)
      if (size>0 && (!contained))
        firstElement = validMoves[0]
        return firstElement

      else
        return Dice.nextStep(direction, validMoves, @intelligence)
      end

    end

    def attack ()
      damage = sumWeapons()
      damage += Dice.intensity(@strength)
      return damage
    end

    def defensiveEnergy()
      defense = 0.0
      defense += sumShields()
      defense += Dice.intensity(@intelligence)
      return defense
    end


    def to_s
      "FP["+super+"]"
    end

  end
end