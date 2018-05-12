package com.platformer.gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.platformer.objects.Background;

public class MenuState extends GameState {
	
	private Background bg;
	private String text = "Hi,Thank you for letting me show you this game\n "
			+ "This is a demostation of what i know from object\n orinated programing."
			+ "I hope that i will be working\n "
			+ "with Symless and C++ to create improvements to\n Synergy";
	
	private Color titleColor;
	private Font titleFront;
	private Font textFront;
	private int currentChoice;
	private String options [] = {"Start", "End"};
	private GameStateManger gsm;
	
	public MenuState(GameStateManger gameStateManger) {
		this.gsm= gameStateManger;
		bg = new Background("/res/backgrounds/background.jpg", 1);
		bg.setVector(-0.1, 0);
		setTitleColor(Color.WHITE);
		setTitleFront(new Font("Century Gothic", Font.PLAIN, 15));
		setTextFront(new Font("Arial", Font.PLAIN, 12));	
	}
	
	@Override
	public void init() {}

	@Override
	public void update() {
		bg.update();
	}

	@Override
	public void draw(Graphics2D g) {
		bg.draw(g);
		g.setColor(titleColor);
		g.setFont(titleFront);
		g.drawString(text.split("\n")[0], 75, 70);
		g.drawString(text.split("\n")[1], 70, 85);
		g.drawString(text.split("\n")[2], 70, 97);
		g.drawString(text.split("\n")[3], 70, 110);
		g.drawString(text.split("\n")[4], 70, 125);
		g.setFont(textFront);
		for(int i=0; i<options.length; i++) {
			if(i==currentChoice) {
				g.setColor(Color.RED);
			}
			else {
				g.setColor(Color.WHITE);
			}
			g.drawString(options[i], 145, 140 + i * 15);
		}
	}
	
	
	private void select () {
		if(currentChoice == 0) {
			gsm.setState(GameStateManger.LEVEL1STATE);
		};
		if(currentChoice == 1) {
			System.exit(0);
		};
		
	}

	@Override
	public void KeyPressed(int e) {
		if(e == KeyEvent.VK_ENTER) {
			select();
		}
		if(e == KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1) {
				currentChoice = options.length -1;
			}
		}
		if(e == KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == -1) {
				currentChoice = 0;
			}
		}
	}

	@Override
	public void KeyReleased(int e) {
		
	}

	public Font getTitleFront() {
		return titleFront;
	}

	public void setTitleFront(Font titleFront) {
		this.titleFront = titleFront;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Color getTitleColor() {
		return titleColor;
	}
	public void setTitleColor(Color titleColor) {
		this.titleColor = titleColor;
	}
	public Font getTextFront() {
		return textFront;
	}

	public void setTextFront(Font textFront) {
		this.textFront = textFront;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String options[]) {
		this.options = options;
	}

	@Override
	public void collsion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gravity() {
		// TODO Auto-generated method stub
		
	}

}
