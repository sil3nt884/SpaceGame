package com.platformer.objects;

import java.awt.Rectangle;

public class Tile  {

	
	private int type ;
	//tile types;
	public static final int NORMAL = 0;
	public static final int BLOCKED = 1;
	private Rectangle tile;
	
	
	public Tile(double x, double y) {
		setTile(new Rectangle (30,30, (int)x,(int)y));
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public Rectangle getTile() {
		return tile;
	}


	public void setTile(Rectangle tile) {
		this.tile = tile;
	}
	
	
}
