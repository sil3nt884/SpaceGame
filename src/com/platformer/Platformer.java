package com.platformer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.platformer.config.GameConfig;

public class Platformer extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameConfig config  = new GameConfig();
	private GameCanvas canvas = new GameCanvas(config);
	
	public Platformer () {
		setSize(config.getGameWidth(), config.getGameHeight());
		setTitle("C++ Platform");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.add(canvas);
		add(panel);
		setVisible(true);
		
		
	}
	

	public static void main(String[] args) {
		new Platformer();
	}

}
