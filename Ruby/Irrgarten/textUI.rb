require_relative 'player.rb'
require_relative 'monster.rb'
require_relative 'game_state'
require_relative 'shield'
require_relative 'weapon'
require_relative 'dice'
require_relative 'labyrinth'
require_relative 'directions'
require_relative 'game_character'
require_relative 'orientation'
require_relative 'labyrinth_square'
require_relative 'monster_square'
require_relative 'player_square'
require 'io/console'
require_relative 'directions'

module UI

  class TextUI

    #https://gist.github.com/acook/4190379
    def read_char
      STDIN.echo = false
      STDIN.raw!
    
      input = STDIN.getc.chr
      if input == "\e" 
        input << STDIN.read_nonblock(3) rescue nil
        input << STDIN.read_nonblock(2) rescue nil
      end
    ensure
      ##
      #STDIN.echo = true

      STDIN.cooked!
    
      return input
    end

    def next_move
      print "Where? "
      got_input = false
      while (!got_input)
        c = read_char
        case c
          when "w"
            puts "UP ARROW"
            output = Directions::UP
            got_input = true
          when "s"
            puts "DOWN ARROW"
            output = Directions::DOWN
            got_input = true
          when "d"
            puts "RIGHT ARROW"
            output = Directions::RIGHT
            got_input = true
          when "a"
            puts "LEFT ARROW"
            output = Directions::LEFT
            got_input = true
          when "\u0003"
            puts "CONTROL-C"
            got_input = true
            exit(1)
          else
            #Error
        end
      end
      output
    end

    def show_game(game_state)
      puts(game_state.to_s)
    end

  end # class   

end # module   


