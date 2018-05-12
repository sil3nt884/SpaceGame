package com.platformer.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import com.platformer.GameCanvas;

/**
 * Polymorphism this class extends Backgrond and overrides background methods 
 * to do difrernt things.
 * 
 * @author Ricky
 *
 */

public class Level1Background extends Background{

	

	/**
	 * Controlling the visabilty of methods and varabile is called 
	 * encapsulation
	 * Java has package,protected,public and private 
	 * 
	 */
	
	private double playery;
	
	public Level1Background(String s, double ms) {
		super(s, ms);
	}
	
	
	
	public double getPlayery() {
		return playery;
	}



	public void setPlayery(double playery) {
		this.playery = playery;
	}



	public void update() {
		setY(playery * 0.07 % GameCanvas.HEIGHT *2);
		if(playery < 0) {
			setY(0);
		}
		if(playery < GameCanvas.HEIGHT) {
			setY(playery);
		}
		
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(getImage(), (int)getX() ,-(int)getY(), null);
			
	}
	


}
