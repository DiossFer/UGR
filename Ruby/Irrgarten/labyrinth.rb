# frozen_string_literal: true
require_relative 'player.rb'
require_relative 'monster.rb'
require_relative 'game_state'
require_relative 'shield'
require_relative 'weapon'
require_relative 'dice'
require_relative 'game'
require_relative 'directions'
require_relative 'game_character'
require_relative 'orientation'
require_relative 'labyrinth_square'
require_relative 'monster_square'
require_relative 'player_square'
module Irrgarten
  class Labyrinth

    @@BLOCK_CHAR = 'X'
    @@EMPTY_CHAR = '-'
    @@MONSTER_CHAR = 'M'
    @@COMBAT_CHAR = 'C'
    @@EXIT_CHAR = 'E'
    @@ROW = 0
    @@COL = 1



    def initialize(nRows, nCols, exitRow, exitCol)

      if (nRows>=1 && nCols>=1)

        @monstersTable = Array.new(nRows) { Array.new(nCols) }
        @playersTable = Array.new(nRows) { Array.new(nCols) }
        @charTable = Array.new(nRows) { Array.new(nCols) }
        @nRows = nRows
        @nCols = nCols
        @exitRow = exitRow
        @exitCol = exitCol

        for i in 0...@nRows
          for j in 0...@nCols
            @charTable[i][j]=@@EMPTY_CHAR
          end
        end



        @charTable[exitRow][exitCol]=@@EXIT_CHAR

      end

    end




    def spreadPlayers(players)

      for player in players
        pos = randomEmptyPos()
        putPlayer2D(-1, -1, pos[0], pos[1], player)
      end

    end



    def haveAWinner()
        win=false
        if (@playersTable[@exitRow][@exitCol]!=nil)
          win = true
        end

        return win
    end




    def to_s()
      s="\n"

      for i in 0...@nRows
        s+="| "
        for j in 0...@nCols
          s+=" "+@charTable[i][j]+" "
        end
        s+=" |\n"
      end

      return s
    end



    def addMonster(row, col, monster)
      if (posOK(row, col))
        if (@charTable[row][col]==@@EMPTY_CHAR)
          @monstersTable[row][col] = monster
          @charTable[row][col] = @@MONSTER_CHAR
        end
      end

      monster.setPos(row, col)
    end

    def putPlayer(direction, player)

      oldRow = player.row
      oldCol = player.col

      newPos = dir2Pos(oldRow, oldCol, direction)

      m = putPlayer2D(oldRow, oldCol, newPos[0], newPos[1], player)

      return m

    end

    def set (row, col, c)
      @charTable[row][col] = c
    end

    def addBlock(orientation, startRow, startCol, length)
      incRow = 0
      incCol = 0

      if(orientation==Orientation::VERTICAL)
        incRow=1
        incCol=0
      else
        incRow=0
        incCol=1
      end

      row = startRow
      col = startCol

      while((posOK(row,col)) && (emptyPos(row,col)) && (length >0))
        set(row, col, @@BLOCK_CHAR)
      end

      length-=1
      row+=incRow
      col+=incCol
    end



    def validMoves(row, col)
              output = Array.new()
              if (canStepOn(row+1, col))
                output << Directions::DOWN
              end
              if (canStepOn(row-1, col))
                output << Directions::UP
              end
              if (canStepOn(row, col+1))
                output << Directions::RIGHT
              end
              if (canStepOn(row, col-1))
                output << Directions::LEFT
              end

              return output
    end

    def posOK(row, col)
      ok=false
      if (row<@nRows && col<@nCols && row>=0 && col>=0)
        ok=true
        return ok
      end
    end




    def emptyPos(row, col)
      empty=false
      if (posOK(row, col))
        if(@charTable[row][col]==@@EMPTY_CHAR)
          empty=true
        end

      end
      return empty
    end



    def monsterPos(row, col)
      m=false
      if (posOK(row, col))
        if(@charTable[row][col]==@@MONSTER_CHAR)
          m=true
        end
      end

      return m
    end

    def exitPos(row, col)
      e=false

      if (posOK(row, col))
        if(@charTable[row][col]==@@EXIT_CHAR)
          e=true
        end
      end
      return e
    end


    def combatPos(row, col)
      c=false
      if (posOK(row, col))
        if(@charTable[row][col]==@@COMBAT_CHAR)
          c=true
        end
      end
      return c
    end

    def canStepOn(row, col)
      step=false
      if (posOK(row, col))
        if(@charTable[row][col]==@@EMPTY_CHAR)
          step=true

        elsif (@charTable[row][col]==@@MONSTER_CHAR)
          step=true

        elsif  (@charTable[row][col]==@@EXIT_CHAR)
           step=true

        end

      end
      return step
    end

    def updateOldPos(row, col)
       if (posOK(row, col))
         if(combatPos(row, col))
           @charTable[row][col]=@@MONSTER_CHAR

         else
           @charTable[row][col]=@@EMPTY_CHAR
         end


       end
    end

    def dir2Pos(row, col, direction)
      r=row
      c=col

      if (posOK(row, col))

        if (direction==Directions::DOWN)
          r+=1
        elsif (direction==Directions::UP)
          r-=1
        elsif (direction==Directions::LEFT)
          c-=1
        elsif (direction==Directions::RIGHT)
          c+=1
        end

      end

      pos = Array.new(2)
      pos[0] = r
      pos[1] = c

      return pos

    end

    def randomEmptyPos()
      fin=false
      r=0
      c=0

      while (!fin)

        r=Dice.randomPos(@nRows)
        c=Dice.randomPos(@nCols)

        if (emptyPos(r, c))
          fin=true
        end
      end


      pos = Array.new(2)
      pos[0] = r
      pos[1] = c
      return pos

    end

    def putPlayer2D(oldRow, oldCol, row, col, player)
      output = nil
      if (canStepOn(row, col))
        if (posOK(oldRow, oldCol))
          p = @playersTable [oldRow][oldCol]
          if (player == p)
            updateOldPos(oldRow, oldCol)
            @playersTable[oldRow][oldCol]=nil

          end

        end


        monsterPos = monsterPos(row, col)

        if (monsterPos)
          @charTable[row][col]=@@COMBAT_CHAR
          output = @monstersTable[row][col]
        else
          @charTable[row][col] = player.number
        end
        @playersTable [row][col] = player
        player.setPos(row, col)
      end
      return output
    end

  end
end

