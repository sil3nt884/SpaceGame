package com.platformer;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import com.platformer.config.GameConfig;
import com.platformer.gamestates.GameStateManger;

public class GameCanvas extends Canvas implements Runnable, KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int  WIDTH = 400;
	public static int HEIGHT = 300;
	int scale = 2;
	private Thread thread;
	private boolean running;
	int FPS = 60;
	private long targetTime =1000/FPS;
	private BufferedImage image;
	private Graphics2D g ;
	private GameConfig config;
	
	private GameStateManger gsm;
	
	public GameCanvas (GameConfig config){
		super();
		setPreferredSize(new Dimension(WIDTH * scale, HEIGHT * scale));
		setFocusable(true);
		requestFocus();
		this.config= config;
		System.out.println(config);
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread==null) {
			thread  = new Thread(this);
			this.addKeyListener(this);
			thread.start();
		}
	}
	
	private void init() {
		image = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_BGR);
		g = (Graphics2D) image.getGraphics();
		running = true;
		System.out.println(config);
		gsm = new GameStateManger(config);
	}
	
	

	@Override
	public void run() {
		if(config !=null)
			init();
		
		long start;
		long esalpsed;
		long wait;
		while(running) {	
			start = System.nanoTime();
			update();
			draw();
			drawToScreen();
			esalpsed = System.nanoTime()-  start;
			wait = setTargetTime(esalpsed /  1000000);
			try {
				Thread.sleep(wait);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		 
		}
		
	}
	
	

	private void drawToScreen() {
		Graphics g2 = this.getGraphics();
		g2.drawImage(image,0,0,WIDTH * scale , HEIGHT * scale ,null);
		g2.dispose();
		
	}

	private void draw() {
		gsm.draw(g);
		
	}

	private void update() {
		gsm.update();
		gsm.collsion();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		gsm.KeyPressed(e.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		gsm.KeyReleased(e.getKeyCode());
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public long getTargetTime() {
		return targetTime;
	}

	public long setTargetTime(long targetTime) {
		this.targetTime = targetTime;
		return targetTime;
	}
	
	
	
}
