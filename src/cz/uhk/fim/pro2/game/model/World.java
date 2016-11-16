package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;

public class World {
	
	private Bird bird;
	private ArrayList<Tube> tubes;
	private ArrayList<Heart> hearts;
	
	public static final int SPEED = 100;
	
	public World(Bird bird){
		this.bird = bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
	}
	
	
	public void update(float deltaTime){
		bird.update(deltaTime);
	}
	
	public ArrayList<Tube> getTubes(){
		return tubes;
	}
	
	public ArrayList<Heart> getHearts(){
		return hearts;
	}
	
	public void addTube(Tube tube){
		tubes.add(tube);
	}
	public void addHeart(Heart heart){
		hearts.add(heart);
	}
	public void removeHeart(){
		hearts.remove(hearts.size()-1);
	}
	public String toString(){
		return bird.getName() + " je na pozici [" + bird.getPositionX() + "," + bird.getPositionY() + "], pocet trubek: " +
				tubes.size() + ", pocet srdicek: " + hearts.size();
	}
	public Bird getBird(){
		return bird;
	}
	

}