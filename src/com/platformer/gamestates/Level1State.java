package com.platformer.gamestates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import com.platformer.GameCanvas;
import com.platformer.objects.Map;
import com.platformer.objects.Player;
import com.platformer.objects.Tile;

public class Level1State extends GameState implements ActionListener{

	private GameStateManger gsm;
	private Map map;
	private Player player;
	double gravity = 9.8;
	long gravityTime  =0;
	private Timer timer = new Timer (1000, this);
	int seconds = 0;
	boolean gravityEffect = true;
	

	public Level1State(GameStateManger gameStateManger) {
		this.gsm = gameStateManger;
		timer.start();

	}

	@Override
	public void init() {
		setMap(gsm.getConfig().getCreator().getMap(0));
		player = gsm.getConfig().getPlayer();

	}

	@Override
	public void update() {
		
		if(gravityEffect) {
			player.update(gravity);
		}
		
		map.setX(-player.getX() *0.07);
		map.setY(-player.getY()* 0.07);
		map.update();
		
		
	}
	
	

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, GameCanvas.WIDTH, GameCanvas.HEIGHT);
		map.mapDraw(g);
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

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public void collsion() {	
		float height = map.getTileSize() * map.getHeight();
        float width =  map.getTileSize() * map.getWidth();
        float playerX = (float) player.getX();
        float playerY = (float) player.getY();
        int tileRow =  (int) Math.abs((playerY - (height / 2)) / map.getTileSize());
        int tileCol = (int) (playerX / map.getTileSize());
        if(tileRow < map.getHeight() && tileCol < map.getWidth()) {
        	if(map.getMap()[tileRow][tileCol]==Tile.BLOCKED) {
        		player.setY(playerY * 0 + map.getTileSize()  - (player.getPlayRect().height - gravity) -9);
        		gravityEffect = false;
        	}
        }
        else if(tileRow < map.getHeight() && tileCol < map.getWidth()) {
        	if(map.getMap()[tileRow][tileCol]==Tile.NORMAL) {
        		gravityEffect = true;
        	}
        }
        else {
        		gravityEffect = true;	
        }
		
	}

	@Override
	public void gravity() {
		
	
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
