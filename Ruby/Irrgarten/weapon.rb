# frozen_string_literal: true
require_relative 'dice.rb'
module Irrgarten
  class Weapon
    attr_accessor :power, :uses

    def initialize (power, uses)
      @power=power
      @uses=uses
    end

    def attack ()
      damage = 0.0

      if @uses > 0
        @uses = @uses - 1
        damage = @power
      end

      return damage
    end


    def discard ()

        disc = false
        disc = Irrgarten::Dice.discardElement(@uses)
        return disc

    end

    def to_s
      "W[#{@power}, #{@uses}]"
    end

  end
end