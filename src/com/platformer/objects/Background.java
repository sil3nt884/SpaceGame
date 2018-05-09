package com.platformer.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.platformer.GameCanvas;

public class Background {

	private double x,y,dx ,dy; 	
	private double moveScale;
	private BufferedImage image;
	
	
	public Background(String s , double ms) {

		try {
			image = ImageIO.read(this.getClass().getResourceAsStream(s));
			System.out.println(image);
			moveScale = ms;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setPosition(double x, double y) {
		this.x = x * moveScale % GameCanvas.WIDTH;
		this.y = y * moveScale % GameCanvas.HEIGHT;
	}
	
	public void setVector(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	
	public void update() {
		x +=dx;
		y +=dy;
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(image, (int)x ,(int)y, null);
		if(x < 0) {
			g.drawImage(image, (int)x + GameCanvas.WIDTH , (int) y, null);
		}
		if(x > 0) {
			g.drawImage(image, (int) - GameCanvas.WIDTH , (int) y, null);
		}
	}
}
