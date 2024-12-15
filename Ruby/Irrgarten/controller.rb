module Control

  class Controller
    def initialize(game,view)
      @game = game
      @view = view
    end

    def play
      end_of_game = false
      while (!end_of_game)
        @view.show_game(@game.getGameState())
        direction = @view.next_move
        puts("0_111111111111111111111111111")
        end_of_game = @game.nextStep(direction)
        puts("1_111111111111111111111111111")
      end
      @view.show_game(@game.gameState)
    end
  end # class   
end # module        