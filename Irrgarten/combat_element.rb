# frozen_string_literal: true
require_relative 'dice.rb'
module Irrgarten
  class CombatElement

      def initialize (power, uses)
        @power=power
        @uses=uses
      end

      def produceEffect ()
        effect = 0.0

        if @uses > 0
          @uses = @uses - 1
          effect = @power
        end

        return effect
      end

      def discard ()

        disc = false
        disc = Irrgarten::Dice.discardElement(@uses)
        return disc

      end


      def to_s
        "CombEleme[#{@power}, #{@uses}]"
      end



  end
end

