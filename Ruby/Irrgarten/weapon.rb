# frozen_string_literal: true
require_relative 'dice.rb'
require_relative 'combat_element'
module Irrgarten
  class Weapon < CombatElement
    attr_accessor :power, :uses

    def initialize (power, uses)
      super(power, uses)
    end

    def attack ()
      return produceEffect
    end

    def to_s
      "W["+super+"]"
    end

  end
end