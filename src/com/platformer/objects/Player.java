package com.platformer.objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {

	private double x, y;
	private double speed = 50;
	private Rectangle playRect = new Rectangle(25,25);
	private BufferedImage playImage;
	public Rectangle getPlayRect() {
		return playRect;
	}

	
	public void update(double gravity) {
		y+=gravity;
		playRect.y = (int) y;
	}
	public void draw(Graphics2D g2) {
		g2.drawImage(playImage,  playRect.x, playRect.y, 50/2, 50/2,null);
	}
	
	public void setPlayRect(Rectangle playRect) {
		this.playRect = playRect;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
		this.playRect.x = (int) x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
		this.playRect.y = (int) y;
	}




	public void loadAssets() {
		try {
			setPlayImage(ImageIO.read(new File(this.getClass().getResource("/res/Player/c.png").getFile())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}




	public BufferedImage getPlayImage() {
		return playImage;
	}




	public void setPlayImage(BufferedImage playImage) {
		this.playImage = playImage;
	}
	
	
	
	
	
}
