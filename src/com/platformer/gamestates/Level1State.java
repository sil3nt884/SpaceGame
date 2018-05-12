package com.platformer.gamestates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import com.platformer.GameCanvas;
import com.platformer.objects.Level1Background;
import com.platformer.objects.Player;

public class Level1State extends GameState implements ActionListener{

	private GameStateManger gsm;
	private Player player;
	double gravity = 9.8;
	long gravityTime  =0;
	private Timer timer = new Timer (1000, this);
	int seconds = 0;
	boolean gravityEffect = true;
	private Level1Background level1;
	

	public Level1State(GameStateManger gameStateManger) {
		this.gsm = gameStateManger;
		timer.start();
		level1 = new Level1Background("/res/backgrounds/level1.jpg",  1.0);

	}

	@Override
	public void init() {
		player = gsm.getConfig().getPlayer();
		player.setX(0);
		player.setY(0);

	}

	@Override
	public void update() {
		
	level1.setPlayery(player.getY());
	level1.update();	
	player.update();	
		
		
	}
	
	

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, GameCanvas.WIDTH, GameCanvas.HEIGHT);
		level1.draw(g);
		player.draw(g);
	}

	@Override
	public void KeyPressed(int e) {
		if (e == KeyEvent.VK_LEFT) {
			double current = player.getX();
			player.setX(current -= player.getSpeed());
		}
		if (e == KeyEvent.VK_RIGHT) {
			double current = player.getX();
			player.setX(current += player.getSpeed());
		}

		if (e == KeyEvent.VK_UP) {
			double current = player.getY();
			player.setY(current -= player.getSpeed());
		}
		if (e == KeyEvent.VK_DOWN) {
			double current = player.getY();
			player.setY(current += player.getSpeed());
		}
	}

	@Override
	public void KeyReleased(int e) {
		// TODO Auto-generated method stub

	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public void collsion() {	
		
	}

	@Override
	public void gravity() {
		
	
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
