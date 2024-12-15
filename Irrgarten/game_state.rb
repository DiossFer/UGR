# frozen_string_literal: true
module Irrgarten
  class GameState
    attr_accessor :labyrinth, :players, :monsters, :currentPlayer, :winner, :log

    def initialize (labyrinth, players, monsters, currentPlayer, winner, log)
      @labyrinth = labyrinth
      @players = players
      @monsters = monsters
      @currentPlayer = currentPlayer
      @winner = winner
      @log = log
    end

    def to_s
      salida = "Game State:\n"
      salida += "Labyrinth:\n"
      salida += "#{@labyrinth}\n"
      salida += "Players:\n"
      salida += "#{@players}\n"
      salida += "Monsters:\n"
      salida += "#{@monsters}\n"
      salida += "Current Player: Player ##{@currentPlayer}, "

      if @winner
        salida += "ganador."
      else
        salida += "en juego"
      end

      salida += "\nLog: #{@log}\n"

      salida
    end


  end
end
