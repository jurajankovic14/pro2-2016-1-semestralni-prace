package cz.uhk.fim.pro2.game;

import cz.uhk.fim.pro2.game.gui.HomeScreen;
import cz.uhk.fim.pro2.game.gui.MainFrame;
import cz.uhk.fim.pro2.game.gui.ScoreScreen;
import cz.uhk.fim.pro2.game.gui.GameScreen;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainFrame mainFrame = new MainFrame();
		
		mainFrame.setScreen(new HomeScreen(mainFrame));
	
		
	}

}
