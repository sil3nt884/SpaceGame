package com.platformer.gamestates;

import java.awt.Graphics2D;

public  abstract class  GameState {

	public abstract  void init() ;
	public abstract  void update();
	public abstract  void draw(Graphics2D g) ;
	public abstract  void KeyPressed(int e);
	public abstract  void KeyReleased(int e);
	public abstract void collsion();
	public abstract void gravity();

}
