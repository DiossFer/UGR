# frozen_string_literal: true
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
module Irrgarten
  class Game
    attr_accessor :players, :currentPlayerlndex, :log, :currentPlayer, :labyrinth, :monsters, :gameState
    @@MAX_ROUNDS = 10


    def initialize(nplayers)
      @players = Array.new()


      for i in 0...nplayers
        p = Player.new(i.to_s, Irrgarten::Dice.randomIntelligence, Irrgarten::Dice.randomStrength)
        @players << p

      end

      @currentPlayerlndex = Dice.whoStarts(nplayers)

      puts("DEBUG------------------")
      puts(@currentPlayerlndex)
      puts(@players[0])
      puts(@players[@currentPlayerlndex])
      puts("__________________________________")

      @currentPlayer = @players[@currentPlayerlndex]

      @monsters = Array.new()

      @log = ""

      auxCol = 5
      auxRow = 5

      @labyrinth = Irrgarten::Labyrinth.new(auxCol, auxRow, Irrgarten::Dice.randomPos(auxCol), Irrgarten::Dice.randomPos(auxRow))

      configureLabyrinth()
      @labyrinth.spreadPlayers(@players)




    end

    def finished()
          return @labyrinth.haveAWinner()
    end


    def nextStep(preferredDirection)
      puts("entroNextStep")
      @log=""
      dead = @currentPlayer.dead()
      if (!dead)
        puts("-1pppppppp")
        direction = actualDirection(preferredDirection)
        puts("-2pppppppp")
        if (direction!=preferredDirection)
          logPlayerNoOrders()
        end
        puts("1pppppppp")
        monster = @labyrinth.putPlayer(direction, @currentPlayer)
        puts("2pppppppp")
        if (monster==nil)
          logNoMonster()

        else
          winner = combat(monster)
          manageReward(winner)

        end

      else
        manageResurrection()
      end


      endGame = finished()

      if (!endGame)
        nextPlayer()
      end


      return endGame
      puts("salgoNextStep")
    end


    def getGameState()

        auxLabyrint = @labyrinth.to_s()

        auxPlayers = ""

        for i in 0...@players.size
          auxPlayers+="  "+@players[i].to_s()+"\n"
        end


        auxMonsters = ""
        for i in 0...@monsters.size
          auxMonsters += "  " + @monsters[i].to_s + "\n"
        end

        auxCurrentPlayer = @currentPlayerlndex

        auxWinner = finished()

        auxLog = @log

        gs = GameState.new(auxLabyrint, auxPlayers, auxMonsters, auxCurrentPlayer, auxWinner, auxLog)

        return gs
    end


    def configureLabyrinth()


      for i in 0...4
            mAux = Monster.new("Monster#"+i.to_s, Dice.randomIntelligence(), Dice.randomStrength())
            @monsters<<mAux
      end



      @labyrinth.addMonster(2, 0, @monsters[0])
      @labyrinth.addMonster(2, 2, @monsters[1])
      @labyrinth.addMonster(3, 4, @monsters[2])
      @labyrinth.addMonster(4, 2, @monsters[3])


      @labyrinth.addBlock(Orientation::VERTICAL, 0, 2, 2)
      @labyrinth.addBlock(Orientation::HORIZONTAL, 0, 3, 1)
      @labyrinth.addBlock(Orientation::HORIZONTAL, 3, 0, 1)

    end




    def nextPlayer()
        if (@currentPlayerlndex==@players.length-1)
          @currentPlayerlndex=0
        else
          @currentPlayerlndex+=1
        end
        @currentPlayer = players[@currentPlayerlndex]
    end

    def actualDirection (preferredDirection)

      currentRow = @currentPlayer.row
      currentCol = @currentPlayer.col

      validMoves = @labyrinth.validMoves(currentRow, currentCol)
      output = @currentPlayer.move(preferredDirection, validMoves)


      return output

    end

    def combat(monster)
      rounds = 0
      monsterAttack = 0.0
      winner = GameCharacter::PLAYER
      playerAttack = @currentPlayer.attack()
      lose = monster.defend(playerAttack)

      while ((!lose) && (rounds<@@MAX_ROUNDS))
        puts("aaaaaaaa")
        winner=GameCharacter::MONSTER
        rounds+=1
        monsterAttack = monster.attack()
        lose = @currentPlayer.defend(monsterAttack)
        if (!lose)
          playerAttack = @currentPlayer.attack()
          winner = GameCharacter::PLAYER
          lose=monster.defend(playerAttack)
        end
      end

      logRounds(rounds, @@MAX_ROUNDS)
      return winner
    end


    def manageReward(winner)
              if (winner==GameCharacter::PLAYER)
                @currentPlayer.receiveReward()
                logPlayerWon()

              else
                logMonsterWon()

              end
    end


    def manageResurrection()
      resurrect = Dice.resurrectPlayer()
      if (resurrect)
        @currentPlayer.resurrect()
        logResurrected()
      else
        logPlayerSkipTurn()
      end
    end

    def logPlayerWon()
      @log=(@log+"El jugador "+@currentPlayer.to_s+"ha ganado el combate"+"\n")
    end

    def logMonsterWon()
      @log=(@log+"El monstruo ha ganado el combate"+"\n")
    end

    def logResurrected()

      @log=(@log+"El jugador "+@currentPlayer.to_s+"ha ganado resucitado"+"\n")
    end

    def logPlayerSkipTurn()
      puts("AAAAAAAAAAAAAAAAAAAAAAAAAAAA")
      puts(@currentPlayer)
      @log=(@log+"El jugador "+@currentPlayer.to_s+"ha perdido el turno por estar muerto"+"\n")
    end

    def logPlayerNoOrders()
      puts("AAAAAAAAAAAAAAAAAAAAAAAAAAAA")
      puts(@currentPlayer)
      @log=(@log+"El jugador "+@currentPlayer.to_s+"no pudo cumplir con las indicaciones"+"\n")
    end

    def logNoMonster()
      puts("AAAAAAAAAAAAAAAAAAAAAAAAAAAA")
      puts(@currentPlayer)
      @log=(@log+"El jugador "+@currentPlayer.to_s+"ha entrado a una casilla vacia"+"\n")
    end

    def logRounds(rounds, max)
      puts("AAAAAAAAAAAAAAAAAAAAAAAAAAAA")
      puts(@currentPlayer)
      puts("PUREBAPRUEBAPRUEBAPRUEBAPRUEBA")
      @log=(@log+"Se ha producido "+rounds.to_s+" de "+max.to_s+" rondas de combate"+"\n")
    end

  end

end