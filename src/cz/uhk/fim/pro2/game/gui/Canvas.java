package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.Graphics;

import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class Canvas extends java.awt.Canvas{
	
	private World world;
	
	public Canvas(World world){
		this.world = world;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(world.getBird().getPositionX(), world.getBird().getPositionY(), 50, 50);
		for (Heart heart : world.getHearts()) {
			heart.paint(g);
			
		}
		for (Tube tube : world.getTubes()) {
			tube.paint(g);
		}
	}

}