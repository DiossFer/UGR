# frozen_string_literal: true
require_relative 'dice.rb'
require_relative 'combat_element'
module Irrgarten
  class Shield < CombatElement

    attr_accessor :protection, :uses

    def initialize (power, uses)
      super(power, uses)
    end

    def protect ()
      return produceEffect
    end

    def to_s
      "S["+super+"]"
    end
  end
end