# frozen_string_literal: true
module Irrgarten
  class LabyrinthCharacter
    attr_accessor :name, :intelligence, :strength, :health, :row, :col

    def initialize(name, intelligence, strength, health)
      @intelligence = intelligence
      @strength = strength

      @name = name
      @health = health
      @row = 0
      @col = 0

    end

    def newCopia(other)
      newLC = new(other.name, other.intelligence, other.strength, other.health)

      newLC.row = other.row
      newLC.col = other.col

      newLC
    end

    def setPos(row, col)
      @col = col
      @row = row
    end

    def dead()
      dead=false
      if (@health<=0)
        dead=true
      end
      return dead
    end


    def attack ()

    end

    def defend(receivedAttack)

    end

    def to_s
      "LC{name=#{@name}, intelligence=#{@intelligence}, strength=#{@strength}, health=#{@health}, row=#{@row}, col=#{@col}}"
    end

  end
end