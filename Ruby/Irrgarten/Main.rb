# frozen_string_literal: true
require_relative 'controller.rb'
require_relative 'game.rb'
require_relative 'textUI'

c = Control::Controller.new( Irrgarten::Game.new(2), UI::TextUI.new)
c.play()