package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

import cz.uhk.fim.pro2.game.Game;
import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;


public class GameScreen extends Screen {
	
	private Timer timer;
	private long lastTimeMillis;

	public GameScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		JButton back = new JButton("BACK");
		back.setBounds(20, 20, 60, 60);
		back.setFont(new Font("Arial",Font.PLAIN,7));
		JButton pause = new JButton("PAUSE");
		pause.setBounds(400, 20, 60, 60);
		pause.setFont(new Font("Arial",Font.PLAIN,7));
		
		
		add(back);
		add(pause);
		

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));

			}
		});
		pause.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(timer.isRunning()){
					timer.stop();
				}else{
					lastTimeMillis = System.currentTimeMillis();
					timer.start();
				}
			}
		});
		
		//WORLD
		Bird bird = new Bird("Bird", 240, 400);
		World world = new World(bird);
		world.addTube(new Tube(400, 400, Color.green));
		world.addTube(new Tube(600, 300, Color.green));
		world.addTube(new Tube(800, 500, Color.green));
		
		world.addHeart(new Heart(500, 450));
		world.addHeart(new Heart(700, 600));
		
		Canvas canvas = new Canvas(world);
		canvas.setBounds(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
		add(canvas);
		
		timer = new Timer(20, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long currentTimeMillis = System.currentTimeMillis();
				float delta = (currentTimeMillis - lastTimeMillis)/1000.f;
				System.out.println(world.getBird().getPositionX());
				world.update(delta);
				canvas.repaint();
			}
		});
		
		timer.start();
	}
}
