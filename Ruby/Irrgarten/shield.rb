# frozen_string_literal: true
require_relative 'dice.rb'
module Irrgarten
  class Shield

    attr_accessor :protection, :uses

    def initialize (protection, uses)
      @protection=protection
      @uses=uses
    end

    def protect ()
      defense = 0.0

      if @uses > 0
        @uses = @uses - 1
        defense = @defense
      end

      return defense
    end


    def discard ()

      disc = false
      disc = Dice.discardElement(@uses)
      return disc

    end

    def to_s
      "S[#{@protection}, #{@uses}]"
    end
  end
end