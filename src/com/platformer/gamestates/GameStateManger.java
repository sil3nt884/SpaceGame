package com.platformer.gamestates;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.platformer.config.GameConfig;

public class GameStateManger {
	
	private ArrayList<GameState> gameStates;
	private int currentState;
	static final int MENUSTATE = 0;
	static final int LEVEL1STATE = 1;
	private GameConfig config;
	
	public GameStateManger(GameConfig config) {
		this.setConfig(config);
		gameStates = new ArrayList<GameState>();
		currentState = MENUSTATE;
		gameStates.add(new MenuState(this));
		gameStates.add(new Level1State(this));
		
	}
	
	public void setState(int state) {
		currentState = state;
		gameStates.get(currentState).init();
	}
	
	
	public void collsion () {
		gameStates.get(currentState).collsion();
	}
	
	

	
	public void update() {
		gameStates.get(currentState).update();
		gravity();
		collsion();
		
	}
	
	public void gravity() {
		gameStates.get(currentState).gravity();
	}

	
	public void draw(Graphics2D g) {
		gameStates.get(currentState).draw(g);
	}
	
	public void KeyPressed(int e) {
		gameStates.get(currentState).KeyPressed(e);
	}
	
	public void KeyReleased(int e) {
		gameStates.get(currentState).KeyReleased(e);
	}

	public GameConfig getConfig() {
			return config;
	}
	

	public void setConfig(GameConfig config) {
		this.config = config;
	}
	
	
}
