package com.platformer.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.platformer.MapCreator;
import com.platformer.objects.Map;
import com.platformer.objects.Player;

public class GameConfig {

	
	private File resources;
	private Properties gameProperties = new Properties();
	private InputStream input = null;
	private int gameWidth;
	private int gameHeight;
	private MapCreator  creator;
	private Player player;
	
	public GameConfig () {
		try {
			initConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initConfig() throws IOException {
		input =  new FileInputStream("game.properties");
		gameProperties.load(input);
		setGameWidth(Integer.parseInt(gameProperties.getProperty("gameWidth")));
		setGameHeight(Integer.parseInt(gameProperties.getProperty("gameHeight")));
		resources = new File(this.getClass().getResource("/res").getFile());
		System.out.println("creating..objects");
		creator = new MapCreator();
		player = new Player();
		loadAssets();
		creator.createMaps();
		creator.loadMapArrays(this);
		
		
	}
	
	
	
	
	public void loadAssets() {
		System.out.println("loading...assests for GameConfig");
		creator.loadMaps(this);
		player.loadAssets();
	
	}

	
	public File getResources() {
		return resources;
	}
	public void setResources(File resources) {
		this.resources = resources;
	}

	public int getGameWidth() {
		return gameWidth;
	}
	public void setGameWidth(int gameWidth) {
		this.gameWidth = gameWidth;
	}

	public int getGameHeight() {
		return gameHeight;
	}

	public void setGameHeight(int gameHeight) {
		this.gameHeight = gameHeight;
	}

	public MapCreator getCreator() {
		return creator;
	}

	public void setCreator(MapCreator creator) {
		this.creator = creator;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	
	
	
}
