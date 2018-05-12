package com.platformer.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.platformer.GameCanvas;

public class Background {

	private double x;
	private double y;
	private double dx;
	private double dy; 	
	private double moveScale;
	private BufferedImage image;
	
	
	public Background(String s , double ms) {

		try {
			image = ImageIO.read(this.getClass().getResourceAsStream(s));
			System.out.println(image);
			setMoveScale(ms);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setPosition(double x, double y) {
		this.x = x * getMoveScale() % GameCanvas.WIDTH;
		this.setY(y * getMoveScale() % GameCanvas.HEIGHT);
	}
	
	public void setVector(double dx, double dy) {
		this.setDx(dx);
		this.dy = dy;
	}
	
	
	
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void update() {
		x +=getDx();
		setY(getY() + dy);
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(image, (int)x ,(int)getY(), null);
		if(x < 0) {
			g.drawImage(image, (int)x + GameCanvas.WIDTH , (int) getY(), null);
		}
		if(x > 0) {
			g.drawImage(image, (int) - GameCanvas.WIDTH , (int) getY(), null);
		}
	}

	public double getMoveScale() {
		return moveScale;
	}

	public void setMoveScale(double moveScale) {
		this.moveScale = moveScale;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}
}
